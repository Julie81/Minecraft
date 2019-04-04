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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Minecraft extends Observable implements WindowListener,ItemListener {
	Frame f;
	
	public static void main(String[] args) throws IOException {
		new Minecraft();

	}
	
	public Minecraft() throws IOException {

		GridBagConstraints gbc = new GridBagConstraints();
		this.f = new Frame();
		this.f.setLayout(new GridBagLayout());
		this.f.setBackground(Color.WHITE);
		gbc.gridx=0;
		gbc.gridy=0;
		
		ArrayList<Item> L = new ArrayList<>();
		L = BDD();
		/*
		gbc.gridy=1;
		Inventaire inv = new Inventaire(L);
		this.add(inv, gbc);
		*/
				
		
		//item.txt obtenu a partir de ls RC/ > item.txt
		//Creation du fichier itemID.txt a partir du fichier item.txt
		//future modification facile a implementer
		BufferedReader reader = new BufferedReader(new FileReader("miniatures/item.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("miniatures/itemID.txt"));
		
		try {
		    String line = reader.readLine();

		    int cpt = 1;
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
		HashMap<String,String> itemNametoID = new HashMap<String,String>();
		
		reader = new BufferedReader(new FileReader("miniatures/itemID.txt"));
		try {
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	String ID = split[0];
		    	String itemPath = split[1];
		    	String itemName = itemPath.replace("_"," ").replace(".png","");
		    	//System.out.println(ID+" "+itemPath+ " "+itemName);
		    	
		    	itemList.put(ID, new Item("miniatures/RC/"+itemPath, itemName, ID));
		    	itemNametoID.put(itemName, ID);
		    	
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

		    while (line != null) {
		    	String[] split = line.split(";");
		    	
		    	String itemCrafted = split[0];
		    	String itemID = itemNametoID.get(itemCrafted);
		    	
		    	
		    	String[] itemsName = split[1].split(":");
		    	String[][] itemsNameList = {itemsName[0].split(","),itemsName[1].split(","),itemsName[2].split(",")}; 
		    	
		    	Item[][] items = new Item[3][3];
		    	String craftID = "";
		    	
		    	for(int i=0;i<3;i++) {
		    		for(int j=0;j<3;j++) {
		    			if(itemsNameList[i][j].equals("null")) {
		    				items[i][j] = null;
		    				craftID+= "00";
		    			}
		    			else {
			    			String ID = itemNametoID.get(itemsNameList[i][j]);
				    		items[i][j] = itemList.get(itemID);
				    		craftID += ID;
		    			}

		    		}
		    	}
		    	craftList.put(craftID, new Craft(itemList.get(itemID), items));
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
		
		
		//la base de doonne dois etre completer pour pouvoir faire des tests
		//System.out.println(craftList.get("080200000000000000").item.name);
		
		gbc.gridy=1;
		Inventaire inv = new Inventaire(itemList);
		this.f.add(inv, gbc);
		
		gbc.gridx=1;
		Recolte rec = new Recolte(L);
		this.f.add(rec,gbc);
		
		gbc.gridy=0;
		Memoire mem = new Memoire (null);
		this.f.add(mem,gbc);
		
		gbc.gridx=0;
		gbc.gridy=0;
		Craft_Zone cz = new Craft_Zone ();
		this.f.add(cz,gbc);
		
		Controleur c = new Controleur(inv, mem, cz, rec);
		
		c.addObserver(rec);
		c.addObserver(inv);
		this.f.addWindowListener(this);
		this.f.setTitle ("Table de craft Minecraft");
		this.f.pack();
		this.f.setVisible(true);
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
		Item rails = new Item("miniatures/RC/rails.png","rails");
		Item wagon = new Item("miniatures/RC/wagon.png","wagon");
		Item pomme = new Item("miniatures/RC/pomme.png","pomme");
		Item viande = new Item("miniatures/RC/viande.png","viande");
		Item orange = new Item("miniatures/RC/orange.png","orange");
		Item pioche_en_pierre = new Item("miniatures/RC/pioche_en_pierre.png","pioche_en_pierre");
		//Item or = new Item("miniatures/RC/or.png","or");
		//Item lianes = new Item("miniatures/RC/lianes.png","lianes");
		Item hache_en_fer = new Item("miniatures/RC/hache_en_fer.png","hache_en_fer");
		//Item ficelle = new Item("miniatures/RC/ficelle.png","ficelle");
		//Item lait = new Item("miniatures/RC/lait.png","lait");
		//Item fleche = new Item("miniatures/RC/fleche.png","fleche");
		l.add(pierre);
		l.add(bois);
		l.add(eau);
		l.add(plume);
		//l.add(or);
		l.add(fer);
		l.add(diamant);
		l.add(pomme);
		l.add(orange);
		//l.add(lait);
		//l.add(lianes);
		l.add(pioche_en_pierre);
		//l.add(ficelle);
		l.add(hache_en_fer);
		//l.add(fleche);
		l.add(bateau);
		l.add(echelle);
		l.add(rails);
		l.add(wagon);
		l.add(viande);
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
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
		if (e.getSource() instanceof JitmButton) {
			JitmButton b = (JitmButton) e.getSource();
			System.out.println(b.it.name);
		}
		
	}


}
