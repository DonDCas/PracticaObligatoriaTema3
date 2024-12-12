import models.Usuario;
import utils.Menu;
import utils.Utils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        String user = "", clave = "";
        int op;

        //Empieza el programa
        do{
            System.out.print("""
                ================= BIENVENIDO ===================
                                      A
                                  FERNANSHOP
                ________________________________________________
                
                1. Iniciar Sesión
                2. Registrarte
                3. Salir
                
                Ingresas la opción que desee:/s""");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    System.out.print("Ingresa usuario: ");
                    user = sc.nextLine();
                    System.out.print("Ingresa contraseña: ");
                    clave = sc.nextLine();
                    System.out.println((usuario.login(user,clave))? "LOGIN COMPLETADO" : "ERROR EN EL INICIO DE SESIÓN");
                    Menu.
                    break;
                case 2:
                    break;
                default:
                    break;
            };


        }while (usuario.cerrar());


    }
}