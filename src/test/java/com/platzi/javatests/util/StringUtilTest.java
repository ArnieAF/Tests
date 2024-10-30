package com.platzi.javatests.util;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class StringUtilTest {

    @Test
    public void repeat_string_once(){

        Assertions.assertEquals("hola",StringUtil.repeat("hola",1));

    }
    @Test
    public void repeat_string_multiple_times(){

        Assertions.assertEquals("holaholahola",StringUtil.repeat("hola",3));

    }
    @Test
    public void repeat_string_zero_times(){

        Assertions.assertEquals("",StringUtil.repeat("hola",0));

    }
    @Test
    public void repeat_string_negative_times(){

        Assertions.assertThrows(IllegalArgumentException.class,()->StringUtil.repeat("Hola",-3));

    }

    @Test
    public void string_is_not_empty() {
        Assertions.assertFalse(StringUtil.isEmpty("caca"));
    }

    @Test
    public void string_is_empty_when_expected_is_doble_comilla(){
        Assertions.assertTrue(StringUtil.isEmpty(""));
    }
    @Test
    public void when_string_is_null_is_empty(){
        Assertions.assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void when_string_is_empty_comillas_con_espacio(){
        Assertions.assertTrue(StringUtil.isEmpty(" "));
    }
}