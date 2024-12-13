import models.Tienda;
import utils.Menu;
import utils.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        String user = "", clave = "", logueo = "";
        String nombre = "", direccion = "", localidad = "", provincia = "", introTelefono = "", introCorreo = "";
        int op;

        //Creamos usuarios MOCK
        tienda.mock();

        //Empieza el programa
        Utils.logo();

        do{
            System.out.print("""
                ================= BIENVENIDO ===================
                                      A
                                  FERNANSHOP
                ________________________________________________
                
                1. Iniciar Sesión
                2. Registrarte
                3. Salir
                
                Ingresas la opción que desee:\s""");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    System.out.print("Ingresa usuario: ");
                    user = sc.nextLine();
                    System.out.print("Ingresa contraseña: ");
                    clave = sc.nextLine();
                    logueo = (tienda.login(user,clave));
                    if (logueo.equals("ERROR")) System.out.println("ERROR EN EL LOGUEO");
                    if (logueo.equals("Admin")) Menu.menuAdmin();
                    if (logueo.equals("Trabajador")) Menu.menuTrabajador(tienda, user);
                    if (logueo.equals("Cliente")) Menu.menuCliente(tienda, user);
                    Utils.pulsaEnter();
                    break;
                case 2:
                    System.out.print("Ingresa nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingresa tu dirección: ");
                    direccion = sc.nextLine();
                    System.out.print("Ingresa tu localidad: ");
                    localidad = sc.nextLine();
                    System.out.print("Ingresa la provincia: ");
                    provincia = sc.nextLine();
                    System.out.print("Ingresa tu telefono de contacto: ");
                    introTelefono = sc.nextLine();
                    System.out.print("Ingresa tu correo: ");
                    introCorreo = sc.nextLine();
                    System.out.print("Ingresa usuario: ");
                    user = sc.nextLine();
                    System.out.print("Ingresa tu contraseña: ");
                    clave = sc.nextLine();
                    System.out.println((tienda.registroCliente(nombre, direccion, localidad, provincia, introTelefono, introCorreo, user, clave))
                            ? "Exito al registrarse"
                            : "Fallo al registrarse");
                    break;
                default:
                    break;
            };


        }while (op != 3);


    }
}