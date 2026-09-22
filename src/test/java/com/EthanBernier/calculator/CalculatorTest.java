package com.EthanBernier.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}
