import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manuel_Vue extends JFrame implements WindowListener{

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	
	String[] listEtapes = {"etape1", "etape2", "etape3", "etape4", "etape5"};
	int indice=0;
	
	public Manuel_Vue() throws IOException{
		super();
		this.setTitle("Manuel d'aide");
		this.setSize(500,400);
		this.addWindowListener(this);
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(9,82,40));
		
		JPanel etape1= new JPanel();
		etape1.setBackground(new Color(58,242,75));
		GridBagConstraints gbc = new GridBagConstraints();
		etape1.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		etape1.add(new JLabel ("                                                   I- Recoltez vos ressources"),gbc);
		Box explication1 = Box.createVerticalBox();
		explication1.add(new JLabel (""));
		explication1.add(new JLabel ("Vous pouvez recoltez vos ressources en cliquant"));
		explication1.add(new JLabel (" sur les objets colores."));
		explication1.add(new JLabel ("Les objets grises sont disponibles quand vous avez debloque"));
		explication1.add(new JLabel ("les ressources pour aller les chercher."));
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.ipadx=20;
		etape1.add(explication1,gbc);
		JLabel photo1 = new JLabel(new ImageIcon("miniatures/aide/recolte.png"));
		gbc.gridx=0;
		gbc.gridy=1;
		//gbc.fill= GridBagConstraints.VERTICAL;
		//gbc.gridheight=2;
		etape1.add(photo1,gbc);
		
		JPanel etape2= new JPanel();
		etape2.setBackground(new Color(58,242,75));
		GridBagConstraints gbc2 = new GridBagConstraints();
		etape2.setLayout(new GridBagLayout());
		gbc2.gridx=0;
		gbc2.gridy=0;
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		gbc2.gridwidth=2;
		etape2.add(new JLabel ("                                                   II- Craftez vos ressources"),gbc2);
		Box explication2 = Box.createVerticalBox();
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel ("Choisissez dans l'inventaire et "));
		explication2.add(new JLabel ("positionnez dans la matrice"));
		explication2.add(new JLabel (" les differents objets que vous "));
		explication2.add(new JLabel ("souhaitez pour essayer d'en"));
		explication2.add(new JLabel (" debloquer un nouveau."));
		explication2.add(new JLabel ("Vous pouvez construire plusieurs "));
		explication2.add(new JLabel ("objets identiques en une fois"));
		explication2.add(new JLabel (" en modifiant la quantite : "));
		explication2.add(new JLabel ("l'augmenter (bouton plus) ou la "));
		explication2.add(new JLabel ("diminuer (bouton moins)"));
		explication2.add(new JLabel ("Enfin, pour construire l'objet voulu,"));
		explication2.add(new JLabel (" appuyez sur le bouton \"craft\"."));
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel (" "));
		explication2.add(new JLabel (" "));
		gbc2.gridwidth=1; 
		gbc2.gridx=1;
		gbc2.gridy=1;
		gbc2.ipadx=40;
		etape2.add(explication2,gbc2);
		JLabel photo2 = new JLabel(new ImageIcon("miniatures/aide/craft.png"));
		gbc2.gridx=0;
		gbc2.gridy=1;
		//gbc2.fill= GridBagConstraints.VERTICAL;
		//gbc2.gridheight=2;
		etape2.add(photo2,gbc2);
		
		JPanel etape3= new JPanel();
		etape3.setBackground(new Color(58,242,75));
		GridBagConstraints gbc3 = new GridBagConstraints();
		etape3.setLayout(new GridBagLayout());
		gbc3.gridx=0;
		gbc3.gridy=0;
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.gridwidth=2;
		etape3.add(new JLabel ("                                                   III- Messages d'erreur"),gbc3);
		Box explication3 = Box.createVerticalBox();
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel (" "));
		
		explication3.add(new JLabel ("Il y a deux messages d'erreur :"));
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel ("    - l'objet dont la matrice que vous avez"));
		explication3.add(new JLabel ("cree n'existe pas"));
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel (" "));
		explication3.add(new JLabel (" "));
		Box explication3_2 = Box.createVerticalBox();
		explication3_2.add(new JLabel (" "));
		explication3_2.add(new JLabel (" "));
		explication3_2.add(new JLabel ("    - vous n'avez pas assez de materiaux."));
		explication3_2.add(new JLabel ("Dans ce cas, les materiaux que vous n'avez "));
		explication3_2.add(new JLabel ("pas en assez grande quantite sont affiches."));
		explication3_2.add(new JLabel (" "));
		explication3_2.add(new JLabel (" "));
		explication3_2.add(new JLabel (" "));
		gbc3.gridx=1;
		gbc3.gridy=1;
		gbc3.ipadx=40;
		gbc3.gridwidth=1;
		etape3.add(explication3,gbc3);
		gbc3.gridx=1;
		gbc3.gridy=2;
		gbc3.ipadx=40;
		etape3.add(explication3_2,gbc3);
		JLabel photo3 = new JLabel(new ImageIcon("miniatures/aide/message1.png"));
		gbc3.gridx=0;
		gbc3.gridy=1;
		etape3.add(photo3,gbc3);
		JLabel photo3_2 = new JLabel(new ImageIcon("miniatures/aide/message2.png"));
		gbc3.gridx=0;
		gbc3.gridy=2;
		etape3.add(photo3_2,gbc3);
		
		JPanel etape4= new JPanel();
		etape4.setBackground(new Color(58,242,75));
		GridBagConstraints gbc4 = new GridBagConstraints();
		etape4.setLayout(new GridBagLayout());
		gbc4.gridx=0;
		gbc4.gridy=0;
		gbc4.fill=GridBagConstraints.HORIZONTAL;
		gbc4.gridwidth=2;
		etape4.add(new JLabel ("                             IV- La memoire"),gbc4);
		Box explication4 = Box.createVerticalBox();
		explication4.add(new JLabel (" "));
		explication4.add(new JLabel (" "));
		explication4.add(new JLabel (" "));
		explication4.add(new JLabel ("Vous pouvez survoler un objet"));
		explication4.add(new JLabel ("dans l'inventaire afin d'en"));
		explication4.add(new JLabel ("connaitre le nom. "));
		explication4.add(new JLabel (" "));
		explication4.add(new JLabel (" "));
		Box explication4_2 = Box.createVerticalBox();
		explication4_2.add(new JLabel (" "));
		explication4_2.add(new JLabel (" "));
		explication4_2.add(new JLabel ("Vous pouvez cliquer sur un"));
		explication4_2.add(new JLabel (" objet puis sur \"recherchez"));
		explication4_2.add(new JLabel ("  ici la recette d'un craft ...\""));
		explication4_2.add(new JLabel ("pour connaitre la matrice"));
	    explication4_2.add(new JLabel (" permettant de"));
		explication4_2.add(new JLabel ("construire l'objet."));
		explication4_2.add(new JLabel (" "));
		explication4_2.add(new JLabel (" "));
		explication4_2.add(new JLabel (" "));
		gbc4.gridx=1;
		gbc4.gridy=1;
		gbc4.ipadx=40;
		gbc4.gridwidth=1;
		etape4.add(explication4,gbc4);
		gbc4.gridx=1;
		gbc4.gridy=2;
		gbc4.ipadx=40;
		etape4.add(explication4_2,gbc4);
		JLabel photo4 = new JLabel(new ImageIcon("miniatures/aide/memoire.png"));
		gbc4.gridx=0;
		gbc4.gridy=1;
		etape4.add(photo4,gbc4);
		JLabel photo4_2 = new JLabel(new ImageIcon("miniatures/aide/memoire2.png"));
		gbc4.gridx=0;
		gbc4.gridy=2;
		etape4.add(photo4_2,gbc4);
		
		JPanel etape5= new JPanel();
		etape5.setBackground(new Color(58,242,75));
		GridBagConstraints gbc5 = new GridBagConstraints();
		etape5.setLayout(new GridBagLayout());
		gbc5.gridx=0;
		gbc5.gridy=0;
		gbc5.fill= GridBagConstraints.HORIZONTAL;
		gbc5.gridwidth=2;
		etape5.add(new JLabel ("                                                   V-Sauvegarder et quitter"),gbc5);
		Box explication5 = Box.createVerticalBox();
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel ("Vous pouvez a tout moment sauvegarder votre partie "));
		explication5.add(new JLabel ("(bouton sauvegarder)."));
		explication5.add(new JLabel (" Vous pouvez quitter votre partie (bouton quitter)."));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		gbc5.gridx=1;
		gbc5.gridy=1;
		gbc5.gridwidth=1;
		gbc5.ipadx=40;
		etape5.add(explication5,gbc5);
		JLabel photo5 = new JLabel(new ImageIcon("miniatures/aide/sauvegarde.png"));
		gbc5.gridx=0;
		gbc5.gridy=1;
		etape5.add(photo5,gbc5);
		
		JButton suivant = new JButton ("suivant");
		suivant.setFont(new Font("Arial",Font.BOLD,12));
		suivant.setForeground(Color.black);
		suivant.setBackground(new Color(219,219,219));
		suivant.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.next(content);
			}
		});
		
		JButton precedent = new JButton ("precedent");
		precedent.setFont(new Font("Arial",Font.BOLD,12));
		precedent.setForeground(Color.black);
		precedent.setBackground(new Color(219,219,219));
		precedent.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.previous(content);
			}
		});
		
		JPanel boutonPane = new JPanel();
		boutonPane.setBackground(new Color(0,0,0,0));
		boutonPane.setLayout(new BorderLayout());
		boutonPane.add(suivant,BorderLayout.EAST);
		boutonPane.add(precedent,BorderLayout.WEST);
		boutonPane.setPreferredSize(new Dimension(this.getWidth(),40));
		this.setBackgroundImage(this, new File("miniatures/aide/titre_minecraft.png"));
		this.setBackground(new Color(9,82,40));
		
		content.setLayout(cl);
		
		content.add(etape1, listEtapes[0]);
		content.add(etape2, listEtapes[1]);
		content.add(etape3, listEtapes[2]);
		content.add(etape4, listEtapes[3]);
		content.add(etape5, listEtapes[4]);
		
		this.getContentPane().add(boutonPane,BorderLayout.NORTH);
		this.getContentPane().add(content,BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); 
			g.setColor(new Color(9,82,40));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(buf, 100,0,300,40, null); }
		};
		frame.setContentPane(panel); 
		return panel; }

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
