package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.Reportes.addStep;
import static utils.MetodoUtils.esperoObjeto;

public class CreacionDeProducto {
    private AppiumDriver driver;
    public CreacionDeProducto(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Más opciones\"]")
    private MobileElement optiones;
    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloCrearProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement NombreProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement Precios;
    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement botonConfirmar;

    public void validarVistaDesplegada(){
        if(esperoObjeto(tituloCrearProducto, 5)){
            addStep("[Validar titulo de la vista Crear Producto]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Crear Producto]", true, Status.FAILED, true);
        }
    }

    public void CreaFormularioProducto(String nombreProducto, int precio){
        System.out.println("[ Completar formulario Crear Producto ]");
        NombreProducto.click();
        NombreProducto.setValue( nombreProducto );
        this.driver.hideKeyboard();
        Precios.click();
        Precios.setValue( String.valueOf( precio ) );
        this.driver.hideKeyboard();
        addStep("[Completar formulario Crear Producto]", true, Status.PASSED, false);
    }

    public void tapConfirmar(){
        if(esperoObjeto(botonConfirmar,2)){
            addStep("Tap al Boton 'Confirmar' ", false, Status.PASSED,false);
            botonConfirmar.click();
        }else{
            addStep("Error, al dar TAP en  Boton Confirmar.", true, Status.FAILED,true);
        }
    }

}
