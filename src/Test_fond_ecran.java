import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test_fond_ecran {

	public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException { 
		JPanel panel = new JPanel() { 
			private static final long serialVersionUID = 1;
			private BufferedImage buf = ImageIO.read(img);
			@Override protected void paintComponent(Graphics g)
			{ super.paintComponent(g); g.drawImage(buf, 0,0, null); }
		};
		frame.setContentPane(panel); 
		return panel; }
	public static void main(String...args) throws IOException {
		JFrame frame = new JFrame();
		JPanel panel = setBackgroundImage(frame, new File("miniatures/fond_ecran.jpg"));
		panel.add(new JButton("A"));
		panel.add(new JButton("B"));
		panel.add(new JButton("C"));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); }
}
