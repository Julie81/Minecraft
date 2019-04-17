import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
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

public class Inventaire_Vue extends Panel implements ActionListener,Observer,MouseListener {
	public JitmButton tampon;
	public JitmButton[][] inventaire;
	
	public Inventaire_Vue(Controleur_Rec c,Controleur_Atelier ctrla, Modele m) {
		super();
		int ligne = 4;
		int colonne = 10;
		int s_icon = 40;
		int larg = 80;// largeur d'une cellule pour les cases de l'inventaire
		int longr = 100;
		
		this.inventaire = new JitmButton [ligne][colonne];
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = ligne;
		gbc.gridwidth = colonne;
		
		for (int i=0; i<ligne; i++){
			gbc.gridy = i*longr;
			
			for (int j=0; j<colonne;j++){

				gbc.gridx = j*larg;
				String key = ""+(i*colonne+j);
				if ((i*colonne+j)<10){
					key="0"+key;
				}
				JitmButton b = new JitmButton(m.itemList.get(key));  // on creer un Bouton d'item d'ID key
				inventaire[i][j] = b;
				b.setPreferredSize(new Dimension(longr,larg));

				ImageIcon icon = new ImageIcon(m.itemList.get(key).path);
				Image img = icon.getImage() ;
				Image newimg = img.getScaledInstance( s_icon, s_icon,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				b.setIcon(icon);

				//Definition de la quantite
				b.setText(""+m.itemList.get(key).quantity);
				b.setIconTextGap(5);
				
				b.setFont(new Font("Arial",Font.BOLD,10));
				
				b.setActionCommand(key);  // Il y aura ici en fait un string caracterisant l'item sur lequel on a clique
				b.addActionListener(this);
				b.addActionListener(ctrla);
				b.addActionListener(c);
				b.addMouseListener(this);
				this.add(b,gbc);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {  // mise en valeur de l'item actuellement selectionne
		String n = arg0.getActionCommand();
		if (tampon != null){
			tampon.setBackground(new JButton().getBackground());
			tampon.repaint();
		}
		tampon = this.inventaire[n.charAt(0)-'0'][n.charAt(1)-'0'];
		tampon.setBackground(Color.white);
		tampon.repaint();

	}

	@Override
	public void update(Observable o, Object arg) { // update lors de changement de quantite
		if (arg instanceof Item ) { 
			this.inventaire[((Item) arg).ID.charAt(0)-'0'][((Item) arg).ID.charAt(1)-'0'].setBackground(((Item) arg).variation);
			this.inventaire[((Item) arg).ID.charAt(0)-'0'][((Item) arg).ID.charAt(1)-'0'].setText(""+((Item) arg).quantity);
		}
		if (arg instanceof ArrayList) {
			for(int i=0;i<((ArrayList<Item>) arg).size();i++) {
				this.inventaire[((Item) arg).ID.charAt(0)-'0'][((Item) arg).ID.charAt(1)-'0'].setBackground(((Item) arg).variation);
				this.inventaire[((Item) arg).ID.charAt(0)-'0'][((Item) arg).ID.charAt(1)-'0'].setText(""+((Item) arg).quantity);
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JitmButton ) {
			JitmButton t = (JitmButton) e.getSource();
			if (t == this.tampon) {
				t.setBackground(Color.white);
			}
			t.setToolTipText(t.it.name);	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JitmButton ) {
			JitmButton t = (JitmButton) e.getSource();
			if (t != this.tampon) {
				t.setBackground(new JButton().getBackground());
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
