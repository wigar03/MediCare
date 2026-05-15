package org.medicare.model;

public class Paciente {

    private final String numeroCedula;
    private String nombre;
    private int edad;
    private double saldoPendiente;

    public Paciente(String numeroCedula, String nombre, int edad, double saldoPendiente) {
        if (numeroCedula == null || numeroCedula.isBlank()) {
            throw new IllegalArgumentException("El número de cédula no puede ser nulo ni vacío.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        validarEdad(edad);
        if (saldoPendiente < 0) {
            throw new IllegalArgumentException("El saldo pendiente no puede ser negativo.");
        }
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.edad = edad;
        this.saldoPendiente = saldoPendiente;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    public void realizarPago(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del pago debe ser mayor que cero.");
        }
        if (monto > saldoPendiente) {
            throw new IllegalArgumentException(
                    "El pago (" + monto + ") supera el saldo pendiente (" + saldoPendiente + ").");
        }
        saldoPendiente -= monto;
    }

    private static void validarEdad(int edad) {
        if (edad <= 0 || edad >= 130) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0 y menor que 130.");
        }
    }
}
