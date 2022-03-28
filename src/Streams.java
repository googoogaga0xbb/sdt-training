import java.util.ArrayList;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Count the number of names starting with Alphabet A in list
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Leanna Mooney");
		names.add("Abigayle Martin");
		names.add("Bethany Shaffer");
		names.add("Esmeralda Kline");
		names.add("Andy Monroe");
		names.add("Prince Whitaker");
		names.add("Makena Parker");
		names.add("Zion Grimes");
		names.add("Kennedi Giles");
		names.add("Juan Hawkins");
		names.add("Sarah Brown");
		names.add("Ryann Cook");
		names.add("Serena Daniels");
		names.add("Roberto Houston");
		names.add("Maria Todd");
		names.add("Angeline Salinas");
		names.add("Linda Gamble");
		names.add("Nevaeh Glenn");
		names.add("Aaron Hurley");
		names.add("Khalil Stevens");
		int count = 0;
		
		
		for (int i=0; i<names.size(); i++) {
			String actualName = names.get(i);
			if(actualName.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println("Names starting with A: " + count);
	}

	
}
