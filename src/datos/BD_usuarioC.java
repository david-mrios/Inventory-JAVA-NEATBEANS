/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.usuario_c;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_usuarioC {

    private usuario_c cu;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_usuarioC() {
        cu = null;
    }

    public BD_usuarioC(usuario_c cu) {
        this.cu = cu;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[GuardarContraseniaCus](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, cu.getContrasenia());
        cnx.callState.setInt(2, cu.getInss());

        return cnx.callState.executeUpdate();
    }//Fin método

    public usuario_c leer(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        usuario_c p = null;
        String sql = "select * from  [Inventory].[CustodioBuscarContraseñaView]\n"
                + "		 where inss = ?";// + inss;

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, inss);
        cnx.resultado = cnx.pst.executeQuery();

        if (cnx.resultado.next()) {

            p = new usuario_c(
                    cnx.resultado.getString("contrasenia"),
                    cnx.resultado.getInt("inss")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }

    public int actualizar(int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[ActualizarContraseniaCus](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, cu.getContrasenia());
        cnx.callState.setInt(2, inss);

        return cnx.callState.executeUpdate();
    }

  

    public usuario_c verificarPerfil(String contrasenia, int inss) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        usuario_c p = null;
        String procedureCall = "{call [Inventory].[LoginCustodio](?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, contrasenia);
        cnx.callState.setInt(2, inss);
        cnx.callState.execute();

        cnx.resultado = cnx.callState.getResultSet();
        if (cnx.resultado.next()) {
            int count = cnx.resultado.getInt("Count");
            if (count > 0) {
                p = new usuario_c(
                        cnx.resultado.getString("Nombre")
                );
            }
        }
        cnx.resultado.close();

        return p;
    }

}
