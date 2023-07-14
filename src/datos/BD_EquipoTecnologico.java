/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.EquipoTecnologico;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_EquipoTecnologico {

    private EquipoTecnologico Eq;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_EquipoTecnologico() {
        Eq = null;
    }

    public BD_EquipoTecnologico(EquipoTecnologico Eq) {
        this.Eq = Eq;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[InsertarEquipoTecnologico]("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getInss());
        cnx.callState.setInt(2, Eq.getNumeroArticulo());
        cnx.callState.setString(3, Eq.getCodigo());
        cnx.callState.setString(4, Eq.getEtiqueta());
        cnx.callState.setInt(5, Eq.getCantidad());
        cnx.callState.setString(6, Eq.getDescripcion());
        cnx.callState.setString(7, Eq.getModelo());
        cnx.callState.setInt(8, Eq.getIdMarca());
        cnx.callState.setString(9, Eq.getSerie());
        cnx.callState.setDouble(10, Eq.getCosto());
        cnx.callState.setInt(11, Eq.getIdEstado());
        cnx.callState.setString(12, Eq.getObservacion());
        cnx.callState.setInt(13, 1); // Indica que el registro está activo

        return cnx.callState.executeUpdate();
    }

    public EquipoTecnologico leer(int numeroArticulo) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        EquipoTecnologico p = null;
        String sql = "SELECT *\n"
                + "FROM [Inventory].[BuscarEquipoTecnologicoView]\n"
                + "WHERE numeroArt = ?;";// 
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, numeroArticulo);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new EquipoTecnologico(
                    cnx.resultado.getString("nombres"),
                    cnx.resultado.getInt("inss"),
                    cnx.resultado.getInt("numeroArt"),
                    cnx.resultado.getString("codigo"),
                    cnx.resultado.getString("etiqueta"),
                    cnx.resultado.getInt("cantidad"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getString("modelo"),
                    cnx.resultado.getString("marca"),
                    cnx.resultado.getString("serie"),
                    cnx.resultado.getDouble("costo"),
                    cnx.resultado.getString("estado"),
                    cnx.resultado.getString("observacion"),
                    cnx.resultado.getInt("activo")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }//Fin de método

    public int actualizar(int numeroArt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ActualizarEquipo](?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, Eq.getInss());
        cnx.callState.setInt(2, Eq.getCantidad());
        cnx.callState.setString(3, Eq.getDescripcion());
        cnx.callState.setString(4, Eq.getModelo());
        cnx.callState.setInt(5, Eq.getIdMarca());
        cnx.callState.setString(6, Eq.getSerie());
        cnx.callState.setDouble(7, Eq.getCosto());
        cnx.callState.setInt(8, Eq.getIdEstado());
        cnx.callState.setString(9, Eq.getObservacion());
        cnx.callState.setInt(10, Eq.getActivo());
        cnx.callState.setInt(11, numeroArt);

        return cnx.callState.executeUpdate();
    }

    public boolean verificarEquipoRegistrado(int numeroArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String functionCall = "{? = call  [Inventory].[VerificarEquipoTecnologico](?)}";

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
        String procedureCall = "{call [Inventory].[Borrar Equipo](?,?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numeroArt);
        cnx.callState.setInt(2, Eq.getActivo());

        return cnx.callState.executeUpdate();
    }

    // List para llenar el combo box
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

    public List<String> ObtenerMarca() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> marcas = new ArrayList<>();
        String sql = "select * from [Inventory].[MarcaView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String marca = cnx.resultado.getString("marca");
            marcas.add(marca);
        }
        return marcas;
    }

    // Buscar id del cargo atraves del cargo que sea seleccionado
    public int BuscarIDMarca(String Marca) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int MarcaID = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdMarca](?)}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setString(2, Marca);
        cnx.callState.execute();

        MarcaID = cnx.callState.getInt(1);
        return MarcaID;
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

    public Object[] obtenerDatosEquipoTecnologico() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        String procedureCall = "{call [Inventory].[ObtenerDatosEquipoTecnologico]}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.resultado = cnx.callState.executeQuery();
        cnx.rstm = cnx.resultado.getMetaData();
        int cantidadColumnas = cnx.rstm.getColumnCount();
        ArrayList<Object[]> filas = new ArrayList<>();

        while (cnx.resultado.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                String nombreColumna = cnx.rstm.getColumnName(i + 1);
                if (nombreColumna.equalsIgnoreCase("activo")) {
                    int valorActivo = cnx.resultado.getInt(i + 1);
                    fila[i] = (valorActivo == 1) ? "Activo" : "Inactivo";
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
        String sql = "SELECT * FROM [Inventory].[EquipoTecnologicoMalosView]";
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
        String sql = "SELECT * FROM [Inventory].[EquipoTecnologicoInactivosView];";
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
        String sql = "SELECT * FROM [Inventory].[EquipoTecnologicoBuenosView]";
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

    public EquipoTecnologico leerTabla(String etiqueta) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        EquipoTecnologico p = null;
        String sql = "SELECT *\n"
                + "FROM [Inventory].[BuscarEquipoTecnologicoView]\n"
                + "WHERE etiqueta = ?;";// 
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, etiqueta);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new EquipoTecnologico(
                    cnx.resultado.getString("nombres"),
                    cnx.resultado.getInt("inss"),
                    cnx.resultado.getInt("numeroArt"),
                    cnx.resultado.getString("codigo"),
                    cnx.resultado.getString("etiqueta"),
                    cnx.resultado.getInt("cantidad"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getString("modelo"),
                    cnx.resultado.getString("marca"),
                    cnx.resultado.getString("serie"),
                    cnx.resultado.getDouble("costo"),
                    cnx.resultado.getString("estado"),
                    cnx.resultado.getString("observacion"),
                    cnx.resultado.getInt("activo")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }//Fin de método

    public Object[] ReporteEquipo(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "SELECT *\n"
                + "FROM [Inventory].[BuscarEquipoTecnologicoView]\n"
                + "WHERE nummeroArt = ?;";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, numArt);
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

    public float porcentajeEquiposBuenos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        float porcentaje = -1;
        String functionCall = "{? = CALL [Inventory].[CalcularPorcentajeEquiposBuenos]()}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.FLOAT);
        cnx.callState.execute();

        porcentaje = cnx.callState.getFloat(1);
        return porcentaje;
    }

    public float porcentajeEquiposMalos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        float porcentaje = -1;
        String functionCall = "{? = CALL [Inventory].[CalcularPorcentajeEquiposMalos]()}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.FLOAT);
        cnx.callState.execute();

        porcentaje = cnx.callState.getFloat(1);
        return porcentaje;
    }

}
