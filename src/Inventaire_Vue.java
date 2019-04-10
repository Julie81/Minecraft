import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

public class Inventaire_Vue extends Panel implements ActionListener,Observer,MouseListener {
	public JitmButton tampon;
	public JitmButton[][] inventaire;
	//Modele modl;
	
	public Inventaire_Vue(Controleur c,Modele m) {
		super();
		//this.modl = m;
		int ligne = 4;
		int colonne = 10;
		int s_icon = 30;
		int larg = 80;// largeur d'une cellule pour les cases de l'inventaire
		
		this.inventaire = new JitmButton [ligne][colonne];
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = ligne;
		gbc.gridwidth = colonne;
		
		for (int i=0; i<ligne; i++){
			gbc.gridy = i*larg;
			
			for (int j=0; j<colonne;j++){

				gbc.gridx = j*larg;
				String sobriquet = i+""+j+"";
				String key = ""+(i*colonne+j);
				if ((i*colonne+j)<10){
					key="0"+key;
				}
				JitmButton b = new JitmButton(m.itemList.get(key));
				inventaire[i][j] = b;
				b.setPreferredSize(new Dimension(larg,larg));

				ImageIcon icon = new ImageIcon(m.itemList.get(key).path);
				Image img = icon.getImage() ;
				Image newimg = img.getScaledInstance( s_icon, s_icon,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				b.setIcon(icon);
				
				b.setText(""+m.itemList.get(key).quantity);
				b.setHorizontalTextPosition(SwingConstants.RIGHT);
				b.setVerticalTextPosition(SwingConstants.BOTTOM);
				b.setActionCommand(sobriquet);  // Il y aura ici en fait un string caracterisant l'item sur lequel on a cliqu�
				b.addActionListener(this);
				b.addItemListener(c);
				b.addMouseListener(this);
				m.addObserver(this);
				this.add(b,gbc);
				
			}
		}

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String n = arg0.getActionCommand();
		if (tampon != null){
			tampon.setBackground(new JButton().getBackground());
			tampon.repaint();
		}
		tampon = this.inventaire[n.charAt(0)-'0'][n.charAt(1)-'0'];
		tampon.setBackground(Color.white);
		tampon.repaint();
		this.repaint();

	}

	@Override
	public void repaint() {
		super.repaint();
		for (int i=0; i<4; i++){
			for (int j=0; j<10;j++){
				this.inventaire[i][j].setText(""+this.inventaire[i][j].it.quantity);
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update Inventaire");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
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
