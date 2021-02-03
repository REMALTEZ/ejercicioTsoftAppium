package testCase;

import io.appium.java_client.AppiumDriver;
import pages.CarruselPages;
import pages.CreacionDeProducto;
import pages.Registros;

public class AgregoProductos {
    private AppiumDriver driver;
    CarruselPages carruselPages =new CarruselPages();
    Registros registros =new Registros();
    CreacionDeProducto creacionDeProducto =new CreacionDeProducto();

    String nombreProducto = "Cerveza Artesanal";
    int precio = 3600;

    public void controlFlujoProducto(){
        carruselPages.validarVistaDesplegada();
        carruselPages.recorrerCarrusel();
        carruselPages.tapBotonHecho();

        registros.validarVistaDesplegada();
        registros.tapBotonMas();
        registros.tapBotonCreaProducto();

        creacionDeProducto.validarVistaDesplegada();
        creacionDeProducto.CreaFormularioProducto(nombreProducto,precio);
        creacionDeProducto.tapConfirmar();

        registros.validarPestanaProductos();
        registros.validarProducto(nombreProducto);
        registros.validarPrecio(precio);

        this.driver.hideKeyboard();

    }
}
