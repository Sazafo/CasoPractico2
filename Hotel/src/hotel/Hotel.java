/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sazaf
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
    private String[][] habitaciones;
    private int totalHabitaciones;
    private int habitacionesLibres;
    private int habitacionesOcupadas;
    private int habitacionesSucias;
    private double gananciasTotales;

    public Hotel(int pisos, int habitacionesPorPiso) {
        this.totalHabitaciones = pisos * habitacionesPorPiso;
        this.habitaciones = new String[pisos][habitacionesPorPiso];
        inicializarHabitaciones();
        this.habitacionesLibres = totalHabitaciones;
        this.habitacionesOcupadas = 0;
        this.habitacionesSucias = 0;
        this.gananciasTotales = 0.0;
    }

    private void inicializarHabitaciones() {
        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                habitaciones[i][j] = "libre";
            }
        }
    }

    public void mostrarEstadoHotel() {
        System.out.println("Resumen del estado del hotel:");
        System.out.println("Habitaciones libres: " + habitacionesLibres);
        System.out.println("Habitaciones ocupadas: " + habitacionesOcupadas);
        System.out.println("Habitaciones sucias: " + habitacionesSucias);
        System.out.println("Ganancias actuales: $" + gananciasTotales);
    }

    public void modificarEstadoHabitacion(int piso, int numeroHabitacion, String nuevoEstado, double precio) {
        if (piso < 0 || piso >= habitaciones.length || numeroHabitacion < 0 || numeroHabitacion >= habitaciones[piso].length) {
            System.out.println("Número de habitación inválido.");
            return;
        }
        String estadoActual = habitaciones[piso][numeroHabitacion];
        habitaciones[piso][numeroHabitacion] = nuevoEstado;

        switch (estadoActual) {
            case "libre":
                habitacionesLibres--;
                break;
            case "ocupada":
                habitacionesOcupadas--;
                gananciasTotales -= precio;
                break;
            case "sucia":
                habitacionesSucias--;
                break;
        }

        switch (nuevoEstado) {
            case "libre":
                habitacionesLibres++;
                break;
            case "ocupada":
                habitacionesOcupadas++;
                gananciasTotales += precio;
                break;
            case "sucia":
                habitacionesSucias++;
                break;
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel(5, 10);
        hotel.modificarEstadoHabitacion(2, 3, "ocupada", 100.0);
        hotel.mostrarEstadoHotel();
    }
}
      
        


        

    

