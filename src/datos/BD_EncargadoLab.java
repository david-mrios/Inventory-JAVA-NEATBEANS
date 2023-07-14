/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import negocio.encargadoLab;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_EncargadoLab {

    private encargadoLab e;
    private MS_SQLServer cnx;

    public BD_EncargadoLab() {
        e = null;
    }

    public BD_EncargadoLab(encargadoLab Eq) {
        this.e = Eq;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call  [Inventory].[GuardarEncargadoLab](?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, e.getIdLab());
        cnx.callState.setInt(2, e.getNoCarnet());
        cnx.callState.setString(3, e.getFechaEntrada());
        cnx.callState.setString(4, e.getFechaSalida());
        return cnx.callState.executeUpdate();
    }//Fin método

    public int actualizar(int idLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[ActualizarEncargadoLab](?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        
        cnx.callState.setInt(1, e.getIdLab());
        cnx.callState.setInt(2, e.getNoCarnet());
        cnx.callState.setString(3, e.getFechaEntrada());
        cnx.callState.setString(4, e.getFechaSalida());
        return cnx.callState.executeUpdate();
    }
}
