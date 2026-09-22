package com.EthanBernier.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    private Calculator calculator;

    @AfterEach
    public void afterEach() {
        calculator =  null;
    }

    @Test
    public void devrait_retourner_la_somme_de_deux_entiers_positif(){

        //GIVEN
        int a = 5;
        int b = 5;

        //WHEN
        int resultat = calculator.add(a,b);

        //THEN
        assertThat(resultat).isEqualTo(10);

    }

    @Test
    public void devrait_retourner_le_quotient_de_deux_entiers_positif(){

        //GIVEN
        int a = 5;
        int b = 5;

        //WHEN
        int resultat = calculator.divide(a,b);

        //THEN
        assertThat(resultat).isEqualTo(1);

    }

}
