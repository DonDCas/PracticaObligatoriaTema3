package models;

public class Admin {
    //Atributos
    private String user;
    private String clave;
    private String tipo;

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
}
