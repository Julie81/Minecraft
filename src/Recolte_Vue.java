import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Recolte_Vue extends Panel implements MouseListener,Observer{
	Controleur_Rec ctrl;
	ArrayList<JitmButton> ress;
	Modele modl;
	
	public Recolte_Vue(Controleur_Rec c, Controleur_Game ctrlg, Modele m) {
		modl=m;
		//liste des items de recolte
		String[] rn_names = {"pierre","bois","eau","plume","viande","fer","diamant","pomme","orange","lait","lianes","noix de coco","cuir","charbon","or","canne a sucre"};  // rn pour ressources naturelles
		this.ctrl = c;
		ress = new ArrayList<>();
		
		// tri
		int v;
	    for (int u = 1; u < rn_names.length; u++) {
	    	Item en_cours = modl.itemNametoItem.get(rn_names[u]);
			for (v = u; v > 0 &&  modl.itemNametoItem.get(rn_names[v-1]).generation > en_cours.generation; v--) {
	            rn_names[v] = rn_names[v-1];
	            }
			rn_names[v] = en_cours.name;
	    }
		
		this.setBackground(Minecraft.fond);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		int moitie = 8;
		int dim_icon = (Minecraft.longr)/2 - Minecraft.espace2;
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridheight = moitie;
		gbc.gridwidth = moitie;
		
		int j=0;  // numero de colonne 
		int i=0;
		for(i=0; i<rn_names.length; i++) {  // Creation de tout les boutons en parcourant les listes
			if (i==moitie){  // quand on a parcouru la moitie des items
				j=1;  // on passe a la colonne suivante
				gbc.gridx = (Minecraft.longr)/2;
			}
			gbc.gridy=(i-j*moitie+2)*(Minecraft.longr)/2+2*Minecraft.taille_bouton;
			JitmButton b = Init_Icon_Recolte(m.itemNametoItem.get(rn_names[i]));
			
			// Transformation de l'image pour l'adapter a la taille du Bouton
			ImageIcon icon = new ImageIcon(m.itemNametoItem.get(rn_names[i]).path);
			Image img = icon.getImage() ;
			Image newimg = img.getScaledInstance( dim_icon, dim_icon,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			b.setIcon(icon);
			b.setBackground(new Color(86,130,3));
			Border bord = new LineBorder(Color.black, 1);
			b.setBorder(bord);
			ress.add(b);
			this.add(b,gbc);
			
		}
		
		//ajout et positionnement du bouton d'aide
		gbc.gridx=0;
		gbc.gridy=0;
		JButton aide= new JButton(new ImageIcon("miniatures/aide/manuel_aide.jpg"));
		aide.setPreferredSize(new Dimension((Minecraft.longr)/2,2*Minecraft.taille_bouton));
		this.add(aide,gbc);
		aide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ouverture du manuel
				try {
					new Manuel_Vue();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		//ajout et positionnement du titre
		gbc.gridx=(Minecraft.longr)/2;
		Box box_titre = Box.createVerticalBox();
		Label titre1=new Label("Recoltez vos");
		Label titre2=new Label("ressources");
		titre1.setFont(new Font("Arial",Font.BOLD,16));
		titre1.setForeground(Color.white);
		box_titre.add(titre1);
		titre2.setFont(new Font("Arial",Font.BOLD,16));
		titre2.setForeground(Color.white);
		box_titre.add(titre2);
		box_titre.setPreferredSize(new Dimension ((Minecraft.longr)/2*2,(Minecraft.longr)/2));
		gbc.gridx=0;
		gbc.gridy=70;
		gbc.ipady=Minecraft.espace1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=Minecraft.longr;
		this.add(box_titre,gbc);
		
		//ajout d'un espace avant le bouton sauvegarde
		Label blanc=new Label("");
		blanc.setPreferredSize(new Dimension ((Minecraft.longr)/2,Minecraft.espace2));
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+2)*(Minecraft.longr)/2+2*Minecraft.taille_bouton;
		this.add(blanc,gbc);
		
		//ajout d'un espace entre les boutons sauvegarde et menu principal
		Label blanc2=new Label("");
		blanc2.setPreferredSize(new Dimension ((Minecraft.longr)/2,5));
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+3)*(Minecraft.longr)/2+90;
		this.add(blanc2,gbc);
		
		//ajout du bouton sauvegarde
		Button sauvegarde= new Button("Sauvegarder");
		//police de sauvegarde
		sauvegarde.setFont(new Font("Arial",Font.BOLD,12));
		sauvegarde.setForeground(Color.black);
		sauvegarde.setPreferredSize(new Dimension(Minecraft.longr,20));
		sauvegarde.setBackground(Minecraft.fond_bouton);
		sauvegarde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//sauvegarde
				try {
					modl.saveGame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		//positionnement du bouton
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+3)*(Minecraft.longr)/2+2*Minecraft.taille_bouton;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=Minecraft.longr;
		this.add(sauvegarde,gbc);
		
		//ajout et positionnement du bouton menu principal
		Button mp= new Button("Menu Principal");
		//police de menu principal
		mp.setFont(new Font("Arial",Font.BOLD,12));
		mp.setForeground(Color.black);
		mp.setPreferredSize(new Dimension(Minecraft.longr,20));
		mp.setBackground(Minecraft.fond_bouton);
		gbc.gridx=0;
		gbc.gridy=(i-j*moitie+3)*(Minecraft.longr)/2+Minecraft.longr;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=Minecraft.longr;
		this.add(mp,gbc);
		mp.setActionCommand("endgame");
		mp.addActionListener(ctrlg);
	}
	
	private JitmButton Init_Icon_Recolte(Item obj) {
		// Creer un bouton avec l'image icon
		JitmButton b = new JitmButton(obj);
		b.setPreferredSize(new Dimension((Minecraft.longr)/2,(Minecraft.longr)/2));
		b.setActionCommand("R");
		b.putClientProperty("id", obj.name);
		b.addActionListener(this.ctrl);
		b.addMouseListener(this);
		b.setEnabled(obj.unlock());
		return b;
	}
	
	private void verif_lock() {
		//debloquer une ressource
		for( JitmButton b : this.ress) {
			b.setEnabled(b.it.unlock());
		}
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

	@Override
	public void update(Observable o, Object arg) {
		//modification des verrous
		if (arg=="reset") {
			this.verif_lock();
		}
		
	}

}
