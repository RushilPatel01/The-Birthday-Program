import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates the GUI and makes it functional.
 * 
 */
public class GUI implements ActionListener {
	
	// JFrame, which is the whole window you see.
	private JFrame frame;
	// Panel, which is within the JFrame.
	private JPanel panel;
	
	// Creates the buttons displayed in the GUI
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	public JButton changeDateButton;
	
	/**
	 * Main method that enables and shows the GUI and makes it functional.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI();
	}
	
	/**
	 * Adds all the buttons, adds the action listeners, which makes the buttons do stuff;
	 * Gives all the components of the GUI names.
	 * 
	 */
	public GUI () {
		frame = new JFrame(); //Creates a JFrame object called frame. Frames create a window on the screen
		
		button1 = new JButton("Birthday Gemstone"); //Creates a JButton object. It's a button what do you think it does.
		button1.addActionListener(this); //Listens for whenever the button is clicked
		button1.setBounds(50, 150, 200, 50);
		
		button2 = new JButton("Zodiac Sign"); //Creates a JButton object. It's a button what do you think it does.
		button2.addActionListener(this); //Listens for whenever the button is clicked
		button2.setBounds(50, 250, 200, 50);
		
		button3 = new JButton("Button 3"); //Creates a JButton object. It's a button what do you think it does.
		button3.addActionListener(this); //Listens for whenever the button is clicked
		button3.setBounds(50, 350, 200, 50);
		
		button4 = new JButton("Your Life Statistics"); //Creates a JButton object. It's a button what do you think it does.
		button4.addActionListener(this); //Listens for whenever the button is clicked
		button4.setBounds(650, 150, 200, 50);
		
		button5 = new JButton("Current Date Information"); //Creates a JButton object. It's a button what do you think it does.
		button5.addActionListener(this); //Listens for whenever the button is clicked
		button5.setBounds(650, 250, 200, 50);
		
		button6 = new JButton("Button 6"); //Creates a JButton object. It's a button what do you think it does.
		button6.addActionListener(this); //Listens for whenever the button is clicked
		button6.setBounds(650, 350, 200, 50);
		
		changeDateButton = new JButton("Change Date");
		changeDateButton.addActionListener(this);
		changeDateButton.setBounds(375, 300, 150, 50);
		
		JLabel titleLabel = new JLabel("The Date App");
		titleLabel.setBounds(335, 50, 400, 50);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
		
		JLabel birthdayLabel = new JLabel("You were born on " + mainMethod.getBirthdayMonth(mainMethod.birthdayMonth) + " " + mainMethod.birthdayDay + ", " + mainMethod.birthdayYear);
		birthdayLabel.setBounds(280, 170, 350, 50);
		birthdayLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		birthdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel currentTimeLabel = new JLabel("The current date is " + mainMethod.currentTime);
		currentTimeLabel.setBounds(10, 10, 500, 20);
		currentTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
		
		panel = new JPanel(); //Creates a JPanel object called panel. Panels store the groups of components (buttons, text boxes, etc.)
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); //Sets the border size of the frame
		panel.setLayout(null);
		
		//Adds all of the components to the panel. If you do not add it, it will not show up
		panel.add(button1); //Top left button
		panel.add(button2); //Middle left button
		//panel.add(button3); //Bottom left button *CODED OUT SINCE THERE IS NO USE ATM*
		panel.add(button4); //Top right Button
		panel.add(button5); //Middle right button
		//panel.add(button6); //Bottom right button *CODED OUT SINCE THERE IS NO USE ATM*
		panel.add(changeDateButton);
		
		panel.add(birthdayLabel);
		panel.add(titleLabel);
		panel.add(currentTimeLabel);
		
		//Adds the panel to the frame(the window)
		frame.add(panel, BorderLayout.CENTER); //Adds the panel to the content frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the close button exit the program
		frame.setTitle("The Date App"); //Sets the title of the GUI to "Dating App"
		frame.setSize(920, 460);
		frame.setBackground(Color.GRAY);
		frame.setResizable(false); // Make it where we can't resize the main GUI frame.
		//frame.pack(); //Sizes the frame so that all its contents are at or above their preferred sizes (Do not use if a layout is not being used)
		frame.setVisible(true); //Sets the frame (window) to visible.	
	}

	/**
	 * For all the buttons, this is how they operate once that are clicked.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) { //Birthday gemstone
			JOptionPane.showMessageDialog(null, "Your birthday gemstone is " + GetGemstone.getGemstone(mainMethod.birthdayMonth), "Birthday Gemstone", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == button2) { //Zodiac Signs
			JOptionPane.showMessageDialog(null, "Your zodiac sign is " + mainMethod.zodiacSignString
			 + "\n" + ZodiacAnimal.getInfo(((mainMethod.birthdayYear - 1900) % 12) + 1), "Zodiac Sign", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == button4) { //Days lived statistics
			JOptionPane.showMessageDialog(null, 
					 "You have lived for " + mainMethod.daysLived + " days!" + "\n" + "You lived through " + mainMethod.leapDaysLived + " leap years."
					 		 + "\n" + "You were born on the " + mainMethod.dayOfYearBorn + " day of the year."
					 		 + "\n" + "You have been alive for " + mainMethod.exactAgeYear + " year(s), " + mainMethod.exactAgeMonth + " month(s), and " + mainMethod.exactAgeDay + " day(s)."
					 		 + "\n" + "Based on the average human lifespan, you have " + mainMethod.timeLeftYear + " year(s), " + mainMethod.timeLeftMonth + " month(s), and " + mainMethod.timeLeftDay + " day(s) left to live."
					,"Age Statistics", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == button5) { // Current Date Information
			
			JOptionPane.showMessageDialog(null, "There are " + (365 - mainMethod.daysOfYear) + " days of the year left." + "\n" + "Today on " + mainMethod.currentTime + " it is the " + mainMethod.daysOfYear + " day of the year.");
		}
		
		if (e.getSource() == changeDateButton) {

			frame.dispose();
			mainMethod.main(null);

		}
		
	}
}
