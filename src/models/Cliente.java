package models;

public class Cliente {
    //Atributos

    private String user;
    private String clave;
    private String nombre;
    private String direccion;
    private String localidad;
    private String provincia;
    private int movil;
    private String correo;
    private String tipo;
    private Pedido pedido1;
    private Pedido pedido2;

    //Constructor


    public Cliente(String user, String clave, String nombre, String direccion,
                   String localidad, String provincia, int movil,
                   String correo) {
        this.user = user;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.movil = movil;
        this.correo = correo;
        this.tipo = "Cliente";
        this.pedido1 = null;
        this.pedido2 = null;
    }

    public Cliente(Cliente cliente) {
        this.user = cliente.getUser();
        this.clave = cliente.getClave();
        this.nombre = cliente.getNombre();
        this.direccion = cliente.getDireccion();
        this.localidad = cliente.getLocalidad();
        this.provincia = cliente.getProvincia();
        this.movil = cliente.movil;
        this.correo = cliente.getCorreo();
        this.tipo = cliente.getTipo();
        this.pedido1 = cliente.getPedido1();
        this.pedido2 = cliente.getPedido2();
    }

    //Getters y Setters


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }

    //Otros Metodos


}
