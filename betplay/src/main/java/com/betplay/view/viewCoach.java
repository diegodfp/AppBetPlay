package com.betplay.view;

import java.util.Collection;
import java.util.Scanner;

import com.betplay.Controller;
import com.betplay.model.entity.Coach;
import com.betplay.model.entity.Player;
import com.betplay.model.entity.Team;

public class viewCoach {
    public static Controller controlador;

    public void menuCoach() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Crear Entrenador");
            System.out.println("2. Actualizar Entrenador");
            System.out.println("3. Buscar Entrenador");
            System.out.println("4. Eliminar Entrenador");
            System.out.println("5. Listar todos los Entrenadores");
            System.out.println("6. Regresar al menu principal");
            System.out.println("7. Salir del programa");
            String codBusqueda = "";
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Confirmando equipo
                    System.out.println("ingrese el codigo del equipo  en el que sera entrenador");
                    String codigoEquipo = scanner.nextLine();
                    if (controlador.equipos.containsKey(codigoEquipo)) {

                        System.out.println("Ingrese el codigo del entrenador :");
                        String codigojugador = scanner.nextLine();
                        if (controlador.entrenadores.containsKey(codigojugador)) {
                            System.out.println(
                                    " El codigo que ingreso ya existe, intente nuevamente");
                            break;
                        } else {
                            System.out.println("Ingrese el id del Entrenador :");
                            int idEntrenador = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese Nombre del Entrenador :");
                            String nombreEntrenador = scanner.nextLine();
                            System.out.println("Ingrese el apellido:");
                            String apellidoEntrenador = scanner.nextLine();
                            System.out.println("Ingrese la edad:");
                            int edadEntrenador = scanner.nextInt();
                            System.out.println("Ingrese el id  de la federacion para la cual trabaja:");
                            int idFederacion = scanner.nextInt();
                            scanner.nextLine();
                            Coach entrenador = new Coach(idEntrenador, nombreEntrenador, apellidoEntrenador,
                                    edadEntrenador, idFederacion, codigoEquipo);
                            controlador.entrenadores.put(codigojugador, entrenador);

                            Team agregarEntrenador = controlador.equipos.get(codigoEquipo);
                            
                            agregarEntrenador.setLstEntrenadores(entrenador);
                            
                            controlador.equipos.put(codigoEquipo, agregarEntrenador);
                            System.out.println("Entrenador creado correctamente");
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
                    System.out.println("ingrese el codigo del Entrenador que desea actualizar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.jugadores.containsKey(codBusqueda)) {
                        Coach entrenadorActualizado = new Coach();
                        String menuModificarUsuario = """
                                ********************************************
                                1. Nombre
                                2. Apellido
                                3. Edad
                                4. idFederacion
                                5. Equipo
                                6. Cancelar Modificacion
                                ********************************************
                                """.formatted();
                        System.out.println(menuModificarUsuario);
                        int opcion = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del coach");
                                String newNombre = scanner.nextLine();
                                entrenadorActualizado = controlador.entrenadores.get(codBusqueda);
                                entrenadorActualizado.setNombre(newNombre);
                                controlador.entrenadores.put(codBusqueda, entrenadorActualizado);
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo Apellido del coach");
                                String newApellido = scanner.nextLine();
                                entrenadorActualizado = controlador.entrenadores.get(codBusqueda);
                                entrenadorActualizado.setApellido(newApellido);
                                controlador.entrenadores.put(codBusqueda, entrenadorActualizado);
                                break;
                            case 3:
                                System.out.println("Ingrese la nueva edad del coach");
                                int newEdad = scanner.nextInt();
                                scanner.nextLine();
                                entrenadorActualizado = controlador.entrenadores.get(codBusqueda);
                                entrenadorActualizado.setEdad(newEdad);
                                controlador.entrenadores.put(codBusqueda, entrenadorActualizado);
                                break;
                            case 4:
                                System.out.println("Ingrese la nueva federacion del coach");
                                int newFederacion = scanner.nextInt();
                                scanner.nextLine();
                                entrenadorActualizado = controlador.entrenadores.get(codBusqueda);
                                entrenadorActualizado.setIdFederacion(newFederacion);
                                controlador.entrenadores.put(codBusqueda, entrenadorActualizado);
                                break;
                            case 5:
                                
                                break;
                            case 6:
                                System.out.println("Presione cualquier tecla para salir");
                                scanner.nextLine();
                                break;
                            default:
                                break;
                        }

                       
                    } else {
                        System.out.println("codigo de jugador no encontrado intente nuevamente");
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("ingrese el codigo del entrenador que desea buscar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.entrenadores.containsKey(codBusqueda)) {
                        Coach entrenadorBuscado = controlador.entrenadores.get(codBusqueda);
                        System.out.println(entrenadorBuscado);

                    } else {
                        System.out.println("no hay un entrenador con ese codigo, intente nuevamente");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println(
                            " ¡esta accion tamnbien lo eliminara de la lista de jugadores de su respectivo equipo! \n ingrese el codigo del jugador que desea eliminar: ");
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
                    Collection<Coach> values = controlador.entrenadores.values();
                    for (Coach coach : values) {
                        System.out.println(coach.toString());

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
