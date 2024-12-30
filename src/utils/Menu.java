package utils;
import models.Cliente;
import models.Pedido;
import models.Tienda;
import models.Trabajador;

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
        int op = 0;
        String select;
        Trabajador trabajadorCopia = tienda.copiarTrabajador(user);
        do {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido " + tienda.pintaNombreTrabajador(trabajadorCopia) + ". Tienes " + Tienda.cantidadPedidosTrabajador(trabajadorCopia) + " pedidos por gestionar\n" +
                    "1.- Consultar los pedidos que tengo asignados\n" +
                    "2.- Modificar el estado de un pedido\n" +
                    "3.- Consultar el catálogo de productos\n" +
                    "4.- Modificar un producto del catalogo\n" +
                    "5.- Ver mi perfil\n" +
                    "6.- Modificar mis datos personales\n" +
                    "7.- Cerrar sesión\n" +
                    "Introduce la opción deseada:\s");
            select = sc.nextLine();
            if (!Utils.esDigito(select)){
                System.out.println("opcion no valida");
                Utils.pulsaEnter();
            }
            else{

                op = Integer.parseInt(select);
                switch (op) {
                    case 1:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaPedidosTrabajador(trabajadorCopia));
                        Utils.pulsaEnter();
                        break;
                    case 2:
                        Utils.limpiarPantalla();
                        menuPedidosTrabajador(tienda, trabajadorCopia);
                        Utils.pulsaEnter();
                        break;
                    case 3:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaProductosConStock());
                        Utils.pulsaEnter();
                        break;
                    case 4:
                        Utils.limpiarPantalla();
                        selecionProductoModificar(tienda);
                        Utils.pulsaEnter();
                        break;
                    case 5:
                        Utils.limpiarPantalla();
                        System.out.println(tienda.pintaDatosTrabajador(trabajadorCopia));
                        Utils.pulsaEnter();
                        break;
                    case 6:
                        String datoNuevo = "";
                        int modificar;
                        do{
                            menuModificarPerfil();
                            modificar = Integer.parseInt(sc.nextLine());
                            if (modificar != 9){
                                System.out.print("Introduce el nuevo dato: ");
                                datoNuevo = sc.nextLine();
                                System.out.println(tienda.modificarDatoTrabajador(modificar, datoNuevo, trabajadorCopia)
                                        ? "Modificación realizada con exito"
                                        : "Error al realizar modificación");
                            }
                            else System.out.println("Error al realizar modificación");
                            Utils.pulsaEnter();
                            Utils.limpiarPantalla();
                        } while (modificar !=9);
                        break;
                    case 7:
                        tienda.cierraSesionTrabajador(trabajadorCopia, user);
                        System.out.print("\n\nGracias por usar FERNANSHOP :D");
                        Utils.pulsaEnter();
                        Utils.limpiarPantalla();
                        break;
                    default:
                }
            }
        } while (op != 7);
    }

    private static void menuPedidosTrabajador(Tienda tienda, Trabajador trabajadorCopia) {
        String select ="";
        int op = -1;
        if (trabajadorCopia.getPedido1() == null && trabajadorCopia.getPedido2() == null){
            System.out.println("""
                    ====================================
                    
                    No tienes pedidos asignados
                    
                    =====================================""");
        }else {
            do{
                System.out.printf("""
                ===============================
                %s
                
                Pulsa 0 para salir
                
                Elige el ID sobre el que quieres trabajar:\s """, tienda.pintaPedidosAsignados(trabajadorCopia));
                select = sc.nextLine();
                if (Utils.esDigito(select)){
                    op = Integer.parseInt(select);
                    Pedido pedidoCopia = null;
                    if (trabajadorCopia.getPedido1() != null && op == trabajadorCopia.getPedido1().getId()) pedidoCopia = trabajadorCopia.getPedido1();
                    if (trabajadorCopia.getPedido2() != null && op == trabajadorCopia.getPedido2().getId()) pedidoCopia = trabajadorCopia.getPedido2();
                    if (pedidoCopia != null)menuModificarPedido(tienda, trabajadorCopia, pedidoCopia);
                    else{
                        if (op != 0) System.out.println("Opción no valida");
                    }
                    if (trabajadorCopia.getPedido1() != null && pedidoCopia.getId() == trabajadorCopia.getPedido1().getId)
                }
                else System.out.println("Opción no valida");
            } while (op != 0);
        }
    }

    private static void menuModificarPedido(Tienda tienda, Trabajador trabajadorCopia ,Pedido pedidoCopia) {
        Utils.limpiarPantalla();
        String select;
        String datoNuevo;
        int op = 0;
        do{

            System.out.printf("""
                ============== ID pedido: %d ===============
                
                1. Modificar el estado del pedido.
                2. Añadir un comentario.
                
                0. Dejar de modificar.
                
                Selecciona la opción deseada: \s""", pedidoCopia.getId());
            select = sc.nextLine();
            if(Utils.esDigito(select)){
                op = Integer.parseInt(select);
                if (op != 0 && op < 3){
                    if(op == 1){
                        System.out.print("Introduce el nuevo estado del pedido:");
                        datoNuevo = sc.nextLine();
                        System.out.println(trabajadorCopia.modificarPedido(op, datoNuevo, pedidoCopia)
                                ? "Se modifico el estado"
                                : "No se pudo cambiar el estado");
                    }
                    if(op == 2){
                        System.out.println("Introduce el comentario que quieres añadir:");
                        datoNuevo = sc.nextLine();
                        System.out.println(trabajadorCopia.modificarPedido(op, datoNuevo, pedidoCopia)
                                ? "Comentario añadido"
                                : "No se pudo añadir el comentario");
                    }
                }
            }
            else System.out.println("Opción no valida.");
        } while (op != 0);
    }

    public static void menuCliente(Tienda tienda, String user) {
        int op;
        Cliente clienteCopia = tienda.copiarCliente(user);
        do {
            Utils.limpiarPantalla();
            System.out.print("FERNANSHOP\n" +
                    "Bienvenido " + tienda.pintaNombreCliente(clienteCopia) + ".\n" +
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
                    System.out.println(tienda.pintaProductosSinStock());
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 2:
                    Pedido pedidoNuevo = new Pedido();
                    int cantidad;
                    int opc;
                    if (clienteCopia.getPedido1() != null && clienteCopia.getPedido2() != null) System.out.print("No se pueden realizar más pedidos");
                    else{
                        do{
                            System.out.printf(tienda.pintaProductosSinStock() + """
                            
                            Introduce un 0 si no quieres cuando quiera parar de añadir productos: \s""");
                            opc = Integer.parseInt(sc.nextLine());
                            if(opc > 0){
                                if(opc>5) System.out.println("Numero identificativo erroneo");
                                else{
                                    if (pedidoNuevo.hayHueco()){
                                        System.out.print("¿Cuantas unidades del producto desea?");
                                        cantidad = Integer.parseInt(sc.nextLine());
                                        if (cantidad > 0) System.out.println(tienda.realizaPedidoCliente(opc, pedidoNuevo, cantidad) ? "Producto añadido" : "No hay Stock suficiente.");
                                        else System.out.println("Cantidad no aceptada");
                                    }
                                    else{
                                        if(!pedidoNuevo.comprobarContenidoPedido(opc)) System.out.println("No puede añadir más productos aunque puede añadir más cantidad a los ya elegidos");
                                        else{
                                            System.out.print("¿Cuantas unidades del producto desea? ");
                                            cantidad = Integer.parseInt(sc.nextLine());
                                            System.out.println(tienda.realizaPedidoCliente(opc, pedidoNuevo, cantidad) ? "Producto añadido" : "No hay Stock suficiente.");
                                        }
                                    }
                                }
                            }
                        } while (opc > 0);
                        if (clienteCopia.getPedido1() == null && pedidoNuevo.getProducto1() != null) clienteCopia.setPedido1(pedidoNuevo);
                        else {
                            if (clienteCopia.getPedido2() == null && pedidoNuevo.getProducto1() != null) clienteCopia.setPedido2(pedidoNuevo);
                        }
                        tienda.asignarPedido(pedidoNuevo);
                    }
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 3:
                    System.out.println(tienda.pintaPedidosCliente(clienteCopia));
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 4:
                    System.out.println(tienda.pintaDatosCliente(clienteCopia));
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                case 5:
                    String datoNuevo = "";
                    int modificar;
                    do{
                        menuModificarPerfil();
                        modificar = Integer.parseInt(sc.nextLine());
                        if (modificar != 9){
                            System.out.print("Introduce el nuevo dato: ");
                            datoNuevo = sc.nextLine();
                            System.out.println(tienda.modificarDatoCliente(modificar, datoNuevo, clienteCopia)
                                    ? "Modificación realizada con exito"
                                    : "Error al realizar modificación");
                        }
                        else System.out.println("Error al realizar modificación");
                        Utils.pulsaEnter();
                        Utils.limpiarPantalla();
                    }while(modificar != 9);
                    break;
                case 6:
                    System.out.print("Gracias por usar FERNANSHOP :D\n");
                    tienda.cierraSesionCliente(clienteCopia, user);
                    Utils.pulsaEnter();
                    Utils.limpiarPantalla();
                    break;
                default:
                    System.out.println("Error, opción no valida.");
                    break;
            }
        } while (op != 6);
    }


    //Menus internos
    public static void menuModificarPerfil(){
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
    }

    private static void selecionProductoModificar(Tienda tienda) {
        int selectProducto = 0;
        String select;
        do{
            System.out.println(tienda.pintaProductosConStock());
            System.out.print("Selecciona el producto que deseas modificar o O para salir: ");
            select = sc.nextLine();
            if (Utils.esDigito(select)) selectProducto = Integer.parseInt(select);
            else System.out.println("opcion no valida");
            if (selectProducto != 0 && selectProducto < 6 && Utils.esDigito(select)) seleccionDatosProducto(tienda, selectProducto);
        }while (selectProducto !=0);
    }

    private static void seleccionDatosProducto(Tienda tienda, int selectProducto) {
        int modificar = 0;
        String select, datoNuevo;
        do{
            System.out.print("""
                    1. Nombre producto.
                    2. Precio producto
                    3. Cantidad de stock del producto
                    
                    0. Salir
                    
                    Seleccione el dato que desea modificar.""");
            select = sc.nextLine();
            if (Utils.esDigito(select)) modificar = Integer.parseInt(select);
            else System.out.println("opcion no valida");
            if (modificar != 0 && modificar < 4 && Utils.esDigito(select)){
                System.out.print("¿Cual es el nuevo dato? ");
                datoNuevo = sc.nextLine();
                tienda.modificarDatosProducto(modificar, selectProducto, datoNuevo);
                modificar = 0;
            }
        }while (modificar !=0);
    }

}
