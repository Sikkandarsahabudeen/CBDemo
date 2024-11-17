package org.example.Base;

import Pages.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
   public BaseTest Btest;
   public PageObjectManager pageObjectManager;

    public TestContextSetup(){
        Btest=new BaseTest();
        driver= Btest.DriverManager();
       pageObjectManager=new PageObjectManager(Btest.DriverManager());
    }
}
