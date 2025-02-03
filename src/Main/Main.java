package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tiyan\\Downloads\\chromedriver-win64\\chromedriver.exe");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open CPUT website
       driver.get("https://www.cput.ac.za/index.php?search=registration&option=com_search&Itemid=999999");

        System.out.println("Opened CPUT homepage.");
        System.out.println();


        WebElement searchBox = driver.findElement(By.name("searchword"));
        searchBox.sendKeys("Registration");

        System.out.println("Entered 'Registration' in the search box.");
        System.out.println();

        // Find and click the search button
        WebElement searchButton = driver.findElement(By.name("Search"));
        searchButton.click();
        System.out.println("Clicked the search button.");

        // Wait for the results to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Check if the search results page loaded
        String pageTitle = driver.getTitle();

        if (pageTitle.contains("Registration"))
        {
            System.out.println("Test Passed! Search results page loaded successfully.");
        }
        else {
            System.out.println("Test Failed! Search results page did not load.");
        }
        WebElement resultsContainer = driver.findElement(By.cssSelector("dl.search-results"));

        // Find all <dt> or <dd> elements inside the <dl> (assuming each result is in a <dt> or <dd>)
        List<WebElement> searchResults = resultsContainer.findElements(By.cssSelector("dt, dd"));
        int numberOfResults = searchResults.size();

        System.out.println("Number of search results found: " + numberOfResults);


        // Close the browser
       driver.quit();
        System.out.println();

        System.out.println("Browser closed.");



    }
}