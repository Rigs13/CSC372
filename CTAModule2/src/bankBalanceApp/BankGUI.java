package bankBalanceApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BankGUI extends JFrame implements ActionListener {
	
	// variables for balance, balanceLabel, and JTextField (amountField)
	private double balance = 0.0;
	private JLabel balanceLabel;
	private JTextField amountField;
	
	public BankGUI() {
		
		// variables for fonts
		Font defaultFont = new Font("Calibri", Font.PLAIN, 16);
		Font boldFont = new Font("Calibri", Font.BOLD, 18);
		
		// setting up main JFrame
		setTitle("Bank Balance GUI");
		setSize(400, 180);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			// Main Panel
		
		// Main Panel for adding formatting layers
		JPanel mainPanel = new JPanel();
		// Set layout to BoxLayout for vertical stacking
		BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainLayout);
		
			// Upper Panel
		
		// create upper panel for greeting and balance labels
		JPanel panel1 = new JPanel();
		// boxlayout for upper panel; vertical stacking
		BoxLayout upperLayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		panel1.setLayout(upperLayout);
		// centering of components
		panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// create greeting JLabel; Centered
		JLabel greeting = new JLabel("Welcome to the Basic Bank GUI!");
		// greeting label settings
		greeting.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		greeting.setFont(boldFont);
		
		// create a balance label to update upon transactions; centered
		balanceLabel = new JLabel("Current Balance: $" + balance);
		// balanceLabel settings
		balanceLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		balanceLabel.setFont(defaultFont);
		
			// Mid Panel
		
		// create mid panel
		JPanel panel2 = new JPanel();
		// create a boxlayout for mid panel; horizontally
		BoxLayout midLayout = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(midLayout);
		panel2.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		// create label for mid panel for entering amount to manipulate
		JLabel amountLabel = new JLabel("Amount to Deposit/Withdraw: $");
		// set font of label
		amountLabel.setFont(defaultFont);
		
		// create textfield for entry of amount for transaction
		amountField = new JTextField(10);
		// textfield font set
		amountField.setFont(defaultFont);
		// set max size to restrict sizing
		amountField.setMaximumSize(new Dimension(150, amountField.getPreferredSize().height));
		
			// Lower Panel
		
		// create lower panel
		JPanel panel3 = new JPanel();
		// setup boxlayout for lower panel; horizontal
		BoxLayout lowLayout = new BoxLayout(panel3, BoxLayout.X_AXIS);
		panel3.setLayout(lowLayout);
		panel3.setAlignmentY(CENTER_ALIGNMENT);
		
		// create button for deposit
		JButton depositButton = new JButton("Deposit");
		// add action listener to button with internal logic for button
		depositButton.addActionListener(this);
		
		// create button for withdrawal
		JButton withdrawButton = new JButton("Withdraw");
		// add action listener to button
		withdrawButton.addActionListener(this);
		
		// add components to upper panel
		panel1.add(greeting);
		panel1.add(balanceLabel);
		
		// add components to mid panel
		panel2.add(amountLabel);
		panel2.add(amountField);
		
		// add components to lower panel
		panel3.add(depositButton);
		// create a rigid are to separate buttons
		panel3.add(Box.createRigidArea(new Dimension(10,0)));
		panel3.add(withdrawButton);
		
		// adding panels to main panel
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		// add mainPanel to frame
		add(mainPanel);
		
		// make the frame visible
		setVisible(true);
		
	}
	
	// Override for action performed by tracking which button is clicked
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// variable for storing event as a string for comparison
		String s = event.getActionCommand();
		// variable for storing/parsing data from amountField
		double amount = Double.parseDouble(amountField.getText());
		
			// button handling
		
		// Deposit Handling
		if (s.equals("Deposit")) {
			balance = balance + amount;
			updateBalanceLabel();
		}
		// Withdraw Handling
		if (s.equals("Withdraw")) {
			balance = balance - amount;
			updateBalanceLabel();
		}
		
	}
	
	// Method for updating the Balance Label
	private void updateBalanceLabel() {
		balanceLabel.setText("Balance :$" + balance);
	}
	
	// Main Method; uses SwingUtilities to invoke the BankGUI class
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new BankGUI());
	}

}
