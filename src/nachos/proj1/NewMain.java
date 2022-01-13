package nachos.proj1;

public class NewMain {
	NewConsoles newCon = new NewConsoles();
	public NewMain() {
//		newCon.print("Hello World\n");
		Integer a = newCon.readInt();
		newCon.printInt(a);
	}
}
