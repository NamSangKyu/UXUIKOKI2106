import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMain {
	public static void testSelenium(String url) {
        //Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(url);
       
        try {
        	Thread.sleep(2000);
        } catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//       	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
        //System.out.println(driver.findElementByCssSelector("html"));
        
        List<WebElement> list= driver.findElementsByCssSelector("_3QDEeS6NLn");
        System.out.println(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());
		}
        driver.close();
        driver.quit();
        
		
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
//		String url = "https://search.shopping.naver.com/gate.nhn?id=26858677522";
		String url = "https://smartstore.naver.com/acube0/products/4968898617?NaPm=ct%3Dkuywc46w%7Cci%3D27f31e61173b2baca619f98a49885b88c06fa40d%7Ctr%3Dslsl%7Csn%3D899816%7Chk%3Dd64feb4f5a1bdad9e08d58de498dc5280c733226";
		testSelenium(url);
	}

}
