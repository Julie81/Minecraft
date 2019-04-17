import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;

public class Controleur_Rec implements ActionListener{
	Modele modl;
	
	public Controleur_Rec(Modele m) { //Toutes les parties de la vue
		this.modl = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() instanceof JitmButton){
			if (arg0.getActionCommand()=="R") {
				JitmButton b = (JitmButton) arg0.getSource();
				this.modl.addItemResource(b.it,1);
			}
		}
	}

}