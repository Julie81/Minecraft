import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class Vue extends Frame implements WindowListener{
	
	public Vue(HashMap<String, Item> itemList, HashMap<String, Item> itemNametoItem) {
		
		super();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		gbc.gridy=1;
		Inventaire_Vue inv = new Inventaire_Vue(itemList);
		this.add(inv, gbc);
		
		gbc.gridx=1;
		Recolte_Vue rec = new Recolte_Vue(itemNametoItem);
		this.add(rec,gbc);
		
		gbc.gridy=0;
		Memoire_Vue mem = new Memoire_Vue (null);
		this.add(mem,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		Atelier_Vue Av = new Atelier_Vue(inv);
		this.add(Av,gbc);
		
		Controleur c = new Controleur(inv, mem, Av, rec);
		
		c.addObserver(rec);
		c.addObserver(inv);
		this.addWindowListener(this);
		this.setTitle ("Table de craft Minecraft");
		this.pack();
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

}
