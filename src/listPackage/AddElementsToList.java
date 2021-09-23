package listPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.annotations.Test;

public class AddElementsToList {

	
	@Test
	public void AddToList() {
	//Add elements to ArrayList
			List<String> cars = new ArrayList<>();
			Collections.addAll(cars, "Benz","Suzuki","Hyundai");
			
			List<String> cycles = new ArrayList<>();
			Collections.addAll(cycles,"Hero", "TVS");
			
			cars.addAll(2,cycles);
			System.out.println("List after appending:"+cars);
			
			
			//display ArrayList
			System.out.println("Before sort:"+ cars);
			
		//	Collections.sort(cars);
			cars.sort(Comparator.naturalOrder());		
			System.out.println("sorted:"+cars);
			
		//	Collections.reverse(cars);
			cars.sort(Comparator.reverseOrder());
			System.out.println("Reverse sorted:"+cars);
			
			//iterate
			System.out.println("Iterate: ");
			for(String cr:cars) {
				System.out.println(cr);
			}
			
	}
}
