/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionhotelera;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author sazaf
 */
public class Gestionhotelera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Vector<Habitacion> habitaciones = new Vector<>();
        Vector<Integer> ocupadas = new Vector<>();
        Vector<Integer> disponibles = new Vector<>();

        for (int i = 0; i < 25; i++) {
            int numero = i + 1;
            String categoria = null;
            String costo = null;
            String estado = "disponible";  // disponible, ocupada y limpieza

            Habitacion habitacion = new Habitacion(numero, categoria, costo, estado);
            habitaciones.add(habitacion);
            disponibles.add(habitacion.numero);
        }

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Selecciona una opción: \n\n1. Reservar\n2. Actualizar\n3. Resumen\n4. Ingresos\n5. Ver listado\n"
            );

            if (opcion == null || !opcion.matches("[1-5]")) {
                break;
            }

            switch (opcion) {
                case "1" -> {
                    int reserva = Integer.parseInt(JOptionPane.showInputDialog("Indica el número de habitación a reservar: "));
                    for (int i = 0; i < disponibles.size(); i++) {
                        if (disponibles.get(i) == reserva) {
                            ocupadas.add(reserva);
                            disponibles.remove((Integer) reserva);
                            JOptionPane.showMessageDialog(null, "Habitación reservada: " + reserva);
                            break;
                        }
                    }
                }
                case "2" -> {
                    int habitacionActualizar = Integer.parseInt(JOptionPane.showInputDialog("Número de habitación a actualizar: "));
                    for (int i = 0; i < habitaciones.size(); i++) {
                        if (habitaciones.get(i).numero == habitacionActualizar) {
                            String nuevoEstado = JOptionPane.showInputDialog("Nuevo estado de la habitación: ");
                            habitaciones.get(i).estado = nuevoEstado;
                            JOptionPane.showMessageDialog(null, "Estado actualizado: " + habitaciones.get(i).estado);
                            break;
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Habitaciones ocupadas: " + ocupadas);
                    System.out.println("Habitaciones disponibles: " + disponibles);
                    System.out.println("Las demás habitaciones están en limpieza.");
                    break;
                }
                case "4" -> {
                    int simples = 0;
                    int dobles = 0;
                    int suites = 0;

                    for (int i = 0; i < ocupadas.size(); i++) {
                        if (ocupadas.get(i) <= 10) {
                            simples++;
                        } else if (ocupadas.get(i) <= 20) {
                            dobles++;
                        } else {
                            suites++;
                        }
                    }

                    int totalSimples = simples * 20;
                    int totalDobles = dobles * 25;
                    int totalSuites = suites * 30;
                    int totalIngresos = totalSimples + totalDobles + totalSuites;

                    System.out.println("Habitaciones simples: " + totalSimples);
                    System.out.println("Habitaciones dobles: " + totalDobles);
                    System.out.println("Suites: " + totalSuites);
                    System.out.println("Ingresos totales: " + totalIngresos);
                    break;
                }
                case "5" -> {
                    for (int i = 0; i < habitaciones.size(); i++) {
                        System.out.println(
                                "Número: " + habitaciones.get(i).numero
                                + ", Precio: " + habitaciones.get(i).costo
                                + ", Estado: " + habitaciones.get(i).estado
                                + ", Tipo: " + habitaciones.get(i).categoria
                        );
                    }
                }
            }
        }
    }

}
