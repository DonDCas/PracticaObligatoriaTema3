package models;

public class Admin {
    //Atributos
    private String user;
    private String clave;
    private String tipo;
    private Pedido pedido1;
    private Pedido pedido2;
    private Pedido pedido3;
    private Pedido pedido4;
    private Pedido pedido5;
    private Pedido pedido6;

    //Constructor


    public Admin(String user, String clave) {
        this.user = user;
        this.clave = clave;
        this.tipo = "Admin";
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Otros Metodos
    public void asignarPedidoAdmin(Pedido pedidoNuevo) {
    if (pedido1 == null ) pedido1 = pedidoNuevo;
    else if (pedido2 == null) pedido2 = pedidoNuevo;
        else if (pedido3 == null) pedido3 = pedidoNuevo;
            else if (pedido4 == null) pedido4 = pedidoNuevo;
                else if (pedido5 == null) pedido5 = pedidoNuevo;
                    else if (pedido6 == null) pedido6 = pedidoNuevo;
    }

}
