package org.medicare.model;

import java.util.Objects;

public class Medico {

    private final String codigoMedico;
    private final String nombre;
    private final String especialidad;
    private int contadorConsultas;

    public Medico(String codigoMedico, String nombre, String especialidad) {
        if (codigoMedico == null || codigoMedico.isBlank()) {
            throw new IllegalArgumentException("El código de médico no puede ser nulo ni vacío.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede ser nula ni vacía.");
        }
        this.codigoMedico = codigoMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ConsultaMedica registrarConsulta(
            Paciente paciente, String diagnostico, String medicamento, double costo) {
        Objects.requireNonNull(paciente, "El paciente no puede ser nulo.");
        contadorConsultas++;
        String codigoConsulta = String.format("C%03d", contadorConsultas);
        return new ConsultaMedica(codigoConsulta, diagnostico, medicamento, costo, paciente);
    }
}
