/*
 * Representa la generación de conexiones con el motor de base de datos, el 
 * propósito es mantener una sola conexión, de modo que se evite un uso 
 * indebido de los recursos de consultas al motor de base de datos
 * 
 */
package servicios;

import java.sql.SQLException;

/**
 *
 * @author Lawdee Norman Narváez Bello
 */
public class ServiceFactory {
 // Variable de instancia
      private Conexion cnn;
      private static ServiceFactory instancia;
      
      // Constreuctor
       public ServiceFactory () {      
    }
     // Método sincronizado
        public static synchronized ServiceFactory getInstancia () {
        //Determinar si no hay una instancia en uso
       return (instancia != null)?instancia:new ServiceFactory();     
    }
    
    public Conexion getConexion () throws ClassNotFoundException,
                                          InstantiationException,
                                          IllegalAccessException,
                                          SQLException
    {
        if (cnn == null) {
        //Tomar del archivo de configuración el nombre especifico de la clase
        // con la que se generará instancia de conexión
            String nombClass = System.getProperty("databaseclass");            
        }//Fin de condicional if
        //cnn = (Conexion) Class.forName(nombClass);
        return cnn;
    }
}//Fin de la clase
