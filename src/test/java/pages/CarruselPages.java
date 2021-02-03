package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.Reportes.addStep;
import static utils.MetodoUtils.esperaImplicita;
import static utils.MetodoUtils.esperoObjeto;

public class CarruselPages {

    private AppiumDriver driver;

    public CarruselPages(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /** Reconocimiento de Objetos */
    @AndroidBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVistaOne;
    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;
    @AndroidBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;
    @AndroidBy(id = "com.rodrigo.registro:id/next")
    private MobileElement botonFlecha;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement botonPermitir;
    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement botonHecho;

    public void recorrerCarrusel(){
        /**
         System.out.println("[CarruselPage] recorrer Carrusel");
         for (int clickBtn = 1;  clickBtn < 4;  clickBtn ++){
         if (esperoObjeto(botonFlecha,5)){
         botonFlecha.click();
         esperaImplicita(2);
         addStep(String.format("Recorriendo Carrusel vista 1.%s", clickBtn),true,Status.PASSED,false);
         }
         else {
         addStep(String.format("Recorriendo Carrusel vista 1.%s", clickBtn),true,Status.FAILED,false);
         }
         }
         */

        System.out.println("[CarruselPage] recorrer Carrusel");
        int cont = 0;
        do{
            cont++;
            botonFlecha.click();
            esperaImplicita(2);
            addStep("Validar Vista del Carrusel Desplegado", true, Status.PASSED,false);

        }while (cont<3);
    }

    public void tapBotonHecho(){

        if (esperoObjeto(botonPermitir,5)){
            esperaImplicita(2);
            addStep("Permisos de escritura concedidos,Vista de Carrusel Desplegada",true,Status.PASSED,false);
            botonPermitir.click();
        }
        else {
            addStep("Recorrido de carrusel terminado",true,Status.FAILED,true);
        }

        if (esperoObjeto(botonHecho,5)){
            esperaImplicita(2);
            addStep("Recorrido de carrusel terminado",true,Status.PASSED,false);
            botonHecho.click();
        }
        else {
            addStep("Recorrido de carrusel terminado",true,Status.FAILED,true);
        }
    }

    public void validarVistaDesplegada(){
        if (iconoVistaOne.isDisplayed()){
            addStep("Validar Vista 1 de carrucel",false, Status.PASSED,false);
        }else{
            addStep("Validar Vista 1 de carrucel",true, Status.FAILED,true);
        }
    }

    public void validaTextoVistaOneCarrucel() {
        if(esperoObjeto(descripcionVista,5)){
            String validaTextoVistaOneCarrucel = descripcionVista.getText();
            if (validaTextoVistaOneCarrucel.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios."))
            {
                addStep("Valido Primera Vista de Carrusel - Descripcion", true, Status.PASSED,false);
            }else{
                addStep("Error al Validar Primera Vista de Carrusel", true, Status.FAILED,true);
            }
        }else{
            addStep("Error en Tiempo de Espera", true, Status.FAILED,true);
        }

    }
}
