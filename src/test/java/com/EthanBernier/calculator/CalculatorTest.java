package com.EthanBernier.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    public void devrait_retourner_la_somme_de_deux_entiers_positif(int a, int b, int result) {

        //GIVEN

        //WHEN
        int resultat = Calculator.add(a,b);

        //THEN
        assertThat(resultat).isEqualTo(result);

    }

    @Test
    public void devrait_retourner_le_quotient_de_deux_entiers_positif(){

        //GIVEN
        int a = 5;
        int b = 5;

        //WHEN
        int resultat = Calculator.divide(a,b);

        //THEN
        assertThat(resultat).isEqualTo(1);

    }

    @Test
    public void devrait_lever_une_exception_si_la_somme_est_trop_grande(){

        //GIVEN
        int a = Integer.MAX_VALUE; // plus grand int possible : 2147483647
        int b = 1;

        //WHEN / THEN
        assertThatThrownBy(() -> Calculator.add(a, b))
                .isInstanceOf(ArithmeticException.class);

    }

    @Test
    public void devrait_lever_une_exception_lors_d_une_division_par_zero(){

        //GIVEN
        int a = 5;
        int b = 0;

        //WHEN / THEN
        assertThatThrownBy(() -> Calculator.divide(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Division par zéro impossible");

    }

    @Test
    public void devrait_retourner_l_ensemble_des_chiffres_d_un_nombre_avec_doublon(){

        //GIVEN
        Calculator calculator = new Calculator();
        int nombre = 7679;

        //WHEN
        Set<Integer> resultat = calculator.ensembleChiffres(nombre);

        //THEN
        assertThat(resultat).isEqualTo(Set.of(6, 7, 9));

    }

    @Test
    public void devrait_ignorer_le_signe_d_un_nombre_negatif(){

        //GIVEN
        Calculator calculator = new Calculator();
        int nombre = -11;

        //WHEN
        Set<Integer> resultat = calculator.ensembleChiffres(nombre);

        //THEN
        assertThat(resultat).isEqualTo(Set.of(1));

    }

    @Test
    public void devrait_retourner_zero_pour_le_nombre_zero(){

        //GIVEN
        Calculator calculator = new Calculator();
        int nombre = 0;

        //WHEN
        Set<Integer> resultat = calculator.ensembleChiffres(nombre);

        //THEN
        assertThat(resultat).isEqualTo(Set.of(0));

    }

    @Test
    public void devrait_gerer_le_plus_petit_entier_negatif(){

        //GIVEN
        Calculator calculator = new Calculator();
        int nombre = Integer.MIN_VALUE; // -2147483648

        //WHEN
        Set<Integer> resultat = calculator.ensembleChiffres(nombre);

        //THEN
        assertThat(resultat).isEqualTo(Set.of(2, 1, 4, 7, 8, 3, 6));

    }

}
