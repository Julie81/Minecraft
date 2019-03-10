import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

public class Inventaire extends Canvas{
	
	public int [][] matrice;
	
	public Inventaire() {
		super();
		int ligne = 4;
		int colonne = 10;
		this.matrice = new int [ligne][colonne];
		int quota = 64;
		
		this.setPreferredSize(new Dimension(colonne*50,ligne*50));
	}
	
	public void Recolte(int quantite) {
		quantite+=5;
	}
	
	public void paint(Graphics g) {
		for (int i=0; i<=this.matrice.length; i++){
			for (int j=0; j<this.matrice[0].length;j++){
				g.drawRect(j*50, i*50, 50, 50);
			}
		}
	}
}