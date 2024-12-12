/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionhotelera;

/**
 *
 * @author sazaf
 */
public class Habitaciones {
     int numero;
        String categoria;
        String costo;
        String estado;

    

    public Habitacion(int numero, String categoria, String costo, String estado) {
        this.numero = numero;
        this.categoria = definirCategoria(numero);
        this.costo = definirCosto(numero);
        this.estado = estado;
    }

    public String definirCategoria(int numero) {
        if (numero <= 10) {
            return "Simple";
        } else if (numero <= 20) {
            return "Doble";
        } else {
            return "Suite";
        }
    }

    public String definirCosto(int numero) {
        if (numero <= 10) {
            return "$20";
        } else if (numero <= 20) {
            return "$25";
        } else {
            return "$30";
        }
    
