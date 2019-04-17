import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
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


public class Minecraft extends Frame implements WindowListener,Observer{
	
	Modele modl;
	Atelier_Modele atm;
	AudioClip adc;
	
	public static void main(String[] args) throws IOException {
		new Minecraft();
	}

	public Minecraft() throws IOException {
		super();
		NewLoadGame nlg = new NewLoadGame();
		while(!nlg.choice || nlg.IGN.equals("")) {	//on reste sur la premiere frame de choix tant que l'utilisateur n'a pas fait son choix ou bien que son IGN est vide
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		nlg.dispose();
		this.modl = new Modele(nlg.fileName,nlg.New);
		this.atm = new Atelier_Modele(modl.craftList,modl);
		Controleur_Rec ctrl = new Controleur_Rec(modl);
		Controleur_Atelier ctrlA = new Controleur_Atelier(atm,modl);
		
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		gbc.gridy=1;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.ipady=20;
		gbc.ipadx=20;
		Inventaire_Vue inv = new Inventaire_Vue(ctrl,ctrlA,modl);
		modl.addObserver(inv);
		atm.addObserver(inv);
		this.add(inv, gbc);
		
		
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.VERTICAL;
		gbc.gridheight=2;
		gbc.ipadx=20;
		Recolte_Vue rec = new Recolte_Vue(ctrl,modl);
		this.add(rec,gbc);
		
		gbc.gridwidth=1;
		gbc.gridheight=1;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.ipadx=30;
		Atelier_Vue Av = new Atelier_Vue(ctrlA,modl);
		atm.addObserver(Av);
		this.add(Av,gbc);
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.ipady=50;
		Message_Memoire_Vue mmem = new Message_Memoire_Vue();
		this.add(mmem,gbc);
		

		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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

