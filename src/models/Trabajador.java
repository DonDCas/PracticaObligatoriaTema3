package models;

public class Trabajador {
    //Atributos
    private String nombre;
    private String clave;
    private String correo;
    private String direccion;
    private String localidad;
    private String provincia;
    private String telefono;
    private String tipoUser;
    private Pedido pedido1;
    private Pedido pedido2;

    //Constructor


    public Trabajador(String nombre, String clave, String correo, String direccion,
                      String localidad, String provincia, String telefono){
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.tipoUser = "Trabajador";
        this.pedido1 = null;
        this.pedido2 = null;
    }

    //Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
