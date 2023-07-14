/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.detalle_invEqTec;

/**
 *
 * @author David
 */
public class CTr_DetalleInvEqTecnologico {

    public static int agregar(int idEquipo, int IdInventario)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        detalle_invEqTec pa = new detalle_invEqTec(idEquipo, IdInventario);
        return pa.guardar(); 
    }

    public static int buscarIDEquipo(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        detalle_invEqTec bdP = new detalle_invEqTec();
        return bdP.BuscarIdEquipo(numArt);
    }
       public static int buscarIDInventario(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        detalle_invEqTec bdP = new detalle_invEqTec();
        return bdP.BuscarIdInventario(numInventario);
    }
}
