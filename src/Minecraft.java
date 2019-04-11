import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Minecraft extends Frame implements WindowListener,Observer{
	
	public static void main(String[] args) throws IOException {
		new Minecraft();
	}
	
	public Minecraft() throws IOException {
		super();
		Modele modl = new Modele();
		Controleur ctrl = new Controleur(modl);
		this.add(new JLabel(new ImageIcon("miniatures/fond_ecran.jpg")));
		
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		gbc.gridy=1;
		Inventaire_Vue inv = new Inventaire_Vue(ctrl,modl);
		modl.addObserver(inv);
		this.add(inv, gbc);
		
		gbc.gridx=1;
		Recolte_Vue rec = new Recolte_Vue(ctrl,modl);
		//modl.addObserver(rec);
		this.add(rec,gbc);
		
		gbc.gridy=0;
		Memoire_Vue mem = new Memoire_Vue(null);
		modl.addObserver(mem);
		this.add(mem,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		Atelier_Vue Av = new Atelier_Vue(ctrl,modl,inv);
		modl.addObserver(Av);
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
		g.drawImage(backroundImage, 0,0, null); 
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
	public void windowClosing(WindowEvent arg0) {
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

