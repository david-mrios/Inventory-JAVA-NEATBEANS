/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import negocio.DetalleMovEqTec;

/**
 *
 * @author David
 */
public class CTr_DetalleMovEqTec {
    
      public static int agregar (int noMovimiento, int idEquipoTecnologico) 
                               throws ClassNotFoundException,
                                      InstantiationException,
                                      IllegalAccessException,
                                      SQLException
    
            
    {
       DetalleMovEqTec pa = new DetalleMovEqTec (noMovimiento,idEquipoTecnologico);
       return pa.agregarRegistro(); 
    }
}
