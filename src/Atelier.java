import java.awt.Canvas;
import java.awt.Image;
import java.util.HashMap;
import java.util.Hashtable;
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
	
	public Item ExistingCraft(Item[][] user, Hashtable<String,Craft> EnsembleDesCrafts) {
		Craft userTry = new Craft(null,user);
		String UID = userTry.getCraftUID();
		if(EnsembleDesCrafts.containsKey(UID)){
				return EnsembleDesCrafts.get(UID).item;
		}
		return null;
	}
	
	
	public void SetQuantity(int newQuantity) {
		quantity = newQuantity;
	}

}
