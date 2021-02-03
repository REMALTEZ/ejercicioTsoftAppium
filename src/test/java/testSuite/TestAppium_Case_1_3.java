package testSuite;

import conexion.DriverContext;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testCase.AgregoProductos;
import testCase.EliminoCliente;

import static conexion.DriverContext.setUP;

public class TestAppium_Case_1_3 {
    private static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void iniciarSesion() {
        setUP("emulator-5554","Android","C:\\Users\\nacho\\Download\\registroDeUsuarios.apk","emulator-5554",true);
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }

    @Test(priority =1, description = "Test Case Agrego Prouctos al Carro")
    public void agregarProducto(){
        AgregoProductos agregoProductos  =new AgregoProductos();
        agregoProductos.controlFlujoProducto();
        Assert.assertTrue(true);
    }

    @Test(priority =2, description = "Test Case Elimino un Cliente y se Valida su Eliminacion")
    public void eliminarCliente(){
        EliminoCliente eliminoCliente  =new EliminoCliente();
        eliminoCliente.controlFlujoEliminaCliente();
        Assert.assertTrue(true);
    }

}
