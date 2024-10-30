package com.platzi.javatests.fizzbuzz;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void if_number_is_divisible_by_3_return_Fizz(){
        assertThat(FizzBuzz.fizzBuzz(6),is("Fizz"));
    }

    @Test
    void if_number_is_divisible_by_5_return_Buzz() {
        assertThat(FizzBuzz.fizzBuzz(10),is("Buzz"));
    }

    @Test
    void if_number_is_divisible_by_5_and_3_return_FizzBuzz() {
        assertThat(FizzBuzz.fizzBuzz(30),is("FizzBuzz"));
    }

    @Test
    void if_number_is_divisible_by_another_number_return_same_number() {
        assertThat(FizzBuzz.fizzBuzz(2),is("2"));
    }
}