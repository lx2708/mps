package org.ejercicio.person;

import org.junit.jupiter.api.*;

import javax.security.auth.Destroyable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    //Declaracion de la lista usada y los objecto usado para facilitar mis tests.
    List<Person> personList;
    Person p1;
    Person p2;
    Person p3;
    Person p4;
  //  Person p5;


    @BeforeEach
    //Inicialiazar la lista ante de cada test
    void setup(){
        personList = new ArrayList<>();
    }

    @AfterEach
    //Asignar a null a cada lista despues de cada test para
        // dejarselo a cargo al recolector de basura de Java.
    void shutdown(){
        personList = null;
    }

    @BeforeAll
    //Ante de empezar todos los test inicializa los objetos que van a ser utilizados
    void initObject(){
        p1 = new Person("Juan",26,"Male");
        p2 = new Person("Javi",25,"Male");
        p3 = new Person("Ana",27,"Female");
        p4 = new Person("Antonia",29,"Female");
    }

    @AfterAll
    //Despues de terminar todos los test asigno null a todos los objetos
    //para dejarselo a cargo al recolector de basura de Java.
    void deleteAll(){
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;

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
    void NegativeAgeTest(){
        assertThrows(NegativeValueException.class, () -> new Person("juan ",-1,"Male"));
    }

    @Test
    void GenderValueMaleTest(){
        assertThrows(ErrorGenderValueException.class, () -> new Person("juan ",20,"hi"));
    }

    @Test
    void GenderValueFemaleTest(){
        assertThrows(ErrorGenderValueException.class, () -> new Person("juan ",20,"hi"));
    }

    @Test
    void GenderValueMaleFemaleTest(){
        assertThrows(ErrorGenderValueException.class, () -> new Person("juan ",20,"MaleFemale"));
    }

    @Test
    void GenderUpperCaseMaleTest(){
        assertThrows(ErrorGenderValueException.class, () -> new Person("juan ",20,"MALE"));
    }

    @Test
    void GenderLowerCaseMaleTest(){
        assertThrows(ErrorGenderValueException.class, () -> new Person("juan ",20,"male"));
    }





}