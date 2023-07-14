/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import negocio.detalle_invEqTec;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_detalleInvEqTec {

    private detalle_invEqTec D;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_detalleInvEqTec() {
        D = null;
    }

    public BD_detalleInvEqTec(detalle_invEqTec D) {
        this.D = D;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[AgregarDetalleInvEqTec](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, D.getIdEquipoTecnologico());
        cnx.callState.setInt(2, D.getIdInventario());

        return cnx.callState.executeUpdate();
    }//Fin método

    public int BuscarIDEquipo(int numArt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int EquipoID = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdEquipo](?)}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setInt(2, numArt);
        cnx.callState.execute();

        EquipoID = cnx.callState.getInt(1);
        return EquipoID;
    }

    public int BuscarIDInventario(int numInventario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int InventarioID = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdInventario](?)}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setInt(2, numInventario);
        cnx.callState.execute();

        InventarioID = cnx.callState.getInt(1);
        return InventarioID;
    }

}
