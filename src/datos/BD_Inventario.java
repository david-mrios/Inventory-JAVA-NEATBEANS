/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Inventario;
import servicios.MS_SQLServer;

/**
 *
 * @author David
 */
public class BD_Inventario {

    private Inventario I;
    private MS_SQLServer cnx = null; //Manejador de conexión

    public BD_Inventario() {
        I = null;
    }

    public BD_Inventario(Inventario I) {
        this.I = I;
    }//Fin constructor

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String procedureCall = "{call  [Inventory].[AgregarInventario](?, ?, ?, ?, ?, ?, ?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, I.getNumInventario());
        cnx.callState.setInt(2, 1);
        cnx.callState.setInt(3, 1);
        cnx.callState.setInt(4, 1);
        cnx.callState.setInt(5, I.getResponsableInss());
        cnx.callState.setInt(6, I.getCustodioInss());
        cnx.callState.setString(7, I.getFechaIngreso());

        return cnx.callState.executeUpdate();
    }//Fin método

    public Inventario leer(int numInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {

        Inventario p = null;
        String sql = "select * from  [Inventory].[InventarioBuscarView]\n"
                + "		 where NumInventario = ?";// + inss;
        //Preparar la conexión hacia el SGBD para obtener registros
        //cnx = ServiceFactory.getInstancia().getConexion();
        cnx = new MS_SQLServer();
        //Procesar la ejecución de la consulta en la base de datos 
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.pst.setInt(1, numInventario);
        cnx.resultado = cnx.pst.executeQuery();
        //Recorrer los resultados obtenidos en la consulta si los hay 
        if (cnx.resultado.next()) {
            //Recuperar los valores del registro y asignar al objeto p
            p = new Inventario(
                    cnx.resultado.getInt("NumInventario"),
                    cnx.resultado.getString("Responsable"),
                    cnx.resultado.getString("Custodio"),
                    cnx.resultado.getString("FechaIngreso")
            );
        }//Fin de la instrucción if
        return p;//Retornar el objeto con los valores encontrados
    }

    public boolean verificarEquipoRegistrado(int numrtoInven) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String functionCall = "{? = call  [Inventory].[VerificarInventario](?)}";

        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(functionCall);
        cnx.callState.registerOutParameter(1, java.sql.Types.INTEGER);
        cnx.callState.setInt(2, numrtoInven);
        cnx.callState.execute();
        int count = cnx.callState.getInt(1);
        return count > 0;
    }

    public int getNoInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        int count = -1;
        String sql = "select * from [Inventory].[InventariosView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();
        if (cnx.resultado.next()) {
            count = cnx.resultado.getInt(1);
        }

        return count;
    }

    public List<String> ObtenerFacultad() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> marcas = new ArrayList<>();
        String sql = "select * from [Inventory].[FacultadView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String marca = cnx.resultado.getString("Facultdad");
            marcas.add(marca);
        }
        return marcas;
    }

    public List<String> ObtenerDependencia() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> marcas = new ArrayList<>();
        String sql = "select * from [Inventory].[DependenciaView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String marca = cnx.resultado.getString("Departamento");
            marcas.add(marca);
        }
        return marcas;
    }

    public List<String> ObtenerRecinto() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        List<String> marcas = new ArrayList<>();
        String sql = "select * from [Inventory].[RecintoView]";
        cnx = new MS_SQLServer();
        cnx.pst = cnx.conexion.prepareStatement(sql);
        cnx.resultado = cnx.pst.executeQuery();

        while (cnx.resultado.next()) {
            String marca = cnx.resultado.getString("Recinto");
            marcas.add(marca);
        }
        return marcas;
    }

    public Object[] CantEquipoTecInventario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[InventarioCatEquiposTec]}";
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

    public Object[] obtenerDatosEquipoTecnologicosInv(int numInventario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[EquiposTecInventario](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numInventario);
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

    public Object[] CantEquipoMobInventario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[InventarioCatEquiposMob]}";
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

    public Object[] obtenerDatosEquipoMobiliarioInv(int numInventario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String procedureCall = "{call [Inventory].[EquiposMobInventario](?)}";
        cnx = new MS_SQLServer();
        cnx.callState = cnx.conexion.prepareCall(procedureCall);
        cnx.callState.setInt(1, numInventario);
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

    public Object[] InventarioAll() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        String sql = "select * from [Inventory].[InventariosALLView]";
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

}
