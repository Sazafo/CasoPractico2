/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author sazaf
 */
public class Habitacion {
    
 public static void main(String[] args) {
        Hotel hotel = new Hotel(5, 10);
        hotel.modificarEstadoHabitacion(2, 3, "ocupada", 100.0);
        hotel.mostrarEstadoHotel();
    }
}
