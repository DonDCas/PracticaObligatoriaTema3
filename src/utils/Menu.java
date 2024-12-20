package utils;
import models.Cliente;
import models.Tienda;

import java.util.Scanner;

public class Menu {

    public static Scanner sc = new Scanner(System.in);
    public static void cosa(){
    }

    public static void menuAdmin() {
        Utils.limpiarPantalla();
        System.out.print("FERNANSHOP\n"+
                "Bienvenido Admin. Tiene "  + Tienda.pintaPedidosAdmin() + "\n"+
                "1.- Asignar un pedido a un trabajador\n" +
                "2.- Modificar el estado de un pedido\n" +
                "3.- Dar de alta a un trabajador\n" +
                "4.- Ver todos los pedidos\n" +
                "5.- Ver todos los clientes\n" +
                "6.- Ver todos los trabajadores\n"+
                "7.- Cerrar sesión\n"+
                "Introduce la opción deseada:\s");

    }

    public static void menuTrabajador(Tienda tienda, String user) {
        int op;
        do {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido " + tienda.pintaNombreTrabajador(user) + ". Tienes " + Tienda.pintaPedidosTrabajador() + "\n" +
                    "1.- Consultar los pedidos que tengo asignados\n" +
                    "2.- Modificar el estado de un pedido\n" +
                    "3.- Consultar el catálogo de productos\n" +
                    "4.- Modificar un producto del catalogo\n" +
                    "5.- Ver mi perfil\n" +
                    "6.- Modificar mis datos personales\n" +
                    "7.- Cerrar sesión\n" +
                    "Introduce la opción deseada:\s");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.println(tienda.pintaDatosTrabajador(user));
                    Utils.pulsaEnter();
                case 7:
                    System.out.print("Gracias por usar FERNANSHOP :D");
                default:
            }
        } while (op != 7);
    }

    public static void menuCliente(Tienda tienda, String user) {
        int op;
        Cliente clienteCopia = tienda.copiarCliente(user);
        do {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido " + tienda.pintaNombreCliente(user) + ".\n" +
                    "1.- Consultar catalogo de productos\n" +
                    "2.- Realizar un pedido\n" +
                    "3.- Ver mis pedidos realizados\n" +
                    "4.- Ver mis datos personales\n" +
                    "5.- Modificar mis datos personales\n" +
                    "6.- Cerrar sesión\n" +
                    "Introduce la opción deseada:\s");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    System.out.println(tienda.pintaProductos());
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 2:
                    int cont = 0;
                    int opc;
                    do{
                        System.out.printf(tienda.pintaProductos() + """
                            
                            Introduce un 0 si no quieres cuando quiera parar de añadir productos; \s""");
                        opc = Integer.parseInt(sc.nextLine());
                        if(opc > 0) System.out.println(tienda.realizaPedidoCliente(opc, clienteCopia) ? "Producto añadido" : "Pedido terminado");
                        cont++;
                    } while (opc > 0 | cont < 3);
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 3:
                    System.out.println(tienda.pintaPedidosCliente(user));
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 4:
                    System.out.println(tienda.pintaDatosCliente(user));
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 5:
                    String datoNuevo = "";
                    int modificar;
                    System.out.print("""
                            =========================\n
                            1. Nombre
                            2. Dirección
                            3. Localidad
                            4. Provincia
                            5. Telefono
                            6. Correo
                            7. Usuario
                            8. Contraseña
                            9. Salir
                            ¿Que datos quieres modificar?\s""");
                    modificar = Integer.parseInt(sc.nextLine());
                    if (modificar != 9){
                        System.out.print("Introduce el nuevo dato: ");
                        datoNuevo = sc.nextLine();
                        System.out.println(tienda.modificarDatoCliente(modificar, datoNuevo, user)
                                ? "Modificación realizada con exito"
                                : "Error al realizar modificación");
                    }
                    if (modificar == 7){
                        user = datoNuevo;
                    }
                    else System.out.println("Error al realizar modificación");
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 6:
                    System.out.print("Gracias por usar FERNANSHOP :D\n");
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                default:
                    System.out.println("Error, opción no valida.");
                    break;
            }
        } while (op != 6);
    }

}
