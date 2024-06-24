package com.betplay;

import java.util.Scanner;

import com.betplay.view.viewCoach;
import com.betplay.view.viewDoctor;
import com.betplay.view.viewPlayer;
import com.betplay.view.viewTeam;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        viewTeam.controlador = ctrlTeams;
        viewPlayer.controlador = ctrlTeams;
        viewCoach.controlador = ctrlTeams;
        viewDoctor.controlador = ctrlTeams;
        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewCoach vc = new viewCoach();
        viewDoctor vd = new viewDoctor();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Entrar al menu de equipos");
                System.out.println("2. Entrar al menu  de Jugadores");
                System.out.println("3. Entrar al menu de  Entrenadores");
                System.out.println("4. Entrar al menu de  Medicos");
                System.out.println("5. Salir");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        vt.menuEquipo();
                        break;
                    case 2:
                        vp.menujugador();
                        break;
                    case 3:
                        vc.menuCoach();
                        break;
                    case 4:
                        vd.menuDoctor();
                        break;
                    default:
                        System.out.println(" opcion incorrecta intente nuevamente");
                        break;
                }

            }
        }
    }
}