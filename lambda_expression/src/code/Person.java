package code;

import java.util.Objects;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private Sex gender;
    private String emailAddress;
    private int age;

    public Person(String name, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && gender == person.gender && Objects.equals(emailAddress, person.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, emailAddress, age);
    }
}