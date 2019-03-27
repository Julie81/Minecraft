import java.awt.Canvas;
import java.awt.Image;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class Atelier extends Canvas{
	
	public Item[][] CraftTable;
	public Image craft;
	public int quantity;
	public Hashtable<String,Craft> EnsembleDesCrafts;
	
	
	public Atelier(Hashtable<String,Craft> EnsembleDesCrafts) {
		super();
		this.CraftTable = new Item[3][3];
		int quantite = 0;
		this.EnsembleDesCrafts = EnsembleDesCrafts;
	}
	
	
	
	public Item ExistingCraft(Craft userTry) {
		String UID = userTry.getCraftUID();
		if(EnsembleDesCrafts.containsKey(UID)){
				return EnsembleDesCrafts.get(UID).item;
		}
		return null;
	}
	
	public void Crafting(Craft craft) {
		
		Item item = ExistingCraft(craft);
		
		if(item == null) {
			// renvoyer à l'utilisateur que son craft est incorrect
		}
		else if(this.quantity > craft.minQuantity()) {
			//renvoyer à l'utilisateur qu'il manque des item pour creer le bon nombre de craft
		}
		else {
			item.quantity += this.quantity;
			for(Item[] itemLine : craft.items) {
				for(Item i : itemLine) {
					i.quantity -= this.quantity;
				}
			}
		}
		
	}
	
	
	public void SetQuantity(int newQuantity) {
		quantity = newQuantity;
	}

}
