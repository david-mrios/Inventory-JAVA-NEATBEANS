/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.usuario_i;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_usuarioi {

    private usuario_i I;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_usuarioi() {
        I = null;
    }

    public BD_usuarioi(usuario_i I) {
        this.I = I;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[GuardarContraseniaIns](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, I.getContrasenia());
        cnx.callState.setInt(2, I.getNoCarnet());

        return cnx.callState.executeUpdate();
    }//Fin método

    public usuario_i leer(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        usuario_i p = null;
        String sql = "select * from  [Inventory].[InstructorBuscarContrasenaView]\n"
                + "		 where noCarnet = ?";// + noCarnet;

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, noCarnet);
        cnx.resultado = cnx.pst.executeQuery();

        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new usuario_i(
                    cnx.resultado.getString("contrasenia"),
                    cnx.resultado.getInt("noCarnet")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }

    public int actualizar(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[ActualizarContraseniaIns](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, I.getContrasenia());
        cnx.callState.setInt(2, noCarnet);

        return cnx.callState.executeUpdate();
    }

    public usuario_i verificarPerfil(String contrasenia, int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_i p = null;
        String procedureCall = "{call [Inventory].[LoginInstructor](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, contrasenia);
        cnx.callState.setInt(2, inss);
        cnx.callState.execute();

        cnx.resultado = cnx.callState.getResultSet();
        if (cnx.resultado.next()) {
            int count = cnx.resultado.getInt("Count");
            if (count > 0) {
                p = new usuario_i(
                        cnx.resultado.getString("Nombre")
                );
            }
        }
        cnx.resultado.close();

        return p;
    }

}
