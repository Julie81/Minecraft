import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

	//couleur des pages du manuel
	Color page = new Color(58,242,75);
	//on ajoute un cardLayout permettant d'avoir plusieurs panels a un endroit
	CardLayout cl = new CardLayout();
	//panel contenant les differentes pages du manuel
	JPanel content = new JPanel();
	
	//liste des pages du manuel
	String[] listEtapes = {"etape1", "etape2", "etape3", "etape4", "etape5"};
	int indice=0;
	
	public Manuel_Vue() throws IOException{
		super();
		//titre de la fenetre
		this.setTitle("Manuel d'aide");
		this.setResizable(false);
		this.setSize(500,400);
		this.addWindowListener(this);
		//ajout du Layout
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(9,82,40));
		
		//premiere page du manuel
		JPanel etape1= new JPanel();
		etape1.setBackground(this.page);
		//ajout du Layout
		GridBagConstraints gbc = new GridBagConstraints();
		etape1.setLayout(new GridBagLayout());
		//ajout et placement du titre
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		etape1.add(new JLabel ("                                                   I- Recoltez vos ressources"),gbc);
		//boite contenant les explications de la page 1
		Box explication1 = Box.createVerticalBox();
		//description des explications
		explication1.add(new JLabel (""));
		explication1.add(new JLabel ("Vous pouvez recoltez vos ressources en cliquant"));
		explication1.add(new JLabel (" sur les objets colores."));
		explication1.add(new JLabel ("Les objets grises sont disponibles quand vous avez debloque"));
		explication1.add(new JLabel ("les ressources pour aller les chercher."));
		explication1.add(new JLabel ("Les ressources sont classes par colonne dans l'ordre des "));
		explication1.add(new JLabel ("generations. C'est-a-dire qu'une ressource peut avoir besoin"));
		explication1.add(new JLabel ("des ressources qui se trouvent au-dessus mais jamais de celles"));
		explication1.add(new JLabel ("en-dessous."));
		explication1.add(new JLabel (""));
		//ajout et placement de la boite des explications
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.ipadx=Minecraft.espace1;
		etape1.add(explication1,gbc);
		//ajout et placement de la photo
		JLabel photo1 = new JLabel(new ImageIcon("miniatures/aide/recolte.png"));
		gbc.gridx=0;
		gbc.gridy=1;
		etape1.add(photo1,gbc);
		
		//page 2 du manuel
		JPanel etape2= new JPanel();
		etape2.setBackground(this.page);
		//ajout du Layout
		GridBagConstraints gbc2 = new GridBagConstraints();
		etape2.setLayout(new GridBagLayout());
		//ajout et placement du titre
		gbc2.gridx=0;
		gbc2.gridy=0;
		gbc2.fill=GridBagConstraints.HORIZONTAL;
		gbc2.gridwidth=2;
		etape2.add(new JLabel ("                                                   II- Craftez vos ressources"),gbc2);
		//ajout et placement des explications dans une boite
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
		gbc2.ipadx=Minecraft.espace1;
		etape2.add(explication2,gbc2);
		//ajout et placement de la photo
		JLabel photo2 = new JLabel(new ImageIcon("miniatures/aide/craft.png"));
		gbc2.gridx=0;
		gbc2.gridy=1;
		etape2.add(photo2,gbc2);
		
		//page 3 du manuel
		JPanel etape3= new JPanel();
		etape3.setBackground(this.page);
		//ajout du Layout
		GridBagConstraints gbc3 = new GridBagConstraints();
		etape3.setLayout(new GridBagLayout());
		//ajout et placement du titre
		gbc3.gridx=0;
		gbc3.gridy=0;
		gbc3.fill=GridBagConstraints.HORIZONTAL;
		gbc3.gridwidth=2;
		etape3.add(new JLabel ("                                                   III- Messages d'erreur"),gbc3);
		//ajout et placement des deux boites d'explications
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
		gbc3.ipadx=Minecraft.espace1;
		gbc3.gridwidth=1;
		etape3.add(explication3,gbc3);
		gbc3.gridx=1;
		gbc3.gridy=2;
		gbc3.ipadx=Minecraft.espace1;
		etape3.add(explication3_2,gbc3);
		//ajout et placement de la premiere photo
		JLabel photo3 = new JLabel(new ImageIcon("miniatures/aide/message1.png"));
		gbc3.gridx=0;
		gbc3.gridy=1;
		etape3.add(photo3,gbc3);
		//ajout et placement de la deuxieme photo
		JLabel photo3_2 = new JLabel(new ImageIcon("miniatures/aide/message2.png"));
		gbc3.gridx=0;
		gbc3.gridy=2;
		etape3.add(photo3_2,gbc3);
		
		//page 4 du manuel
		JPanel etape4= new JPanel();
		etape4.setBackground(this.page);
		//ajout du Layout
		GridBagConstraints gbc4 = new GridBagConstraints();
		etape4.setLayout(new GridBagLayout());
		//ajout et placement du titre
		gbc4.gridx=0;
		gbc4.gridy=0;
		gbc4.fill=GridBagConstraints.HORIZONTAL;
		gbc4.gridwidth=2;
		etape4.add(new JLabel ("                             IV- La memoire"),gbc4);
		//description des explications
		Box explication4 = Box.createVerticalBox();
		explication4.add(new JLabel (" "));
		explication4.add(new JLabel ("Vous pouvez survoler un objet"));
		explication4.add(new JLabel ("dans l'inventaire afin d'en"));
		explication4.add(new JLabel ("connaitre le nom. "));
		explication4.add(new JLabel (" "));
		Box explication4_2 = Box.createVerticalBox();
		explication4_2.add(new JLabel ("Vous pouvez cliquer sur un"));
		explication4_2.add(new JLabel ("objet puis sur \"recherchez"));
		explication4_2.add(new JLabel ("ici la recette d'un craft ...\""));
		explication4_2.add(new JLabel ("pour connaitre la matrice"));
	    explication4_2.add(new JLabel ("permettant de construire "));
		explication4_2.add(new JLabel ("l'objet si ce n'est pas"));
		explication4_2.add(new JLabel ("un objet recoltable."));
		explication4_2.add(new JLabel (" "));
		Box explication4_3 = Box.createVerticalBox();
		explication4_3.add(new JLabel (" "));
		explication4_3.add(new JLabel ("Vous pouvez de la meme"));
		explication4_3.add(new JLabel ("maniere, recherchez les elements"));
		explication4_3.add(new JLabel ("permettant de debloquer la"));
		explication4_3.add(new JLabel ("ressource dont vous venez de choisir."));
		explication4_3.add(new JLabel (" "));
		//ajout et placement de la premiere boite d'explications
		gbc4.gridx=1;
		gbc4.gridy=1;
		gbc4.ipadx=Minecraft.espace1;
		gbc4.gridwidth=1;
		etape4.add(explication4,gbc4);
		//ajout et placement de la deuxiere boite d'explications
		gbc4.gridx=1;
		gbc4.gridy=2;
		gbc4.ipadx=Minecraft.espace1;
		etape4.add(explication4_2,gbc4);
		//ajout et placement de la troisieme boite d'explications
		gbc4.gridx=1;
		gbc4.gridy=3;
		gbc4.ipadx=Minecraft.espace1;
		etape4.add(explication4_3,gbc4);
		//ajout et placement de la premiere photo
		JLabel photo4 = new JLabel(new ImageIcon("miniatures/aide/memoire.png"));
		gbc4.gridx=0;
		gbc4.gridy=1;
		etape4.add(photo4,gbc4);
		//ajout et placement de la deuxieme photo
		JLabel photo4_2 = new JLabel(new ImageIcon("miniatures/aide/memoire2.png"));
		gbc4.gridx=0;
		gbc4.gridy=2;
		etape4.add(photo4_2,gbc4);
		//ajout et placement de la troisieme photo
		JLabel photo4_3 = new JLabel(new ImageIcon("miniatures/aide/memoire3.png"));
		gbc4.gridx=0;
		gbc4.gridy=3;
		etape4.add(photo4_3,gbc4);
		
		//page 5 du manuel
		JPanel etape5= new JPanel();
		etape5.setBackground(this.page);
		//ajout du Layout
		GridBagConstraints gbc5 = new GridBagConstraints();
		etape5.setLayout(new GridBagLayout());
		//ajout et placement du titre
		gbc5.gridx=0;
		gbc5.gridy=0;
		gbc5.fill= GridBagConstraints.HORIZONTAL;
		gbc5.gridwidth=2;
		etape5.add(new JLabel ("                                                   V-Sauvegarder et quitter"),gbc5);
		//description des explications
		Box explication5 = Box.createVerticalBox();
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel ("Vous pouvez a tout moment sauvegarder votre partie "));
		explication5.add(new JLabel ("(bouton sauvegarder)."));
		explication5.add(new JLabel ("Vous pouvez retourner a l'ecran titre pour choisir"));
		explication5.add(new JLabel ("une autre partie ou quitter (bouton menu principal)."));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		explication5.add(new JLabel (" "));
		Box explication5_2 = Box.createVerticalBox();
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel ("Vous pouvez quitter le jeu (boutton quitter)."));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		explication5_2.add(new JLabel (" "));
		//ajout et placement de la premiere boite d'explications
		gbc5.gridx=1;
		gbc5.gridy=1;
		gbc5.gridwidth=1;
		gbc5.ipadx=Minecraft.espace1;
		etape5.add(explication5,gbc5);
		//ajout et placement de la deuxieme boite d'explications
		gbc5.gridx=1;
		gbc5.gridy=2;
		gbc5.ipadx=Minecraft.espace1;
		etape5.add(explication5_2,gbc5);
		//ajout de la premiere photo
		JLabel photo5 = new JLabel(new ImageIcon("miniatures/aide/sauvegarde.png"));
		gbc5.gridx=0;
		gbc5.gridy=1;
		etape5.add(photo5,gbc5);
		//ajout de la deuxieme photo
		JLabel photo5_2 = new JLabel(new ImageIcon("miniatures/aide/quitter.png"));
		gbc5.gridx=0;
		gbc5.gridy=2;
		etape5.add(photo5_2,gbc5);
		
		//bouton suivant
		JButton suivant = new JButton ("suivant");
		//police de suivant
		suivant.setFont(new Font("Arial",Font.BOLD,12));
		suivant.setForeground(Color.black);
		suivant.setBackground(Minecraft.fond_bouton);
		suivant.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//passage a la page suivante
				cl.next(content);
			}
		});
		
		//bouton precedent
		JButton precedent = new JButton ("precedent");
		//fon de precedent
		precedent.setFont(new Font("Arial",Font.BOLD,12));
		precedent.setForeground(Color.black);
		precedent.setBackground(Minecraft.fond_bouton);
		precedent.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//retour a la page precedente du manuel
				cl.previous(content);
			}
		});
		
		//ajout du panel contenant les boutons precedent et suivant
		JPanel boutonPane = new JPanel();
		boutonPane.setBackground(new Color(0,0,0,0));
		boutonPane.setLayout(new BorderLayout());
		boutonPane.add(suivant,BorderLayout.EAST);
		boutonPane.add(precedent,BorderLayout.WEST);
		boutonPane.setPreferredSize(new Dimension(this.getWidth(),Minecraft.espace1*2));
		this.setBackgroundImage(this, new File("miniatures/aide/titre_minecraft.png"));
		this.setBackground(new Color(9,82,40));
		
		content.setLayout(cl);
		
		//ajout des pages
		content.add(etape1, listEtapes[0]);
		content.add(etape2, listEtapes[1]);
		content.add(etape3, listEtapes[2]);
		content.add(etape4, listEtapes[3]);
		content.add(etape5, listEtapes[4]);
		
		//ajout des deufferents panels
		this.getContentPane().add(boutonPane,BorderLayout.NORTH);
		this.getContentPane().add(content,BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		//ajout de l'image de fond
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); 
			//ajout de la couleur de fond
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
		//fermeture de le fenetre
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
