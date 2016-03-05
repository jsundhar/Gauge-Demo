import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Mainclass {

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
	
    @Step("Navigate to <url>")
    public void navigateToURL(String url) {
        Driver.driver.get(url);
        Gauge.writeMessage("Page title is %s", Driver.driver.getTitle());
        assertTrue(true);
    }
    
    @Step("check for the following footer links <linksTable>")
    public void verifyFooterLinks(Table linksTable) {
        for (TableRow row : linksTable.getTableRows()) {
            String word = row.getCell("Links");
            Gauge.writeMessage("Link name is %s", word);
            assertTrue(Driver.driver.findElement(By.xpath("//div[@class='footer-column']//a[contains(text(),'"+word+"')]")).isDisplayed());
        }
    }

    @Step("Check if <content> is visible")
    public void checkContent(String content) {
    	Gauge.writeMessage("File content : %s", content);
    	assertTrue(Driver.driver.findElement(By.xpath("//div[@class='footer-column']//a[contains(text(),'"+content+"')]")).isDisplayed());
    }
    
    @Step("Check if link is visible <linksTable>")
    public void checkLinkContent(Table linksTable) {
    	for (TableRow row : linksTable.getTableRows()) {
            String word = row.getCell("Links");
            Gauge.writeMessage("CSV content is %s", word);
            assertTrue(Driver.driver.findElement(By.xpath("//div[@class='footer-column']//a[contains(text(),'"+word+"')]")).isDisplayed());
        }
    }
    

}
