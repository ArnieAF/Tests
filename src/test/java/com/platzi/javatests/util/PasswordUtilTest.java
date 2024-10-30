package com.platzi.javatests.util;

import org.junit.jupiter.api.Test;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(WEAK,PasswordUtil.assesPassword("14a!7"));
    }
    @Test
    public void weak_when_has_only_letters(){
        assertEquals(WEAK,PasswordUtil.assesPassword("abcdefghijk"));
    }
    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(MEDIUM,PasswordUtil.assesPassword("abcd1234"));
    }
    @Test
    public void medium_when_has_letters_numbers_and_symbols(){
        assertEquals(STRONG,PasswordUtil.assesPassword("abcd1234!"));
    }
}