package models;

import data.AdminData;

public class Usuario {
    private Cliente cliente1;
    private Cliente cliente2;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Admin admin;
    
    public Usuario(){
        cliente1 = null;
        cliente2 = null;
        trabajador1 = null;
        trabajador2 = null;
        admin = AdminData.admin();
    }


    //Otros Metodos

    public boolean login(String user, String clave) {
        if ((admin != null) && admin.getUser().equals(user)&& admin.getClave().equals(clave)) return true;
        if ((cliente1 != null) && cliente1.getUser().equals(user)&&cliente1.getClave().equals(clave)) return true;
        return false;
    }

    public boolean cerrar() {
        return false;
    }
}
