package org.ejercicio.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    List<Person> personList = new ArrayList<>();
    Person p1 = new Person("juan",26,"Male");
    Person p2 = new Person("Javi",25,"Male");
    Person p3 = new Person("Ana",27,"Female");
    Person p4 = new Person("Antonia",29,"Female");
    Person p5 = new Person("Antonioo",-3,"Female");


    @BeforeEach
    void setup(){

    }

    @AfterEach
    void shutdown(){

    }

    @Test
    void ResultadoMediaTest(){
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        double[] obtainMaleValue = Person.averageAgePerGender(personList);
        double[] expectedValue = {25.5, 28};
        assertArrayEquals(expectedValue, obtainMaleValue);
    }

    @Test
    void ResultadoMediaUnaPersonaPorGenderTest(){
        personList.add(p2);
        personList.add(p4);
        double[] obtainMaleValue = Person.averageAgePerGender(personList);
        double[] expectedValue = {25, 29};
        assertArrayEquals(expectedValue, obtainMaleValue);
    }

    @Test
   /** void yigetest(){
        personList.add(p2);
        personList.add(p4);
        double[] obtainMaleValue = Person.averageAgePerGender(personList);
        double[] expectedValue = {25, 29};
        assertArrayEquals(expectedValue, obtainMaleValue);
    }*/

    /*void negativeTest(){
        personList.add(p2);
        personList.add(p5);
        double[] obtainMaleValue = Person.averageAgePerGender(personList);
        double[] expectedValue = {25, 29};
        assertArrayEquals(expectedValue, obtainMaleValue);


    }*/

    void NegativeAgeTest(){
        assertThrows(NegativeValueException.class, () -> new Person("juan ",-1,"Male"));
    }


}