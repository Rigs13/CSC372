package discussionMod2;
import javax.swing.*;

public class GUIExample {

	public static void main(String[] args) {

		// creation of JFrame window
		JFrame frame = new JFrame();
		// set size of JFrame
		frame.setSize(400, 250);
		// set title
		frame.setTitle("Discussion Module 2 Example");
		// set close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create a panel to add components
		JPanel panel = new JPanel();
		
		// create a JLabel for the text field
		JLabel userLabel = new JLabel("Name");
		// set bounds of label
		userLabel.setBounds(5, 20, 80, 25);
		// add label to panel
		panel.add(userLabel);
		
		// create text field
		JTextField text = new JTextField(20);
		// set bounds of text field
		text.setBounds(100, 20, 165, 25);
		// add text field to panel
		panel.add(text);
		
		// add panel to frame
		frame.add(panel);
		
		// set frame visibility
		frame.setVisible(true);
		
		
	}
}
