/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import negocio.DetalleMovEqTec;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_DetalleMovEqTec {
     private DetalleMovEqTec Eq;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_DetalleMovEqTec() {
        Eq = null;
    }

    public BD_DetalleMovEqTec(DetalleMovEqTec Eq) {
        this.Eq = Eq;
    }//Fin constructor
    
    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call  [Inventory].[GuardarDetalleMovTec](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getNoMovimiento());
        cnx.callState.setInt(2, Eq.getIdEquipoTecnologico());
        return cnx.callState.executeUpdate();
    }//Fin método
    
}
