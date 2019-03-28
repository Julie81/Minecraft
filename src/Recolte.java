import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Recolte extends Panel {
	ArrayList<Item> L;
	int larg = 30; // dimension du carre bouton
	
	public Recolte(ArrayList<Item> r) {
		this.L = r;
		String[] rn_names = {"pierre","bois","eau","plume","or","fer","diamant","pomme","orange","lait","lianes"};  // rn pour ressources naturelles
		
		for(int i=0; i<rn_names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			
			JitmButton b = Init_Icon_Recolte(r.get(i));
			
			if (i>3) { // seules les ressources de bases sont recoltables à l'init
				b.setEnabled(false);
			}
			
			// Transformation de l'image pour l'adapter a la taille du Bouton
			ImageIcon icon = new ImageIcon("miniatures/RC/"+rn_names[i]+".png");
			Image img = icon.getImage() ;
			Image newimg = img.getScaledInstance( larg, larg,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			
			b.setIcon(icon);
			this.add(b);
		}
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // alignement en vertical
	}
	
	private JitmButton Init_Icon_Recolte(Item obj) {
		// Creer un bouton avec l'image icon
		JitmButton b = new JitmButton(obj);
		b.setPreferredSize(new Dimension(larg,larg));
		b.setActionCommand(obj.name);
		b.putClientProperty("id", obj.name);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String n = e.getActionCommand(); 
				if (e.getSource() instanceof JitmButton ) {
					JitmButton t = (JitmButton) e.getSource();
					System.out.println(t.getClientProperty("id"));
					t.it.quantity++;
				}
				} });
		return b;
		}

}
