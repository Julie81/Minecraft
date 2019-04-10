import java.awt.Canvas;
import java.awt.Image;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Atelier_Modele extends Canvas{
	
	public Item[][] CraftTable;
	public Image craft;
	public int quantity;
	public Hashtable<String,Craft> EnsembleDesCrafts;
	
	
	public Atelier_Modele(Hashtable<String,Craft> EnsembleDesCrafts) {
		super();
		this.CraftTable = new Item[3][3];
		int quantite = 1;
		this.EnsembleDesCrafts = EnsembleDesCrafts;
	}
	
	
	
	public Item ExistingCraft(Craft userTry) {
		String UID = userTry.getCraftUID();
		if(EnsembleDesCrafts.containsKey(UID)){
				return EnsembleDesCrafts.get(UID).item;
		}
		return null;
	}
	
	public void Crafting(Item[][] items) {
		
		Craft craft = new Craft(null,items);
		craft.UpperLeft();
		
		Item item = ExistingCraft(craft);
		
		if(item == null) {
			// renvoyer à l'utilisateur que son craft est incorrect
		}
		else {
			HashMap<Item,Integer> quantityNeeded = craft.quantityNeeded();
			Boolean enoughQuantity = true;
			for (Item key : quantityNeeded.keySet()) {
				if(quantityNeeded.get(key)*this.quantity > key.quantity) {
					enoughQuantity = false;
					// renvoyer au fur et a mesure les quantite manquante
				}
			}
			if(enoughQuantity) {
				for (Item key : quantityNeeded.keySet()) {
					key.quantity -= quantityNeeded.get(key)*this.quantity;
					// renvoyer au fur et a mesure les quantite manquante
					}
				item.quantity += quantity;
			}
		}
		
		
	}
	
	
	public void addQuantity() {
		this.quantity++;
	}
	
	public void reduceQuantity() {
		if(this.quantity>=0) {
			this.quantity--;
		}
	}

}
