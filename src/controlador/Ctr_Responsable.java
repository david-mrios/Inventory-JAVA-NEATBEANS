/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.Responsable;

/**
 *
 * @author David
 */
public class Ctr_Responsable {

    public static int agregar(int inss, String nomb, String apell,
            int telefono, String cedula)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable pa = new Responsable(inss, nomb, apell,
                telefono, cedula);
        return pa.agregarRegistro();
    }

    public static Responsable leerRegistro(int inss) throws
            ClassNotFoundException,
            InstantiationException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable po = new Responsable();
        return (Responsable) po.LEER(inss);
    }

    public static int actualizar(int inss, String nomb, String apell,
            int telefono, String cedula, int activo)
            throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable pa = new Responsable(inss, nomb, apell,
                telefono, cedula, activo);
        return pa.actualizarRegistro(inss);
    }

    public static boolean verificarCarnetRegistrado(int inss)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable pa = new Responsable();
        return pa.verificarCarnetRegistrado(inss);
    }

    public static int borrarRegistro(int inss, int activo)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable bdP = new Responsable(activo);
        return bdP.borrarRegistro(inss);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        Responsable bdP = new Responsable();
        return bdP.Listado();
    }

}
