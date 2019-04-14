import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controleur_Atelier implements ActionListener{
	Atelier_Modele atm;
	Modele mdl;

	public Controleur_Atelier(Atelier_Modele m,Modele mdl) { //Toutes les parties de la vue
		this.atm = m;
		this.mdl = mdl;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JButton) {
			if (arg0.getActionCommand().startsWith("f", 0)) { // si on clique sur une case de la matrice de craft
					this.atm.remplissage(arg0.getActionCommand().charAt(1)-'0',arg0.getActionCommand().charAt(2)-'0'); 
			}
			else { // on selectionne un item de l'inventaire
					this.atm.selection(((JitmButton) arg0.getSource()).it); // on le sauvegarde en memoire
			}
		}
		else {
			if (arg0.getSource() instanceof Button) {  // si on clique sur l'un des boutons de gestion de l'atelier
				if (arg0.getActionCommand()=="+"){
					this.atm.addQuantity();
				}
				if (arg0.getActionCommand()=="-"){
					this.atm.reduceQuantity();
				}
				if (arg0.getActionCommand()=="C") {
					this.atm.Crafting(atm.CraftTable);
				}
			
		}
		}
	}
}

