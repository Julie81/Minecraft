import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Rec implements ActionListener{
	Modele modl;
	
	public Controleur_Rec(Modele m) {
		this.modl = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JitmButton){
			if (arg0.getActionCommand()=="R") { // on recolte les ressources en cliquant sur les boutons 
				JitmButton b = (JitmButton) arg0.getSource();
				if (b.it.name.equals("bois")) {
					this.modl.addItemResource(b.it,3); // on incremente la ressource dans le modele
			}
				else {
					this.modl.addItemResource(b.it,1);
				}
		}
	}
	}
}
