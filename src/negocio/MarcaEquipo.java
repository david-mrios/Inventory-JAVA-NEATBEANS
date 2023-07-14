/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;
import datos.BD_MarcaEquipo;
import java.sql.SQLException;
/**
 *
 * @author David
 */
public class MarcaEquipo {
    private String marca;

    public MarcaEquipo() {
        this.marca= "";
    }

    public MarcaEquipo(String marca) {
        this.marca = marca;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
      public int agregarRegistro() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_MarcaEquipo pa_bd = new BD_MarcaEquipo(this);
        return pa_bd.guardar();
    }
            
       public int borrarRegistro(String marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_MarcaEquipo bdP = new BD_MarcaEquipo(this);
        return bdP.borrar(marca);

    }
         public boolean verificarMarca(String marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_MarcaEquipo CU_bd = new BD_MarcaEquipo();
        return CU_bd.verificarMarca(marca);
    }
}
