import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controleur_Atelier implements ActionListener{
	Atelier_Modele atm;
	Message_Memoire_Vue mmv;

	public Controleur_Atelier(Atelier_Modele m, Message_Memoire_Vue mmv) { // Constructeur
		// Message_Memoire_Vue est necessaire pour qu'elle est aussi l'information de la selection
		this.atm = m;
		this.mmv = mmv;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() instanceof JButton) { // ces boutons modifient instantanement la vue 
			
			if (arg0.getActionCommand().startsWith("f", 0)) { // si on clique sur une case de la matrice de craft
				// on la remplie par l'image de l'item selectionne
				this.atm.remplissage(arg0.getActionCommand().charAt(1)-'0',arg0.getActionCommand().charAt(2)-'0'); 
			}
			else { // on clique sur un item de l'inventaire
				// on met a jour le nouvel item courant dans l'atelier et la memoire
				this.atm.selection(((JitmButton) arg0.getSource()).it);
				this.mmv.mv.selection(((JitmButton) arg0.getSource()).it); 
			}
		}
		
		else {
			if (arg0.getSource() instanceof Button) {  // si on clique sur l'un des boutons de gestion de l'atelier
				if (arg0.getActionCommand()=="+"){
					this.atm.addQuantity(); // on veut creer un item de plus 
				}
				if (arg0.getActionCommand()=="-"){
					this.atm.reduceQuantity(); // on veut creer un item de moins 
				}
				if (arg0.getActionCommand()=="C") {
					this.atm.Crafting(atm.CraftTable); // on craft 
				}
			
			}
		}
	}
}

