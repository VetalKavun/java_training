package code;

import java.util.ArrayList;
import java.util.List;

public class LambdaFirstTestMain {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("name1", Person.Sex.MALE, "email_1", 23));
        personList.add(new Person("name2", Person.Sex.FEMALE, "email_2", 34));
        personList.add(new Person("name3", Person.Sex.MALE, "email_3", 12));
        personList.add(new Person("name4", Person.Sex.FEMALE, "email_4", 2));
        personList.add(new Person("name5", Person.Sex.MALE, "email_5", 22));
        personList.add(new Person("name6", Person.Sex.FEMALE, "email_6", 59));
        personList.add(new Person("name7", Person.Sex.FEMALE, "email_7", 21));
        personList.add(new Person("name8", Person.Sex.MALE, "email_8", 19));
        personList.add(new Person("name9", Person.Sex.FEMALE, "email_9", 29));
        personList.add(new Person("name10", Person.Sex.FEMALE, "email_10", 55));
        personList.add(new Person("name11", Person.Sex.MALE, "email_11", 35));
        personList.add(new Person("name12", Person.Sex.FEMALE, "email_12", 3));

        printPersonOlderThan(personList, 13);
        System.out.println("--------------------");
        printPersonWithinAgeRange(personList, 14, 45);
        System.out.println("--------------------");
        printPersons(personList, new CheckPersonEligibleForSelectiveService());
        System.out.println("--------------------");

        //Approach 4: Specify Search Criteria Code in an Anonymous Class
        printPersons(personList, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() >= 18 &&
                        person.getAge() <= 30;
            }
        });
        System.out.println("-----------------");

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        printPersons(personList, (Person person) ->
            person.getGender() == Person.Sex.MALE &&
                    person.getAge() >= 20 &&
                    person.getAge() <= 70
        );
    }

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public static void printPersonOlderThan(List<Person> personList, int age){
        for(Person person : personList){
            if(person.getAge() > age){
                person.printPerson();
            }
        }
    }

    //Approach 2: Create More Generalized Search Methods
    public static void printPersonWithinAgeRange(List<Person> personList, int low, int high){
        for(Person person : personList){
            if(person.getAge() > low && person.getAge() <= high){
                person.printPerson();
            }
        }
    }

    //Approach 3: Specify Search Criteria Code in a Local Class
    public static void printPersons(List<Person> personList, CheckPerson tester){
        for(Person person : personList){
            if(tester.test(person)){
                person.printPerson();
            }
        }
    }


}
