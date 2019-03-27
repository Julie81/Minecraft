import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Minecraft extends Frame implements WindowListener,ActionListener {
	
	JPanel content = new JPanel();
	CardLayout cl = new CardLayout();
	
	public static void main(String[] args) throws IOException {
		
		new Minecraft();

	}
	
	public Minecraft() throws IOException {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		
		ArrayList<Item> L = new ArrayList<>();
		L = BDD();

		
		Inventaire inv = new Inventaire(L);
	//	this.add(inv, BorderLayout.WEST);
		
		Recettes menu = new Recettes ();
		//this.add(menu, BorderLayout.WEST);
		
		
		content.setLayout(cl);
		content.add(inv,"inventaire");
		content.add(menu,"Menu");
		
		JPanel inv_rec = new JPanel();
		
		JButton inventaire = new JButton("inventaire");
		inventaire.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cl.show(content, "inventaire");
			}
		});
		
		JButton recette = new JButton("recettes");
		recette.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				cl.show(content, "Menu");
			}
		});
		
		inv_rec.add(inventaire);
		inv_rec.add(recette);
		
		this.add(inv_rec,BorderLayout.WEST);
		this.add(content,BorderLayout.SOUTH);
		
		
		
		Recolte rec = new Recolte(L);
		this.add(rec,BorderLayout.EAST);
		
		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
		this.setVisible(true);
	}

	private ArrayList<Item> BDD() throws IOException {
		ArrayList<Item> l = new ArrayList<>();
		Item pierre = new Item("miniatures/RC/pierre.png","pierre");
		Item  plume = new Item("miniatures/RC/plume.png","plume");
		Item eau = new Item("miniatures/RC/eau.png","eau");
		Item bois = new Item("miniatures/RC/bois.png","bois");
		Item diamant = new Item("miniatures/RC/diamant.png","diamant");
		Item bateau = new Item("miniatures/RC/bateau.png","bateau");
		Item echelle = new Item("miniatures/RC/echelle.png","echelle");
		Item fer = new Item("miniatures/RC/fer.png","fer");
		Item Rails = new Item("miniatures/RC/Rails.png","Rails");
		Item Wagonnet = new Item("miniatures/RC/Wagonnet.png","Wagonnet");
		Item viande = new Item("miniatures/RC/viande.png","viande");
		Item orange = new Item("miniatures/RC/orange.png","orange");
		l.add(pierre);
		l.add(bois);
		l.add(eau);
		l.add(plume);
		l.add(diamant);
		l.add(bateau);
		l.add(echelle);
		l.add(fer);
		l.add(Rails);
		l.add(Wagonnet);
		l.add(viande);
		l.add(orange);
		return l;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
