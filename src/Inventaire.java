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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Inventaire extends Panel implements ActionListener,Observer {
	public JitmButton tampon;
	public JitmButton[][] inventaire;
	
	public Inventaire(ArrayList<Item> r) {
		super();
		int dim = 10;
		int ligne = 2;
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
			
			for (int j=0; j<colonne-5;j++){

				gbc.gridx = j*larg;
				String sobriquet = i+""+j+"";
				JitmButton b = new JitmButton(r.get(i*dim+j));
				inventaire[i][j] = b;
				b.setPreferredSize(new Dimension(larg,larg));
				
				ImageIcon icon = new ImageIcon("miniatures/RC/"+r.get(i*dim+j).name+".png");
				Image img = icon.getImage() ;
				Image newimg = img.getScaledInstance( s_icon, s_icon,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				b.setIcon(icon);
				
				b.setText(""+r.get(i*dim+j).quantity);
				b.setHorizontalTextPosition(SwingConstants.RIGHT);
				b.setVerticalTextPosition(SwingConstants.BOTTOM);
				b.setActionCommand(sobriquet);  // Il y aura ici en fait un string caracterisant l'item sur lequel on a cliqu�
				b.addActionListener(this);
				this.add(b,gbc);
			}
		}
		
		this.setPreferredSize(new Dimension(5*larg+10,2*larg+10));

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

	}


	@Override
	public void update(Observable o, Object arg) {
		
	}
	

}
