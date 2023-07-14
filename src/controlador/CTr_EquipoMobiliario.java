/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.List;
import negocio.EquipoMobiliario;

/**
 *
 * @author David
 */
public class CTr_EquipoMobiliario {

    public static int agregar(int inss, int numeroArt, String etiqueta, String codigo, int cantidad,
            String descripcion, double costo, int idEstado, String obervacion)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario pa = new EquipoMobiliario(inss, numeroArt, etiqueta, codigo,
                cantidad, descripcion, costo, idEstado, obervacion);
        return pa.agregarRegistro(); 
    }

    public static EquipoMobiliario leerRegistro(int numCarnet) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario po = new EquipoMobiliario();
        return (EquipoMobiliario) po.LEER(numCarnet);
    }

    public static EquipoMobiliario leerRegistroTabla(String etiqueta) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario po = new EquipoMobiliario();
        return (EquipoMobiliario) po.LeerTabla(etiqueta);
    }

    public static int actualizar(int inss, int numeroArt, int cantidad, String descripcion,
            double costo, int idEstado, String obervacion, int activo)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario pa = new EquipoMobiliario(inss, numeroArt, cantidad, descripcion,
                costo, idEstado, obervacion, activo);
        return pa.actualizarRegistro(numeroArt);
    }

    public static int borrarRegistro(int numArt, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario(activo);
        return bdP.borrarRegistro(numArt);
    }

    public static boolean verificarEquipoRegistrado(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario pa = new EquipoMobiliario();
        return pa.verificarEquipoRegistrado(numArt);
    }

    public static List<String> obtenerEstados() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.Estado();

    }

    public static int buscarIDEstado(String Estado) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.BuscarIdEstado(Estado);
    }

    public static Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.Listado();
    }

    public static Object[] EquipoMalosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.EquipoMalosList();
    }

    public static Object[] EquipoInactivos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.EquiposInactivo();
    }

    public static Object[] EquipoBuenos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoMobiliario bdP = new EquipoMobiliario();
        return bdP.EquipoBuenosList();
    }

}
