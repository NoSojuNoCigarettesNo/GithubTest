package project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Inside_Out extends JFrame {
	// 더블 버퍼링을 위해 전체 화면의 이미지를 담는 두 인스턴스 (screenImage, screenGraphic) import 필요
	private Image screenImage;
	private Graphics screenGraphic;
	// 배경 이미지를 담을 수 있는 객체
	private Image introBackground;

	public Inside_Out() {
		setTitle("Inside Out");
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		setResizable(false); // 사용자가 게임창을 임의로 줄이고 하는게 불가능, true로 하면 가능
		setLocationRelativeTo(null); // 게임창이 정 중앙에 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임을 끄면 완전히 종료, 반드시 필요한 함수
		setVisible(true); // 게임창을 눈에 보이게 출력시켜줌

		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		/* ImageIcon -> import 필요 , 메인 클래스의 위치를 기반으로 introBackground의 이미지 파일을 얻어 온뒤 이미지
		 파일을 초기화
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();*/
		// title 이미지 얻으면 다시 수정할 것 <<<<<<<<<
		
		Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 인트로뮤직이 무한 반복
		introMusic.start(); // 게임이 시작함과 동시에 음악이 무한 재생 
	}

	// 하나의 약속 된 메소드
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT); // 1280 x 720 만큼의 이미지를 생성뒤 넣어줌
		screenGraphic = screenImage.getGraphics(); // screenImage를 통해 그래픽을 얻어옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null); // 화면에 스크린 이미지가 그려짐
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // 다시 페인트 함수를 불러옴 , 전체 이미지를 계속 반복하며 그려줌 
	}
}
