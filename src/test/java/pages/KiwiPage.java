package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement sehirEkleKutusu;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(id = "com.skypicker.main:id/saveButton")
    public WebElement setDateButton;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement enUcuzTicket;

}
