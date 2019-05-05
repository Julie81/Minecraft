import java.io.IOException;

public class Jeu { // Lancement application quelque peu sale donc potentiellement a revoir
	static public Minecraft m;
	static public boolean launch = true;
	static public NewLoadGame nlg;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			nlg = new NewLoadGame();
			while(!nlg.choice || nlg.IGN.equals("")) {	//on reste sur la premiere frame de choix tant que l'utilisateur n'a pas fait son choix ou bien que son IGN est vide
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			m = new Minecraft(nlg); // on charge la partie correspondante
			nlg.dispose();	//on a plus besoin de la fenetre de lancement de partie
			while(m.isDisplayable()) { // tant que la fenetre de Minecraft est ouverte
				try {
					Thread.sleep(1/10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			m.dispose();	// on va revenir sur la fenetre de lancement de partie et donc on a plus besoin de Minecraft
			}
		}
	}

