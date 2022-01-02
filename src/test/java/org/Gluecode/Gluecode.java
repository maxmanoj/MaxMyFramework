package org.Gluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.BaseClass.Basecodes;
import org.CommonFunctions.CommonFunctions;
import org.Pages.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;

public class Gluecode extends Basecodes {

    public LoginPage loginPage;
    @Before
    public void LaunchBrowser() {
        Basecodes.initialization();
        loginPage = new LoginPage();
    }
    @After
    public void Hide(){
        Basecodes.CloseBrowser();
    }

    @Given("I navigate to OrangeHRM Url")
    public void  I_navigate_to_OrangeHRM_Url () throws InterruptedException {

        webdriver.get(CommonFunctions.getOrangeHRMURL());
        Thread.sleep(5000);
    }

    @When("I enter valid username and password")
    public  void Ientervalidusernameandpassword() {

        loginPage.UserNamefld.sendKeys(CommonFunctions.getUserName());
        loginPage.Passwordfld.sendKeys(CommonFunctions.getPassword());
    }

    @Then("I click on Login Button")
    public void  IclickonLoginButton () {
   loginPage.Loginbutton.click();
    }

    @Then("I Should be able to Login into Application")
    public void user_Should_be_able_to_Login_into_Application() throws InterruptedException {
        Thread.sleep(9000);
        Assert.assertTrue(LoginPage.Marketplace.isDisplayed());
    }
}
