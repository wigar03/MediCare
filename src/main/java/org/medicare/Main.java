package org.medicare;

import org.medicare.model.ConsultaMedica;
import org.medicare.model.Medico;
import org.medicare.model.Paciente;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("=== Clínica MediCare — Demostración ===\n");

        Medico medico = new Medico("M001", "Dr. Carlos Ruiz", "Medicina General");
        Paciente paciente = new Paciente("001-230456-0012X", "Ana López", 34, 150.00);

        System.out.println("Médico: " + medico.getNombre() + " (" + medico.getCodigoMedico() + ") — "
                + medico.getEspecialidad());
        System.out.println("Paciente: " + paciente.getNombre() + ", edad " + paciente.getEdad()
                + ", saldo pendiente $" + String.format("%.2f", paciente.getSaldoPendiente()));
        System.out.println();

        ConsultaMedica consulta = medico.registrarConsulta(
                paciente,
                "Hipertensión leve",
                "Enalapril 10mg",
                80.00);

        consulta.mostrarResumen();

        System.out.println("Ana realiza un pago de $80.00 para cubrir la consulta.");
        try {
            paciente.realizarPago(80.00);
            System.out.println("Pago registrado. Saldo pendiente: $"
                    + String.format("%.2f", paciente.getSaldoPendiente()));
        } catch (IllegalArgumentException e) {
            System.err.println("Error al registrar pago: " + e.getMessage());
        }

        System.out.println("\n--- Pruebas de validación (try-catch) ---\n");

        System.out.println("Intento: paciente.setEdad(-5)");
        try {
            paciente.setEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\nIntento: consulta.setCosto(-100)");
        try {
            consulta.setCosto(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\nIntento: paciente.realizarPago(9999)");
        try {
            paciente.realizarPago(9999);
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        System.out.println("\n=== Fin de la demostración ===");
    }
}
