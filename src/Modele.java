import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Modele extends Observable implements WindowListener,ItemListener {
	Frame f;
	
	public static void main(String[] args) throws IOException {
		new Modele();

	}
	
	public Modele() throws IOException {

		GridBagConstraints gbc = new GridBagConstraints();
		this.f = new Frame();
		this.f.setLayout(new GridBagLayout());
		this.f.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;			
		
		//item.txt obtenu a partir de ls RC/ > item.txt
		//Creation du fichier itemID.txt a partir du fichier item.txt
		//future modification facile a implementer
		BufferedReader reader = new BufferedReader(new FileReader("miniatures/item.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("miniatures/itemID.txt"));
		
		try {
		    String line = reader.readLine();

		    int cpt = 0;
		    String ID= "";
		    
		    while (line != null) {
		    	if(cpt<10) {
		    		ID = "0"+cpt;
		    	}
		    	else {
		    		ID = ""+cpt;
		    	}
		    	writer.write(ID+";"+line+"\n");
		        line = reader.readLine();
		        cpt++;
		    }
		} finally {
		    reader.close();
		    writer.close();
		}

		//initalisation de la BDD d'item
		
		HashMap<String,Item> itemList = new HashMap<String,Item>();
		HashMap<String,Item> itemNametoItem = new HashMap<String,Item>();
		
		reader = new BufferedReader(new FileReader("miniatures/itemID.txt"));
		try {
			Item item;
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	String ID = split[0];
		    	String itemPath = split[1];
		    	String itemName = itemPath.replace("_"," ").replace(".png","");
		    	
		    	item = new Item("miniatures/RC/"+itemPath, itemName, ID);
		    	itemList.put(ID, item);
		    	itemNametoItem.put(itemName, item);
		    	
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
		
		//initialisation de la BDD de craft
		
		HashMap<String,Craft> craftList = new HashMap<String,Craft>();
		
		reader = new BufferedReader(new FileReader("miniatures/Craft.txt"));
		try {
		    String line = reader.readLine();
		    Craft craft;

		    while (line != null) {
		    	String[] split = line.split(";");
		    	
		    	String itemCrafted = split[0];
		    	String itemID = itemNametoItem.get(itemCrafted).ID;
		    	
		    	
		    	String[] itemsName = split[1].split(":");
		    	String[][] itemsNameList = {itemsName[0].split(","),itemsName[1].split(","),itemsName[2].split(",")}; 
		    	
		    	Item[][] items = new Item[3][3];
		    	String craftID = "";
		    	
		    	for(int i=0;i<3;i++) {
		    		for(int j=0;j<3;j++) {
		    			if(itemsNameList[i][j].equals("null")) {
		    				items[i][j] = null;
		    				craftID+= "99";
		    			}
		    			else {
			    			String ID = itemNametoItem.get(itemsNameList[i][j]).ID;
				    		items[i][j] = itemNametoItem.get(itemsNameList[i][j]);
				    		craftID += ID;
		    			}

		    		}
		    	}
		    	craft = new Craft(itemList.get(itemID), items);
		    	craft.UpperLeft();
		    	itemList.get(itemID).setCraft(craft);
		    	craftList.put(craftID, craft);
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
				
		gbc.gridy=1;
		Inventaire_Vue inv = new Inventaire_Vue(itemList);
		this.f.add(inv, gbc);
		
		gbc.gridx=1;
		Recolte_Vue rec = new Recolte_Vue(itemNametoItem);
		this.f.add(rec,gbc);
		
		gbc.gridy=0;
		Memoire_Vue mem = new Memoire_Vue (null);
		this.f.add(mem,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		Atelier_Vue cz = new Atelier_Vue(inv);
		this.f.add(cz,gbc);
		
		Controleur c = new Controleur(inv, mem, cz, rec);
		
		c.addObserver(rec);
		c.addObserver(inv);
		this.f.addWindowListener(this);
		this.f.setTitle ("Table de craft Minecraft");
		this.f.pack();
		this.f.setVisible(true);
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
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
		if (e.getSource() instanceof JitmButton) {
			JitmButton b = (JitmButton) e.getSource();
			System.out.println(b.it.name);
		}
		
	}


}
