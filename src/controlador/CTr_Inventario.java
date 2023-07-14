package controlador;

import java.sql.SQLException;
import java.util.List;
import negocio.Inventario;

/**
 *
 * @author David
 */
public class CTr_Inventario {

    public static int agregar(int NumInventario, int ResponsableInss, int CustodioInss, String FechaIngreso)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario pa = new Inventario(NumInventario, ResponsableInss, CustodioInss, FechaIngreso);
        return pa.guardar();
    }

    public static boolean verificarEquipoRegistrado(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario pa = new Inventario();
        return pa.verificarEquipoRegistrado(numArt);
    }

    public static int getNoInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.getNoInventario();
    }

    public static List<String> obtenerFacultad() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.obtenerFacultad();
    }

    public static List<String> obtenerDepartamento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.obtenerDepartamento();
    }

    public static List<String> obtenerRecinto() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.obtenerRecinto();
    }

    public static Object[] CantEquipoInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.CantEquipoInventario();
    }

    public static Object[] obtenerDatosEquipoTecnologicosInv(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.obtenerDatosEquipoTecnologicosInv(numInventario);
    }

    public static Inventario leerRegistro(int numInventario) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario po = new Inventario();
        return (Inventario) po.LEER(numInventario);
    }

    public static Object[] CantEquipoMobInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.CantEquipoIMobnventario();
    }

    public static Object[] obtenerDatosEquipoMobiliarioInv(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.obtenerDatosEquipoMobiliarioInv(numInventario);
    }

    public static Object[] InventarioAll() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Inventario bdP = new Inventario();
        return bdP.InventarioAll();
    }

}
