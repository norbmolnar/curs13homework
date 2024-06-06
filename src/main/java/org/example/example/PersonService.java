package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(1);

    public Person addPerson(Person person) {
        if (person.getId() != null) {
            throw new IllegalArgumentException("Person ID must be null when adding a new person");
        }
        person.setId(idGenerator.getAndIncrement());
        persons.add(person);
        return person;
    }

    public Person removePerson(int id) {
        Optional<Person> person = persons.stream().filter(p -> p.getId() == id).findFirst();
        if (!person.isPresent()) {
            throw new IllegalArgumentException("Person with ID " + id + " not found");
        }
        persons.remove(person.get());
        return person.get();
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Age must be between 1 and 119");
        }
        return persons.stream().filter(p -> p.getAge() > age).collect(Collectors.toList());
    }

    public List<String> getAllPersonNames() {
        return persons.stream().map(Person::getName).collect(Collectors.toList());
    }

    public Person getPerson(String name) {
        return persons.stream().filter(p -> p.getName().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Person with name " + name + " not found"));
    }

    public Person getPersonById(int id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Person with ID " + id + " not found"));
    }
}
