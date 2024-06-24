package com.betplay.view;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import com.betplay.Controller;
import com.betplay.model.entity.Player;
import com.betplay.model.entity.Team;

public class viewPlayer {

       public static Controller controlador;

       public void menujugador() {
              Scanner scanner = new Scanner(System.in);

              while (true) {

                     System.out.println("1. Crear Jugador");
                     System.out.println("2. Actualizar Jugador");
                     System.out.println("3. Buscar Jugador");
                     System.out.println("4. Eliminar Jugador");
                     System.out.println("5. Listar todos los Jugadores");
                     System.out.println("6. Regresar al menu principal");
                     System.out.println("7. Salir del programa");
                     String codBusqueda = "";
                     int choice = scanner.nextInt();
                     scanner.nextLine(); // Consume newline

                     switch (choice) {
                            case 1:
                                   // Confirmando equipo
                                   System.out.println("ingrese el codigo del equipo  en que jugara?");
                                   String codigoEquipo = scanner.nextLine();
                                   if (controlador.equipos.containsKey(codigoEquipo)) {

                                          System.out.println("Ingrese el codigo del jugador :");
                                          String codigojugador = scanner.nextLine();
                                          if (controlador.jugadores.containsKey(codigojugador)) {
                                                 System.out.println(
                                                               " El codigo que ingreso ya existe, intente nuevamente");
                                                 break;
                                          } else {
                                                 System.out.println("Ingrese el id del jugador :");
                                                 int idJugador = scanner.nextInt();
                                                 scanner.nextLine();
                                                 System.out.println("Ingrese Nombre del jugador :");
                                                 String nombreJugador = scanner.nextLine();
                                                 System.out.println("Ingrese el apellido:");
                                                 String apellidoJugador = scanner.nextLine();
                                                 System.out.println("Ingrese la edad:");
                                                 int edadJugador = scanner.nextInt();
                                                 System.out.println("Ingrese el # de dorsal:");
                                                 int dorsalJugador = scanner.nextInt();
                                                 scanner.nextLine();
                                                 System.out.println("Ingrese la demarcacion:");
                                                 String demarcacionJugador = scanner.nextLine();
                                                 Player jugador = new Player(idJugador, nombreJugador, apellidoJugador,
                                                               edadJugador, dorsalJugador, demarcacionJugador, codigoEquipo);
                                                 controlador.jugadores.put(codigojugador, jugador);

                                                 Team agregarJugador = controlador.equipos.get(codigoEquipo);
                                                 //System.out.println(agregarJugador.getLstJugadores());
                                                 agregarJugador.setLstJugadores(jugador);
                                                 //System.out.println(agregarJugador.getLstJugadores());
                                                 controlador.equipos.put(codigoEquipo, agregarJugador);
                                                 System.out.println("jugador creado correctamente");
                                                 System.out.println("presione cualquier tecla para continuar");
                                                 scanner.nextLine();
                                                 break;
                                          }
                                   } else {
                                          System.out.println("no existe ese equipo, intente nuevamente");
                                   }

                                   //

                                   break;

                            case 2:
                                   System.out.println("ingrese el codigo del jugador que desea actualizar");
                                   codBusqueda = scanner.nextLine();
                                   if (controlador.jugadores.containsKey(codBusqueda)) {
                                          Player jugadorActualizado = new Player();
                                          String menuModificarUsuario = """
                                                        ********************************************
                                                        1. Nombre
                                                        2. Apellido
                                                        3. Edad
                                                        4. Dorsal
                                                        5. Posicion
                                                        6. Equipo
                                                        7. Cancelar Modificacion
                                                        ********************************************
                                                        """.formatted();
                                          System.out.println(menuModificarUsuario);
                                          int opcion = scanner.nextInt();
                                          scanner.nextLine();
                                          switch (opcion) {
                                                 case 1:
                                                        System.out.println("Ingrese el nuevo nombre del jugador");
                                                        String newNombre = scanner.nextLine();
                                                        jugadorActualizado = controlador.jugadores.get(codBusqueda);
                                                        jugadorActualizado.setNombre(newNombre);
                                                        controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                                        break;
                                                 case 2:
                                                        System.out.println("Ingrese el nuevo Apellido del jugador");
                                                        String newApellido = scanner.nextLine();
                                                        jugadorActualizado = controlador.jugadores.get(codBusqueda);
                                                        jugadorActualizado.setApellido(newApellido);
                                                        controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                                        break;
                                                 case 3:
                                                        System.out.println("Ingrese la nueva edad del jugador");
                                                        int newEdad = scanner.nextInt();
                                                        scanner.nextLine();
                                                        jugadorActualizado = controlador.jugadores.get(codBusqueda);
                                                        jugadorActualizado.setEdad(newEdad);
                                                        controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                                        break;
                                                 case 4:
                                                        System.out.println("Ingrese el nuevo dorsal del jugador");
                                                        int newDorsal = scanner.nextInt();
                                                        scanner.nextLine();
                                                        jugadorActualizado = controlador.jugadores.get(codBusqueda);
                                                        jugadorActualizado.setDorsal(newDorsal);
                                                        controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                                        break;
                                                 case 5:
                                                        System.out.println("Ingrese la nueva posicion del jugador");
                                                        String newPosicion = scanner.nextLine();
                                                        jugadorActualizado = controlador.jugadores.get(codBusqueda);
                                                        jugadorActualizado.setPosicion(newPosicion);
                                                        controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                                        break;
                                                 case 7:
                                                        System.out.println("Presione cualquier tecla para salir");
                                                        scanner.nextLine();
                                                        break;
                                                 default:
                                                        break;
                                          }

                                          /*
                                           * System.out.println("Ingrese la nueva ciudad del jugador");
                                           * String newCiudad = scanner.nextLine();
                                           * // jugadorActualizado.setCiudad(newCiudad);
                                           * //jugadorActualizado.setNombre(newNombre);
                                           * controlador.jugadores.put(codBusqueda, jugadorActualizado);
                                           * System.out.println("jugador actualizado correctamente");
                                           * System.out.println("presione cualquier tecla para continuar");
                                           * scanner.nextLine();
                                           */
                                   } else {
                                          System.out.println("codigo de jugador no encontrado intente nuevamente");
                                          continue;
                                   }
                                   break;

                            case 3:
                                   System.out.println("ingrese el codigo del jugador que desea buscar");
                                   codBusqueda = scanner.nextLine();
                                   if (controlador.jugadores.containsKey(codBusqueda)) {
                                          Player jugadorBuscado = controlador.jugadores.get(codBusqueda);
                                          System.out.println(jugadorBuscado);

                                   } else {
                                          System.out.println("no hay un jugador con ese codigo, intente nuevamente");
                                          continue;
                                   }
                                   break;
                            case 4:
                                   System.out.println(" ¡esta accion tamnbien lo eliminara de la lista de jugadores de su respectivo equipo! \n ingrese el codigo del jugador que desea eliminar: ");
                                   codBusqueda = scanner.nextLine();

                                   if (controlador.jugadores.containsKey(codBusqueda)) {
                                          Player jugadorEliminado = controlador.jugadores.get(codBusqueda);
                                          controlador.jugadores.remove(codBusqueda);
                                          Team equipoEliminarJugador = controlador.equipos.get(jugadorEliminado.getCodigoEquipo());
                                          if (equipoEliminarJugador != null) {
                                                 equipoEliminarJugador.getLstJugadores().remove(jugadorEliminado);
                                             }
                                          System.out.println("jugador el1iminado correctamente");
                                          System.out.println("presione cualquier tecla para continuar");
                                          scanner.nextLine();
                                   } else {
                                          System.out.println("codigo de jugador no encontrado intente nuevamente");
                                          continue;
                                   }

                                   break;

                            case 5:

                                   // impresion sin las llaves
                                   Collection<Player> values = controlador.jugadores.values();
                                   for (Player player : values) {
                                          System.out.println(player.toString());

                                   }
                                   /*
                                    * impresion, llave y valor. Se modifico el toString de la clase Team
                                    * for (Map.Entry<String, Team> entry : controlador.jugadors.entrySet()) {
                                    * System.out.println("Key: " + entry.getKey() + ", Value: " +
                                    * entry.getValue());
                                    * }
                                    */
                                   break;
                            case 6:
                                   return;
                            case 7:
                                   scanner.close();
                                   System.exit(0);
                                   break;

                            default:
                                   System.out.println("Opcion invalida, intentelo de nuevo.");
                     }
              }
       }

}
