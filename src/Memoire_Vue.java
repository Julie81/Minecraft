import java.awt.Canvas;
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
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Memoire_Vue extends Panel implements MouseListener{
	int larg = 80;
	Item currItem = null;
	
	public Memoire_Vue() {
		super();
		this.setPreferredSize(new Dimension(larg*3,larg*3+30));
		this.setBackground(new Color(139,108,66));
		this.addMouseListener(this);
		Label titre = new Label (" Memoire : ");
		titre.setFont(new Font("Arial",Font.BOLD,18));
		titre.setForeground(Color.black);
		this.add(titre);
	}
	public Insets getInsets() {
		Insets normal = super.getInsets();
		return new Insets(normal.top+5, normal.left +10, normal.bottom, normal.right + 10);
		}
	
	public void paint(Graphics g){
		// ici on dessine la memoire vide
		if (this.currItem == null || this.currItem.craft == null) {
			
			for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					g.drawRect(i*larg+10, j*larg+50, larg, larg);
				}
			}
			
			if (this.currItem != null) {
				Image item_select;
				try {
					item_select = ImageIO.read(new File(currItem.path));
					item_select = item_select.getScaledInstance(2*larg-30, 2*larg-30, java.awt.Image.SCALE_SMOOTH);
					g.drawImage(item_select, this.getSize().width-item_select.getHeight(null)-15,  this.getSize().height/4+10,null);
				} catch (IOException e1) {
					}
			}
		}
		else {
			// ici on affiche simplement l'image de l'objet recherche
			Image item_select;
			try {
				item_select = ImageIO.read(new File(currItem.path));
				item_select = item_select.getScaledInstance(2*larg-30, 2*larg-30, java.awt.Image.SCALE_SMOOTH);
				g.drawImage(item_select, this.getSize().width-item_select.getHeight(null)-15,  this.getSize().height/4+10,null);
			} catch (IOException e1) {
				}
			// ici on remplie la memoire de la recette de l'item select
			Craft recette = this.currItem.craft;
			Image img = null;
			for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					if (recette.items[i][j] != null) {
						try {
							img = ImageIO.read(new File(recette.items[i][j].path));
							img = img.getScaledInstance(larg-10, larg-10, java.awt.Image.SCALE_SMOOTH);
							g.drawRect(i*larg+10, j*larg+50, larg, larg);
							g.drawImage(img, j*larg+15,  i*larg+55,null); // null pour eviter le rappel du painta chaque dessin image
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						g.drawRect(i*larg+10, j*larg+50, larg, larg);
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
		// TODO Auto-generated method stub
		
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
