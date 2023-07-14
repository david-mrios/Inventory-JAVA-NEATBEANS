/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.encargadoLab;

/**
 *
 * @author David
 */
public class CTr_EncargadoLab {
     public static int agregar (int idLab,int noCarnet, String fechaEntrada, 
                               String fechaSalida) 
                               throws ClassNotFoundException,
                                      InstantiationException,
                                      IllegalAccessException,
                                      SQLException
    
            
    {
       encargadoLab pa = new encargadoLab (idLab,noCarnet, fechaEntrada,
                                               fechaSalida);
       return pa.agregarRegistro(); 
    }
      
       public static int actualizar(int idLab,int noCarnet, String fechaEntrada, 
                               String fechaSalida) 
                                                   throws
                                                   ClassNotFoundException,
                                                   InstantiationException,
                                                   IllegalAccessException,
                                                   SQLException 
    {
        encargadoLab pa = new encargadoLab(idLab,noCarnet, fechaEntrada,
                                               fechaSalida);
        return pa.actualizarRegistro(idLab);
    }
}
