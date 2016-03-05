
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.assertTrue;

public class Test {

	 public void navigateTo(String url) {
		 	Driver d = new Driver();
		 	d.initializeDriver();
		 	Driver.driver.get(url);
	        System.out.println(Driver.driver.getTitle());
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Mainclass m = new Mainclass();
			m.navigateTo("http://www.bbc.co.uk");
	}
	
    @Step("Vowels in English language are")
    public void navigateToGauge(String url) {
        System.out.print("HEllo");
        assertTrue(true);
    }



}

