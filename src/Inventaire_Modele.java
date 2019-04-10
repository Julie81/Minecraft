import java.util.Observable;

public class Inventaire_Modele extends Observable{
	Item[][] grille;
	
	public Inventaire_Modele(Modele m) {
		for(String id : m.itemList.keySet()) {
			grille[id.charAt(0)-'0'][id.charAt(1)-'0'] = m.itemList.get(id);
		}
	}
}
