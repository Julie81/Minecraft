import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Recolte extends Panel {
	
	int larg = 80; // dimension du carré bouton
	
	public Recolte() {
		String[] names = {"Pierre","Bois","Fer","Plume"};  // Liste des noms des boutons
		Color[] cl = {Color.gray, Color.orange,Color.lightGray,Color.white}; // Liste des couleurs associees
		
		for(int i=0; i<names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			this.add(Init_Btn_Recolte(names[i],cl[i]));
		}
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // alignement en vertical
	}
	
	
	private Component Init_Btn_Recolte(String name, Color cl) {
		// Creer un bouton du nom de name et de couleur cl
		JButton b = new JButton();
		b.setText(name);
		b.setBackground(cl);
		return b;
		}
	

}
