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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Atelier_Vue extends Panel implements ActionListener,Observer,MouseListener{
	int larg=80;
	int quantite=1;
	Controleur_Atelier ctrla;
	Label affQ;
	JButton[][] Mat;
	
	public Atelier_Vue(Controleur_Atelier ctrla, Modele m) {
		//initialisation du Layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 5;
		gbc.gridwidth = 7;
		
		//couleur de fond de l'atelier
		this.setBackground(Minecraft.fond);
		this.ctrla = ctrla;
		this.Mat = new JButton[3][3];
		
		//initialisation de la grille de craft
		for (int i=0; i<3; i++){
			//placement selon l'axe des ordonnees
			gbc.gridy = (i+1)*Minecraft.larg;
			
			for (int j=0; j<3;j++){

				//placement selon l'axe des abscisses
				gbc.gridx = j*Minecraft.larg;
				
				//creation des boutons
				JButton b = new JButton();
				b.setActionCommand("f"+i+""+j);
				this.Mat[i][j] = b;
				b.setPreferredSize(new Dimension(Minecraft.larg,Minecraft.larg));
				b.addActionListener(ctrla);
				b.addMouseListener(this);
				b.setBackground(new Color(200,173,127));
				Border bord = new LineBorder(Color.black, 1);
				b.setBorder(bord);
				this.add(b,gbc);
			}
		}
		
		//creation et placement du titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=larg*3;
		Label atelier = new Label (" Craftez vos ressources : ");
		atelier.setFont(new Font("Arial",Font.BOLD,18));
		atelier.setForeground(Color.white);
		this.add(atelier,gbc);
		
		//creation et placement de la legende quantite
		gbc.gridx = 4*Minecraft.larg;
		gbc.gridy=2*Minecraft.larg-20;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=Minecraft.larg;
		gbc.gridheight=Minecraft.larg+20;
		Label quant = new Label ("     	     Quantite : ");
		quant.setFont(new Font("Arial",Font.BOLD,16));
		quant.setForeground(Color.white);
		this.add(quant,gbc);
		
		//creation et placement de la quantite
		gbc.gridx = 4*larg+Minecraft.espace_haut;
		gbc.gridy=2*Minecraft.larg;
		gbc.ipadx=Minecraft.espace_larg;
		gbc.gridwidth=1;
		this.affQ = new Label(Integer.toString(quantite));
		this.affQ.setFont(new Font("Arial",Font.BOLD,16));
		this.affQ.setForeground(Color.white);
		this.add(affQ,gbc);
		
		//ajout d'un espace entre le tableau et le bouton plus
		Label blanc=new Label("");
		blanc.setPreferredSize(new Dimension (10,20));
		gbc.gridx=4*Minecraft.larg;
		gbc.gridy=2*Minecraft.larg;
		this.add(blanc,gbc);
		
		//creation et placement du bouton plus
		gbc.gridx = 4*Minecraft.larg+Minecraft.espace_haut-5;;
		gbc.gridy=3*Minecraft.larg;
		gbc.ipadx=Minecraft.espace_haut;
		Button plus= new Button("+");
		plus.setFont(new Font("Arial",Font.BOLD,12));
		plus.setForeground(Color.black);
		plus.setActionCommand("+");
		plus.addActionListener(ctrla);
		plus.setPreferredSize(new Dimension(Minecraft.taille_bouton,Minecraft.taille_bouton));
		plus.setBackground(Minecraft.fond_bouton);
		this.add(plus,gbc);
		
		//creation et placement du bouton moins
		gbc.gridx = 4*Minecraft.larg+Minecraft.espace_haut;;
		gbc.gridy=3*Minecraft.larg;
		gbc.ipadx=Minecraft.espace_haut;
		Button moins = new Button("-");
		moins.setFont(new Font("Arial",Font.BOLD,14));
		moins.setForeground(Color.black);
		moins.setBackground(Minecraft.fond_bouton);
		moins.setActionCommand("-");
		moins.addMouseListener(this);
		moins.addActionListener(ctrla);
		moins.setPreferredSize(new Dimension(Minecraft.taille_bouton,Minecraft.taille_bouton));
		this.add(moins,gbc);
		
		//creation et placement du bouton craft
		gbc.gridx = 5*Minecraft.larg;;
		gbc.gridy=2*Minecraft.larg;
		Button craft = new Button("Crafter");
		craft.setFont(new Font("Arial",Font.BOLD,12));
		craft.setForeground(Color.black);
		craft.setActionCommand("C");
		craft.addActionListener(ctrla);
		craft.setBackground(Minecraft.fond_bouton);
		craft.setPreferredSize(new Dimension(Minecraft.taille_bouton*2,Minecraft.taille_bouton));
		this.add(craft,gbc);
	}

	@Override
	//mise a jour de la vue
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
