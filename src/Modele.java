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
import java.io.FileNotFoundException;
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
import javax.swing.plaf.synth.SynthSpinnerUI;


public class Modele extends Observable{
	
	HashMap<String,Item> itemList;
	HashMap<String,Item> itemNametoItem;
	HashMap<String,Craft> craftList;
	HashMap<Integer,ArrayList<Item>> itemGen;
	String gamePath;
	String OSseparator;

	public Modele(String fileName,Boolean New) throws IOException {
		
		File file = null;
		this.OSseparator = file.separator;
		
		this.gamePath = "miniatures"+OSseparator+fileName+".txt";
		//item.txt obtenu a partir de ls RC/ > item.txt
		//Creation du fichier itemID.txt a partir du fichier item.txt
		//future modification facile a implementer
		
		if(New) {
			eraseData();
			newGame();
		}

		//initalisation de la BDD d'item
		initItemMap();
		
		
		//initialisation des lock d'item
		initItemLock();
		
		//initialisation de la BDD de craft
		initCraftMap();
		
		//initialisation d'un tri des item celon leur generation
		initItemGen();
		
		
		//this.affichBDDcraft();	//permet une visualisation de la BDD des crafts	
	}
	
	public void eraseData() throws IOException {
		File file = new File("miniatures"+OSseparator+"Save");
        File[] files = file.listFiles();
        
        String ID = gamePath.split("_")[0];
        for(File f : files) {
        	if(f.getPath().contains(ID)){
        		f.delete();	//suppression des fichier utilisant le meme espace de sauvegarde
        	}

        }
	}
	
	public void newGame() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"item.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath));
		
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
		    	writer.write(ID+";"+line+";"+"0\n");
		        line = reader.readLine();
		        cpt++;
		    }
		} finally {
		    reader.close();
		    writer.close();
		}
	}
	
	public void initItemMap() throws IOException {
		
		this.itemList = new HashMap<String,Item>();
		this.itemNametoItem = new HashMap<String,Item>();
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(gamePath));
		}catch(Exception e) {
			newGame();
			reader = new BufferedReader(new FileReader(gamePath));
		}
		
		try {
			Item item;
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	String ID = split[0];
		    	String itemPath = split[1];
		    	String itemName = itemPath.replace("_"," ").replace(".png","");
		    	
		    	item = new Item("miniatures"+OSseparator+"RC"+OSseparator+itemPath, itemName, ID);
		    	item.quantity = Integer.parseInt(split[2]);
		    	itemList.put(ID, item);
		    	itemNametoItem.put(itemName, item);
		    	
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
	}
	
	public void initItemLock() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"itemLock.txt"));
		
		try {
			Item item;
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	item = itemNametoItem.get(split[0]);
		    	String[] lock = split[1].split(",");
		    	for(String itemName : lock) {
		    		item.lock.add(itemNametoItem.get(itemName));
		    	}
		    	
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
	}
	
	public void initCraftMap() throws IOException {
		this.craftList = new HashMap<String,Craft>();
		
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"Craft.txt"));
		
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
		    			}
		    			else {
				    		items[i][j] = itemNametoItem.get(itemsNameList[i][j]);
		    			}

		    		}
		    	}
		    	craft = new Craft(itemList.get(itemID), items);
		    	craft.UpperLeft();
		    	craftID = craft.getCraftUID();
		    	itemList.get(itemID).setCraft(craft);
		    	craftID = craft.getCraftUID();
		    	craftList.put(craftID, craft);
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
	}
	
	public void initItemGen() {
		
		this.itemGen = new HashMap<Integer,ArrayList<Item>>();
		
		for(String key : itemList.keySet()) {
			int generation = itemList.get(key).generation();
			if(!(itemGen.containsKey(generation))) {
				itemGen.put(generation, new ArrayList<Item>());
			}
			itemGen.get(generation).add(itemList.get(key));
		}
	}
	
	public void addItemResource(Item i, int q) {
		//this.itemList.get(i.ID).add_Resources(q);
		i.add_Resources(q);
		this.setChanged();
		this.notifyObservers(i);
		
	}

	public void delItemResource(Item i, int q) {
		//this.itemList.get(i.ID).del_Resources(q);
		i.del_Resources(q);
		this.setChanged();
		this.notifyObservers(i);
		
	}
	
	public void saveGame() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath));
		
		try {
			for (String ID : itemList.keySet()) {
				Item item = itemList.get(ID);
				String line = ID+";"+item.name.replace(' ','_')+".png"+";"+item.quantity+"\n";
				
				writer.write(line);
				}
			
		} finally {

		    writer.close();
		}
	}

	public void affichBDDcraft() {
		for (String key : this.craftList.keySet()) {
			System.out.println(key);
			this.craftList.get(key).afficher();
			System.out.println("-----------------------");
		}
	}
}
