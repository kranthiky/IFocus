package thisNsuperKeywords;

public class SuperChildClass extends SuperBaseClass {

	String name="Child Kranthi";
	
	public SuperChildClass() {
		
		System.out.println("Child class default constructor..!");
	}
	
	public SuperChildClass(String name) {
	//Access BaseClass constructor
	 super(name);
	 System.out.println("Child class single param constructor..:"+this.name);
	}
	public void displayName(String name){
		System.out.println("ChildClass method: "+name);
	}
	public static void main(String[] args) {
		
		SuperChildClass childObj = new SuperChildClass("Mons");
		childObj.testVarNMethod();

	}

	public void testVarNMethod() {
		//Access BaseClass variable
		System.out.println("BaseClass var: "+super.name);
		System.out.println("ChildClass var: "+name);
		
		//Access BaseClass method
		super.displayName("Base method Kranthi");
		displayName("Child method Kranthi");
	}
}
