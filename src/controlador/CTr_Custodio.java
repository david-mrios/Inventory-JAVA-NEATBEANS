/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.Custodio;

/**
 *
 * @author David
 */
public class CTr_Custodio {

    public static int agregar(int inss, String nomb, String apell,
            int telefono, String cedula)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio pa = new Custodio(inss, nomb, apell,
                telefono, cedula);
        return pa.agregarRegistro(); 
    }

    public static Custodio leerRegistro(int inss) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio po = new Custodio();
        return (Custodio) po.LEER(inss);
    }

    public static int actualizar(int inss, String nomb, String apell,
            int telefono, String cedula, int activo)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio pa = new Custodio(inss, nomb, apell,
                telefono, cedula, activo);
        return pa.actualizarRegistro(inss);
    }

    public static boolean verificarInssRegistrado(int inss)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio pa = new Custodio();
        return pa.verificarCarnetRegistrado(inss);
    }

    public static int borrarRegistro(int inss, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio bdP = new Custodio(activo);
        return bdP.borrarRegistro(inss);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Custodio bdP = new Custodio();
        return bdP.Listado();
    }

}
