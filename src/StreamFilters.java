import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamFilters {

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

		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Names starting with A: " + c);
		
		long d = Stream.of("Leanna Mooney", "Abigayle Martin", "Bethany Shaffer", "Esmeralda Kline", "Andy Monroe", "Prince Whitaker", "Makena Parker", "Zion Grimes", "Kennedi Giles", "Juan Hawkins", "Sarah Brown", "Ryann Cook", "Serena Daniels", "Roberto Houston", "Maria Todd", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens").filter(s-> {
		    s.startsWith("A");
		    return true;
		}).count();
		System.out.println(d);
		
		//print all the names of ArrayList
		names.stream().filter(s->s.length()>13).forEach(s->System.out.println(s));
		
		//Print first result ---- foreach helps to scan.
		names.stream().filter(s->s.length()>13).limit(1).forEach(s->System.out.println(s));
		
	}

	
}
