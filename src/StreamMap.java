import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamMap {

	public static void main(String[] args) {
	
		//Print those ending with e and Uppercase
		Stream.of("Leanna", "Abigayle", "Bethany", "Esmeralde", "Andy", "Prince Whitaker", "Makene", "Roberto Houston", "Maria Todde", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens").filter(s->s.endsWith("e")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("-");
		//Print names first letter and sort
		Stream.of("Leanna", "Abigayle", "Bethany", "Esmeralde", "Andy", "Prince Whitaker", "Makene", "Roberto Houston", "Maria Todde", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		System.out.println("-");
		//Print names first letter A, Last letter E and sort
		Stream.of("Leanna", "Abigayle", "Bethany", "Esmeralde", "Andy", "Prince Whitaker", "AMakene", "Roberto Houston", "Maria Todde", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens").filter(s->s.startsWith("A")).filter(s->s.endsWith("e")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Mergin llists
		List<String> names = Arrays.asList("Leanna", "Abigayle", "Bethany", "Esmeralde", "Andy", "Prince Whitaker", "AMakene", "Roberto Houston", "Maria Todde", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens");
		List<String> namesTwo = Arrays.asList("James", "Juan", "Belamy", "One Hundred", "Andy", "Nemo", "Charles");
		
		//Merging 2 lists
		Stream<String> newStream = Stream.concat(names.stream(), namesTwo.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//Match
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Nemo"));
		Assert.assertTrue(flag);
		
		//Collect
		List<String> ls = Stream.of("Leanna", "Abigayle", "Bethany", "Esmeralde", "Andy", "Prince Whitaker", "Makene", "Roberto Houston", "Maria Todde", "Angeline Salinas", "Linda Gamble", "Nevaeh Glenn", "Aaron Hurley", "Khalil Stevens").filter(s->s.endsWith("e")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//Print unique and sort
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

}
