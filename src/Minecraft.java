import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class Minecraft extends Frame implements WindowListener {
	
	public static void main(String[] args) throws IOException {
		
		new Minecraft();

	}
	
	public Minecraft() throws IOException {
		ArrayList<Item> L = new ArrayList<>();
		L = BDD();
		this.setLayout(new BorderLayout());
		
		Inventaire inv = new Inventaire(L);
		this.add(inv, BorderLayout.WEST);
		
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

}
