import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

public class Controleur extends Observable implements ItemListener{
	Inventaire_Vue ivt;
	Atelier_Vue atl;
	Memoire_Vue mm;
	Recolte_Vue rc;
	
	public Controleur(Inventaire_Vue i,Memoire_Vue m, Atelier_Vue a, Recolte_Vue c ) { //Toutes les parties de la vue
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
