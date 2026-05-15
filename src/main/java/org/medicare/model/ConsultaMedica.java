package org.medicare.model;

import java.util.Objects;

public class ConsultaMedica {

    private final String codigoConsulta;
    private final String diagnostico;
    private final String medicamento;
    private double costo;
    private final Paciente paciente;

    public ConsultaMedica(
            String codigoConsulta,
            String diagnostico,
            String medicamento,
            double costo,
            Paciente paciente) {
        if (codigoConsulta == null || codigoConsulta.isBlank()) {
            throw new IllegalArgumentException("El código de consulta no puede ser nulo ni vacío.");
        }
        if (diagnostico == null || diagnostico.isBlank()) {
            throw new IllegalArgumentException("El diagnóstico no puede ser nulo ni vacío.");
        }
        if (medicamento == null || medicamento.isBlank()) {
            throw new IllegalArgumentException("El medicamento no puede ser nulo ni vacío.");
        }
        validarCosto(costo);
        this.codigoConsulta = codigoConsulta;
        this.diagnostico = diagnostico;
        this.medicamento = medicamento;
        this.costo = costo;
        this.paciente = Objects.requireNonNull(paciente, "El paciente no puede ser nulo.");
    }

    public String getCodigoConsulta() {
        return codigoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public double getCosto() {
        return costo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setCosto(double costo) {
        validarCosto(costo);
        this.costo = costo;
    }

    public void mostrarResumen() {
        System.out.println("--- Resumen de consulta ---");
        System.out.println("Código: " + codigoConsulta);
        System.out.println("Paciente: " + paciente.getNombre() + " (" + paciente.getNumeroCedula() + ")");
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Medicamento: " + medicamento);
        System.out.println("Costo: $" + String.format("%.2f", costo));
        System.out.println("---------------------------");
    }

    private static void validarCosto(double costo) {
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor que cero.");
        }
    }
}
