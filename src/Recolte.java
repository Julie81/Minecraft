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
	int larg = 30; // dimension du carr� bouton
	
	public Recolte(ArrayList<Item> r) {
		this.L = r;
		String[] rn_names = {"pierre","bois","eau","plume"};  // rn pour ressources naturelles
		Color[] rn_cl = {Color.gray, Color.orange,Color.blue,Color.white}; 
		String[] rc_names = {"Viande","Orange","Pomme","Noix de coco","Fer","Diamant"}; // rc pour ressources recoltables
		Color[] rc_cl = {Color.red ,Color.orange, Color.green, Color.white, Color.lightGray, Color.cyan};
		
		for(int i=0; i<rn_names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			
			JitmButton b = Init_Icon_Recolte(r.get(i));
			
			// Transformation de l'image pour l'adapter a la taille du Bouton
			ImageIcon icon = new ImageIcon("miniatures/RN/"+rn_names[i]+".png");
			Image img = icon.getImage() ;
			Image newimg = img.getScaledInstance( larg, larg,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			
			b.setIcon(icon);
			this.add(b);
		}
		
		
		for(int i=0; i<rc_names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			JButton b = Init_Btn_Recolte(rc_names[i],rc_cl[i]);
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
	
	private JButton Init_Btn_Recolte(String name, Color cl) {
		// Creer un bouton du nom de name et de couleur cl
		JButton b = new JButton();
		b.setText(name);
		b.setBackground(cl);
		b.setPreferredSize(new Dimension(larg,larg));
		return b;
		}

}
