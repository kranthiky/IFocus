package commandLineArgs;


public class CommandLineArguments {

	
	public static void main(String[] args) {
		
		System.out.println("Command line parameters are:");
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
		}
		//String browser ="chrome";
		if(args[0].equalsIgnoreCase("chrome")) {
			
			
		}
	}

}
