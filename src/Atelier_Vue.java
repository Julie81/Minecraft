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
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Atelier_Vue extends Panel implements ActionListener,Observer,MouseListener{
	int larg=80;
	int quantite=1;
	Controleur_Atelier ctrla;
	Label affQ;
	JButton[][] Mat;
	
	public Atelier_Vue(Controleur_Atelier ctrla, Modele m) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setBackground(new Color(139,108,66));
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
				b.addActionListener(ctrla);
				b.addMouseListener(this);
				b.setBackground(new Color(200,173,127));
				this.add(b,gbc);
			}
		}
		gbc.gridx = 4*larg;
		gbc.gridy=larg-20;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=larg;
		gbc.gridheight=larg+20;
		Label quant = new Label ("quantite : ");
		quant.setFont(new Font("Arial",Font.BOLD,16));
		quant.setForeground(Color.black);
		
		this.add(quant,gbc);
		
		
		gbc.gridx = 4*larg+20;
		gbc.gridy=larg;
		gbc.ipadx=10;
		gbc.gridwidth=1;
		this.affQ = new Label(Integer.toString(quantite));
		this.affQ.setFont(new Font("Arial",Font.BOLD,16));
		this.affQ.setForeground(Color.black);
		this.add(affQ,gbc);
		
		gbc.gridx = 4*larg;;
		gbc.gridy=2*larg;
		gbc.ipadx=20;
		Button plus= new Button("+");
		plus.setFont(new Font("Arial",Font.BOLD,14));
		plus.setForeground(Color.black);
		plus.setActionCommand("+");
		plus.addActionListener(ctrla);
		plus.setPreferredSize(new Dimension(30,30));
		plus.setBackground(new Color(219,219,219));
		this.add(plus,gbc);
		
		gbc.gridx = 4*larg+20;;
		gbc.gridy=2*larg;
		gbc.ipadx=20;
		Button moins = new Button("-");
		moins.setFont(new Font("Arial",Font.BOLD,14));
		moins.setForeground(Color.black);
		moins.setBackground(new Color(219,219,219));
		moins.setActionCommand("-");
		moins.addActionListener(ctrla);
		moins.setPreferredSize(new Dimension(30,30));
		this.add(moins,gbc);
		
		gbc.gridx = 5*larg;;
		gbc.gridy=larg;
		Button craft = new Button("craft");
		craft.setFont(new Font("Arial",Font.BOLD,14));
		craft.setForeground(Color.black);
		craft.setActionCommand("C");
		craft.addActionListener(ctrla);
		craft.setBackground(new Color(219,219,219));
		craft.setPreferredSize(new Dimension(50,30));
		this.add(craft,gbc);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Atelier_Modele) {
			if(arg instanceof String){
				if ((String) arg == "reset") {
					this.newAt();
				}
				else {
					ImageIcon icon = new ImageIcon(((String) arg).substring(2));
					Image img = icon.getImage();
					Image newimg = img.getScaledInstance( larg-10, larg-10,  java.awt.Image.SCALE_SMOOTH ) ;
					icon = new ImageIcon(newimg);
					this.Mat[((String) arg).charAt(0)-'0'][((String) arg).charAt(1)-'0'].setIcon(icon);
				}
			}
			if(arg instanceof Integer) {
				this.quantite = (int) arg;
				this.affQ.setText(""+this.quantite);
				}
		}
		
	}

	private void newAt() {  // efface tout les materiaux de la table de craft de l'atelier
		for(int i=0;i<this.Mat.length;i++) {
			for(int j=0;j<this.Mat.length;j++) {
				this.Mat[i][j].setIcon(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
