import java.util.ArrayList;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		int[] array2 = {5,6,13,19,17,22,42};
		
		//Check if array has multiple of 2 values
		
		// Multiple of 2
		for(int i = 0; i< array2.length; i++)
		{
			if (array2[i] % 2 == 0) // comare == 
			{
				System.out.println(array2[i]);
				break;
			}
			else
			{
				System.out.println("no");
			}
		}
		
		//ARRAYLIST and WHY WE USE IT - Dynasically grow arrays in real time
		ArrayList<String> al = new ArrayList<String>();
		// Create object of the class - object.method
		al.add("Ivan A");
		al.add("Ivan");
		al.add("Betty");
		al.add("Penelope");
		al.add("Boda");
			
		System.out.println(al.get(4));
	}

}
