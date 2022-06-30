package random.tests;

public class CharOccurInStr {

	public static void main(String[] args) {
		
		String str = "AABBCC DDEEF";
		char[] chArray = new char[str.length()];
		
		for(int i=0;i<str.length();i++) {
			chArray[i] = str.charAt(i);
		}
		
		for(int j=0;j<chArray.length;j++) {
			int count =0;
			for(int k=0;k<str.length();k++) {
				if(chArray[j]==str.charAt(k)) {
					count++;
				}
			}
			System.out.println(chArray[j]+" occurance in a given String: "+str+" is: "+count);
		}
	}

}
