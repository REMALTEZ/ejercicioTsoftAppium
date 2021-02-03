package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static report.Reportes.addStep;
import static utils.MetodoUtils.esperoObjeto;

public class Registros {
    private AppiumDriver driver;
    public Registros(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath ="//android.widget.TextView[contains(@text,\"Registro\")]")
    private MobileElement titleVistaRegistro;
    @AndroidFindBy(id ="com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement botonMas;
    @AndroidFindBy(id ="com.rodrigo.registro:id/action_producto")
    private MobileElement botonCreaProducto;
    @AndroidFindBy(xpath ="//*[contains(@text,'PRODUCTOS')]")
    private MobileElement titleVistaProductos;
    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/nombre_producto']")
    private List<MobileElement> listarNombresDeProductos;
    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/precio_producto']")
    private List<MobileElement> listaPrecioProductos;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelCliente;

    public void validarVistaDesplegada(){
        if (esperoObjeto(titleVistaProductos,5)){
            addStep("Valido Vista Registro Desplegada.", true, Status.PASSED,false);
        }else{
            addStep("Error, al visualizar Vista de Registro Desplegada.  ", true, Status.FAILED,true);
        }
    }

    public void validarPestanaProductos(){
        if (esperoObjeto(titleVistaProductos,2)){
            titleVistaProductos.click();
            addStep("Validar Vista Productos Desplegada.", true, Status.PASSED,false);
        }else{
            addStep("Error,al Visualizar Productos Desplegados ", true, Status.FAILED,true);
        }
    }

    public void validarProducto(String Producto){
        System.out.println("[RegistroProducto] Validar producto");
        Boolean existeCliente = false;
        for (int i=0;i<=listarNombresDeProductos.size();i++){
            String ProductoActual = listarNombresDeProductos.get(i).getText();
            if (ProductoActual.equals(Producto)){
                existeCliente =true;
                break;
            }
        }
        if (existeCliente){
            System.out.println("[Existen Productos registrados]");
            addStep("Producto: "+Producto+" encontrado", true, Status.PASSED,false);
        }
        else {
            addStep("Producto: "+Producto+" NO encontrado", true, Status.PASSED,true);
        }
    }

    public void validarPrecio(int Precio){
        Boolean existePrecio = false;
        for (int i=0;i<=listaPrecioProductos.size();i++){
            String PrecioActual = listaPrecioProductos.get(i).getText();
            if (PrecioActual.equals(Precio)){
                existePrecio =true;
                break;
            }
        }
        if (existePrecio){
            System.out.println("[RegistroPrecios] Validar precios");
            addStep("Precio: "+Precio+" Visualizado", true, Status.PASSED,false);
        }
        else {
            addStep("Precio: "+Precio+" NO Visualizado", true, Status.PASSED,true);
        }
    }

    public void validaClienteEliminado(String Cliente){
        boolean clienteEncontrado = false;
        for (int i =0;i<=labelCliente.size();i++){
            String nombreCliente = labelCliente.get(i).getText();
            if (!nombreCliente.equals(Cliente)){
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado){
            System.out.println("[Registro Page] Valida Cliente Eliminado");
            addStep("El Cliente: "+Cliente+" Fue Eliminado", true, Status.PASSED, false);
        }
        else {
            addStep("El Cliente: "+Cliente+" no se eliminó correctamente", true, Status.FAILED, true);
        }

    }

    public void tapBotonMas(){
        if(esperoObjeto(botonMas,2)){
            addStep("Tap al Boton '+' ", false, Status.PASSED,false);
            botonMas.click();
        }else{
            addStep("Error,al Visualizar el Boton MAS '+' ", true, Status.FAILED,true);
        }
    }

    public void tapBotonCreaProducto(){
        if(esperoObjeto(botonCreaProducto,2)){
            addStep("Tap al Boton 'Crear Producto' ", false, Status.PASSED,false);
            botonCreaProducto.click();
        }else{
            addStep("Error, No se Visualiza,Boton 'Crear Producto'", true, Status.FAILED,true);
        }
    }

    public void tapClientes(String Cliente){
        boolean ClienteEncontrado = false;
        for (int i =0;i<=labelCliente.size();i++){
            String nombreCliente = labelCliente.get(i).getText();
            if (nombreCliente.equals(Cliente)){
                labelCliente.get(i).click();
                ClienteEncontrado = true;
                break;
            }
        }
        if (ClienteEncontrado){
            System.out.println("[Registro Page] Validar Cliente");
            addStep("El Cliente: "+Cliente+" Visualizado", true, Status.PASSED, false);
        }
        else {
            addStep("El Cliente: "+Cliente+" no se Visualiza ", true, Status.FAILED, true);
        }
    }


}
