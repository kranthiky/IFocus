package thisNsuperKeywords;

public class SuperBaseClass {

	String name = "Base Kranthi";

	public SuperBaseClass() {

		System.out.println("Base class default constructor..!");
	}

	public SuperBaseClass(String name) {

		System.out.println("Base class single param constructor..:" + name);
	}

	public void displayName(String name) {
		System.out.println("BaseClass method: " + name);
	}

}
