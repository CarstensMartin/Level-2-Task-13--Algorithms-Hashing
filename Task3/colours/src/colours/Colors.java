package colours;

//Import all the required imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Colors {

	public static void main(String[] args) {

		// Declare Arraylist for the names and colours
		List<String> names = new ArrayList<>();
		List<String> colours = new ArrayList<>();

		// Initialize input to 0 - Let the user know how inputs was successful
		int inputNumber = 0;

		// Initialize while loop with a "Yes" want to add items
		String continueAdd = "Yes";
		
		//Run a while loop to give inputs for names and colours
		while (continueAdd == "Yes") {
			
			// Set up a text field input for name and colour
			JTextField name = new JTextField();
			JTextField colour = new JTextField();
			// Input message fields to complete on prompt
			Object[] message = { "Name:", name, "Colour:", colour };

			// Prompt message with 2 fields
			// Also let the user know how many inouts was successful so far
			int option = JOptionPane.showConfirmDialog(null, message, "You have added " + inputNumber + " inputs", JOptionPane.OK_CANCEL_OPTION);
			
			// If the input was successful
			if (option == JOptionPane.OK_OPTION ) {
				
				// If statement to test if a name and a color is added or if cell is blank
				if(((name.getText()).length() != 0) && (colour.getText()).length() != 0) {
				
					// Add the name to names arraylist
					names.add(name.getText());
					
					// Add the tempColour to colours arraylist
					colours.add(colour.getText());
					
					// Increase inputNumber so user knows how many was successfully captured
					inputNumber++;
				}
				else {
					// Display that input was not captured
					System.out.println("1 of the fields was incomplete. Could not add to inputs");
				}
			}
			// Else if prompt input failed, display on console and let user know
			else {
				System.out.println("Input was unsuccessful and not added");
			}

			// Create Yes and No option to continue adding
			String[] options = { "Yes", "No" };
			// Prompt user if they want to continue adding - if "Yes" while loop runs again
			continueAdd = (String) JOptionPane.showInputDialog(null, inputNumber + " inputs captured, do you want to add more?", null, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		}
		
		// Shuffle the names
		Collections.shuffle(names);
		// Shuffle the colours
		Collections.shuffle(colours);
		
		// Output message - header of data
		System.out.println("\nRandom Names to random Colours \nName : Colour\n");
		
		// For each element, print the new random pairs of names and colours
		for(int x = 0; x < names.size(); x++) {
			System.out.println(names.get(x) + " : " + colours.get(x));
		}
	}
}