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
import javax.swing.JButton;

public class Atelier_Vue extends Panel implements ActionListener,Observer{
	int larg=50;
	int quantite=1;
	Controleur_Atelier ctrla;
	Label affQ;
	JButton[][] Mat;
	
	public Atelier_Vue(Controleur_Atelier ctrla, Modele m,Inventaire_Vue iv) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.ctrla = ctrla;
		this.Mat = new JButton[3][3];
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 5;
		gbc.gridwidth = 7;
		
		for (int i=0; i<3; i++){
			gbc.gridy = i*larg;
			
			for (int j=0; j<3;j++){

				gbc.gridx = (j+1)*larg;
				JButton b = new JButton();
				b.setActionCommand("f"+i+""+j);
				this.Mat[i][j] = b;
				b.setPreferredSize(new Dimension(larg,larg));
				//b.addMouseListener(this);
				b.addActionListener(ctrla);
				this.add(b,gbc);
			}
		}
		
		gbc.gridx = 4*larg+20;
		gbc.gridy=larg;
		this.affQ = new Label(Integer.toString(quantite));
		this.add(affQ,gbc);
		
		gbc.gridx = 4*larg;;
		gbc.gridy=2*larg;
		Button plus= new Button("+");
		plus.setActionCommand("+");
		plus.addActionListener(ctrla);
		plus.setPreferredSize(new Dimension(30,30));
		plus.setBackground(Color.lightGray);
		this.add(plus,gbc);
		
		gbc.gridx = 4*larg+20;;
		gbc.gridy=2*larg;
		Button moins = new Button("-");
		moins.setActionCommand("-");
		moins.addActionListener(ctrla);
		moins.setPreferredSize(new Dimension(30,30));
		moins.setBackground(Color.lightGray);
		this.add(moins,gbc);
		
		gbc.gridx = 5*larg;;
		gbc.gridy=larg;
		Button craft = new Button("craft");
		craft.setActionCommand("C");
		craft.addActionListener(ctrla);
		craft.setPreferredSize(new Dimension(50,30));
		craft.setBackground(Color.lightGray);
		this.add(craft,gbc);
	}
/*
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton()== MouseEvent.BUTTON3) {
			 if (e.getSource() instanceof JButton) {
				 JButton b = (JButton) e.getSource();
				 System.out.println("on efface");
				 b.setIcon(null);;
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
*/
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Atelier_Modele) {
			if(arg instanceof String){
				ImageIcon icon = new ImageIcon(((String) arg).substring(2));
				Image img = icon.getImage();
				Image newimg = img.getScaledInstance( larg-10, larg-10,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				this.Mat[((String) arg).charAt(0)-'0'][((String) arg).charAt(1)-'0'].setIcon(icon);
				
			}
			if(arg instanceof Integer) {
				System.out.println("Vue atelier");
				this.quantite = (int) arg;
				this.affQ.setText(""+this.quantite);
				}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
