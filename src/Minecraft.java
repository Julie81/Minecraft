import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Minecraft extends JFrame implements WindowListener,Observer{
	
	Modele modl;
	Atelier_Modele atm;
	//largeur des cases
	static int larg=80;
	//longueur des cases
	static int longr=100;
	//espace entre les cases
	static int espace1=20;
	static int espace2=10;
	//taille des boutons
	static int taille_bouton=30;
	//couleur de fond des panels Recolte, Craft,...
	static Color fond = new Color (139,108,66);
	//couleur de fon des boutons
    static Color fond_bouton = new Color (219,219,219);

	public Minecraft(NewLoadGame nlg) throws IOException {
		super();
		//ajout de l'image de fond
		this.setBackgroundImage(this, new File("miniatures/fond_ecran.jpg"));
		//mode plein ecran
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.modl = new Modele(nlg.fileName,nlg.New);//Creer un modele qui sera sauvegarder sur le fichier fileName
		this.atm = new Atelier_Modele(modl);
		
		//initialisation du Layout
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		//ajout de la memoire et du message de la memoire
		Message_Memoire_Vue mmem = new Message_Memoire_Vue();
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.ipady=50;
		gbc.ipadx=Minecraft.taille_bouton;
		this.add(mmem,gbc);
		
		//initialisation des controleurs
		Controleur_Rec ctrl = new Controleur_Rec(modl);
		Controleur_Game ctrlg = new Controleur_Game(this);
		Controleur_Atelier ctrlA = new Controleur_Atelier(atm,mmem);
		
		//ajout et placement de l'inventaire
		gbc.gridy=1;
		gbc.gridx=0;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		gbc.ipady=this.espace1;
		gbc.ipadx=this.espace1;
		Inventaire_Vue inv = new Inventaire_Vue(ctrl,ctrlA,modl);
		//ajout des observateurs de l'inventaire
		modl.addObserver(inv);
		atm.addObserver(inv);
		this.add(inv, gbc);
		
		//ajout et placement de la recolte
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.gridheight=2;
		gbc.ipadx=this.espace1;
		Recolte_Vue rec = new Recolte_Vue(ctrl,ctrlg,modl);
		atm.addObserver(rec);
		this.add(rec,gbc);
		
		//remise en place des cases su Layout
		gbc.gridwidth=1;
		gbc.gridheight=1;
		
		//ajout et placement de l'atelier
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.ipadx=this.taille_bouton;
		Atelier_Vue Av = new Atelier_Vue(ctrlA,modl);
		atm.addObserver(Av);
		this.add(Av,gbc);
		

		this.addWindowListener(this);
		//titre de la fenetre
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		//fonction permettant d'ajouter l'image de fond
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); g.drawImage(buf, 0,0, this.getWidth(),this.getHeight(), null); }
		};
		frame.setContentPane(panel); 
		return panel; }

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0){
		//quitte l'application
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

