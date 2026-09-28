package com.EthanBernier.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {


    public static int add(int a, int b) {
        // Si la somme est trop grande pour un int, Math.addExact lève une ArithmeticException
        // (avec "a + b", le résultat serait faux sans aucune erreur)
        return Math.addExact(a, b);
    }

    public static int divide(int a, int b) {
        // On ne peut pas diviser par zéro
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Retourne l'ensemble (non ordonné, sans doublon) des chiffres composant pNombre.
     * Exemple : 7679 -> {6, 7, 9} ; -11 -> {1}
     */
    public Set<Integer> ensembleChiffres(int pNombre){

        // Un Set n'accepte pas les doublons : chaque chiffre n'y sera présent qu'une fois
        Set<Integer> chiffres = new HashSet<>();

        // On convertit le nombre en String pour pouvoir le parcourir caractère par caractère
        // (ex : 7679 -> "7679", -11 -> "-11")
        String nombre = String.valueOf(pNombre);

        for (char caractere : nombre.toCharArray()) {

            // On ignore le signe '-' des nombres négatifs
            if (caractere == '-') {
                continue;
            }

            // Conversion du caractère en chiffre : '7' - '0' = 7
            // (les caractères '0' à '9' se suivent dans la table ASCII)
            chiffres.add(caractere - '0');
        }

        return chiffres;
    }


}
