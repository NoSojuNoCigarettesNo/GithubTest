package project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

// Thread�� �ϳ��� ���� ���α׷�
public class Music extends Thread {
   // Player ==> JLayer�� ���̺귯�� �� �ϳ� 
	private Player player; 
	private boolean isLoop; // ���� ���� �ݺ� ? �� ���� ����ϰ� �� ���� ?
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	  // �� �̸��� , �ݺ����η� ������ ������
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI()); // URI�� �ش� ������ ��ġ�� ������
			fis = new FileInputStream(file); // �ش� ������ ���ۿ� ��� �о� �� �� �ֵ��� �� 
			bis = new BufferedInputStream(fis); 
			player = new Player(bis); // �÷��̾�� �ش� ������ ���� �� �ֵ��� ��
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	  // ���� ����ǰ� �ִ� ������ � ��ġ���� ����ǰ� �ִ��� �˷��ִ� �Լ�
	// ex) 10�ʶ�� 10000�� ���� 
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	// ������ ���� ����Ǵ����� �׻� ���Ḧ ������ ���ִ� �Լ� 
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // �ش� ������(��)�� �������·� ���� interrupt << 
	}
	
	@Override  // �����带 ��� ������ ������ ����ؾ� �ϴ� �Լ� 
	public void run() {
		try {
			do {
				player.play(); // ���� �����Ŵ 
				fis = new FileInputStream(file); 
				bis = new BufferedInputStream(fis); 
				player = new Player(bis); 
			} while(isLoop); // true��� ���� �ݺ� 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
