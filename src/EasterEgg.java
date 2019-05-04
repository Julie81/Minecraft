import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EasterEgg {
	Frame f;
	Dimension taille_popup;
	boolean autho;
	
	public EasterEgg(){
		
		f = new Frame();
		taille_popup = new Dimension(250, 100);
		autho = false;
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		f.setSize(width, height);
		Bug();
	}

	private void Bug() { // Iteration des popups
		ArrayList<Popup> garbage = new ArrayList<>();
		long ecart = 500;
		while (!autho) {
			System.out.println(autho);
			Random rd = new Random();
			int x = rd.nextInt(Math.abs(this.f.getWidth())-(int) taille_popup.getWidth());
			int y = rd.nextInt(Math.abs(this.f.getHeight())-(int) taille_popup.getHeight());
			try {
				Thread.sleep(ecart);
			} catch (InterruptedException e) {
				System.out.println("Exception");
			}
			if (ecart>300) {
				ecart = (long) (ecart * 0.95);
			}
			garbage.add(new Popup(x,y,taille_popup));
			garbage.get(garbage.size()-1).addWindowListener(new java.awt.event.WindowAdapter() 
				
				{ public void windowClosing(WindowEvent arg0) {
					System.out.println("closing");
					autho = true;
				}
			});
		
		}
		for(Popup pp: garbage) {
			pp.dispose();
		}
		garbage.clear();
	}
	
}
