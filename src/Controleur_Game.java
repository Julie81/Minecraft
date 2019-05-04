import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur_Game implements ActionListener{
	Minecraft mcf;
	
	public Controleur_Game(Minecraft mcf) { // Constructeur
		this.mcf = mcf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "endgame") {
			mcf.setVisible(false);
			mcf.dispose();
		}
	}

}