/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import negocio.MarcaEquipo;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_MarcaEquipo {

    private MarcaEquipo M;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_MarcaEquipo() {
        M = null;
    }

    public BD_MarcaEquipo(MarcaEquipo M) {
        this.M = M;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        String sql;
        sql = "INSERT INTO MarcaEquipo (marca)";
        sql += "VALUES (?)";

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, M.getMarca());
        return cnx.pst.executeUpdate();
    }

    public int borrar(String marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql;
        sql = "Delete from MarcaEquipo where marca = ?";
        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, M.getMarca());
        return cnx.pst.executeUpdate();
    }//Fin método

    public boolean verificarMarca(String marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "SELECT COUNT(*) FROM MarcaEquipo WHERE marca = ?";

        cnx = new MS_SQLServer();
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, marca);
        cnx.resultado = cnx.pst.executeQuery();
        cnx.resultado.next();
        int count = cnx.resultado.getInt(1);
        return count > 0;
    }

}
