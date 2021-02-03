package testCase;

import pages.CarruselPages;
import pages.DetalleDeClientes;
import pages.Registros;

public class EliminoCliente {

    CarruselPages carruselPages =new CarruselPages();
    Registros registros =new Registros();
    DetalleDeClientes detalleDeClientes =new DetalleDeClientes();
    String Motivo="Borrando";
    String NombreCliente ="Sebastian Piraña";

    public void controlFlujoEliminaCliente(){
        carruselPages.validarVistaDesplegada();
        carruselPages.recorrerCarrusel();
        carruselPages.tapBotonHecho();

        registros.validarVistaDesplegada();
        registros.tapClientes(NombreCliente);

        detalleDeClientes.validarVistaDesplegada();
        detalleDeClientes.tapEliminoCliente();
        detalleDeClientes.CompletaFormularioEliminaCli(Motivo);
        detalleDeClientes.tapEliminaCliBotonOK();

    }
}
