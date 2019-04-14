import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Minecraft extends JFrame implements WindowListener,Observer{
	
	Modele modl;
	Atelier_Modele atm;
	
	public static void main(String[] args) throws IOException {
		new Minecraft();
	}
	
	public JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); g.drawImage(buf, 0,0, null); }
		};
		frame.setContentPane(panel); 
		return panel; }
	
	public Minecraft() throws IOException {
		super();
		this.setBackgroundImage(this, new File("miniatures/fond_ecran.jpg"));
		NewLoadGame nlg = new NewLoadGame();
		while(!nlg.choice) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nlg.dispose();
		this.modl = new Modele(nlg.fileName,nlg.New);
		this.atm = new Atelier_Modele(modl.craftList);
		Controleur_Rec ctrl = new Controleur_Rec(modl);
		Controleur_Atelier ctrlA = new Controleur_Atelier(atm);
		//this.add(new JLabel(new ImageIcon("miniatures/fond_ecran.jpg")));
		
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		gbc.gridy=1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		gbc.ipady=20;
		gbc.ipadx=20;
		Inventaire_Vue inv = new Inventaire_Vue(ctrl,ctrlA,modl);
		modl.addObserver(inv);
		atm.addObserver(inv);
		inv.setBackground(new Color(0,0,0,0));
		this.add(inv, gbc);
		
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.gridheight=2;
		gbc.ipadx=20;
		Recolte_Vue rec = new Recolte_Vue(ctrl,modl);
		rec.setBackground(new Color(0,0,0,0));
		this.add(rec,gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		CardLayout cl = new CardLayout();
		JPanel memoire= new JPanel();
		String[] listContent = {"Messsage","Matrice"};
		int indice = 0;
		JPanel card1= new JPanel();
		Font f = new Font("Serif", Font.PLAIN, 36); 
		JLabel message = new JLabel("Choisissez un item ");
		JLabel message2 = new JLabel("parmi les recettes");
		JLabel message3 = new JLabel("pour connaitre son craft...");
		card1.setBackground(new Color(0,0,0,0));
		message.setFont(f);
		message2.setFont(f);
		message3.setFont(f);
		message.setForeground(Color.GREEN);
		message2.setForeground(Color.GREEN);
		message3.setForeground(Color.GREEN);
		Box Mess = Box.createVerticalBox();
		Mess.add(message);
		Mess.add(message2);
		Mess.add(message3);
		card1.add(Mess);
		JPanel card2 = new JPanel();
		Memoire_Vue memvue = new Memoire_Vue(null);
		card2.setBackground(new Color(0,0,0,0));
		modl.addObserver(memvue);
		this.add(memoire,gbc);
		memoire.setLayout(cl);
		memoire.add(card1, listContent[0]);
	    memoire.add(card2, listContent[1]);
		
		gbc.gridx=0;
		gbc.gridy=0;
		Atelier_Vue Av = new Atelier_Vue(ctrlA,modl,inv);
		Av.setBackground(new Color(0,0,0,0));
		atm.addObserver(Av);
		this.add(Av,gbc);
		

		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void paintComponent(Graphics g) throws IOException { 
		
		super.paintComponents(g); 
		BufferedImage backroundImage = ImageIO.read(this.getClass() .getResourceAsStream("machinarium.jpg"));
		g.drawImage(backroundImage, 0,0,this.getWidth(),this.getHeight(), null); 
		} 

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
		try {
			modl.saveGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

