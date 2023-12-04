package com.example.llamadas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    /**
     * Valida que un documento ingresado solo posee dígitos
     *
     * @param documento el número de documento a validar
     * @param cantidad la cantidad de dígitos que debe tener
     * @return retorna el documento si cumple con lo establecido sino devuelve
     * un valor null
     */
    public static String validarDoc(String documento, int cantidad) {
        Matcher matcher = Pattern.compile(String.format("[\\d+]{%d}", cantidad)).matcher(documento);
        return matcher.matches() ? null : "Dni no es valido";
    }

    /**
     * Valida que un nombre ingresado solo posee letras
     *
     * @param nombre el nombre a validar
     * @return retorna null si cumple con lo establecido sino devuelve
     * el nombre del valor incorrecto
     */
    public static String validarNombre(String nombre) {
        Matcher matcher = Pattern.compile("^[a-zA-Z\\s]+$").matcher(nombre);
        return matcher.matches() ? null : "Nombre no es valido";
    }

    /**
     * Valida que el tipo de plan sean 'A' o 'B'
     * @param tipoPlan el tipo de plan a validar
     * @return retorna null si cumple con lo establecido sino devuelve
     * el nombre del valor incorrecto
     */
    public static String validarTipoPlan(String tipoPlan) {
        return tipoPlan.matches("[AB]") ? null : "Tipo de plan no es valido";
    }

    /**
     * Valida que el tipo de lamada sean 'L' o 'C'
     * @param tipoLlamada el tipo de plan a validar
     * @return retorna null si cumple con lo establecido sino devuelve
     * el nombre del valor incorrecto
     */
    public static String validarTipoLlamada(String tipoLlamada) {
        return tipoLlamada.matches("[LC]") ? null : "Tipo de llamada no es valido";
    }

    /**
     * Valida que los minutos sean mayores o iguales a al minimo
     * @param minutos el numero de minitos a validar
     * @param minimo el minimo de monutos que debe haber
     * @return retorna null si cumple con lo establecido sino devuelve
     * el nombre del valor incorrecto
     */
    public static String validarMinutos(Integer minutos, Integer minimo) {
        String minutosStr = Integer.toString(minutos);
        return minutosStr.matches(String.format("^(?:%d|[1-9]\\d*)$", minimo)) ? null : "Minutos no es valido";
    }

    /**
     * Valida que todos los campos de la clase llamada sean validos.
     * @param dni el numero de minitos a validar
     * @param nombre el nombre a validar
     * @param tipoPlan el tipo de plan a validar ('A' o 'B')
     * @param tipoLlamada el tipo de llamada a validar ('L' o 'C')
     * @param minutos el numero de minutos a validar
     * @return retorna null si cumple con lo establecido sino devuelve
     * un estrin indicando que campos son incorrectos
     */
    public static String verificarCampos(String dni, String nombre, String tipoPlan, String tipoLlamada, Integer minutos){
        String dniVal, nombreVal, tipoPlanVal, tipoLlamadaVal, minutosVal;
        dniVal = validarDoc(dni, 8);
        nombreVal = validarNombre(nombre);
        tipoPlanVal = validarTipoPlan(tipoPlan);
        tipoLlamadaVal = validarTipoLlamada(tipoLlamada);
        minutosVal = validarMinutos(minutos, 0);

        if (dniVal == null && nombreVal == null && tipoPlanVal == null && tipoLlamadaVal == null && minutosVal == null) {
            return null;
        } else {
            String errorString = String.format("ERROR: %s%s%s%s%s", dniVal != null ? dniVal + ", " : "", nombreVal != null ? nombreVal + ", " : "",  tipoPlanVal != null ? tipoPlanVal + ", " : "", tipoLlamadaVal != null ? tipoLlamadaVal + ", " : "", minutosVal != null ? minutosVal + ", " : "");
            return errorString.substring(0, errorString.length() - 2) + ".";
        }
    }
}