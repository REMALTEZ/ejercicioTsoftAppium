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
import static utils.MetodoUtils.swipeDown;

public class DetalleDeClientes {

    private AppiumDriver driver;

    public DetalleDeClientes(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement titleDetalleCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement botonEliminaCliente;

    @AndroidFindBy(id="com.rodrigo.registro:id/lista_tarjetas")
    private MobileElement textoCompleto;

    @AndroidFindBy(id= "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement textoEliminaCliente;

    @AndroidFindBy(id="android:id/button1")
    private MobileElement botonOK;

    public void validarVistaDesplegada(){
        if (esperoObjeto(titleDetalleCliente, 5)){
            addStep("Validar Detalle Cliente Desplegada", true, Status.PASSED, false);
        }
        else {
            addStep("Error en Vista Detalle Cliente", true, Status.FAILED , true);
        }

    }

    public void tapEliminoCliente(){
        swipeDown();
        if (esperoObjeto(botonEliminaCliente,2)){
            botonEliminaCliente.click();
            addStep("Click al Boton 'Eliminar Cliente' ", true, Status.PASSED,false);
        }
        else {
            addStep("Boton 'Eliminar Cliente' No se visualiza.", true, Status.FAILED,true);

        }
    }

    public void CompletaFormularioEliminaCli(String Motivo){
        System.out.println("[EliminarCliente Page] Completar Formulario para eliminar Cliente");
        textoEliminaCliente.setValue(Motivo);
        this.driver.hideKeyboard();

        addStep("Completar Formulario de Eliminacion de Cliente.", true, Status.PASSED,false);
    }

    public void tapEliminaCliBotonOK() {
        if (esperoObjeto(botonOK, 2)) {
            addStep("Tap al Boton 'OK' ", true, Status.PASSED, false);
            botonOK.click();
        } else {
            addStep("Boton 'OK' no se encuentra.", true, Status.FAILED, true);
        }

    }

}

