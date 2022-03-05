
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//We need to assign the method to an object
		MethodsDemo d = new MethodsDemo(); 
		String msg = d.getData();
		System.out.println(msg);
		MethodsDemo2 d1 = new MethodsDemo2();
		String msg2 = d1.getUserData();
		getData2();
	}
	
	// Method reuse. Must created outside of Public  /Main Block
	public String getData()
	{
		System.out.println("Hello World");
		return "Error";
	}
	
	
	public static String getData2()
	{
		System.out.println("Hello World");
		return "Error";
	}

}
