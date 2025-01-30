
# Practica Obligatoria Tema 4

###Francisco Javier Rueda Serrano y Francisco Cantero Maestro


**Tabla de contenidos**

[TOCM]

[TOC]

#0. Introducción

## Instalación



Para empezar con la instalación de este programa empezaremos por descargar e instalar el [[JDK 23.0.1](http://https//download.oracle.com/java/23/latest/jdk-23_windows-x64_bin.exe "JDK 23.0.1")]. Durante la instalación deberemos verificar que se instale en el directorio: "**c\Program Files\Java**".

Después iremos al buscador de Windows y realizaremos la siguiente búsqueda: "*Editar las variables de Entorno del sistema*".

Buscaremos en "*Variables del entorno*" y dentro nos dirigiremos a "*Variables del sistema*". seleccionaremos "*Path*" y le daremos a editar.

En la ventana que se nos abrirá clicamos en la variable de Java e introducimos la siguiente ruta: "**C:\Program Files\Java\jdl-18.0.2.1\bin**", le damos a confirmar y aceptar.

##Descarga

Para descargar este programa en GitHub deberemos de cliquear el botón verde de "<> Code" y seleccionar la opción de "*Download zip*".

Cuando se nos descargue el archivo comprimido, lo descomprimimos y en la carpeta que nos encontraremos hay que acceder a la carpeta SRC y en ella encontraremos archivo Start.bat que será el que ejecute nuestro programa.

# 1. Inicio de la aplicación

## Inicio


En el menú principal tendremos las opciones de Inicio de sesión y de registro. A la hora la aplicación por primera vez solo existe el usuario de Admin.

> [!Note]
> Para iniciar sesión como Admin.
> Usuario: Admin
> Password: 1234

Explicaremos el uso de esta aplicación de forma secuencial empezando por el registro de los clientes.

### Registro

Cuando un cliente se registre deberá ingresar su nombre completo junto con su dirección, localidad y provincia.
Cuando se pida introducir un número de contacto, el usuario deberá introducir un número de 9 cifras. Tras esto pedirá que se ingrese un correo válido por válido se entiende que el correo sea del dominio hotmail.com o gmail.com. También se comprueba si el correo ya se encuentra registrado. 

Tanto si el correo como el número de teléfono deben de ser válidos para poder continuar y si no se repetirá el proceso de pedir el dato hasta que sea un dato correcto. 

Por último para terminar el registro el cliente deberá introducir un usuario y contraseña que el cliente utilizará para iniciar su sesión.

Una vez finalizado el proceso de registro y solo si este ha sido exitoso el cliente realizará un correo de bienvenida con un token que se le requerirá para poder validar el correo y poder usar su cuenta.

### Inicio de sesión

Para iniciar sesión, en el menú inicial el usuario, ya sea Admin, trabajador o cliente, deberá utilizar la opción 1 para poder iniciar sesión

En el momento de iniciar sesión se pedirá al usuario tanto su usuario como contraseña para comprobar si está en el registro de la aplicación.

En caso de ser un cliente se comprobará que este no está validado y  de ser el caso deberá ingresar el token que este haya recibido via email o no podrá acceder a esta.

#2 Inicio como administrador.

El administrador a la hora de acceder tendrá que ingresar el usuario y contraseña otorgados. Para acceder introducirá el user: “Admin” y la contraseña “1234” para entrar en su menú principal.

#1. Menú de administrador.

El Admin navegar por un menú de 7 opciones a las que accedes introduciendo el número que corresponda y que repasamos debidamente a continuación pero antes, el administrador recibirá la bienvenida seguida de un conteo de los pedidos que tiene por asignar a sus trabajadores. Este conteo se reducirá o aumentará mientras dependiendo de los pedidos que le lleguen a él o los que asigne a otros trabajadores.

## 1.1. Asignar pedidos a un trabajador.

Al introducir el número “1” el Admin accedera a un menú en el que verá un desglosado de todos los pedidos que se encuentran actualmente en proceso y que no han sido asignados a ningún trabajador.

En este menú el administrador deberá introducir la ID del pedido para seleccionarlo y tras esto elegir el trabajador que más le convenga para tramitar el pedido.

El trabajador al que se le haya asignado dicho pedido recibirá una notificación del bot de telegram de nuestra tienda que le avisará de la adjudicación además de recibir un correo en el que se detallan todos los datos del pedido que se le ha asignado.

## 1.2. Modificar el estado de un pedido

Para acceder a este menú el usuario deberá de ingresar el número 2 y accedes a un menú al igual que en el caso anterior en el que verá un desglosado de todos los pedidos en proceso actualmente además de, en caso de estar asignados a un trabajador, ver a qué trabajador se le ha asignado o si no es el caso que se avise de le avise que dicho pedido todavía no se ha asignado a nadie.

Igual que en el menú anterior el Admin deberá introducir el ID del pedido en cuestión y acceder a un nuevo menú en el que podrá modificar diferentes detalles del pedido.

En dicho menú encontrará 5 opciones las cuales serán las siguientes,

### 1.2.1 Dirección del envío

Para acceder a esta opción el Administrador deberá de introducir el número “1” en el menú. Tras acceder se le preguntará por la nueva dirección a la que se debe enviar el paquete. 

Cuando introduzca la nueva dirección se le preguntará por una nueva Localidad, si el Administrador no introduce nada y pulsa la tecla enter la aplicación entenderá que tanto la Localidad como la Provincia son las mismas y que no deben de cambiarse. Si se introduce una nueva localidad se le preguntará al Admin por la provincia a la que pertenece dicha localidad.

### 1.2.2 Estado del pedido

Para acceder a esta opción el Admin deberá introducir el número “2” en el menú y acceder a un nuevo menú en el que dependiendo del número que ingrese podrá modificar el estado del pedido a uno de los ya definidos con anterioridad. Estos estados son:

Recibido. El Cliente ya ha recibido el pedido que encargó.
En Preparación. El paquete se está preparando para ser enviado
Retrasado. El paquete ha sufrido algún imprevisto y se retrasa la fecha de entrega.
Cancelado. Se cambiará el estado ha “cancelado” cuando el pedido sea cancelado por el cliente.
Enviado: El pedido ya ha salido de nuestros almacenes y está de camino al destinatario
Por último en caso de que no queramos cambiar el estado, pulsaremos 0 y saldremos al menú anterior.

### 1.2.3. Fecha de entrega

Para acceder a esta opción se deberá introducir el número “3” donde accederemos se nos preguntará por la nueva fecha de entrega. La fecha de entrega se introducirá deberá tener el siguiente formato:

(dd/MM/yyyy) 

### 1.2.4. Comentario. 

Aquí el Admin podrá introducir algún comentario como por ejemplo indicar la empresa que se encarga del paquete que se le ha enviado.

## 1.3. Dar de alta a un trabajador

El admin deberá introducir el número “3” para dar de alta a los trabajadores. Al contrario que los clientes, los trabajadores solo podrán registrarse en la aplicación a través del administrador.

El proceso de registro del trabajador será el mismo que cuando un cliente se registra. Se deberá introducir el nombre completo, la dirección, localidad y provincia, seguidamente de un teléfono de contacto y un correo que no deberá de estar registrado en la aplicación y un id de Telegram que será indicado por el administrador. Para terminar el registro se introducirán tanto un usuario como contraseña que se le entregarán al trabajador correspondiente

## 1.4. Ver todos los pedidos. 

Al introducir el número 4 el administrador accede a un listado de todos los pedidos en realización que se encuentren activos.

## 1.5. Ver todos los Clientes

Al introducir el número 5 el administrador accede a un listado con todos los datos de los clientes.

## 1.6 Ver todos los trabajadores

Al introducir el número 6 el administrador accede, al igual que en el caso anterior, a un listado de todos los trabajadores registrados en la página.

## 1.7. Cerrar sesión

Por último, al introducir el número 7 el administrador procederá a cerrar su cuenta en la aplicación.

# 2. Menú de trabajadores


###End
