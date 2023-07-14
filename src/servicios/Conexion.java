/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.CallableStatement;

/**
 *
 * @author lnarvaezb
 */
public class Conexion {
/* ****************************************************************************
 *    Variable de instancia para operar con la Base de Datos                  *
/* ****************************************************************************/
    
    public Connection conexion = null; //Tipo Connection con el motor de BD
    public PreparedStatement pst;      //Ejecutor de sentencia SQL
    public String s_conexion = null;   
    public ResultSet resultado = null ;//Resultados obtenidos de una consulta
    public ResultSetMetaData rstm = null;
    public CallableStatement  callState = null; 
/* ****************************************************************************
 *    Variable de instancia para operar con la Base de Datos                  *
/* ****************************************************************************/           
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected int puerto;
    protected String username;
    protected String password;
    protected String un_sql;
    protected String intSegurity;
    
/* ****************************************************************************
 *     Constructor de nuevas instancias                                       *
/* ****************************************************************************/  
    /**
     * Crea instancias de conexiÃ³n para cualquier tipo de gestor de base de 
     * datos
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException 
     */
    public Conexion() throws java.lang.ClassNotFoundException,
                             java.lang.InstantiationException,
                             java.lang.IllegalAccessException, 
                             java.sql.SQLException
    {
        jdbc =System.getProperty("jdbc");
        driver = System.getProperty("driver");
        host= System.getProperty("databasehost");
        database = System.getProperty("database");
        puerto = Integer.parseInt(System.getProperty("port"));
        username = System.getProperty("username");
        password = System.getProperty("password");
        intSegurity = System.getProperty("true");
    }//Fin del constructor
    
/* ****************************************************************************
 *              Método Inicializador de nuevas instancias                     *
/* ****************************************************************************/
    public void initdb () throws java.lang.ClassNotFoundException,
                                 java.lang.InstantiationException,
                                 java.lang.IllegalAccessException,
                                 java.sql.SQLException
    {
        s_conexion = jdbc + host + ":" + puerto + ";" + "databaseName=" 
                   + database;
    }//Fin metodo initdb
    
        /**
       *
       * Metodo que utliza para cargar el combobox desde la base de datos y 
       * de esa manera tambien buscar el id de las tablas
       * segun lo que se seleccion de los combo box
       */
        public ResultSet ejecutarConsulta(String consultaSQL) throws SQLException {
        pst = conexion.prepareStatement(consultaSQL);  // Preparar la sentencia SQL
        return pst.executeQuery(); // Ejecutar la consulta y obtener los resultados
    } // El parámetro "consultaSQL" es la consulta SQL que queremos ejecutar.

        
        
    
    
}//Fin de la clase
