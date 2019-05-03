import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Atelier_Modele extends Observable{
	
	public Item[][] CraftTable; // matrice de l'atelier
	public Item CurrItm; // item courant en memoire
	public int quantiti = 1; // initialisation de la quantite de creation a 1 
	public HashMap<String,Craft> EnsembleDesCrafts;  // BDD des crafts du Modele
	ArrayList<Item> itemManquant;  // liste des items limitant des crafts
	Modele m;
	
	public Atelier_Modele(Modele m) {
		super();
		this.CraftTable = new Item[3][3]; // Matrice initialise vide
		this.m = m;
		this.CurrItm = null; // aucun item courant selectionne
		this.EnsembleDesCrafts = m.craftList;
	}
	
	
	public Item ExistingCraft(Craft userTry) {  // renvoi un item correspondant
		// on compile un UID temporaire a partir du craft de l'utilisateur
		// on verifie si il est contenu dans la BDD et on renvoi l'item correspondant ou null dans le cas echeant
		String UID = userTry.getCraftUID();
		if(EnsembleDesCrafts.containsKey(UID)){
				return EnsembleDesCrafts.get(UID).item;
		}
		return null;
	}
	
	public void Crafting(Item[][] items) { // Action et verifications du craft d'un item
		
		Craft craft = new Craft(null,items); // instancie un craft temporaire
		craft.UpperLeft(); // simplification en haut a gauche du craft

		Item item = ExistingCraft(craft); // item correspondant apres recherche dans la BDD
		this.itemManquant = new ArrayList<Item>(); // instancie une liste vide des items manquants
		
		if(item == null) { // Message d'erreur pour informer l'utilisateur que son craft n'a pad d'association
			new ErrorMess("Oups...");
			this.itemManquant.add(null);
			this.empty_atelier(); // on repart de 0 ( atelier vide )
		}
		else {
			HashMap<Item,Integer> quantityNeeded = craft.quantityNeeded(); // occurence des items dans le craft
			Boolean enoughQuantity = true; // on se base sur le fait que les items sont en quantite suffisante
			for (Item key : quantityNeeded.keySet()) { // on les parcours pour verifier si c'est bien vrai
				if(quantityNeeded.get(key)*this.quantiti > key.quantity) {
					enoughQuantity = false; //  bascule du booleen car un item n'est pas en quantite suffisante
					this.itemManquant.add(key); // ajout des items manquants a la liste itemManquant
				}
			}

			if(enoughQuantity) { // les quantites sont respectees
				if(this.m.craftList.get(craft.getCraftUID()).item == null){
					new EasterEgg();
				}
				else{
					for (Item key : quantityNeeded.keySet()) { // on vide l'inventaire des ressources/items utilisees
						int q = quantityNeeded.get(key)*this.quantiti; // produit de l'occurence et de la quantite de creation
						this.m.delItemResource(this.m.itemList.get(key.ID),q);
						}
					this.m.addItemResource(item,this.quantiti); // on ajoute la quantite de creation a l'item cree
					this.empty_atelier(); // on vide l'atelier
				}
			}
			else {
				new ErrorMess(itemManquant); // Il manque des items on informe aussi l'utilisateur de ce probleme
			}
		}
	}
	
	
	public void empty_atelier() { // reset l'atelier et notifie le controleur
		this.CraftTable = new Item[3][3];
		this.setChanged();
		this.notifyObservers("reset");
	}
	
	public void selection(Item i) {  // l'item courant devient l'item selectionne
		this.CurrItm = i;
	}
	
	public void addQuantity() { // on veut creer un item de plus et on notifie
		this.quantiti++;
		this.setChanged();
		this.notifyObservers(this.quantiti);
	}
	
	public void reduceQuantity() { // on veut creer un item de moins ( si possible ) et on notifie
		if(this.quantiti>1) {
			this.quantiti--;
			this.setChanged();
			this.notifyObservers(this.quantiti);
		}
	}

	public void remplissage(int x, int y) {
		if (this.CurrItm != null) { // un item est selectionne
			if (this.CraftTable[x][y] == this.CurrItm) { 
				// si la case que l'on veut remplir contient le meme item que celui selectionne, on considere que celui-ci est retire
				this.CraftTable[x][y] = null;
				this.setChanged();
				this.notifyObservers(""+x+""+y+""+null); // on notifie le changement de l'atelier
			}
			else {
				//sinon on remplie par l'item selectionne et on notifie
				this.CraftTable[x][y] = this.CurrItm;
				this.setChanged();
				this.notifyObservers(""+x+""+y+""+this.CurrItm.path);
			}
		}
	}
	
	
// FONCTIONS DE TESTS
	
	public void low_on_res(ArrayList<Item> lit) { // fonction de test pour afficher les ressources limitantes et leurs quantites
		for(int i=0;i<lit.size();i++) {
			System.out.println(lit.get(i).name);
			System.out.println("----->"+lit.get(i).quantity);
		}
		System.out.println("Fin des ressources probl�matiques");
	}

}
