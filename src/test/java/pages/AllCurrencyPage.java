package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.security.PublicKey;

public class AllCurrencyPage {

    public AllCurrencyPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }


    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/toolbar")
    public WebElement toolBar;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement bir;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b000")
    public WebElement üçTaneSifir;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement sonucYazisi;

}
