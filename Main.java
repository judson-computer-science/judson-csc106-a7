import java.io.*;
import java.util.*;
import exception.*;

public class Main {

	private static final int RV_INVALID_PARAMS = 1;
	private static final int RV_BAD_INPUT_FILE = 2;
	
	public static void main(String[] args) {

		if(args.length != 1) {
			System.err.println("usage: java Main <filename>");
			System.exit(RV_INVALID_PARAMS);
		}

		Store store = null;


		// TODO:  instantiate the Store object

		// do this in a loop prompting the user for an action
		int selection;

		while((selection = getSelection()) != 3) {

			// TODO: implement the body of the loop

		}
	}

	private static void printMessage(String line) {
		System.out.println("");
		System.out.println("\t" + line);
	}

	private static int getSelection() {

		int selection = 0;
		boolean validInput = false;
		Scanner input = new Scanner(System.in);

		while(!validInput) {
			System.out.println("");
			System.out.println("Choose an option:");
			System.out.println("1: Print Inventory Report");
			System.out.println("2: Purchase Items");
			System.out.println("3: Quit");
			System.out.print("im> ");

			try {
				selection = Integer.parseInt(input.next());

				if(selection >=1 && selection <= 3) validInput = true;
				else printMessage("Invalid Input");
			} catch (NumberFormatException nfe) {
				printMessage("Invalid Input");
			}
		}

		return selection;
	}
}
