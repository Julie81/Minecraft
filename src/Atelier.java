import java.awt.Canvas;
import java.awt.Image;
import java.util.HashMap;
import java.util.Set;

public class Atelier extends Canvas{
	
	public Item[][] CraftTable;
	public Image craft;
	public int quantity;
	
	
	public Atelier() {
		super();
		this.CraftTable = new Item[3][3];
		int quantite = 0;
		
	}
	
	public Item ExistingCraft(Item[][] user, Craft[] EnsembleDesCrafts) {
		for(Craft craft : EnsembleDesCrafts) {
			if(craft.compareTo(user)) {
				return craft.item;
			}
		}
		return null;
	}
	
	
	public void SetQuantity(int newQuantity) {
		quantity = newQuantity;
	}
	
	public void Craft(Craft[] EnsembleDesCrafts) {
		Item item = ExistingCraft(this.CraftTable, EnsembleDesCrafts);
		if(item != null) {
			item.quantity += quantity;
		}
		else {
			System.out.println("Craft invalide");
		}
	}
}
