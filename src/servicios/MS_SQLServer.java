/*
 * Descripción: Esta clase permite llevar a cabo la conexión JDBC hacia un 
 *              motor de bases de datos SQL Server. Es una subclase que hereda
 *              de la superclase Conexion.
 */
package servicios;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Lawdee Norman Narváez B.
 * @version 1.0.0
 * @since JDK 17.0.4
 */
public class MS_SQLServer extends Conexion {
/* ****************************************************************************
 *                 Variable de Instancia                                      *
/* ****************************************************************************/
    //private final int puerto; //Puerto especifico para la conexión en el SGBD
    private final boolean isCertificate; //Verificación de certificado de SQL
    private final boolean isEncrypt; //Cifrar la información a procesar
    private final boolean isSecurity; //Conexión por Autenticación Windows
    /* ****************************************************************************
 *                 Constructor para nuevas instancias                         *
/* ****************************************************************************/    
    public MS_SQLServer  () throws ClassNotFoundException,
                                   InstantiationException,
                                   IllegalAccessException,
                                   SQLException
    {
      super (); //Invocar al constructor de la clase padre
      //puerto = 1433; //Puerto por default del SGBD SQL Server
      isCertificate = true; //Indicar que se use el certificado de SQL Server
      isEncrypt = true;  //Indicar que los datos se deben cifrar
      isSecurity = true; //Permitir conexión en SQL Server por Autenticación Win
      this.initdb (); //Método inicializador de la conexión
    }//Fin constructor
    
/* ****************************************************************************
 *        Método de Inicialización de las propiedades de instancia            *
/* ****************************************************************************/
    @Override
    public void initdb () throws ClassNotFoundException,
                                 InstantiationException,
                                 IllegalAccessException,
                                 SQLException
    {
        //jdbc + host + ":" + puerto  + ";" + "databaseName=" + database +
        super.initdb(); //Invocar al método original para inicializar la cadena
        s_conexion +=";trustServerCertificate=" + isCertificate + ";encrypt=" 
                   + isEncrypt + ";integratedSecurity=" + isSecurity;
        //Instancia anonima para conexión
        Class.forName(driver);
        conexion = DriverManager.getConnection(s_conexion);      
    }//Fin método
}//Fin de la clase