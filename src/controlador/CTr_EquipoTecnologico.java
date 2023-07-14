/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import java.util.List;
import negocio.EquipoTecnologico;

/**
 *
 * @author David
 */
public class CTr_EquipoTecnologico {

    public static int agregar(int inss, int numeroArt, String codigo, String etiqueta, int cantidad,
            String descripcion, String modelo, int idMarca, String serie,
            double costo, int idEstado, String obervacion)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico pa = new EquipoTecnologico(inss, numeroArt, codigo, etiqueta,
                cantidad, descripcion, modelo, idMarca, serie,
                costo, idEstado, obervacion);
        return pa.agregarRegistro(); 
    }

    public static EquipoTecnologico leerRegistro(int numCarnet) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico po = new EquipoTecnologico();
        return (EquipoTecnologico) po.LEER(numCarnet);
    }

    public static EquipoTecnologico leerRegistroTabla(String etiqueta) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico po = new EquipoTecnologico();
        return (EquipoTecnologico) po.LeerTabla(etiqueta);
    }

    public static int actualizar(int inss, int numeroArt, int cantidad, String descripcion, String modelo, int idMarca, String serie,
            double costo, int idEstado, String obervacion, int activo)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico pa = new EquipoTecnologico(inss, numeroArt, cantidad, descripcion, modelo, idMarca, serie,
                costo, idEstado, obervacion, activo);
        return pa.actualizarRegistro(numeroArt);
    }

    public static int borrarRegistro(int numArt, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico(activo);
        return bdP.borrarRegistro(numArt);

    }

    public static boolean verificarEquipoRegistrado(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico pa = new EquipoTecnologico();
        return pa.verificarEquipoRegistrado(numArt);
    }

    public static List<String> obtenerEstados() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.Estado();

    }

    public static List<String> obtenerMarca() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.Marca();

    }

    //Buscar el id
    public static int buscarIDEstado(String Estado) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.BuscarIdEstado(Estado);
    }

    //Buscar el id
    public static int buscarIDMarca(String Marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.BuscarIdMarca(Marca);
    }

    public static Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.Listado();
    }

    public static Object[] EquipoMalosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.EquipoMalosList();
    }

    public static Object[] EquipoInactivos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.EquiposInactivo();
    }

    public static Object[] EquipoBuenos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.EquipoBuenosList();
    }

    
    public static float porcentajeEquiposBuenos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.porcentajeEquiposBuenos();
    }

    public static float porcentajeEquiposMalos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        EquipoTecnologico bdP = new EquipoTecnologico();
        return bdP.porcentajeEquiposMalos();
    }

}
