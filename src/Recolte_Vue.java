import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Recolte_Vue extends Panel implements MouseListener{
	int larg = 50; // dimension du carre bouton
	Controleur_Rec ctrl;
	
	public Recolte_Vue(Controleur_Rec c, Modele m) {
		String[] rn_names = {"pierre","bois","eau","plume","or","fer","diamant","pomme","orange","lait","lianes","noix de coco","ble","charbon","souris","canne a sucre"};  // rn pour ressources naturelles
		this.ctrl = c;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int moitie = 8;
		int dim_icon = larg - 10;
		//this.setPreferredSize(new Dimension(2*larg+10,moitie*larg+10));
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridheight = moitie;
		gbc.gridwidth = moitie;
		
		int j=0;  // numero de colonne 
		int i=0;
		for(i=0; i<rn_names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			if (i==moitie){  // quand on a parcouru la moitie des items
				j=1;  // on passe a la colonne suivante
				gbc.gridx = larg;
			}
			gbc.gridy=(i-j*moitie+1)*larg;
			JitmButton b = Init_Icon_Recolte(m.itemNametoItem.get(rn_names[i]));
			
			// Transformation de l'image pour l'adapter a la taille du Bouton
			ImageIcon icon = new ImageIcon(m.itemNametoItem.get(rn_names[i]).path);
			Image img = icon.getImage() ;
			Image newimg = img.getScaledInstance( dim_icon, dim_icon,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			b.setIcon(icon);
			
			this.add(b,gbc);
			
		}
		Label blanc=new Label("");
		blanc.setPreferredSize(new Dimension (larg,larg));
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+2)*larg;
		this.add(blanc,gbc);
		
		
		Button sauvegarde= new Button("sauvegarder");
		sauvegarde.setPreferredSize(new Dimension(larg*2,30));
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+3)*larg;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2*larg;
		this.add(sauvegarde,gbc);
		
		Button partie= new Button("choisir partie");
		partie.setPreferredSize(new Dimension(larg*2,30));
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+4)*larg;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2*larg;
		this.add(partie,gbc);
	}
	
	private JitmButton Init_Icon_Recolte(Item obj) {
		// Creer un bouton avec l'image icon
		JitmButton b = new JitmButton(obj);
		b.setPreferredSize(new Dimension(larg,larg));
		b.setActionCommand("R");
		b.putClientProperty("id", obj.name);
		b.addActionListener(this.ctrl);
		b.addMouseListener(this);
		b.setEnabled(obj.unlock());
		return b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JitmButton ) {
			JitmButton t = (JitmButton) e.getSource();
			t.setToolTipText(t.it.name);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
