import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

public class Atelier_Vue extends Panel implements MouseListener,Observer{
	int larg=80;
	int quantite=1;
	Inventaire_Vue inv;
	
	public Atelier_Vue(Controleur c, Modele m,Inventaire_Vue iv) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.inv = iv;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 5;
		gbc.gridwidth = 7;
		
		for (int i=0; i<3; i++){
			gbc.gridy = i*larg;
			
			for (int j=0; j<3;j++){

				gbc.gridx = (j+1)*larg;
				JitmButton b = new JitmButton(null);
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() instanceof JitmButton) {
							JitmButton temp = (JitmButton) e.getSource();
							try {
								ImageIcon icon = new ImageIcon(inv.tampon.it.path);
								Image img = icon.getImage();
								Image newimg = img.getScaledInstance( larg-10, larg-10,  java.awt.Image.SCALE_SMOOTH ) ;
								icon = new ImageIcon(newimg);
								temp.setIcon(icon);
							}
							catch(Exception ex){
							}
							
						}
						
					}
				});
				b.setPreferredSize(new Dimension(larg,larg));
				b.addMouseListener(this);
				b.setText("");
				this.add(b,gbc);
			}
		}
		
		gbc.gridx = 0;
		gbc.gridy=larg;
		Button b = new Button("recharger");
		b.setBackground(Color.lightGray);
		b.setPreferredSize(new Dimension(80,30));
		this.add(b,gbc);
		
		gbc.gridx = 4*larg+20;
		gbc.gridy=larg;
		Label q = new Label(Integer.toString(quantite));
		this.add(q,gbc);
		
		gbc.gridx = 4*larg;;
		gbc.gridy=2*larg;
		Button plus= new Button("+");
		plus.setPreferredSize(new Dimension(30,30));
		plus.setBackground(Color.lightGray);
		this.add(plus,gbc);
		
		gbc.gridx = 4*larg+20;;
		gbc.gridy=2*larg;
		Button moins = new Button("-");
		moins.setPreferredSize(new Dimension(30,30));
		moins.setBackground(Color.lightGray);
		this.add(moins,gbc);
		
		gbc.gridx = 5*larg;;
		gbc.gridy=larg;
		Button craft = new Button("craft");
		craft.setPreferredSize(new Dimension(50,30));
		craft.setBackground(Color.lightGray);
		this.add(craft,gbc);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton()== MouseEvent.BUTTON3) {
			 if (e.getSource() instanceof JitmButton) {
				 JitmButton b = (JitmButton) e.getSource();
				 b.setIcon(null);
			 }
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
