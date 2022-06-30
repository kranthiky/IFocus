package commandLineArgs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandLineArguments {

	
	public static void main(String[] args) {
		
		//Set parameters in Run-> Run configurations ->Args
		System.out.println("Command line parameters are:");
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
		}
		//String browser ="chrome";
		if(args[0].equalsIgnoreCase("chrome")) {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com");
		}
	}

}
