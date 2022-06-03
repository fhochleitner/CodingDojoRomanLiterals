package com.gepardec.dojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class RomanNumeralsTest {

    private RomanNumerals numerals;

    @Before
    public void setup(){
        numerals = new RomanNumerals();
    }

    @Test
    public void sanity(){
        assertTrue(true);
    }

    @Test
    public void test1_singleRomanCharacterTransformation(){
        assertEquals(10, numerals.transformRomanToArab("X"));
    }

    @Test
    public void test2_twoCharacterTransformationSimple() {
        assertEquals(6, numerals.transformRomanToArab("VI"));
    }

    @Test
    public void test3_threeCharacterTransformationSimple() {
        assertEquals(3, numerals.transformRomanToArab("III"));
    }

    @Test
    public void test4_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(4, numerals.transformRomanToArab("IV"));
    }

    @Test
    public void test5_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(9, numerals.transformRomanToArab("IX"));
    }

    @Test
    public void test6_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(40, numerals.transformRomanToArab("XL"));
    }

    @Test
    public void test7_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(90, numerals.transformRomanToArab("XC"));
    }

    @Test
    public void test8_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(400, numerals.transformRomanToArab("CD"));
    }

    @Test
    public void test9_twoCharacterTransformationsSimpleSubtraction() {
        assertEquals(900, numerals.transformRomanToArab("CM"));
    }

    @Test
    public void test10_threeCharacterTransformationsSimpleSubtraction() {
        assertEquals(109, numerals.transformRomanToArab("CIX"));
    }

    @Test
    public void test11_charactersTransformationsSimpleSubtraction() {
        assertEquals(3589, numerals.transformRomanToArab("MMMDLXXXIX"));
    }

    @Test
    public void test12_charactersTransformationsSimpleSubtraction() {
        assertEquals(137, numerals.transformRomanToArab("CXXXVII"));
    }

    @Test
    public void test13_charactersTransformationsSimpleSubtraction() {
        assertEquals(3999, numerals.transformRomanToArab("MMMCMXCIX"));
    }

    @Test
    public void test14_charactersTransformationNotNull() {
        assertEquals(0, numerals.transformRomanToArab(null));
    }

    @Test
    public void test15_charactersTransformationIllegalChar() {
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("w"));
    }

    @Test
    public void test16_charactersTransformationInput() {
        assertEquals(1, numerals.transformRomanToArab("i"));
    }

    @Test
    public void test16_illegalCountOfCharactersInRow() {
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("IIII"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("VVVV"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("XXXX"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("CCCC"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("DDDD"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("MMMM"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("MMMMM"));
    }

    @Test
    public void test17_illegalSequenceOfCharactersInRomanLiteral(){
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("IC"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("XM"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("ID"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("VC"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("LD"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("LM"));
        assertThrows("Ist kein gültiger römischer Buchstabe für eine Zahl", IllegalArgumentException.class, () -> numerals.transformRomanToArab("IXC"));
    }

    @Test
    public void test18_checkSpaceIsValidNumber(){
        assertEquals(3, numerals.transformRomanToArab("I I I"));
    }

}