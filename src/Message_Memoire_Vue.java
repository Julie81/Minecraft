import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Message_Memoire_Vue extends JPanel {
	CardLayout cl;
	Memoire_Vue mv;
	
	public Message_Memoire_Vue () {
		
		this.cl =new CardLayout();
		
		// Message : Recherchez ici la recette d'un craft
		JPanel message = new JPanel();
		message.setBackground(new Color(0,0,0,0));
		JLabel message1 = new JLabel("Recherchez ici ");
		JLabel message2 = new JLabel("la recette d'un craft ...");
		message1.setFont(new Font("Arial",Font.BOLD,36));
		message2.setFont(new Font("Arial",Font.BOLD,36));
		message1.setForeground(Color.white);
		message2.setForeground(Color.white);
		
		this.setBackground(new Color(107,87,49));
		Box box_texte = Box.createVerticalBox();
		box_texte.add(message1);
		box_texte.add(message2);
		message.add(box_texte);
		
		JPanel memoire = new JPanel();
		this.mv = new Memoire_Vue();
		memoire.add(this.mv);
		
		this.setLayout(cl);
		this.add(message,"texte");
		this.add(mv,"memoire");
		this.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getSource() instanceof JPanel) {
							cl.last((JPanel) e.getSource() ); // quand on clique on swap le cardlayout vers la memoire
						}
					}
				});
	}

}
