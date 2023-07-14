/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_Inventario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public class Inventario {

    private int NumInventario;
    private int ResponsableInss;
    private int CustodioInss;
    private String Responsable;
    private String Custodio;

    private String FechaIngreso;

    public Inventario() {
        this.NumInventario = 0;
        this.ResponsableInss = 0;
        this.CustodioInss = 0;
        this.Responsable = "";
        this.Custodio = "";
    }

    public Inventario(int NumInventario, int ResponsableInss, int CustodioInss, String fechaIngreso) {
        this.NumInventario = NumInventario;
        this.ResponsableInss = ResponsableInss;
        this.CustodioInss = CustodioInss;
        this.FechaIngreso= fechaIngreso;
    }

    public Inventario(int NumInventario, String Responsable, String Custodio, String FechaIngreso) {
        this.NumInventario = NumInventario;
        this.Responsable = Responsable;
        this.Custodio = Custodio;
        this.FechaIngreso = FechaIngreso;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public String getCustodio() {
        return Custodio;
    }

    public void setCustodio(String Custodio) {
        this.Custodio = Custodio;
    }

    public int getNumInventario() {
        return NumInventario;
    }

    public void setNumInventario(int NumInventario) {
        this.NumInventario = NumInventario;
    }

    public int getResponsableInss() {
        return ResponsableInss;
    }

    public void setResponsableInss(int ResponsableInss) {
        this.ResponsableInss = ResponsableInss;
    }

    public int getCustodioInss() {
        return CustodioInss;
    }

    public void setCustodioInss(int CustodioInss) {
        this.CustodioInss = CustodioInss;
    }

  
    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int guardar() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario obb = new BD_Inventario(this);
        return obb.guardar();

    }

    public boolean verificarEquipoRegistrado(int numInv) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario CU_bd = new BD_Inventario();
        return CU_bd.verificarEquipoRegistrado(numInv);
    }

    public int getNoInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.getNoInventario();

    }

    public List<String> obtenerFacultad() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.ObtenerFacultad();

    }

    public List<String> obtenerDepartamento() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.ObtenerDependencia();

    }

    public List<String> obtenerRecinto() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.ObtenerRecinto();

    }

    public Object[] CantEquipoInventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.CantEquipoTecInventario();
    }

    public Object[] obtenerDatosEquipoTecnologicosInv(int NumInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.obtenerDatosEquipoTecnologicosInv(NumInventario);
    }

    public Inventario LEER(int NumInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return (Inventario) bdP.leer(NumInventario);
    }

    public Object[] CantEquipoIMobnventario() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.CantEquipoMobInventario();
    }

    public Object[] obtenerDatosEquipoMobiliarioInv(int NumInventario) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.obtenerDatosEquipoMobiliarioInv(NumInventario);
    }
    
       public Object[] InventarioAll() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_Inventario bdP = new BD_Inventario(this);
        return bdP.InventarioAll();
    }

}
