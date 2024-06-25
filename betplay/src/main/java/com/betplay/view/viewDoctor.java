package com.betplay.view;

import java.util.Collection;
import java.util.Scanner;

import com.betplay.Controller;
import com.betplay.model.entity.Coach;
import com.betplay.model.entity.Doctor;
import com.betplay.model.entity.Player;
import com.betplay.model.entity.Team;

public class viewDoctor {
    public static Controller controlador;

    public void menuDoctor() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Crear Medico");
            System.out.println("2. Actualizar Medico");
            System.out.println("3. Buscar Medico");
            System.out.println("4. Eliminar Medico");
            System.out.println("5. Listar todos los Medicos");
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

                        System.out.println("Ingrese el codigo del Medico :");
                        String codigoDoctor = scanner.nextLine();
                        if (controlador.doctores.containsKey(codigoDoctor)) {
                            System.out.println(
                                    " El codigo que ingreso ya existe, intente nuevamente");
                            break;
                        } else {
                            System.out.println("Ingrese el id del doctor :");
                            int iddoctor = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese Nombre del doctor :");
                            String nombredoctor = scanner.nextLine();
                            System.out.println("Ingrese el apellido:");
                            String apellidodoctor = scanner.nextLine();
                            System.out.println("Ingrese la edad:");
                            int edaddoctor = scanner.nextInt();
                            System.out.println("Ingrese el titulo del doctor:");
                            String tituloDoctor = scanner.nextLine();
                            System.out.println("Ingrese los años de experiencia del medico:");
                            int expDoctor = scanner.nextInt();
                            scanner.nextLine();
                            Doctor doctor = new Doctor(iddoctor, nombredoctor, apellidodoctor,
                                    edaddoctor, tituloDoctor , expDoctor , codigoEquipo);
                            controlador.doctores.put(codigoDoctor, doctor);

                            Team agregardoctor = controlador.equipos.get(codigoEquipo);
                            // System.out.println(agregardoctor.getLstdoctores());
                            agregardoctor.setLstMasajistas(doctor);
                            // System.out.println(agregardoctor.getLstdoctores());
                            controlador.equipos.put(codigoEquipo, agregardoctor);
                            System.out.println("doctor creado correctamente");
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
                    System.out.println("ingrese el codigo del doctor que desea actualizar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.doctores.containsKey(codBusqueda)) {
                        Doctor doctorActualizado = new Doctor();
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
                                System.out.println("Ingrese el nuevo nombre del doctor");
                                String newNombre = scanner.nextLine();
                                doctorActualizado = controlador.doctores.get(codBusqueda);
                                doctorActualizado.setNombre(newNombre);
                                controlador.doctores.put(codBusqueda, doctorActualizado);
                                break;
                            case 2:
                                System.out.println("Ingrese el nuevo Apellido del doctor");
                                String newApellido = scanner.nextLine();
                                doctorActualizado = controlador.doctores.get(codBusqueda);
                                doctorActualizado.setApellido(newApellido);
                                controlador.doctores.put(codBusqueda, doctorActualizado);
                                break;
                            case 3:
                                System.out.println("Ingrese la nueva edad del doctor");
                                int newEdad = scanner.nextInt();
                                scanner.nextLine();
                                doctorActualizado = controlador.doctores.get(codBusqueda);
                                doctorActualizado.setEdad(newEdad);
                                controlador.doctores.put(codBusqueda, doctorActualizado);
                                break;
                            case 4:
                                System.out.println("Ingrese la experiencie del doctor");
                                int newExp = scanner.nextInt();
                                scanner.nextLine();
                                doctorActualizado = controlador.doctores.get(codBusqueda);
                                doctorActualizado.setExpYear(newExp);
                                controlador.doctores.put(codBusqueda, doctorActualizado);
                                break;
                            case 5:
                                System.out.println("Ingrese la nueva posicion del doctor");
                                String newPosicion = scanner.nextLine();
                                doctorActualizado = controlador.doctores.get(codBusqueda);
                                doctorActualizado.setTitulo(newPosicion);
                                controlador.doctores.put(codBusqueda, doctorActualizado);
                                break;
                            case 7:
                                System.out.println("Presione cualquier tecla para salir");
                                scanner.nextLine();
                                break;
                            default:
                                break;
                        }

                        /*
                         * System.out.println("Ingrese la nueva ciudad del doctor");
                         * String newCiudad = scanner.nextLine();
                         * // doctorActualizado.setCiudad(newCiudad);
                         * //doctorActualizado.setNombre(newNombre);
                         * controlador.doctores.put(codBusqueda, doctorActualizado);
                         * System.out.println("doctor actualizado correctamente");
                         * System.out.println("presione cualquier tecla para continuar");
                         * scanner.nextLine();
                         */
                    } else {
                        System.out.println("codigo de doctor no encontrado intente nuevamente");
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("ingrese el codigo del doctor que desea buscar");
                    codBusqueda = scanner.nextLine();
                    if (controlador.doctores.containsKey(codBusqueda)) {
                        Doctor doctorBuscado = controlador.doctores.get(codBusqueda);
                        System.out.println(doctorBuscado);
                        System.out.println(" y pertenece al equipo " + controlador.equipos.get(doctorBuscado.getCodigoEquipo()));
                    } else {
                        System.out.println("no hay un doctor con ese codigo, intente nuevamente");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println(
                            " ¡esta accion tamnbien lo eliminara de la lista de doctores de su respectivo equipo! \n ingrese el codigo del doctor que desea eliminar: ");
                    codBusqueda = scanner.nextLine();

                    if (controlador.doctores.containsKey(codBusqueda)) {
                        Doctor doctorEliminado = controlador.doctores.get(codBusqueda);
                        controlador.doctores.remove(codBusqueda);
                        Team equipoEliminardoctor = controlador.equipos.get(doctorEliminado.getCodigoEquipo());
                        if (equipoEliminardoctor != null) {
                            equipoEliminardoctor.getLstMasajistas().remove(doctorEliminado);
                        }
                        System.out.println("doctor el1iminado correctamente");
                        System.out.println("presione cualquier tecla para continuar");
                        scanner.nextLine();
                    } else {
                        System.out.println("codigo de doctor no encontrado intente nuevamente");
                        continue;
                    }

                    break;

                case 5:

                    // impresion sin las llaves
                    Collection<Doctor> values = controlador.doctores.values();
                    for (Doctor player : values) {
                        System.out.println(player.toString());

                    }
                    /*
                     * impresion, llave y valor. Se modifico el toString de la clase Team
                     * for (Map.Entry<String, Team> entry : controlador.doctors.entrySet()) {
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
