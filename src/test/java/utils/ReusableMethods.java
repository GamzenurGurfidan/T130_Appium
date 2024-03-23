package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class ReusableMethods {

    static AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    public static void koordinatTiklama(int x, int y) throws InterruptedException {
        TouchAction action = new TouchAction<>(driver);

        action.press(PointOption.point(x,y)).release().perform();

        Thread.sleep(1000);
    }

}
