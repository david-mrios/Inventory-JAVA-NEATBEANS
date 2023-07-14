/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_EquipoTecnologico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author David
 */
public class EquipoTecnologico extends Equipo {

    private String modelo;
    private int idMarca;
    private String serie;
    private String nombreMarca;
    private String nombreEstado;

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public EquipoTecnologico(int marca) {
        this.idMarca = marca;

    }

    // Constructo para el metodo agregarRegistro
    public EquipoTecnologico() {
        this.inss = 0;
        this.numeroArticulo = 0;
        this.codigo = "";
        this.etiqueta = "";
        this.cantidad = 0;
        this.descripcion = "";
        this.modelo = "";
        this.idMarca = 0;
        this.serie = "";
        this.costo = 0.00;
        this.idEstado = 0;
        this.observacion = "";

    }

    // Guardar
    public EquipoTecnologico(int inss, int numeroArt, String codigo, String etiqueta, int cantidad,
            String descripcion, String modelo, int idMarca, String serie,
            double costo, int idEstado, String observacion) {
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.codigo = codigo;
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.idMarca = idMarca;
        this.serie = serie;
        this.costo = costo;
        this.idEstado = idEstado;
        this.observacion = observacion;
    }

    // Buscar 
    public EquipoTecnologico(String custodio, int inss, int numeroArt, String codigo, String etiqueta, int cantidad,
            String descripcion, String modelo, String marca, String serie,
            double costo, String Estado, String observacion, int activo) {
        this.Custodio = custodio;
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.codigo = codigo;
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.nombreMarca = marca;
        this.serie = serie;
        this.costo = costo;
        this.nombreEstado = Estado;
        this.observacion = observacion;
        this.activo = activo;

    }

    // actualizar
    public EquipoTecnologico(int inss, int numeroArt, int cantidad, String descripcion, String modelo, int idMarca, String serie,
            double costo, int idEstado, String obervacion, int activo) {
        this.inss = inss;
        this.numeroArticulo = numeroArt;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.idMarca = idMarca;
        this.serie = serie;
        this.costo = costo;
        this.idEstado = idEstado;
        this.observacion = obervacion;
        this.activo = activo;
    }

    public String getCustodio() {
        return Custodio;
    }

    public void setCustodio(String Custodio) {
        this.Custodio = Custodio;
    }

    public int getInss() {
        return inss;
    }

    public void setInss(int inss) {
        this.inss = inss;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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
        BD_EquipoTecnologico pa_bd = new BD_EquipoTecnologico(this);
        return pa_bd.guardar();
    }

    @Override
    public EquipoTecnologico LEER(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return (EquipoTecnologico) bdP.leer(numArt);
    }

    public EquipoTecnologico LeerTabla(String Etiqueta)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return (EquipoTecnologico) bdP.leerTabla(Etiqueta);
    }

    @Override
    public int actualizarRegistro(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.actualizar(numArt);
    }

    public boolean verificarEquipoRegistrado(int numArt) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico CU_bd = new BD_EquipoTecnologico();
        return CU_bd.verificarEquipoRegistrado(numArt);
    }

    @Override
    public int borrarRegistro(int numArt)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.borrar(numArt);
    }

    public List<String> Estado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.ObtenerEstado();

    }

    public List<String> Marca() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.ObtenerMarca();

    }

    public int BuscarIdEstado(String Estado) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.BuscarIDEstado(Estado);

    }

    public int BuscarIdMarca(String Marca) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.BuscarIDMarca(Marca);

    }

    public Object[] Listado() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.obtenerDatosEquipoTecnologico();
    }

    public Object[] EquipoMalosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.EquipoMalosList();
    }

    public Object[] EquipoBuenosList() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.EquipoBuenosList();
    }

    public Object[] EquiposInactivo() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.EquiposInactivo();
    }

    public float porcentajeEquiposBuenos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.porcentajeEquiposBuenos();

    }

    public float porcentajeEquiposMalos() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException {
        BD_EquipoTecnologico bdP = new BD_EquipoTecnologico(this);
        return bdP.porcentajeEquiposMalos();

    }
}
