/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Laboratorio;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_Laboratorio {

    private Laboratorio L;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_Laboratorio() {
        L = null;
    }

    public BD_Laboratorio(Laboratorio L) {
        this.L = L;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[GuardarLaboratorio]("
                + "?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, L.getNumeroLab());
        cnx.callState.setInt(2, 1); // Indica que el registro está activo

        return cnx.callState.executeUpdate();
    }

    public int Actualizar(String numLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[EstadoLaboratorio](?,?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, numLab);
        cnx.callState.setInt(2, L.getEstado());

        return cnx.callState.executeUpdate();
    }

    public List<String> ObtenerLaboratorio() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> laboratorios = new ArrayList<>();
        String sql = "Select * from [Inventory].[LaboratorioView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String laboratorio = cnx.resultado.getString("numeroLab");
            laboratorios.add(laboratorio);
        }
        return laboratorios;
    }

    public int borrar(String numLab) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call [Inventory].[BorrarLaboratorio](?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setString(1, numLab);
        return cnx.callState.executeUpdate();
    }

    public Laboratorio EncargadosView(String laboratorio) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Laboratorio p = null;
        String sql = "select * from  [Inventory].[EncargadosView]\n"
                + "		 where numeroLab = ?";// + inss;

        cnx = new MS_SQLServer();

        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setString(1, laboratorio);
        cnx.resultado = cnx.pst.executeQuery();

        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new Laboratorio(
                    cnx.resultado.getString("numeroLab"),
                    cnx.resultado.getString("Instructor"),
                    cnx.resultado.getString("fechaEntrada"),
                    cnx.resultado.getString("fechaSalida")
            );
        }//Fin de la instrucción if
        return p;
    }

    public Object[] EncargadosListar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[EncargadosListar]}";
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

    public Object[] LaboratorioEquipoTecView(int idLab) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[LaboratorioEquipoTecView](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, idLab);
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

    public Object[] LaboratorioEquipoMobView(int idLab) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[LaboratorioEquipoMobView](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, idLab);
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

}
