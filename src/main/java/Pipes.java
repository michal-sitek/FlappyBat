import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Pipes {
	
	private Random rand = new Random();
	public int X;
	public int y = rand.nextInt(GamePanel.HIGHT - 350)+210;
	private int width_pipe = 48;
	private int height = GamePanel.HIGHT - y;
	private int distance = 190;
	private BufferedImage img = null;
	
	
	public static int speed = -3;
	
	
	public Pipes(int X) {
		this.X = X;
		
		LoadImage();
	}
	private void LoadImage(){
		
		try {
			img = ImageIO.read(new File("src\\main\\resources\\Rurka.png"));
		}catch (Exception ex) {
			
		}
	}
	

		public void drawPipes (Graphics g){
			g.drawImage(img, X, y, null);
			g.drawImage(img, X,(-GamePanel.HIGHT)+(y-distance) ,null);
			
		}
		
		public void pipesMove() {
			
			X+=speed;
			
			if(X <= width_pipe) {
				X = GamePanel.WIDTH;
				y = rand.nextInt(GamePanel.HIGHT - 350)+210;
				height = GamePanel.HIGHT - y;
			}
			
			Rectangle downRectangle = new Rectangle (X,y, width_pipe, height);
			Rectangle upRectangle = new Rectangle (X,0, width_pipe, GamePanel.HIGHT-(height+distance));
			
			if(downRectangle.intersects(Bat.getBatRectangle())||upRectangle.intersects(Bat.getBatRectangle())) {
				
								
			boolean option = GamePanel.gameOverMessage(); {
				
			if (option) {
			
			try {
				Thread.sleep(500);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			
			Bat.reset();
			pipes_reset();
		}
			
			else {
				JFrame frame = FlappyBat.getWindow();
				frame.dispose();
				FlappyBat.timer.stop();
			}
			}
			}
			}
		
		private void pipes_reset() {
			y = rand.nextInt(GamePanel.HIGHT - 350)+210;
			height = GamePanel.HIGHT - y;
			GamePanel.GameOver = true;
			
		}

}
