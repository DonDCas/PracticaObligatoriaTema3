package models;

public class Admin {
    //Atributos
    private String user;
    private String clave;

    //Constructor


    public Admin(String user, String clave) {
        this.user = user;
        this.clave = clave;
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

    // Otros Metodos
}
