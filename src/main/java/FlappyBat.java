
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBat extends JFrame implements WindowListener,
WindowFocusListener,
WindowStateListener  {

private static JFrame window;
public static Timer timer , timer2;
static boolean musicplay = true;
private int count = 3;


private FlappyBat(){
	

	// Jframe okno
    window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(GamePanel.WIDTH,GamePanel.HIGHT);
    window.setTitle("Flappy Bat");
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    ImageIcon img = new ImageIcon("src/main/resources/netoper.png");
    window.setIconImage(img.getImage());

    
    window.addWindowListener(this);
    window.addWindowFocusListener(this);
    window.addWindowStateListener(this);
}

	private void rendering() throws IOException {
		MenuPanel mp =  new MenuPanel();
		final GamePanel gp = new GamePanel();
		
		
		timer = new Timer(18, new ActionListener() {  // odswiezanie co 18 milisekund
			
			
			public void actionPerformed(ActionEvent e) {
				gp.repaint();
				gp.Move();
		
			}
			
		});
				
		window.add(mp);
		window.setVisible(true);
	
				
		// w¹tek opóznienia startu  5 miliksekund 
		while(mp.StartingPoint == false) {
			try {
				Thread.sleep(5);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		window.remove(mp);
		window.add(gp);
		gp.setVisible(true);
		window.revalidate();
		
		//timer.start();
		
		timer2 = new Timer(1000, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				count--;
				GamePanel.count = count;
				GamePanel.starting = true;
				gp.repaint();
				if(count == 0) {
					timer2.stop();
					timer.start();
					GamePanel.starting = false;
				}
				
				
				
			}
		});
		
		timer2.start();
	}
	
	public static JFrame getWindow() {
		return window;
	}

    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

    FlappyBat fb = new FlappyBat();
    fb.rendering();

    Music.play();
  }
    

	public void windowStateChanged(WindowEvent e) {
	
	}

	public void windowGainedFocus(WindowEvent e) {
	
		
	}

	public void windowLostFocus(WindowEvent e) {
	
}

	public void windowOpened(WindowEvent e) {
	
		
	}

	public void windowClosing(WindowEvent e) {
	
		
	}

	public void windowClosed(WindowEvent e) {
		
		
	}
	
	public void windowIconified(WindowEvent e) { //pauzowanie muzyki po zminimalizowaniu okna
		
		Music.clip.stop();
	}

	public void windowDeiconified(WindowEvent e) {

		
	}

	public void windowActivated(WindowEvent e) {

		
	}

	public void windowDeactivated(WindowEvent e) {

		
	}
}
