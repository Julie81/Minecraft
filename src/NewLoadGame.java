import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class NewLoadGame extends Frame implements WindowListener{
	
	char fileNumber;
	Boolean New;
	Boolean choice;
	String [] Load= {"Load Game 01", "Load Game 02", "Load Game 03"};

	public NewLoadGame() {
		// TODO Auto-generated constructor stub
		super();
		this.choice = false;
		this.setLayout(new GridLayout(3, 2));
		this.addWindowListener(this);
		
		
		JButton jb;
		
		for (int i=1; i<4; i++){
			for (int j=0; j<2;j++){
				if(j==0) {
					jb = new JButton("New Game 0"+i);
				}
				else {
					jb = new JButton(Load[i-1]);
				}
				
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String button = e.getActionCommand();
						if(button.startsWith("N")) {
							New = true;
							String pseudo_souhaite = JOptionPane.showInputDialog(null,
                                    "Entrez le nom de votre partie : ",
                                    "NOM DE LA PARTIE",
                                    JOptionPane.QUESTION_MESSAGE);
							System.out.println(pseudo_souhaite);
						}
						else {
							New = false;
						}
						fileNumber =  button.charAt(button.length()-1);

						choice = true;
					}
					
					
				});
				jb.setActionCommand(jb.getName());
				this.add(jb);
			}
		}
		
		this.pack();
		this.setVisible(true);
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
		// TODO Auto-generated method stub
		System.exit(0);
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
