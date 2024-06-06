package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService service = new PersonService();

        // Adăugare persoane
        Person p1 = new Person("John Doe", 25);
        Person p2 = new Person("Jane Doe", 30);

        service.addPerson(p1);
        service.addPerson(p2);

        // Afișare toate persoanele
        List<Person> allPersons = service.getAllPersons();
        System.out.println("Toate persoanele: ");
        for (Person person : allPersons) {
            System.out.println(person.getId() + ": " + person.getName() + ", " + person.getAge() + " ani");
        }

        // Afișare persoane mai în vârstă de 26 de ani
        List<Person> olderPersons = service.getPersonsOlderThan(26);
        System.out.println("\nPersoane mai în vârstă de 26 de ani: ");
        for (Person person : olderPersons) {
            System.out.println(person.getId() + ": " + person.getName() + ", " + person.getAge() + " ani");
        }

        // Afișare toate numele
        List<String> allNames = service.getAllPersonNames();
        System.out.println("\nToate numele: ");
        for (String name : allNames) {
            System.out.println(name);
        }

        // Căutare persoană după nume
        String searchName = "Jane Doe";
        try {
            Person foundPerson = service.getPerson(searchName);
            System.out.println("\nPersoana găsită: " + foundPerson.getId() + ": " + foundPerson.getName() + ", " + foundPerson.getAge() + " ani");
        } catch (IllegalArgumentException e) {
            System.out.println("\nPersoana cu numele " + searchName + " nu a fost găsită.");
        }

        // Căutare persoană după ID
        int searchId = 1;
        try {
            Person foundPersonById = service.getPersonById(searchId);
            System.out.println("\nPersoana găsită după ID: " + foundPersonById.getId() + ": " + foundPersonById.getName() + ", " + foundPersonById.getAge() + " ani");
        } catch (IllegalArgumentException e) {
            System.out.println("\nPersoana cu ID-ul " + searchId + " nu a fost găsită.");
        }
    }
}