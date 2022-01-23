import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	public static final int WIDTH = 400;
	public static final int HIGHT = 600;
	public static boolean GameOver = false;
	public static int score = 0;
	public static boolean starting = false;
	public static int count = -1;
	

	
	private int baseCoords = 0;
	private BufferedImage img;
	
	Bat bi = new Bat();
	
	Pipes pd = new Pipes(GamePanel.WIDTH);
	Pipes pd2 = new Pipes(GamePanel.WIDTH+(GamePanel.WIDTH/2));
	
	
	
	public GamePanel() { 
		LoadImage();
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			bi.Upmove();
			
		}
		});
		
	}


	private void LoadImage() { // za³adowanie t³a menu
		try {
			img = ImageIO.read(new File("src\\main\\resources\\tlo_gra.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, baseCoords, 0, null);
		
		bi.drawBat(g);
		pd.drawPipes(g);
		pd2.drawPipes(g);
		
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		g.setColor(Color.yellow);
		g.drawString("" + score,GamePanel.WIDTH/2 , 100);	
		
		if(starting) {
			g.setFont(new Font("Tahoma", Font.BOLD, 100));
			g.setColor(Color.yellow);
			g.drawString(Integer.toString(count), 170, 250);
		}
	
	}
	
	public void Move() {
		bi.batMove();
		pd.pipesMove();
		pd2.pipesMove();
		
		if(GameOver) {
			pd.X =GamePanel.WIDTH;
			pd2.X = GamePanel.WIDTH + (GamePanel.WIDTH/2);
			GameOver = false; 
			}
	//	System.out.println(pd.X+"->"+Bat.x +"   :   "+ pd2.X+"->"+Bat.x);
		if (pd.X == Bat.x || pd2.X == Bat.x) {  //naliczanie punktow
			score += 1;
		}
		}
	
public static boolean gameOverMessage()  {
	
 	try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ranking.txt",true));
			
			bw.write(GamePanel.score + "\n");
			bw.flush();
			bw.close();
			
			}catch(Exception ek){};

		
		Object[] options = {"Restart", "The best score","Exit"};
		
//okienko GameOver	
int result = JOptionPane.showOptionDialog(null,"Game Over! Good job " + MenuPanel.nazwa + "! Your score is " + score +"\n"  , "Game Over!",
JOptionPane.YES_NO_OPTION,
JOptionPane.WARNING_MESSAGE,
null,     
options,  
options[0]); 


if (result == JOptionPane.YES_OPTION) {  //restart
return true;

}

if (result == JOptionPane.NO_OPTION) {
	Ranking.ranking();
	
return true;
}

else {   //zamkniecie okna
	 
	FlappyBat.timer.stop();
	
	return false;

	} 
}
	public void actionPerformed(ActionEvent e) {
	    JFrame window3 = new JFrame();
	    window3.setVisible(true);
		window3.setResizable(false);
		window3.pack();
		setVisible(false);
			
	      }
}




