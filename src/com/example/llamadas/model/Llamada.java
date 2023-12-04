package com.example.llamadas.model;

public class Llamada {

    private String dni;
    private String nombres;
    private String tipoPlan;
    private String tipoLlamada;
    private Integer minutos;

    public Llamada(String dni, String nombres, String tipoPlan, String tipoLlamada, Integer minutos) {
        this.dni = dni;
        this.nombres = nombres;
        this.tipoPlan = tipoPlan;
        this.tipoLlamada = tipoLlamada;
        this.minutos = minutos;
    }

    public Double costoMinuto() {
        switch (tipoPlan) {
            case "A" -> {
                switch (tipoLlamada) {
                    case "L" -> {
                        return 0.2d;
                    }
                    case "C" -> {
                        return 0.4d;
                    }
                }
            }
            case "B" -> {
                switch (tipoLlamada) {
                    case "L" -> {
                        return 0.15d;
                    }
                    case "C" -> {
                        return 0.3d;
                    }
                }
            }
        }
        return null;
    }

    public Double costoLlamada() {
        return minutos * costoMinuto();
    }

    public Double pagoFinal() {
        return 1.18 * costoLlamada();
    }

    @Override
    public String toString() {
        return String.format(
                "DNI: %s - Nombres: %s\nPlan: %s - Tipo de llamada: %s\nMinutos: %d\nCosto por minuto: %.2f\nCosto por llamada: %.2f\nPago final: %.2f"
                , dni,nombres,tipoPlan, tipoLlamada, minutos,
                costoMinuto(),costoLlamada(),pagoFinal());
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

}
