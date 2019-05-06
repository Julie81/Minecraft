import java.awt.Dimension;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Random;

public class EasterEgg {
	Frame f;
	Dimension taille_popup;
	
	public EasterEgg(){
		
		f = new Frame();
		taille_popup = new Dimension(250, 100);
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		f.setSize(width, height);
		Bug();
	}

	private void Bug() { // Iteration des popups
		ArrayList<Popup> garbage = new ArrayList<>();
		int nbr = 0;
		long ecart = 50;
		while (nbr<80) {
			nbr++;
			Random rd = new Random();
			int x = rd.nextInt(Math.abs(this.f.getWidth())-(int) taille_popup.getWidth());
			int y = rd.nextInt(Math.abs(this.f.getHeight())-(int) taille_popup.getHeight());
			try {
				Thread.sleep(ecart);
			} catch (InterruptedException e) {
				System.out.println("Exception");
			}
			garbage.add(new Popup(x,y,taille_popup));
		
		}
		for(Popup p: garbage) {
			p.dispose();
		}
		garbage.clear();
		System.exit(0);
	}
	
}
