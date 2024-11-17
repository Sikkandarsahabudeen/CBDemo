package Pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    logIN lg;
    productPage pp;
    resulPage rP;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }
    public logIN loginScreen(){
        lg=new logIN(driver);
        return lg;
    }
    public productPage productScreen(){
        pp=new productPage(driver);
        return pp;
    }
    public resulPage resulScreen(){
        rP=new resulPage(driver);
        return rP;
    }
}
