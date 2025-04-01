package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonConstructorAndGetters() {
        Person person = new Person("Jan", "Kowalski", 1990);

        assertEquals("Jan", person.getFirstName());
        assertEquals("Kowalski", person.getLastName());
        assertEquals(1990, person.getYearOfBirth());
    }

    @Test
    void testPersonToString() {
        Person person = new Person("Anna", "Nowak", 1985);
        assertEquals("Anna Nowak (1985)", person.toString());
    }
}

