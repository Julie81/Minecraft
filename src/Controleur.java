import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

public class Controleur implements ItemListener{
	Modele modl;
	
	public Controleur(Modele m) { //Toutes les parties de la vue
		this.modl = m;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println("ctrl");
		if (arg0.getSource() instanceof Panel) {
			JitmButton b = (JitmButton) arg0.getSource();
			System.out.println(b.it.name);
		}		
	}

}
