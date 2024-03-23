package tests.day04;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverter {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AllCurrencyPage allCurrencyPage = new AllCurrencyPage();

    @Test
    public void testAllCurrencyApp() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(allCurrencyPage.toolBar.isDisplayed());

        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklama(424,336);
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklama(420,490);
        ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");

        ReusableMethods.scrollWithUiScrollableAndClick("1");
        allCurrencyPage.üçTaneSifir.click();

        // cevrilen tutar screenShot olarak kaydedilir
        File ekranFoto = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranFoto, new File("plnToTry.jpg"));

        // ReusableMethods.getScreenshot("pltToTryNew");

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String tlKarsiligi = allCurrencyPage.sonucYazisi.getText();

        // kullaniciya sms olarak bildirilir
        driver.sendSMS("555555","1000 Zloty'nin TL karsiliği = " + tlKarsiligi);



    }
}
