package com.EthanBernier.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {


    /**
     * Retourne la somme de a et b.
     * @throws ArithmeticException si le résultat dépasse la capacité d'un int
     */
    public static int add(int a, int b) {
        // Avec "a + b", un dépassement passe inaperçu : Integer.MAX_VALUE + 1 donne Integer.MIN_VALUE.
        // Math.addExact lève une ArithmeticException au lieu de renvoyer un résultat faux.
        return Math.addExact(a, b);
    }

    /**
     * Retourne le quotient entier de a par b.
     * @throws ArithmeticException si b vaut 0, ou si le résultat dépasse la capacité d'un int
     */
    public static int divide(int a, int b) {

        // Division par zéro : on lève l'exception nous-mêmes avec un message explicite
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }

        // Seul cas de dépassement : Integer.MIN_VALUE / -1 vaudrait 2147483648,
        // qui ne tient pas dans un int (Java renverrait Integer.MIN_VALUE sans erreur)
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("Dépassement de capacité");
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
