
public class CoreJavaBrushup1 {

	public static void main(String[] args) {
		
		
		int num = 5; //Declare data type, variable and assign value
		String WebsiteTitle = "Betty Pérez Web"; // String, Collection of characters
		char letter = 'r'; // Single Character
		double dec = 5.99; //for decimals, float is anothe way
		boolean myCard = true; //Declaration for a variable true or false
		
		//Printing
		System.out.println(num+" is the value stored in the num variable"); // + opperation connect a variable with string
		System.out.println(WebsiteTitle);
		
		//ARRAYS - Store multiple value in one single variable
		int[] array = new int[5]; // Syntax to allocate memory to create variable/array to story X amount of value
		array[0] = 5; //Initialize array with values
		array[1] = 6;
		array[2] = 13;
		array[3] = 19;
		array[4] = 17;;

		int[] array2 = {5,6,13,19,17}; // Shortcut to create array and assign values right away
		
		//Printout Array Element
		System.out.println("Array Position[0]: "+array2[0]);
		
		//LOOP - FOR
		for(int i = 0; i< array2.length; i++)
		{
			System.out.println("Array Position["+i+"] - Position Value: "+array2[i]);
		}
		
		//Array of strings / Names
		String[] name = {"Ivan A", "Ivan", "Betty", "Penelope", "Boda" };
		for(int i = 0;  i< array2.length; i++)
		{
			System.out.println("Nombre: "+name[i]+" - Cumpleaños: "+array2[i]);
		}		
		
		//Enhanced Loops
		for (String s: name)
		{
			System.out.println(s);
		}
		
	}

}
