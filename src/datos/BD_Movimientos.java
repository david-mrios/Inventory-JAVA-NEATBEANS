/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Movimiento;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_Movimientos {

    private Movimiento M;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_Movimientos() {
        M = null;
    }

    public BD_Movimientos(Movimiento M) {
        this.M = M;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call  [Inventory].[GuardarMovimientos](?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, M.getNoMovimiento());
        cnx.callState.setInt(2, M.getResponsableInss());
        cnx.callState.setInt(3, M.getIdLab());
        cnx.callState.setInt(4, M.getIdTipoMovimiento());
        cnx.callState.setString(5, M.getFechaIngreso());
        cnx.callState.setString(6, M.getLocacionNueva());
        cnx.callState.setString(7, M.getObservacion());

        return cnx.callState.executeUpdate();
    }//Fin método

    public int BuscarIDTipoMov(String Movimiento) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int tpMovID = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdTipoMovimient](?)}";
        cnx = new MS_SQLServer();

        // Procesar la ejecución de la llamada a la función en la base de datos
        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setString(2, Movimiento);
        cnx.callState.execute();
        // Obtener el valor del parámetro de salida
        tpMovID = cnx.callState.getInt(1);
        return tpMovID;
    }

    public int BuscarIDLab(String lab) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        int idlab = -1;
        String functionCall = "{? = CALL [Inventory].[ObtenerIdLab](?)}";
        cnx = new MS_SQLServer();

        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setString(2, lab);
        cnx.callState.execute();

        idlab = cnx.callState.getInt(1);
        return idlab;
    }

    public List<String> ObtenerTipoMovimiento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> estados = new ArrayList<>();
        String sql = "Select * from [Inventory].[TipoMovimientoView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String Movimiento = cnx.resultado.getString("tipoMovimiento");
            estados.add(Movimiento);
        }
        return estados;
    }

    public int noMovimiento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        int count = -1;
        String sql = "select * from Inventory.MovimientosView";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();
        if (cnx.resultado.next()) {
            count = cnx.resultado.getInt(1);
        }

        return count;
    }

    public Movimiento leerEquipoTecnologico(int numeroArticulo) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Movimiento p = null;
        String procedureCall = "{call [Inventory].[EquipoTecnologicoAsignados](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numeroArticulo);
        cnx.resultado = cnx.callState.executeQuery();

        if (cnx.resultado.next()) {

            p = new Movimiento(
                    cnx.resultado.getInt("numeroArt"),
                    cnx.resultado.getString("numeroLab")
            );
        }
        // Fin de la instrucción if
        return p; // Retornar el objeto con los valores encontrados
    }

    public Movimiento leerEquipoMobiliario(int numeroArticulo) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Movimiento p = null;
        String procedureCall = "{call [Inventory].[EquipoMobiliarioAsignados](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numeroArticulo);
        cnx.resultado = cnx.callState.executeQuery();

        if (cnx.resultado.next()) {

            p = new Movimiento(
                    cnx.resultado.getInt("numeroArticulo"),
                    cnx.resultado.getString("numeroLab")
            );
        }

        return p; // Retornar el objeto con los valores encontrados
    }

    public Object[] ListarMovimientosTec() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ListarMovimientosTec]}";
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

    public Object[] ListarMovimientosEquipoTec(int numArticulo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ListarMovimientosEquipoTec](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numArticulo);
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

    public Movimiento leerMovimiento(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Movimiento p = null;
        String sql = "select * from  [Inventory].[MovimientoBuscarEqTecView]\n"
                + "		 where noMovimiento = ?";// + inss;

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, noMovimiento);
        cnx.resultado = cnx.pst.executeQuery();

        if (cnx.resultado.next()) {
            p = new Movimiento(
                    cnx.resultado.getInt("noMovimiento"),
                    cnx.resultado.getString("Responsable"),
                    cnx.resultado.getString("numeroLab"),
                    cnx.resultado.getString("LocacionNueva"),
                    cnx.resultado.getString("tipoMovimiento"),
                    cnx.resultado.getInt("numeroArt"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getString("Observacion"),
                    cnx.resultado.getString("Fecha")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }

    public Object[] ListarMovimientosMob() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ListarMovimientosMob]}";
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

        return filasArray; // Retorna el arreglo de filas.
    }

    public Object[] ListarMovimientosEquipoMob(int numArticulo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[ListarMovimientosEquipoMob](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numArticulo);
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

    public Movimiento leerMovimientoMob(int noMovimiento) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Movimiento p = null;
        String sql = "select * from  [Inventory].[MovimientoBuscarEqMobView]\n"
                + "		 where noMovimiento = ?";// + inss;

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, noMovimiento);
        cnx.resultado = cnx.pst.executeQuery();

        if (cnx.resultado.next()) {

            p = new Movimiento(
                    cnx.resultado.getInt("noMovimiento"),
                    cnx.resultado.getString("Responsable"),
                    cnx.resultado.getString("numeroLab"),
                    cnx.resultado.getString("LocacionNueva"),
                    cnx.resultado.getString("tipoMovimiento"),
                    cnx.resultado.getInt("numeroArticulo"),
                    cnx.resultado.getString("descripcion"),
                    cnx.resultado.getString("Observacion"),
                    cnx.resultado.getString("Fecha")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }
}
