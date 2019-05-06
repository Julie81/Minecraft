import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


public class Modele extends Observable{
	
	HashMap<String,Item> itemList;	// HashMap qui a un identifiant (chiffre sous forme de String de la forme XX) associe un item
	HashMap<String,Item> itemNametoItem;	// HashMap uiq a un nom d'item associe un item
	HashMap<String,Craft> craftList;	// HashMap qui a une cle (concatenation des identifiant des items la composants) associe un craft
	HashMap<Integer,ArrayList<Item>> itemGen;	// HashMap qui "trie" les items en fonctions de leurs generations
	String gamePath;	// Chemin d'acces du fichier de jeu
	String IGN;	// Nom de l'utilisateur
	String OSseparator;	// Separateur de fichier de pendant de l'OS

	public Modele(String fileName,Boolean New,String IGN) throws IOException {
		
		File file = null;
		this.OSseparator = file.separator; // initialisation du separateur
		
		this.gamePath = "miniatures"+OSseparator+fileName+".txt";
		this.IGN = IGN;
		
		if(New) {	// en cas de nouvelle partie
			eraseData();	// on efface le fichier lui correspondant
			newGame();	// et on creer une nouvelle partie
		}

		//initalisation de la BDD d'item
		initItemMap();
		
		
		//initialisation des lock d'item
		initItemLock();
		
		//initialisation de la BDD de craft
		initCraftMap();
		
		//initialisation d'un tri des items celon leurs generations
		initItemGen();
		
		
		//this.affichBDDcraft();	//permet une visualisation de la BDD des crafts	
	}
	
	public void eraseData() throws IOException {	// efface les fichier sauvegarder correspondant au numero de partie
		File file = new File("miniatures"+OSseparator+"Save");
        File[] files = file.listFiles();
        
        String ID = gamePath.split("_")[0];	// on recupere la premiere partie du fichier (ItemID 0X) qui eprmet de connaitre le numero de partie
        for(File f : files) {
        	if(f.getPath().contains(ID)){
        		f.delete();	//suppression des fichier utilisant le meme espace de sauvegarde
        	}

        }
	}
	
	public void newGame() throws IOException {	// creation d'un nouveau fichier de sauvegarde
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"item.txt"));	// fichier contenant les noms des miniatures
		BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath));
		
		try {
		    String line = reader.readLine();

		    int cpt = 0; // compteur qui va permettre d'associer des identifiants aux items
		    String ID= "";
		    
		    while (line != null) {
		    	if(cpt<10) {
		    		ID = "0"+cpt; // permet de normaliser les ID a 2 characteres
		    	}
		    	else {
		    		ID = ""+cpt;
		    	}
		    	writer.write(ID+";"+line+";"+"0\n"); // creer un fichier contenant l'ID de l'item, le nom de l'image, et sa quantité (ici 0) separer par des ";"
		        line = reader.readLine();
		        cpt++;
		    }
		} finally {
		    reader.close();
		    writer.close();
		}
	}
	
	public void initItemMap() throws IOException { // initialisation des HashMap itemList et itemNametoItem
		
		this.itemList = new HashMap<String,Item>();
		this.itemNametoItem = new HashMap<String,Item>();
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(gamePath));
		}catch(Exception e) { // si le fichier n'existe pas on en creer un nouveau
			newGame();
			reader = new BufferedReader(new FileReader(gamePath));
		}
		
		try {
			Item item;
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	String ID = split[0]; // ID de l'item
		    	String itemPath = split[1]; // nom de l'image de l'item
		    	String itemName = itemPath.replace("_"," ").replace(".png",""); // nom de l'item
		    	
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
	
	public void initItemLock() throws IOException {	//initialisation des items devant etre debloques
		
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"itemLock.txt"));
		
		try {
			Item item;
		    String line = reader.readLine();

		    while (line != null) {
		    	String[] split = line.split(";");
		    	item = itemNametoItem.get(split[0]); // item devant etre debloquer
		    	String[] lock = split[1].split(","); // liste des items debloquant l'item precedent
		    	for(String itemName : lock) {
		    		item.lock.add(itemNametoItem.get(itemName));
		    	}
		    	
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
	}
	
	public void initCraftMap() throws IOException { // initialisation de la HashMap CraftList
		this.craftList = new HashMap<String,Craft>();
		
		BufferedReader reader = new BufferedReader(new FileReader("miniatures"+OSseparator+"Craft.txt"));
		
		try {
		    String line = reader.readLine();
		    Craft craft;

		    while (line != null) {
		    	String[] split = line.split(";");
		    	
		    	String itemCrafted = split[0]; // nom de l'item produit par le craft
		    	
		    	String[] itemsName = split[1].split(":");
		    	String[][] itemsNameList = {itemsName[0].split(","),itemsName[1].split(","),itemsName[2].split(",")}; 
		    	//liste 3x3 des noms des items du craft
		    	
		    	
		    	Item[][] items = new Item[3][3];
		    	String craftID = "";
		    	
		    	
		    	// conversion de la liste des noms d'items 3x3 en liste d'item 3x3
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
		    	if(itemCrafted.equals("EasterEgg")){
		    		craft = new Craft(null, items);
		    	}
		    	else{
			    	craft = new Craft(itemNametoItem.get(itemCrafted), items);
			    	craft.UpperLeft();	// normalisation du craft en haut a gauche
			    	itemNametoItem.get(itemCrafted).setCraft(craft);	//assignation du craft a l'item produit
		    	}

		    	craftID = craft.getCraftUID();
		    	craftList.put(craftID, craft);
		        line = reader.readLine();
		    }
		} finally {
		    reader.close();
		}
	}
	
	public void initItemGen() { // initialisation de la HashMap itemGen
		
		this.itemGen = new HashMap<Integer,ArrayList<Item>>();
		
		for(String key : itemList.keySet()) {
			int generation = itemList.get(key).generation(); // on recupere ou calcul la generation d'un item
			if(!(itemGen.containsKey(generation))) { //si elle n'est pas dans la HashMap
				itemGen.put(generation, new ArrayList<Item>()); // On creer une ArrayList d'item
			}
			itemGen.get(generation).add(itemList.get(key)); // et on ajoute l'item a cette ArrayList
		}
	}
	
	public void addItemResource(Item i, int q) {	// ajoute un nombre q a la quantite de l'item i
		i.add_Resources(q);
		this.setChanged();
		this.notifyObservers(i);
		
	}

	public void delItemResource(Item i, int q) {	// enleve un nombre q a la quantite de l'item i
		i.del_Resources(q);
		this.setChanged();
		this.notifyObservers(i);
		
	}
	
	public void saveGame() throws IOException {	//sauvegarde de la partie courante
		BufferedWriter writer = new BufferedWriter(new FileWriter(gamePath));
		
		try {
			for (String ID : itemList.keySet()) {
				Item item = itemList.get(ID);
				String line = ID+";"+item.name.replace(' ','_')+".png"+";"+item.quantity+"\n"; // on ne modifie que les quantites
				
				writer.write(line);
				}
			
		} finally {

		    writer.close();
		}
	}

	
	/*
	 * Methode utilisee lors de test
	 */
	public void affichBDDcraft() {	//permet d'afficher les crafts dans la console
		for (String key : this.craftList.keySet()) {
			System.out.println(key);
			this.craftList.get(key).afficher();
			System.out.println("-----------------------");
		}
	}

	public void endgame() {
		this.setChanged();
		this.notifyObservers("endgame");
		
	}
}
