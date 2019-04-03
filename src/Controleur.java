import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

public class Controleur extends Observable implements ItemListener{

	public void Controleur() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println(arg0.getItem().getClass());
		if (arg0.getSource() instanceof JitmButton) {
			JitmButton b = (JitmButton) arg0.getSource();
			b.repaint();
		}
		this.setChanged();
		this.notifyObservers();
		
	}

}
