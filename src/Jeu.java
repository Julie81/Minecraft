import java.io.IOException;

public class Jeu { // Lancement application quelque peu sale donc potentiellement e revoir
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
			m = new Minecraft(nlg); // on charge la partie correspodante
			nlg.setVisible(false); // on cache le menu principal
			while(m.isDisplayable()) { // tant que la fenetre de Minecraft est ouverte
				try {
					Thread.sleep(1/10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nlg.setVisible(true); // inutile théoriquement mais permet une transition plus soft entre les deux fenetres
			}
		}
	}

