package conexion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();


    protected void iniciarSesion(String NombreMobil,String SO, String aplicacion ,String udid, boolean emulador) {

        try {
            server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        cap.setCapability("deviceName", NombreMobil);
        cap.setCapability("platformName",SO);
        cap.setCapability("app", aplicacion);
        if(!emulador){
            cap.setCapability("udid",udid);
        }
        driver= new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    protected AppiumDriver getDriver(){
        return driver;
    }
}
