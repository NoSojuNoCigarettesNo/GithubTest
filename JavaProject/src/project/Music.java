package project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

// Thread는 하나의 작은 프로그램
public class Music extends Thread {
   // Player ==> JLayer의 라이브러리 중 하나 
	private Player player; 
	private boolean isLoop; // 곡을 무한 반복 ? 한 번만 재생하고 끌 껀지 ?
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	  // 곡 이름과 , 반복여부로 생성자 재정의
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI()); // URI로 해당 파일의 위치를 가져옴
			fis = new FileInputStream(file); // 해당 파일을 버퍼에 담아 읽어 올 수 있도록 함 
			bis = new BufferedInputStream(fis); 
			player = new Player(bis); // 플레이어는 해당 파일을 담을 수 있도록 함
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	  // 현재 실행되고 있는 음악이 어떤 위치에서 실행되고 있는지 알려주는 함수
	// ex) 10초라면 10000을 리턴 
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	// 음악이 언제 실행되던간에 항상 종료를 가능케 해주는 함수 
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 쓰레드(곡)를 중지상태로 만듬 interrupt << 
	}
	
	@Override  // 쓰레드를 상속 받으면 무조건 사용해야 하는 함수 
	public void run() {
		try {
			do {
				player.play(); // 곡을 실행시킴 
				fis = new FileInputStream(file); 
				bis = new BufferedInputStream(fis); 
				player = new Player(bis); 
			} while(isLoop); // true라면 무한 반복 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
