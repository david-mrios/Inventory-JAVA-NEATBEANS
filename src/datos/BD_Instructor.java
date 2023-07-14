/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Instructor;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_Instructor {

    private Instructor I;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_Instructor() {
        I = null;
    }

    public BD_Instructor(Instructor I) {
        this.I = I;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[Ingresar Instructor](?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, I.getNoCarnet());
        cnx.callState.setString(2, I.getNombres());
        cnx.callState.setString(3, I.getApellidos());
        cnx.callState.setInt(4, I.getTelefono());
        cnx.callState.setString(5, I.getCedula());
        cnx.callState.setInt(6, 1);

        return cnx.callState.executeUpdate();
    }//Fin método

    public Instructor leer(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Instructor p = null;
        String sql = "select * from  [Inventory].[InstructorBuscarView]\n"
                + "		 where noCarnet = ?";// + inss;
        //Preparar la conexión hacia el SGBD para obtener registros
        //cnx = ServiceFactory.getInstancia().getConexion();
        cnx = new MS_SQLServer();
        //Procesar la ejecución de la consulta en la base de datos 
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, noCarnet);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new Instructor(
                    cnx.resultado.getInt("noCarnet"),
                    cnx.resultado.getString("nombres"),
                    cnx.resultado.getString("apellidos"),
                    cnx.resultado.getInt("telefono"),
                    cnx.resultado.getString("cedula"),
                    cnx.resultado.getInt("activo")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }

    public int actualizar(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[Actualizar Instructor](?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, noCarnet);
        cnx.callState.setString(2, I.getNombres());
        cnx.callState.setString(3, I.getApellidos());
        cnx.callState.setInt(4, I.getTelefono());
        cnx.callState.setString(5, I.getCedula());
        cnx.callState.setInt(6, I.getActivo());

        return cnx.callState.executeUpdate();
    }

    public boolean verificarCarnetRegistrado(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String functionCall = "{? = call [Inventory].[VerificarnumCarnetRegistrado](?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setInt(2, noCarnet);
        cnx.callState.execute();

        int count = cnx.callState.getInt(1);
        return count > 0;
    }

    public int borrar(int noCarnet) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        cnx = new MS_SQLServer();
        String procedureCall = "{call  [Inventory].[BorradoLogicoInstructor](?, ?)}";
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, I.getActivo());
        cnx.callState.setInt(2, noCarnet);
        return cnx.callState.executeUpdate();
    }

    // List para llenar la tabla
    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[ObtenerInstructores]}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.resultado = cnx.callState.executeQuery();
        cnx.rstm = cnx.resultado.getMetaData();
        int cantidadColumnas = cnx.rstm.getColumnCount();
        ArrayList<Object[]> filas = new ArrayList<>();

        while (cnx.resultado.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i] = cnx.resultado.getObject(i + 1);
            }
            filas.add(fila);
        }

        Object[] filasArray = filas.toArray(new Object[0]);

        return filasArray;
    }

}
