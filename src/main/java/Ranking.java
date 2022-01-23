import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ranking  {
	
	public static void ranking() {


		List<Integer> lista = new ArrayList<Integer>();
		int liczba;
		int bestscore;
   
     try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ranking.txt"));
            String linia = null;
             
            while ((linia = br.readLine()) != null) {
            	
            if (	!linia.isEmpty() ) {
            	
                 liczba = Integer.parseInt(linia.trim());
                lista.add(liczba);
            }
            }
        } catch (Exception e) {
            System.err.println("Wystapil blad przy wczytywaniu danych");
            e.printStackTrace();
        }   

     
    bestscore = Collections.max(lista);
    
    ImageIcon iconRanking = new ImageIcon ("src/main/resources/podium.jpg");

	int textRanking = JOptionPane.showOptionDialog(null ,"The best score: " + "\n" + bestscore, "the best sccore", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iconRanking, null, null);
}
   
	
	
 
}

 

	
	
	
	
	
	
	
	

	
//	ImageIcon iconRanking = new ImageIcon ("src/main/resources/podium.jpg");
	//int textRanking = JOptionPane.showOptionDialog(null ,"Top 10: " + "\n" + s, "Top 10", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iconRanking, null, null);
	

	
	
  
	
		



	

