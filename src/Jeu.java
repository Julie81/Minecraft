import java.io.IOException;

public class Jeu { // Lancement application quelque peu sale donc potentiellement e revoir
	static public Minecraft m;
	static public boolean launch = true;
	static public NewLoadGame nlg;
	
	public static void main(String[] args) throws IOException {
		nlg = new NewLoadGame(); // Lance le menu permettant de creer  une nouvelle partie ou d'en charger une
		while(true) {
			nlg.setVisible(true);
			while(!nlg.choice || nlg.IGN.equals("")) {	//on reste sur la premiere frame de choix tant que l'utilisateur n'a pas fait son choix ou bien que son IGN est vide
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			m = new Minecraft(nlg); // on charge la partie correspodante
			nlg.setVisible(false); // on cache le menu principal
			while(m.isDisplayable()) { // tant que la fenetre de Minecraft est ouverte
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nlg.choice = false;
			}
		}
	}

