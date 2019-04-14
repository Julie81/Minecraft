import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Image;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Set;

public class Atelier_Modele extends Observable{
	
	public Item[][] CraftTable; // matrice de l'atelier
	public Image craft; // image de l'item que l'on craft
	public Item CurrItm; // item courant en memoire
	public int quantiti = 1; // quantite que l'on veut faire 
	public HashMap<String,Craft> EnsembleDesCrafts;  // BDD des crafts
	ArrayList<Item> itemManquant;  // liste des items limitant des crafts
	Modele m;
	
	public Atelier_Modele(HashMap<String,Craft> EnsembleDesCrafts, Modele m) {
		super();
		this.CraftTable = new Item[3][3];
		this.m = m;
		this.CurrItm = null; // aucun item courant selectionne
		this.EnsembleDesCrafts = EnsembleDesCrafts;
	}
	
	
	
	public Item ExistingCraft(Craft userTry) {
		String UID = userTry.getCraftUID();
		System.out.println(UID);
		if(EnsembleDesCrafts.containsKey(UID)){
				return EnsembleDesCrafts.get(UID).item;
		}
		return null;
	}
	
	public void Crafting(Item[][] items) {
		
		Craft craft = new Craft(null,items);
		//craft.UpperLeft();

		Item item = ExistingCraft(craft);
		this.itemManquant = new ArrayList<Item>();
		
		if(item == null) {
			// est ce bien ici ?
			ErrorMess f = new ErrorMess("Oups...");
			this.itemManquant.add(null);
		}
		else {
			HashMap<Item,Integer> quantityNeeded = craft.quantityNeeded();
			Boolean enoughQuantity = true;
			for (Item key : quantityNeeded.keySet()) {
				if(quantityNeeded.get(key)*this.quantiti > key.quantity) {
					enoughQuantity = false;
					// ajout des items manquants a la liste itemManquant
					this.itemManquant.add(key);
				}
			}
			if(enoughQuantity) {
				for (Item key : quantityNeeded.keySet()) {
					int q = quantityNeeded.get(key)*this.quantiti;
					this.m.delItemResource(this.m.itemList.get(key.ID),q);
					}
				this.m.addItemResource(item,this.quantiti);
			}
		}
	}
	
	
	public void empty_atelier() {
		this.CraftTable = new Item[3][3];
		this.setChanged();
		this.notifyObservers(null);
	}
	
	public void selection(Item i) {
		this.CurrItm = i;
	}
	
	public void addQuantity() {
		this.quantiti++;
		this.setChanged();
		this.notifyObservers(this.quantiti);
	}
	
	public void reduceQuantity() {
		if(this.quantiti>1) {
			this.quantiti--;
			this.setChanged();
			this.notifyObservers(this.quantiti);
		}
	}

	public void remplissage(int x, int y) {
		if (this.CurrItm != null) {
			this.CraftTable[x][y] = this.CurrItm;
			this.setChanged();
			this.notifyObservers(""+x+""+y+""+this.CurrItm.path);
		}
	}
	public void low_on_res(ArrayList<Item> lit) { // fonction de test pour afficher les ressources limitantes et leur quantite
		for(int i=0;i<lit.size();i++) {
			System.out.println(lit.get(i).name);
			System.out.println("----->"+lit.get(i).quantity);
		}
		System.out.println("Fin des ressources problématiques");
	}

}
