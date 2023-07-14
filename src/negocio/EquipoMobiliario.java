/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_EquipoMobiliario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public class EquipoMobiliario extends Equipo {

    private String nombreEstado;

    public EquipoMobiliario() {
        this.inss = 0;
        this.Custodio = "";
        this.numeroArticulo = 0;
        this.etiqueta = "";
        this.codigo = "";
        this.cantidad = 0;
        this.descripcion = "";
        this.costo = 0.00;
        this.idEstado = 0;
        this.observacion = "";
    }

    public EquipoMobiliario(int idEstado) {
        this.idEstado = idEstado;
    }

    // Guardar
    public EquipoMobiliario(int inss, int numeroArt, String etiqueta, String codigo, int cantidad,
            String descripcion, double costo, int idEstado, String observacion) {
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.etiqueta = etiqueta;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.costo = costo;
        this.idEstado = idEstado;
        this.observacion = observacion;
    }

    // Buscar 
    public EquipoMobiliario(String custodio, int inss, int numeroArt, String etiqueta, String codigo, int cantidad,
            String descripcion, double costo, String Estado, String observacion, int activo) {
        this.Custodio = custodio;
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.numeroArticulo = numeroArt;
        this.codigo = codigo;
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.costo = costo;
        this.nombreEstado = Estado;
        this.observacion = observacion;
        this.activo = activo;
    }

    public int getInss() {
        return inss;
    }

    public void setInss(int inss) {
        this.inss = inss;
    }

    public String getCustodio() {
        return Custodio;
    }

    // actualizar
    public EquipoMobiliario(int inss, int numeroArt, int cantidad, String descripcion,
             double costo, int idEstado, String obervacion, int activo) {
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.costo = costo;
        this.idEstado = idEstado;
        this.observacion = obervacion;
        this.activo = activo;

    }

    public void setCustodio(String Custodio) {
        this.Custodio = Custodio;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(int numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public int agregarRegistro()
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario pa_bd = new BD_EquipoMobiliario(this);
        return pa_bd.guardar();
    }

    @Override
    public EquipoMobiliario LEER(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return (EquipoMobiliario) bdP.leer(numArt);
    }
      public EquipoMobiliario LeerTabla(String etiqueta)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return (EquipoMobiliario) bdP.leerTabla(etiqueta);
    }

    @Override
    public int actualizarRegistro(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.actualizar(numArt);
    }

    public boolean verificarEquipoRegistrado(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario CU_bd = new BD_EquipoMobiliario();
        return CU_bd.verificarEquipoRegistrado(numArt);
    }

    @Override
    public int borrarRegistro(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.borrar(numArt);
    }

    public List<String> Estado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.ObtenerEstado();
    }

    public int BuscarIdEstado(String Estado) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.BuscarIDEstado(Estado);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.obtenerDatosEquipoMobiliario();
    }

    public Object[] EquipoMalosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.EquipoMalosList();
    }

    public Object[] EquipoBuenosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.EquipoBuenosList();
    }

    public Object[] EquiposInactivo() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoMobiliario bdP = new BD_EquipoMobiliario(this);
        return bdP.EquiposInactivo();
    }

}
