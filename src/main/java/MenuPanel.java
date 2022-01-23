import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel implements ActionListener  {
	private static final long serialVersionUID = 1L;

	public static String nazwa;
	
	private BufferedImage img = null;
	public boolean StartingPoint = false;
	JButton start;
	public static JTextField name;
	
	
	public MenuPanel() throws IOException { 
		
		
		setLayout(null);
		setFocusable(true);
		setVisible(true);
		
		JLabel textTitle = new JLabel("Flappy Bat");
		textTitle.setFont(new Font ("Snap ITC", Font.BOLD, 38 ));
		textTitle.setForeground(Color.YELLOW);
		textTitle.setBounds(65, 100, 350, 60);
		add(textTitle); 
		
		JLabel textName = new JLabel ("Enter your name");
		textName.setBounds(138, 220, 150, 30);
		textName.setForeground(Color.yellow);
		
		name = new JTextField (30);
		name.setBounds(135, 250, 100, 30);
		add(textName);
		add(name);
		
		
		
		JButton start = new JButton("Start");
		start.setBounds(135, 350, 100, 40);
		start.setFont(new Font ("Snap ITC", Font.BOLD, 12 ));
		start.setForeground(Color.YELLOW);
		start.setBackground(Color.BLACK);
		add(start);
		start.addActionListener(this);
			
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				super.mouseClicked(e);
				StartingPoint = true;	
				nazwa = name.getText();
			}
		});
		
	}

	
	//t³o
	@Override
	protected void paintComponent( Graphics g ){
	super.paintComponent( g );
	Image im = getToolkit().getImage("src/main/resources/tlo_gra.png");
	g.drawImage( im, 0, 0, this );

		}

	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}


