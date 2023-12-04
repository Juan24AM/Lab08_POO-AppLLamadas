package com.example.llamadas.test;

import com.example.llamadas.model.Llamada;
import com.example.llamadas.util.Validator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestLlamada {
    public static void main(String[] args) {
        String dni, nom, tipPlan, tipLlamada;

        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor ingresa tu dni: "); dni = sc.nextLine();
        System.out.print("Por favor ingresa tu nombre: "); nom = sc.nextLine();
        System.out.print("Por favor ingresa tu tipo de plan ('A' o 'B'): "); tipPlan  = sc.nextLine().toUpperCase();
        System.out.print("Por favor ingresa tu tipo de llamada ('L' o 'C'): "); tipLlamada  = sc.nextLine().toUpperCase();
        System.out.print("Por favor ingresa tus minutos de llamada: "); Integer min = sc.nextInt();

        System.out.println();

        String isValid = Validator.verificarCampos(dni, nom, tipPlan, tipLlamada, min);
        if (isValid != null) {
            System.out.println(isValid);
            return;
        } else {
            Llamada l1 = new Llamada(
                    dni,
                    nom,
                    tipPlan,
                    tipLlamada,
                    min
            );
            System.out.println(l1);
        }
    }

}
