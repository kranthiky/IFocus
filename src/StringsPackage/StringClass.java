package StringsPackage;


public class StringClass {

	public static void main(String[] args) {
		
		String str = " Hello Kranthi K Yadala ";
		String str2 = "Hey Monika";
		
		System.out.println("String:"+str);
		System.out.println("length:"+str.length());
		System.out.println("indexOf:"+str.indexOf("K"));
		System.out.println("charAt:"+str.charAt(7));
	
		
		System.out.println("replace: "+ str.replace("Kranthi", "M"));
		System.out.println("compareTo:"+str.compareTo(str2));
		if(str.equalsIgnoreCase(str2)) 
			System.out.println("True");
		else 
			System.out.println("False");
		System.out.println("trim:"+str.trim());
		String str3 = str.concat(str2); 
		System.out.println("Concatenated:"+str3);
		
		String[] strArr = str.split(" ",2);
		System.out.print("Split:");
		for(String sA: strArr) {
			System.out.println(sA);
		}
		System.out.println("sub string:"+str.substring(5));
		System.out.println("Contains:"+str.contains("Kranthi"));
		System.out.println("Starts:"+str.startsWith(" "));
		
		String actual ="KRANTHI";
		String expected = "kranthi";
		
		boolean check = actual.equalsIgnoreCase(expected);
		boolean check2 = actual.equals(expected);
		System.out.println("equalsIgn:"+check);
		System.out.println("equals:"+check2);
		//StringBuffer
		
		StringBuffer sbuff = new StringBuffer("Kumar Kranthi");
		System.out.println("reverse:"+sbuff.reverse());
		System.out.println("indexOf:"+sbuff.indexOf("u"));
		System.out.println("sf substring:"+sbuff.substring(2));
		
		
		
	}

}
