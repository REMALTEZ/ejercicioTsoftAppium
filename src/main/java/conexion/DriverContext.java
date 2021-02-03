package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {


    private static DriverManager driverManager = new DriverManager();

    public static void setUP(String NombreMobil,String SD, String aplicacion ,String udid, boolean emulador){
        driverManager.iniciarSesion(NombreMobil,SD,aplicacion,udid,emulador);
    }

    public static AppiumDriver getdriver(){
        return driverManager.getDriver();
    }

    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
