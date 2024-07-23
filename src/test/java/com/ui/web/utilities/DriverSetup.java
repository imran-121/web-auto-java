package com.ui.web.utilities;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


//This is where you write your test base function to define the driver
public class DriverSetup {
	private static final Logger LOG = LogManager.getLogger(DriverSetup.class);
	public WebDriver driver;
	public String propBrowser;
	public String mvnBrowser;
    public String urlStaging,urlProd;
    public ChromeOptions chromeOptions;
    public FirefoxOptions fireFoxOptions;


	public static Properties readPropertyFile() throws FileNotFoundException {
		try {
			
			File src = new File("src\\test\\resources\\config\\config.properties");
	        FileInputStream fis = new FileInputStream(src);
	        Properties prop = new Properties();
	        prop.load(fis);
	        return prop;
		}catch (Exception e){
			LOG.error("Got an exception", e);
			return null;
		}
	}
	
    public ChromeOptions chromeDriverCap() throws IOException {
    	chromeOptions = new ChromeOptions();
        return chromeOptions;
    }
	
	public FirefoxOptions firefoxDriverCap() throws IOException {
		fireFoxOptions = new FirefoxOptions();
		fireFoxOptions.addPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer
        return fireFoxOptions;
	}
	
	public WebDriver setupNewDriver() 
    {
		try
		{
	        Properties prop = readPropertyFile();
	        propBrowser = prop.getProperty("browser");
	        mvnBrowser = System.getProperty("browser");
	        urlStaging = prop.getProperty("urlStaging");
	        urlProd = prop.getProperty("urlProd");
	        String browser = mvnBrowser != null ? mvnBrowser : propBrowser;
	        
	        if(driver == null) {
	            switch (browser) {
	                case "chrome":
	                	chromeOptions = chromeDriverCap();
	                    driver = new ChromeDriver(chromeOptions);
	                    break;
	                case "firefox":
	                	fireFoxOptions = firefoxDriverCap();
	                    driver = new FirefoxDriver(fireFoxOptions);
	                    break;
	                case "edge":
	                    driver = new EdgeDriver();
	                    break;
	            }
	
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.get(urlStaging);
	        }
	        return driver;
		}catch(Exception e) {
			LOG.error("Got an exception", e);
			return null;
		}
    }

}
