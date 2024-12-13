package models;

import data.AdminData;

public class Tienda {
    private Cliente cliente1;
    private Cliente cliente2;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;
    private Admin admin;
    
    public Tienda(){
        cliente1 = null;
        cliente2 = null;
        trabajador1 = null;
        trabajador2 = null;
        trabajador3 = null;
        admin = AdminData.admin();
    }


    public void mock(){
        cliente1 = new Cliente("Carlos", "1234","Carlos Barroso","c\\SalSiPuedes, 7","Martos","Jaen",953605843,"carlos@prueba.es");
      //  cliente2 = new Cliente("Luca", "1234","Luca Rueda","c\\Jurado Sin Salida, 14","Castro del Rio","Córdoba",953605843,"Luca@prueba.es");
        trabajador1 = new Trabajador("Lolo","Lolo Rueda","Luca","loloruese@probado.es","c\\Calle del famoso,1","Castro del Rio", "Cordoba", 957370968);
        trabajador2 = new Trabajador("Edu","Edu Cruz","Jesus","Jesus@probado.es","c\\Arroyo del Moro,3","Martos", "Jaen", 953470988);
        trabajador3 = new Trabajador("Mire","Mireya Cueto","1234","Mireya@probado.es","Av. Virgen de las Angustias, S/N","Córdoba", "Córdoba", 957450488);
    }


    //Otros Metodos

    public String login(String user, String clave) {
        if ((admin != null) && admin.getUser().equals(user)&& admin.getClave().equals(clave)) return admin.getTipo();
        if ((cliente1 != null) && cliente1.getUser().equals(user)&&cliente1.getClave().equals(clave)) return cliente1.getTipo();
        if ((cliente2 != null) && cliente2.getUser().equals(user)&&cliente2.getClave().equals(clave)) return cliente2.getTipo();
        if ((trabajador1 != null) && trabajador1.getUser().equals(user) && trabajador1.getClave().equals(clave)) return trabajador1.getTipo();
        if ((trabajador2 != null) && trabajador2.getUser().equals(user) && trabajador2.getClave().equals(clave)) return trabajador2.getTipo();
        if ((trabajador3 != null) && trabajador3.getUser().equals(user) && trabajador3.getClave().equals(clave)) return trabajador3.getTipo();

        return "ERROR";
    }
    public String pintaNombreTrabajador(String user){
        if (trabajador1 != null && trabajador1.getUser().equals(user)) return trabajador1.getNombre();
        if (trabajador2 != null && trabajador2.getUser().equals(user)) return trabajador2.getNombre();
        if (trabajador3 != null && trabajador3.getUser().equals(user)) return trabajador3.getNombre();
        return "ERROR";
    }

    public String pintaNombreCliente(String user) {
        if (cliente1 != null && cliente1.getUser().equals(user)) return cliente1.getNombre();
        if (cliente2 != null && cliente2.getUser().equals(user)) return cliente2.getNombre();
        return "ERROR";
    }

    public static String pintaPedidosAdmin() {
        return "Caca de vaca";
    }

    public static String pintaPedidosTrabajador() {
        return "Caca";
    }

    public boolean cerrar() {
        return false;
    }

    public boolean registroCliente(String nombre, String direccion, String localidad, String provincia, String introTelefono, String introCorreo, String user, String clave) {
        if (introTelefono.length()!=9)return false;
        else{
            for (int i = 0; i < (introTelefono.length()-1); i++) {
                if(!Character.isDigit(introTelefono.charAt(i))) return false;
            }
        }
        int telefono = Integer.parseInt(introTelefono);
        if (!introCorreo.contains("@")) return false;
        if (cliente1 == null) {
            cliente1 = new Cliente(user, clave, nombre, direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        if (cliente2 == null) {
            cliente2 = new Cliente(user, clave, nombre, direccion, localidad, provincia, telefono, introCorreo);
            return true;
        }
        return false;
    }

    public String pintaDatosCliente(Tienda tienda, String user){
        String salida = "";
        Cliente clienteCopia = null;
        if(cliente1 != null && user.equals(cliente1.getUser())) clienteCopia = new Cliente(cliente1);
        if(cliente2 != null && user.equals(cliente2.getUser())) clienteCopia = new Cliente(cliente2);
        salida += "================== Datos Personales =================\n";
        salida += "\n";
        salida += "Nombre: " + clienteCopia.getNombre() + "\n";
        salida += "Dirección: " + clienteCopia.getDireccion() + "\n";
        salida += "localidad : " + clienteCopia.getLocalidad() + "\n";
        salida += "Provincia: " + clienteCopia.getProvincia() + "\n";
        salida += "telefono: " + clienteCopia.getMovil() + "\n";
        salida += "correo: " + clienteCopia.getCorreo() + "\n";
        salida += "====================================================\n";
        return salida;

    }

    public boolean modificarDatoCliente(Tienda tienda, int modificar, String datoNuevo, String user){
        if (cliente1 != null && user.equals(cliente1.getUser())){
            switch (modificar){
                case 1:
                    cliente1.setNombre(datoNuevo);
                    return true;
                case 2:
                    cliente1.setDireccion(datoNuevo);
                    return true;
                case 3:
                    cliente1.setLocalidad(datoNuevo);
                    return true;
                case 4:
                    cliente1.setProvincia(datoNuevo);
                    return true;
                case 5:
                    if (datoNuevo.length()!=9)return false;
                    else{
                        for (int i = 0; i < (datoNuevo.length()-1); i++) {
                            if(!Character.isDigit(datoNuevo.charAt(i))) return false;
                        }
                    }
                    cliente1.setMovil(Integer.parseInt(datoNuevo));
                    return true;
                case 6:
                    if (!datoNuevo.contains("@")) return false;
                    cliente1.setCorreo(datoNuevo);
                    return true;
                case 7:
                    cliente1.setUser(datoNuevo);
                    return true;
                case 8:
                    cliente1.setClave(datoNuevo);
                    return true;
            }
        }
        if (cliente2 != null && user.equals(cliente2.getUser())) {
            switch (modificar) {
                case 1:
                    cliente2.setNombre(datoNuevo);
                    return true;
                case 2:
                    cliente2.setDireccion(datoNuevo);
                    return true;
                case 3:
                    cliente2.setLocalidad(datoNuevo);
                    return true;
                case 4:
                    cliente2.setProvincia(datoNuevo);
                    return true;
                case 5:
                    if (datoNuevo.length() != 9) return false;
                    else {
                        for (int i = 0; i < (datoNuevo.length() - 1); i++) {
                            if (!Character.isDigit(datoNuevo.charAt(i))) return false;
                        }
                    }
                    cliente2.setMovil(Integer.parseInt(datoNuevo));
                    return true;
                case 6:
                    if (!datoNuevo.contains("@")) return false;
                    cliente2.setCorreo(datoNuevo);
                    return true;
                case 7:
                    cliente2.setUser(datoNuevo);
                    return true;
                case 8:
                    cliente2.setClave(datoNuevo);
                    return true;
            }
        }
        return false;
    }
}
