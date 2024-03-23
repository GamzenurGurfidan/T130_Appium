package tests.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {

        AndroidDriver<AndroidElement>driver = Driver.getAndroidDriver();
        KiwiPage kiwiPage = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiKimlik")));

        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.misafirButonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.misafirButonu.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        for (int i = 0; i < 3; i++) {

            ReusableMethods.koordinatTiklama(544,1695);

        }

        // Trip type,one way olarak secilir
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklama(355,615);
        ReusableMethods.koordinatTiklama(255,1454);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklama(370,770);
        ReusableMethods.koordinatTiklama(1015,134);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
            if (driver.isKeyboardShown()){
                driver.getKeyboard().pressKey("Istanbul");
            }else {
                kiwiPage.sehirEkleKutusu.sendKeys("Ankara");
            }
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklama(460,290);
        kiwiPage.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklama(341,910);

        driver.getKeyboard().pressKey("Antalya");

        Thread.sleep(1000);
        ReusableMethods.koordinatTiklama(460,290);
        kiwiPage.chooseButton.click();

        // gidis tarihi mart ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklama(424,1052);
        ReusableMethods.koordinatTiklama(968,1333);
        kiwiPage.setDateButton.click();

        // search butonuna tiklanir
        kiwiPage.searchButton.click();
        Thread.sleep(1500);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.koordinatTiklama(270,259);
        ReusableMethods.koordinatTiklama(522,595);
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklama(522,259);
        ReusableMethods.koordinatTiklama(431,1458);
        Thread.sleep(1000);


        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String enUcuzTicketText = kiwiPage.enUcuzTicket.getText();
        driver.sendSMS("55555555555","Kiwi uygulamasindaki en ucuz bilet fiyati " + enUcuzTicketText);


    }
}
