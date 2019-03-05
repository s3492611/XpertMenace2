//import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;	//asterisk means all library sections are imported
public class window extends JFrame
{
	private JLabel label;
	private JButton button;
	private JTextField textfield;
	
	public window()
	{
		setLayout(new FlowLayout());
		
		label = new JLabel("Hi, I am a label");
		add(label);
		
		textfield = new JTextField(15);
		add(textfield);
		
		button = new JButton("CLICK ME");
		add(button);
	}
	
	private ImageIcon image1;
	private JLabel label1;
	
	//imgTest() 
	{
	//	setLayout(new FlowLayout());
	//	image1 = new ImageIcon(getClass().getResource("Might Beanz.jpg"));
		
	}
	
	public static void main (String args[])
	{
		window gui = new window();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 500);
		gui.setVisible(true);
		gui.setTitle("the gui bb");
	}
	
}