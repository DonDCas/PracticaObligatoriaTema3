package models;

import java.util.Date;

public class Pedido {

    private int id;
    private String estado;
    private Date fechaPedido;
    private Date fechaEntregaEstimada;
    private String comentario;
    private float precioTotal;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;

    //Constructor


    public Pedido(int id, String estado, Date fechaPedido, Date fechaEntregaEstimada, String comentario, float precioTotal) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.comentario = comentario;
        this.precioTotal = precioTotal;
    }

    //Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    //Otros Metodos

}
