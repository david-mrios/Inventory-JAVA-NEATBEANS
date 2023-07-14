/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;


import java.sql.SQLException;
import negocio.DetalleMovEqMob;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_DetalleMovEqMob {
     private DetalleMovEqMob Eq;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_DetalleMovEqMob() {
        Eq = null;
    }

    public BD_DetalleMovEqMob(DetalleMovEqMob Eq) {
        this.Eq = Eq;
    }//Fin constructor
       
    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call  [Inventory].[GuardarDetalleMovMob](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getNoMovimiento());
        cnx.callState.setInt(2, Eq.getIdEquipoMobiliario());
        return cnx.callState.executeUpdate();
    }//Fin método
}
