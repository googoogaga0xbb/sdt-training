
public class CoreJavaBrushup3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String is an object that represents a series of characters
		//String Literal

		String bp1 = "Betty Pérez Abogados";
		
		//New memory allocate opperator "new String"
		String bp2 = new String("Welcome to");
		String bp3 = new String("Welcome to");
		
		
		//Split Method
		String bp = "Betty Pérez Abogados";
		String[] splittedString = bp.split("Pérez");
		
		for(int i = 0; i< splittedString.length; i++)
		{
			System.out.println(splittedString[i].trim());
		}

		for(int i = 0; i< bp.length(); i++)
		{
			System.out.println(bp.charAt(i));
		}
		
		//Reverse Order
		for(int i = bp.length()-1; i >= 0; i--)
		{
			System.out.println(bp.charAt(i));
		}
	}

}
