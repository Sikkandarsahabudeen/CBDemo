package TestClasses;

import Pages.productPage;
import Pages.resulPage;
import org.example.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RegionTest extends BaseTest {


            public void demoProject()  {
                String productName="ZARA COAT 3";
                productPage pp=lg.logged("dummy2@email.com","Test@123");
                List<WebElement> prod=pp.getPro();
                resulPage rP=pp.findProduct(prod, productName);
                Boolean isThere=rP.getHeaders(productName);
                Assert.assertTrue(isThere);
                String cnfMessage=rP.finalresult();
                Assert.assertTrue(cnfMessage.equalsIgnoreCase("Thankyou for the Order."));
            }


        }


