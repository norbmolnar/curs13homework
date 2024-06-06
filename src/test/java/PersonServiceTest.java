package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class PersonServiceTest {
    private PersonService service;

    @Before
    public void setUp() {
        service = new PersonService();
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("John Doe", 25);
        Person addedPerson = service.addPerson(person);
        assertNotNull(addedPerson.getId());
        assertEquals("John Doe", addedPerson.getName());
        assertEquals(25, addedPerson.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonWithId() {
        Person person = new Person("John Doe", 25);
        person.setId(1);
        service.addPerson(person);
    }

    @Test
    public void testRemovePerson() {
        Person person = new Person("John Doe", 25);
        Person addedPerson = service.addPerson(person);
        Person removedPerson = service.removePerson(addedPerson.getId());
        assertEquals(addedPerson.getId(), removedPerson.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePersonNonExistent() {
        service.removePerson(999);
    }

    @Test
    public void testGetAllPersons() {
        service.addPerson(new Person("John Doe", 25));
        service.addPerson(new Person("Jane Doe", 30));
        List<Person> persons = service.getAllPersons();
        assertEquals(2, persons.size());
    }

    @Test
    public void testGetPersonsOlderThan() {
        service.addPerson(new Person("John Doe", 25));
        service.addPerson(new Person("Jane Doe", 30));
        List<Person> persons = service.getPersonsOlderThan(26);
        assertEquals(1, persons.size());
        assertEquals("Jane Doe", persons.get(0).getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPersonsOlderThanInvalidAge() {
        service.getPersonsOlderThan(120);
    }

    @Test
    public void testGetAllPersonNames() {
        service.addPerson(new Person("John Doe", 25));
        service.addPerson(new Person("Jane Doe", 30));
        List<String> names = service.getAllPersonNames();
        assertEquals(2, names.size());
        assertTrue(names.contains("John Doe"));
        assertTrue(names.contains("Jane Doe"));
    }

    @Test
    public void testGetPersonByName() {
        service.addPerson(new Person("John Doe", 25));
        Person person = service.getPerson("John Doe");
        assertNotNull(person);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPersonByNameNonExistent() {
        service.getPerson("Non Existent");
    }

    @Test
    public void testGetPersonById() {
        Person addedPerson = service.addPerson(new Person("John Doe", 25));
        Person person = service.getPersonById(addedPerson.getId());
        assertNotNull(person);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPersonByIdNonExistent() {
        service.getPersonById(999);
    }
}
