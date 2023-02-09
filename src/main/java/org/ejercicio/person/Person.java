package org.ejercicio.person;
import java.util.List;

/**
 * Class representing a person with a name, age and gender,
 *
 * @author longxiang
 */
public class Person {

    private final String name;
    private final int age;
    private final String gender; //Male, Female

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in an
     * array of two elements (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Person> persons){
        double averageAgeOfMale = 0;
        int maleCounts = 0;
        double averageAgeOfFemale = 0;
        int femaleCounts = 0;
        double[] averageResults = new double[2];
        for(Person p : persons){
            if(p.gender.equals("Male")){
                averageAgeOfMale += p.age;
                maleCounts++;
            }else {
                averageAgeOfFemale += p.age;
                femaleCounts++;
            }
        }

        averageResults[0] = averageAgeOfMale/maleCounts;
        averageResults[1] = averageAgeOfFemale/femaleCounts;

        return averageResults;
    }


}
