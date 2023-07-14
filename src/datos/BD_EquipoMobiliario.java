/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.EquipoMobiliario;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_EquipoMobiliario {

    private EquipoMobiliario Eq;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_EquipoMobiliario() {
        Eq = null;
    }

    public BD_EquipoMobiliario(EquipoMobiliario Eq) {
        this.Eq = Eq;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[InsertarEquipoMobiliario]("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getInss());
        cnx.callState.setInt(2, Eq.getNumeroArticulo());
        cnx.callState.setString(3, Eq.getCodigo());
        cnx.callState.setString(4, Eq.getEtiqueta());
        cnx.callState.setInt(5, Eq.getCantidad());
        cnx.callState.setString(6, Eq.getDescripcion());
        cnx.callState.setDouble(7, Eq.getCosto());
        cnx.callState.setInt(8, Eq.getIdEstado());
        cnx.callState.setString(9, Eq.getObservacion());
        cnx.callState.setInt(10, 1); // Indica que el registro está activo

        return cnx.callState.executeUpdate();
    }

    public EquipoMobiliario leer(int numeroArticulo) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        EquipoMobiliario p = null;
        String sql = "SELECT *\n"
                + "FROM [Inventory].[BuscarEquipoMobiliarioView]\n"
                + "WHERE numeroArticulo = ?;";// 
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, numeroArticulo);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new EquipoMobiliario(
                    cnx.resultado.getString("nombres"),
                    cnx.resultado.getInt("inss"),
                    cnx.resultado.getInt("numeroArticulo"),
                    cnx.resultado.getString("codigo"),
                    cnx.resultado.getString("etiqueta"),
                    cnx.resultado.getInt("cantidad"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getDouble("costo"),
                    cnx.resultado.getString("estado"),
                    cnx.resultado.getString("observacion"),
                    cnx.resultado.getInt("activo")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }//Fin de método

    public int actualizar(int numeroArt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ActualizarEquipoMobiliario](?, ?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getInss());
        cnx.callState.setInt(2, Eq.getCantidad());
        cnx.callState.setString(3, Eq.getDescripcion());
        cnx.callState.setDouble(4, Eq.getCosto());
        cnx.callState.setInt(5, Eq.getIdEstado());
        cnx.callState.setString(6, Eq.getObservacion());
        cnx.callState.setInt(7, Eq.getActivo());
        cnx.callState.setInt(8, numeroArt);

        return cnx.callState.executeUpdate();
    }

    public boolean verificarEquipoRegistrado(int numeroArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String functionCall = "{? = call  [Inventory].[VerificarEquipoMobiliario](?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setInt(2, numeroArt);
        cnx.callState.execute();
        int count = cnx.callState.getInt(1);
        return count > 0;
    }

    public int borrar(int numeroArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[BorrarEquipoMobiliario](?,?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numeroArt);
        cnx.callState.setInt(2, Eq.getActivo());

        return cnx.callState.executeUpdate();
    }

    public List<String> ObtenerEstado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> estados = new ArrayList<>();
        String sql = "Select * from [Inventory].[EstadoView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String estado = cnx.resultado.getString("estado");
            estados.add(estado);
        }
        return estados;
    }

    public int BuscarIDEstado(String Estado) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int EstadoID = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdEstado](?)}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setString(2, Estado);
        cnx.callState.execute();

        EstadoID = cnx.callState.getInt(1);

        return EstadoID;
    }

    public Object[] obtenerDatosEquipoMobiliario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        String procedureCall = "{call [Inventory].[ObtenerDatosEquipoMobiliario]}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.resultado = cnx.callState.executeQuery();
        cnx.rstm = cnx.resultado.getMetaData();
        int cantidadColumnas = cnx.rstm.getColumnCount();
        ArrayList<Object[]> filas = new ArrayList<>();

        while (cnx.resultado.next()) {
            Object[] fila = new Object[cantidadColumnas];//arreglo de objetos para almacenar los valores de cada fila
            for (int i = 0; i < cantidadColumnas; i++) {
                String nombreColumna = cnx.rstm.getColumnName(i + 1);
                if (nombreColumna.equalsIgnoreCase("activo")) {
                    int valorActivo = cnx.resultado.getInt(i + 1);
                    fila[i] = (valorActivo == 1) ? "Activo" : "Inactivo";//asigna "Activo" o "Inactivo" según el valor obtenido.
                } else {
                    fila[i] = cnx.resultado.getObject(i + 1);
                }
            }
            filas.add(fila);
        }

        Object[] filasArray = filas.toArray(new Object[0]);

        return filasArray;
    }

    public Object[] EquipoMalosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "SELECT * FROM [Inventory].[EquipoMobiliarioMalosView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();
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

    public Object[] EquiposInactivo() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "SELECT * FROM [Inventory].[EquipoMobiliarioInactivoView];";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();
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

    public Object[] EquipoBuenosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "SELECT * FROM [Inventory].[EquipoMobiliarioBuenosView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();
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

    public EquipoMobiliario leerTabla(String etiqueta) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        EquipoMobiliario p = null;
        String sql = "SELECT *\n"
                + "FROM [Inventory].[BuscarEquipoMobiliarioView]\n"
                + "WHERE etiqueta = ?;";// 
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, etiqueta);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new EquipoMobiliario(
                    cnx.resultado.getString("nombres"),
                    cnx.resultado.getInt("inss"),
                    cnx.resultado.getInt("numeroArticulo"),
                    cnx.resultado.getString("codigo"),
                    cnx.resultado.getString("etiqueta"),
                    cnx.resultado.getInt("cantidad"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getDouble("costo"),
                    cnx.resultado.getString("estado"),
                    cnx.resultado.getString("observacion"),
                    cnx.resultado.getInt("activo")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }//Fin de método

}
