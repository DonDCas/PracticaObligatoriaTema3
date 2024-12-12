package models;

public class Producto {

    private int id = 0;
    private String nombre;
    private float pvp;
    private int stock;

    // Constructor

    public Producto(int id, String nombre, float pvp, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.pvp = pvp;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //Otros Metodos

}