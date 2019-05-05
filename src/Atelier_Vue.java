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
	int grille=3;
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
		//controleur de l'atelier
		this.ctrla = ctrla;
		//matrice de boutons
		this.Mat = new JButton[grille][grille];
		
		//initialisation de la grille de craft
		for (int i=0; i<grille; i++){
			//placement selon l'axe des ordonnees
			gbc.gridy = (i+1)*Minecraft.larg;
			
			for (int j=0; j<grille;j++){

				//placement selon l'axe des abscisses
				gbc.gridx = j*Minecraft.larg;
				
				//creation des boutons
				JButton b = new JButton();
				b.setActionCommand("f"+i+""+j);
				this.Mat[i][j] = b;
				//dimension du bouton
				b.setPreferredSize(new Dimension(Minecraft.larg,Minecraft.larg));
				//ajout des actions sur le bouton
				b.addActionListener(ctrla);
				b.addMouseListener(this);
				//couleur de fond et contour du bouton
				b.setBackground(new Color(200,173,127));
				Border bord = new LineBorder(Color.black, 1);
				b.setBorder(bord);
				//ajout du bouton a l'atelier
				this.add(b,gbc);
			}
		}
		
		//creation et placement du titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		//titre etendue sur plusieurs cases dans la longueur
		gbc.fill= GridBagConstraints.HORIZONTAL;
		//titre prend trois cases sur la longueur
		gbc.gridwidth=Minecraft.larg*grille;
		Label atelier = new Label (" Craftez vos ressources : ");
		//police du titre
		atelier.setFont(new Font("Arial",Font.BOLD,18));
		//coleur du titre
		atelier.setForeground(Color.white);
		//ajout du titre a l'atelier
		this.add(atelier,gbc);
		
		//creation et placement de la legende quantite
		gbc.gridx = (grille+1)*Minecraft.larg;
		gbc.gridy=2*Minecraft.larg-Minecraft.espace1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=Minecraft.larg;
		//la quantite s'etend sur la hauteur de 70 (Minecraft.larg+20)
		gbc.gridheight=Minecraft.larg+Minecraft.espace1;
		Label quant = new Label ("     	     Quantite : ");
		quant.setFont(new Font("Arial",Font.BOLD,16));
		quant.setForeground(Color.white);
		this.add(quant,gbc);
		
		//creation et placement de la quantite
		gbc.gridx = (grille+1)*Minecraft.larg+Minecraft.espace1;
		gbc.gridy=2*Minecraft.larg;
		gbc.ipadx=Minecraft.espace2;
		gbc.gridwidth=1;
		this.affQ = new Label(Integer.toString(quantite));
		this.affQ.setFont(new Font("Arial",Font.BOLD,16));
		this.affQ.setForeground(Color.white);
		this.add(affQ,gbc);
		
		//ajout d'un espace entre le tableau et le bouton plus
		Label blanc=new Label("");
		blanc.setPreferredSize(new Dimension (Minecraft.espace2,Minecraft.espace1));
		gbc.gridx=(grille+1)*Minecraft.larg;
		gbc.gridy=2*Minecraft.larg;
		this.add(blanc,gbc);
		
		//creation et placement du bouton plus
		gbc.gridx = (grille+1)*Minecraft.larg+Minecraft.espace1-5;;
		gbc.gridy=grille*Minecraft.larg;
		//le bouton plus est espace en largeur de 10 (Minecraft.espace_haut)
		gbc.ipadx=Minecraft.espace1;
		Button plus= new Button("+");
		plus.setFont(new Font("Arial",Font.BOLD,12));
		plus.setForeground(Color.black);
		plus.setActionCommand("+");
		plus.addActionListener(ctrla);
		plus.setPreferredSize(new Dimension(Minecraft.taille_bouton,Minecraft.taille_bouton));
		plus.setBackground(Minecraft.fond_bouton);
		this.add(plus,gbc);
		
		//creation et placement du bouton moins
		gbc.gridx = (grille+1)*Minecraft.larg+Minecraft.espace1;;
		gbc.gridy=grille*Minecraft.larg;
		gbc.ipadx=Minecraft.espace1;
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
		gbc.gridx = (grille+2)*Minecraft.larg;;
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
					//on recupere l'image a mettre dans la grille
					ImageIcon icon = new ImageIcon(((String) arg).substring(2));
					Image img = icon.getImage();
					//placement de l'image dans la case
					Image newimg = img.getScaledInstance( Minecraft.larg-Minecraft.espace2, Minecraft.larg-Minecraft.espace2,  java.awt.Image.SCALE_SMOOTH ) ;
					icon = new ImageIcon(newimg);
					//ajout de l'image dans la grille
					this.Mat[((String) arg).charAt(0)-'0'][((String) arg).charAt(1)-'0'].setIcon(icon);
				}
			}
			if(arg instanceof Integer) {
				//modification de la quantite
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
