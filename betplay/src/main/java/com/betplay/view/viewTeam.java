package com.betplay.view;

import java.util.Scanner;

import com.betplay.Controller;
import com.betplay.model.entity.Team;

public class viewTeam {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            String  codBusqueda = "";
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Team equipo = new Team();
            switch (choice) {
                case 1:

                    String codigoEquipo = null;
                    System.out.println("Ingrese el codigo del equipo :");
                    codigoEquipo = scanner.nextLine();
                    System.out.println("Ingrese Nombre del equipo :");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println("Ingrese la ciudad :");
                    equipo.setCiudad(scanner.nextLine());
                    controlador.equipos.put(codigoEquipo, equipo);
                    System.out.println("Equipo creado correctamente");
                    System.out.println("presione cualquier tecla para continuar");
                    scanner.nextLine();

                    break;

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
                    equipo = controlador.equipos.get(codBusqueda);
                    System.out.println("El equipo con codigo " + codBusqueda + " es el equipo " + equipo.getNombre() + " de la ciudad de " + equipo.getCiudad());
                    break;
                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
