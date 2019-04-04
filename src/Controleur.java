import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

public class Controleur extends Observable implements ItemListener{
	Inventaire ivt;
	Craft_Zone atl;
	Memoire mm;
	Recolte rc;
	
	public Controleur(Inventaire i,Memoire m, Craft_Zone a, Recolte c ) { //Toutes les parties de la vue
		this.ivt = i;
		this.atl = a;
		this.mm = m;
		this.rc = c;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println("xx");
		if (arg0.getSource() instanceof JitmButton) {
			JitmButton b = (JitmButton) arg0.getSource();
			System.out.println(b.it.name);
		}
		this.setChanged();
		this.notifyObservers();
		
	}

}
