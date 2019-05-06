import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Inventaire_Vue extends Panel implements ActionListener,Observer,MouseListener {
	public JitmButton tampon;
	public JitmButton[][] inventaire;
	
	public Inventaire_Vue(Controleur_Rec c,Controleur_Atelier ctrla, Modele m) {
		super();
		int ligne = 4;
		int colonne = 10;
		int s_icon = 40;
		
		this.inventaire = new JitmButton [ligne][colonne];
		//couleur du fond
		this.setBackground(new Color(63,34,4));
		//ajout du Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//ajout et placement du titre
		gbc.gridx = Minecraft.larg*ligne;
		gbc.gridy = 0;
		gbc.fill= GridBagConstraints.HORIZONTAL;

		gbc.gridwidth=Minecraft.larg*(ligne);
		Label titre = new Label (" Inventaire de "+m.IGN);
		
		titre.setFont(new Font("Arial",Font.BOLD,18));
		titre.setForeground(Color.white);
		this.add(titre,gbc);
		
		//on ajuste la taille des cases
		gbc.gridheight = ligne;
		gbc.gridwidth = colonne;
		
		//on parcourt les items
		int y = 0;
		int x = 0;
		for(Integer key : m.itemGen.keySet()) {
			for(Item item : m.itemGen.get(key)) {
				
				item.x = x;
				item.y = y;
				
				//placement de l'item
				gbc.gridy = (y+1)*Minecraft.longr;
				gbc.gridx = x*Minecraft.larg;
				
				JitmButton b = new JitmButton(item);  // on creer un Bouton d'item d'ID key
				inventaire[y][x] = b;
				b.setPreferredSize(new Dimension(Minecraft.longr,Minecraft.larg));

				//on recupere l'image de l'item
				ImageIcon icon = new ImageIcon(item.path);
				Image img = icon.getImage() ;
				Image newimg = img.getScaledInstance( s_icon, s_icon,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				//on ajoute l'image au bouton
				b.setIcon(icon);

				//Definition de la quantite
				b.setText(""+item.quantity);
				b.setIconTextGap(5);
				
				//police de la quantite
				b.setFont(new Font("Arial",Font.BOLD,10));
				
				String position = ""+(y*colonne+x);
				if ((y*colonne+x)<10){
					position="0"+position;
				}  // Il y aura ici en fait un string caracterisant l'item sur lequel on a clique
				
				//ajout des actions sur le bouton
				b.setActionCommand(position);
				b.addActionListener(this);
				b.addActionListener(ctrla);
				b.addActionListener(c);
				b.addMouseListener(this);
				//modification du bord et du fond du bouton
				b.setBackground(new Color(76,166,107));
				Border bord = new LineBorder(new Color(63,34,4), 1);
				b.setBorder(bord);
				//ajout du bouton a l'inventaire
				this.add(b,gbc);
				
				x++;
				if(x==colonne) {
					x = 0;
					y++;
				}
				
			}
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {  // mise en valeur de l'item actuellement selectionne
		String n = arg0.getActionCommand();
		if (tampon != null){
			tampon.setBackground(new Color(76,166,107));
			tampon.repaint();
		}
		tampon = this.inventaire[n.charAt(0)-'0'][n.charAt(1)-'0'];
		tampon.setBackground(Color.white);
		tampon.repaint();

	}

	@Override
	public void update(Observable o, Object arg) { // update lors de changement de quantite
		if (arg instanceof Item ) { 
			this.inventaire[((Item) arg).y][((Item) arg).x].setBackground(((Item) arg).variation);
			this.inventaire[((Item) arg).y][((Item) arg).x].setText(""+((Item) arg).quantity);
		}
		if (arg instanceof ArrayList) {
			for(int i=0;i<((ArrayList<Item>) arg).size();i++) {
				this.inventaire[((Item) arg).y][((Item) arg).x].setBackground(((Item) arg).variation);
				this.inventaire[((Item) arg).y][((Item) arg).x].setText(""+((Item) arg).quantity);
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) { //recuperation de l'item qu'on a selectionne et mise en valeur de cet item
		if (e.getSource() instanceof JitmButton ) {
			JitmButton t = (JitmButton) e.getSource();
			if (t == this.tampon) {
				t.setBackground(Color.white);
			}
			t.setToolTipText(t.it.name);	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {//retourne a la couleur initiale du bouton
		if (e.getSource() instanceof JitmButton ) {
			JitmButton t = (JitmButton) e.getSource();
			if (t != this.tampon) {
				t.setBackground(new Color(76,166,107));
			}			
		}
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
