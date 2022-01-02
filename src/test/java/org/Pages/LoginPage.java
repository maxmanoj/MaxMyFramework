package org.Pages;

import org.BaseClass.Basecodes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Basecodes {

    public LoginPage() {

        PageFactory.initElements(webdriver, this);

    }

    @FindBy(xpath ="//input[@id='txtUsername']")
    public WebElement UserNamefld;

    @FindBy(xpath ="//input[@id='txtPassword']")
    public WebElement Passwordfld;

    @FindBy(xpath ="//input[@class='button']")
    public WebElement Loginbutton;

    @FindBy(xpath ="//span[@id='spanMessage']")
    public WebElement invalidCredentialsmsg;

    @FindBy(xpath ="//div[@id='forgotPasswordLink']")
    public WebElement forgetPwdLink;

    @FindBy(xpath = "//input[@value='Marketplace']")
    public static WebElement Marketplace;

}
