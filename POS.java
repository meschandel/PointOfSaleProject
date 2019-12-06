/*
	CAFE DRINK P(oint) O(f) S(ale)
	created: 11/22/19
	by: Megan Schandel

	This is supposed to imitate the POS that is used by Starbucks.
	Also a way to teach myself Java (haha, using Java to order java)

	To do:
	- create a directory of drinks and their default properties
	- compare user input to directory of drinks
	- allow user to change drinks in the order, including name
	- prettier interface
*/

// note to self - once a string is assigned a value, it is apparently immutable?

import java.util.Scanner; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// can this eventually be exported to a separate file and then linked to this one?
class Drink {

	// vars
	enum DrinkSize{TALL, GRANDE, VENTI} // possible size options
	DrinkSize size;
	String name;

	// Constructor
	public Drink(String DrinkName){
		size = DrinkSize.GRANDE; // default size
		name = DrinkName;
	}

	// ChangeSize
	public void ChangeSize(String s){
		if (s.equals("T")) {
			size = DrinkSize.TALL;
		}
		else if (s.equals("G")) {
			size = DrinkSize.GRANDE;
		}

		else if (s.equals("V")) {
			size = DrinkSize.VENTI;
		}
		else {
			System.out.println("Error: size not found");
		}
	}

	// PrintDrink: prints size and name of drink
	public void PrintDrink(){
		System.out.println(size + " " + name);
	}


}

// name of program too??????

public class POS {

	//// 	MAIN 	////

	public static void main (String []args) throws IOException {	// throws IOException needed for br?

		// get # of drinks in order
		// NTS: use scanner to receive integer input
		Scanner in = new Scanner(System.in);
		System.out.println("How many drinks are in your order? ");
		int drinkCount = in.nextInt();

		// create an array of Drinks, allocate memory for array
		Drink[] order;
		order = new Drink[drinkCount];

		// take order
		for (int i = 0; i < drinkCount; i++) {
			// NTS: BufferedReader reads in the entire line from the console - until newline char
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// get name
			System.out.println('\n' + "What is the name of the drink? ");
			String d = br.readLine();
			order[i] = new Drink(d);

			// get size
			System.out.println("What size is the drink? (T/G/V)");
			String sz = br.readLine();
			order[i].ChangeSize(sz);
		}

		// print out the order
		System.out.println('\n' + "Here is your order: ");
		PrintOrder(order, drinkCount);
		
	}

	// method PrintOrder: prints the Drink array received from user
	public static void PrintOrder(Drink[] o, int n){
		for (int i = 0; i < n; i++) {
			System.out.print("Item #" + (i + 1) + ": ");
			o[i].PrintDrink();
		}
		System.out.print('\n');
	}
}