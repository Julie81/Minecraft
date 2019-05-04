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


public class Minecraft extends JFrame implements WindowListener,Observer{
	
	Modele modl;
	Atelier_Modele atm;
	static int larg=80;
	static int espace_haut=20;
	static int espace_larg=10;
	static int taille_bouton=30;
	static Color fond = new Color (139,108,66);
    static Color fond_bouton = new Color (219,219,219);
	
	
	public static void main(String[] args) throws IOException {
		new Minecraft();
	}

	public Minecraft() throws IOException {
		super();
		this.setBackgroundImage(this, new File("miniatures/fond_ecran.jpg"));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		NewLoadGame nlg = new NewLoadGame();	// Lance le menu permettant de creer  une nouvelle partie ou d'en charger une
		while(!nlg.choice || nlg.IGN.equals("")) {	//on reste sur la premiere frame de choix tant que l'utilisateur n'a pas fait son choix ou bien que son IGN est vide
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		nlg.dispose();	//fermeture de la fenetre de lancement de partie
		this.modl = new Modele(nlg.fileName,nlg.New);	//Creer un modele qui sera sauvegarder sur le fichier fileName
		this.atm = new Atelier_Modele(modl);
		Controleur_Rec ctrl = new Controleur_Rec(modl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		Message_Memoire_Vue mmem = new Message_Memoire_Vue();
		
		Controleur_Atelier ctrlA = new Controleur_Atelier(atm,mmem);
		
		gbc.gridy=1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		//gbc.fill=GridBagConstraints.VERTICAL;
		//gbc.gridheight=2;
		gbc.ipady=20;
		gbc.ipadx=20;
		Inventaire_Vue inv = new Inventaire_Vue(ctrl,ctrlA,modl);
		modl.addObserver(inv);
		atm.addObserver(inv);
		this.add(inv, gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.gridheight=2;
		gbc.ipadx=20;
		Recolte_Vue rec = new Recolte_Vue(ctrl,modl);
		atm.addObserver(rec);
		this.add(rec,gbc);
		
		gbc.gridwidth=1;
		gbc.gridheight=1;
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.ipadx=20;
		Sauvegarde_Vue s = new Sauvegarde_Vue(modl);
		this.add(s,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.ipadx=30;
		Atelier_Vue Av = new Atelier_Vue(ctrlA,modl);
		atm.addObserver(Av);
		this.add(Av,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.ipady=50;
		this.add(mmem,gbc);
		

		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
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

