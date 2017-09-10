package project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Inside_Out extends JFrame {
	// ���� ���۸��� ���� ��ü ȭ���� �̹����� ��� �� �ν��Ͻ� (screenImage, screenGraphic) import �ʿ�
	private Image screenImage;
	private Graphics screenGraphic;
	// ��� �̹����� ���� �� �ִ� ��ü
	private Image introBackground;

	public Inside_Out() {
		setTitle("Inside Out");
		setSize(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT);
		setResizable(false); // ����ڰ� ����â�� ���Ƿ� ���̰� �ϴ°� �Ұ���, true�� �ϸ� ����
		setLocationRelativeTo(null); // ����â�� �� �߾ӿ� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ ���� ������ ����, �ݵ�� �ʿ��� �Լ�
		setVisible(true); // ����â�� ���� ���̰� ��½�����

		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		/* ImageIcon -> import �ʿ� , ���� Ŭ������ ��ġ�� ������� introBackground�� �̹��� ������ ��� �µ� �̹���
		 ������ �ʱ�ȭ
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(title).jpg")).getImage();*/
		// title �̹��� ������ �ٽ� ������ �� <<<<<<<<<
		
		Music introMusic = new Music("introMusic.mp3", true); // ����ȭ�鿡�� ��Ʈ�ι����� ���� �ݺ�
		introMusic.start(); // ������ �����԰� ���ÿ� ������ ���� ��� 
	}

	// �ϳ��� ��� �� �޼ҵ�
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREENT_WIDTH, Main.SCREENT_HEIGHT); // 1280 x 720 ��ŭ�� �̹����� ������ �־���
		screenGraphic = screenImage.getGraphics(); // screenImage�� ���� �׷����� ����
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null); // ȭ�鿡 ��ũ�� �̹����� �׷���
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // �ٽ� ����Ʈ �Լ��� �ҷ��� , ��ü �̹����� ��� �ݺ��ϸ� �׷��� 
	}
}
