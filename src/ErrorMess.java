import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ErrorMess extends Frame implements WindowListener{
	
	public ErrorMess(boolean taken) {
		super();
		//message d'erreur
		Label m = new Label("Ce nom est déjà pris.");
		m.setBackground(Minecraft.fond);
		m.setVisible(true);
		//police message d'erreur
		m.setFont(new Font("Arial",Font.BOLD,16));
		m.setForeground(Color.white);
		//ajout du message d'erreur
		this.add(m);
		
		this.addWindowListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public ErrorMess(String mess) {
		super();
		//titre de la fenetre
		this.setTitle(mess);
		
		//message d'erreur
		Label m = new Label("L'objet que vous essayez de créer n'existe pas.");
		m.setBackground(Minecraft.fond);
		m.setVisible(true);
		//police message d'erreur
		m.setFont(new Font("Arial",Font.BOLD,16));
		m.setForeground(Color.white);
		//ajout du message d'erreur
		this.add(m);
		
		this.addWindowListener(this);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public ErrorMess(ArrayList<Item> itemManquant) {
		super();
		//titre de la fenetre
		this.setTitle("Not wealthy enough...");
		this.setVisible(true);
		this.setBackground(Minecraft.fond);
		this.addWindowListener(this);
		
		//Layout
		GridBagLayout gd = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gd);
		
		//message d'erreur
		Label m = new Label("Action impossible : Les ressources suivantes ne sont pas en quantité suffisante.");
		m.setBackground(Minecraft.fond);
		m.setVisible(true);
		//police message d'erreur
		m.setFont(new Font("Arial",Font.BOLD,16));
		m.setForeground(Color.white);
		//placement message d'erreur
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(m,gbc);
		
		//boite des elements manquants
		Box objets = Box.createHorizontalBox();
		for(int i=0;i<itemManquant.size();i++){
			JLabel p = new JLabel();
			//image de l'item manquant
			ImageIcon icon = new ImageIcon(itemManquant.get(i).path);
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance( 90, 90,  java.awt.Image.SCALE_SMOOTH ) ;
			icon = new ImageIcon(newimg);
			p.setIcon(icon);
			p.setBackground(null);
			p.setVisible(true);
			p.setOpaque(true);
			//ajout de l'image
			objets.add(p);
		}
		//placement et ajout de la boite
		gbc.gridy=1;
		this.add(objets,gbc);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//fermeture de la fenetre
		this.dispose();
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
