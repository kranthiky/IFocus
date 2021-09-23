package thisNsuperKeywords;

public class ThisKeyword {

	String name;
	int age;
	long phoneNum;
	
	public ThisKeyword() {
		this("Kranthi",32);
		System.out.println("Default - No args");
	}
	public ThisKeyword(String name,int age) {
		this("Kranthi",32,897100002);
		this.name=name;
		this.age =age;		
		System.out.println("Name is:"+name+" and Age:"+age);
	}
	
	public ThisKeyword(String name,int age, long phoneNum) {
		this.name=name;
		this.age =age;		
		this.phoneNum=phoneNum;
		System.out.println("Name is:"+name+" and Age:"+age+" "+phoneNum);
	}
	public void displayRecord() {
		this.age = 30;
		System.out.println("display record: "+name+" "+age+" "+phoneNum);
	}
	
	public static void main(String[] args) {
		
		ThisKeyword thisObj = new ThisKeyword();
		
		thisObj.displayRecord();
	}

}
