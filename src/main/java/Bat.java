import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Bat {
	
	private BufferedImage img = null;
	
	private static int bat_diameter = 44; // �rednica nietoperza
	public static int x = (GamePanel.WIDTH/2)-bat_diameter/2; // po�o�enie na osi x
	public static int y = GamePanel.HIGHT/2; // po�o�enie na osi y
	
	private static int speed = 2; //pr�dko��
	private int shift = 1; // zmiana przyspieszenia o 1 
	
	// �adowanie obrazu nietoperza
	public Bat() {
		LoadImage();
	}
	private void LoadImage() {
		try {
			img = ImageIO.read(new File("src\\main\\resources\\netoper.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	} // wy�wietlenie nietoperza
	public void drawBat(Graphics g) {
		g.drawImage(img, x,  y,  null);
		
	} // ruch nietoperza po piskelach
	public void batMove() {
		
		if(y>=0 && y<=GamePanel.HIGHT) {
			speed +=shift; //3, 4
			y+=speed; // 300+3, 300+3+4, 300+3+4+5
		}else {
			boolean option = GamePanel.gameOverMessage(); {
				
				if (option) {
				
				try {
					Thread.sleep(500);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
			reset();
				
			}
				
				else {
					JFrame frame = FlappyBat.getWindow();
					frame.dispose();
					FlappyBat.timer.stop();
				}
				}
		}
	} // skok nietoperza ujemnie wzg�dem osi y
	public void Upmove() {
		speed = -13;
		
	} // powr�t do stanu pocz�tkowego
		public static void reset() {
			speed = 2;
			y = GamePanel.HIGHT/2;
			GamePanel.GameOver = true;
			GamePanel.score = 0;
		}
		
		public static Rectangle getBatRectangle() {
			
			Rectangle batRectangle = new Rectangle(x,y, bat_diameter, 40);
			return batRectangle;
		}
	}


