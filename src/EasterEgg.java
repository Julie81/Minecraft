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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EasterEgg implements WindowListener{
	Frame f;
	Dimension taille_popup;
	Timer t;
	
	public EasterEgg(){
		
		f = new Frame();
		taille_popup = new Dimension(250, 100);
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		f.setSize(width, height);
		Bug();
	}
	
	private void Bug() {
		long ecart = 200;
		while (true) {
			Random rd = new Random();
			int x = rd.nextInt(Math.abs(this.f.getWidth())-(int) taille_popup.getWidth());
			int y = rd.nextInt(Math.abs(this.f.getHeight())-(int) taille_popup.getHeight());
			try {
				Thread.sleep(ecart);
				new Popup(x,y,taille_popup);
			} catch (InterruptedException e) {
				System.out.println("Exception");
			}
			if (ecart>50) {
				ecart = (long) (ecart * 0.95);
			}
		}
	}
	

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		f.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
