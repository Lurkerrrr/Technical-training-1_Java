package com.example.demo;

public class Person {
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getYearOfBirth() { return yearOfBirth; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + yearOfBirth + ")";
    }
}

