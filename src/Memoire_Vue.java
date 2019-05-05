import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Memoire_Vue extends Panel implements MouseListener{
	Item currItem = null;
	
	public Memoire_Vue() {
		super();
		this.setPreferredSize(new Dimension(Minecraft.larg*3,Minecraft.larg*3+30));
		this.setBackground(Minecraft.fond);
		this.addMouseListener(this);
		
		//ajout du titre
		Label titre = new Label ("Memoire : ");
		titre.setFont(new Font("Arial",Font.BOLD,18));
		titre.setForeground(Color.white);
		this.add(titre);
	}

	public void paint(Graphics g){
		Image item_select; // on dessine l'image de l'item selectionne
		if (this.currItem != null) { // un item est bien selectionne
				try {
					item_select = ImageIO.read(new File(currItem.path));
					item_select = item_select.getScaledInstance(2*Minecraft.larg-30, 2*Minecraft.larg-30, java.awt.Image.SCALE_SMOOTH); // conversion 
					g.drawImage(item_select, this.getSize().width-item_select.getHeight(null)-15,  this.getSize().height/4+10,null);
				} catch (IOException e2) {}
			if (this.currItem.craft == null) { // l'item est une ressource
				if (!this.currItem.lock.isEmpty()) { // il y a des items bloquants pour cette ressource
					// position de la tete d'ecriture + instanciation Font
					int dep_x = 10;
					int dep_y = 70;
					g.setFont(new Font("Arial",Font.ITALIC,13));
					g.setColor(Color.white);
					g.drawString("Vous devez posseder les items suivants", dep_x, dep_y);
					g.drawString("pour esperer recolter cette ressource.", dep_x, dep_y+15);
					
					dep_y += 30; // on revient a la ligne
					int step_x = 0; // variable qui gere le positionnement sur l'axe des X des images
					int step_y = 0; // variable qui gere le positionnement sur l'axe des U des images
					for(Item i : this.currItem.lock) { // parcours des items bloquants
						Image item_aff;
						try {
							item_aff = ImageIO.read(new File(i.path));
							item_aff = item_aff.getScaledInstance(Minecraft.larg, Minecraft.larg, java.awt.Image.SCALE_SMOOTH);
							if (step_x<=1) { // on remplie la premiere ligne de 2 items
								g.drawImage(item_aff, dep_x+step_x*Minecraft.larg*4/3, dep_y+step_y*Minecraft.larg*4/3 ,null); // le *4/3 est la pour que les images ne soient pas colles entre elles
								step_x++;
							}
							else { 
								step_y++; // on passe a la seconde ligne
								g.drawImage(item_aff, dep_x, dep_y+step_y*Minecraft.larg*4/3 ,null);
								step_x = 1; // on vient de dessiner la premiere image de la ligne donc on passe a la colonne suivante
								}
						} catch (IOException e1) {
							}
					}
				}
				else { // on met une matrice vide si c'est une ressource naturelle elementaire
					for (int i=0;i<3;i++){
						for (int j=0;j<3;j++){
							g.drawRect(i*Minecraft.larg+10, j*Minecraft.larg+50, Minecraft.larg, Minecraft.larg);
						}
					}
				}
			}
		else { // l'item est craftable donc il a un craft et on remplie la matrice du craft
			Craft recette = this.currItem.craft;
			Image img;
			for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					if (recette.items[i][j] != null) {
						try {
							img = ImageIO.read(new File(recette.items[i][j].path));
							img = img.getScaledInstance(Minecraft.larg-10, Minecraft.larg-10, java.awt.Image.SCALE_SMOOTH); // conversion
							g.drawRect(i*Minecraft.larg+10, j*Minecraft.larg+50, Minecraft.larg, Minecraft.larg);
							g.drawImage(img, j*Minecraft.larg+15,  i*Minecraft.larg+55,null); // null pour eviter le rappel du paint a chaque dessin image
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						g.drawRect(i*Minecraft.larg+10, j*Minecraft.larg+50, Minecraft.larg, Minecraft.larg); // case de la matrice
					}
				}
			}
		}
	}
	}
	
	public void selection(Item i) {
		this.currItem = i;
	}

	@Override	
	public void mouseClicked(MouseEvent e) {
		this.repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		//this.repaint();
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
