package com.betplay.view;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.betplay.Controller;
import com.betplay.model.entity.Coach;
import com.betplay.model.entity.Doctor;
import com.betplay.model.entity.Player;
import com.betplay.model.entity.Team;

public class viewTeam {
    public static Controller controlador;

    public void menuEquipo() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Volver al menu principal");
            System.out.println("7. Salir");
            String codBusqueda = "";
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Team equipo = new Team();
            switch (choice) {
                case 1:
                    System.out.println("ingrese el codigo del equipo que vas a crear");
                    codBusqueda = scanner.nextLine();
                    if (controlador.equipos.containsKey(codBusqueda)) {
                        System.out.println(" El codigo que ingreso ya existe, intente nuevamente");
                        break;
                    } else {
                        System.out.println("Ingrese Nombre del equipo :");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipo.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codBusqueda, equipo);
                        System.out.println("Equipo creado correctamente");
                        System.out.println("presione cualquier tecla para continuar");
                        scanner.nextLine();

                        break;
                    }

                case 2:
                    System.out.println("ingrese el codigo del equipo que desea actualizar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.equipos.containsKey(codBusqueda)) {
                        Team equipoActualizado = new Team();
                        System.out.println("Ingrese el nuevo nombre del equipo");
                        String newNombre = scanner.nextLine();
                        System.out.println("Ingrese la nueva ciudad del equipo");
                        String newCiudad = scanner.nextLine();
                        equipoActualizado.setCiudad(newCiudad);
                        equipoActualizado.setNombre(newNombre);
                        controlador.equipos.put(codBusqueda, equipoActualizado);
                        System.out.println("Equipo actualizado correctamente");
                        System.out.println("presione cualquier tecla para continuar");
                        scanner.nextLine();
                    } else {
                        System.out.println("codigo de equipo no encontrado intente nuevamente");
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("ingrese el codigo del equipo que desea buscar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.equipos.containsKey(codBusqueda)) {
                        equipo = controlador.equipos.get(codBusqueda);
                        System.out.println("El equipo con codigo " + codBusqueda + " es el equipo " + equipo.getNombre()
                                + " de la ciudad de " + equipo.getCiudad());
                        if (equipo.getLstJugadores().size() > 0) {
                            System.out.println("y cuenta con los siguientes jugadores ");
                            // Imprimiendo la lista de jugadores del equipo,
                            List<Player> jugadores = equipo.getLstJugadores();
                            for (Player jugador : jugadores) {
                                System.out.println(jugador.toString());
                            }
                        } else {
                            System.out.println("Este equipo, Por el momento no tiene jugadores asignados");
                        }
                        if (equipo.getLstEntrenadores().size() > 0) {
                            System.out.println("\n Cuenta con los siguientes entrenadores: ");
                            // imprimiendo la lista de entrenadores del equipo:
                            List<Coach> entrenadores = equipo.getLstEntrenadores();
                            for (Coach entrenador : entrenadores) {
                                System.out.println(entrenador.toString());
                            }
                        } else {
                            System.out.println("Por el momento no tiene Entrenadoes asignados");
                        }

                        if (equipo.getLstMasajistas().isEmpty()) {
                            System.out.println("No se le han asignado Preparadores Fisicos a este equipo aun!");
                        } else {
                            // imprimiendo la lista de los medicos del equipo:
                            List<Doctor> doctores = equipo.getLstMasajistas();
                            for (Doctor doctor : doctores) {
                                System.out.println(doctor.toString());
                            }

                        }
                    } else {
                        System.out.println("no hay un equipo con ese codigo, intente nuevamente");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("ingrese el codigo del equipo que desea eliminar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.equipos.containsKey(codBusqueda)) {
                        controlador.equipos.remove(codBusqueda);
                        System.out.println("Equipo el1iminado correctamente");
                        System.out.println("presione cualquier tecla para continuar");
                        scanner.nextLine();
                    } else {
                        System.out.println("codigo de equipo no encontrado intente nuevamente");
                        continue;
                    }
                    break;

                case 5:
                    if (controlador.equipos.isEmpty()) {
                        System.out.println(" Lo lamento, aun no hay equipos para mostrar. Agreguelos con la opcion 1!");
                        break;
                    } else {
                        // impresion sin las llaves
                        Collection<Team> values = controlador.equipos.values();
                        for (Team team : values) {
                            System.out.println(team.toString());

                        }
                        // impresion, llave y valor. Se modifico el toString de la clase Team
                        for (Map.Entry<String, Team> entry : controlador.equipos.entrySet()) {
                            System.out.println("Codigo" + entry.getKey() + ",  " + entry.getValue());
                        }
                        break;
                    }

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
