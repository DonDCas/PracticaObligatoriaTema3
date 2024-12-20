package models;

import java.time.LocalDate;

public class Pedido {

    private static int cantPedidos = 0;
    private int id;
    private String estado;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaEstimada;
    private String comentario;
    private float precioTotal;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;

    //Constructor


    public Pedido(int id, String estado, LocalDate fechaPedido, LocalDate fechaEntregaEstimada, String comentario, float precioTotal) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaEntregaEstimada = fechaEntregaEstimada;
        this.comentario = comentario;
        this.precioTotal = precioTotal;
        this.producto1 = null;
        this.producto2 = null;
        this.producto3 = null;
    }

    public Pedido(Producto producto){
        cantPedidos++;
        this.id = cantPedidos;
        this.estado = "En Preparación";
        this.fechaPedido = LocalDate.now();
        this.fechaEntregaEstimada = fechaPedido.plusDays(5);
        this.comentario = "";
        this.precioTotal = producto.getPvp();
        this.producto1 = producto;
        this.producto2 = null;
        this.producto3 = null;
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

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDate fechaEntregaEstimada) {
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


    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", fechaPedido=" + fechaPedido +
                ", fechaEntregaEstimada=" + fechaEntregaEstimada +
                ", comentario='" + comentario + '\'' +
                ", precioTotal=" + precioTotal +
                ", producto1=" + producto1 +
                ", producto2=" + producto2 +
                ", producto3=" + producto3 +
                '}';
    }

    public boolean incluirProducto(Producto producto) {
        if (producto1 == null){
            producto1 = producto;
            return true;
        }
        if (producto2 == null){
            producto2 = producto;
            return true;
        }
        if (producto3 == null){
            producto3 = producto;
            return true;
        }
        return false;
    }
}
