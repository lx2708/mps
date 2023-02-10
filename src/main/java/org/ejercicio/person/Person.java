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
        if(age < 0){
            throw new NegativeValueException("The age of " + name + "is negative.");
        }
        this.age = age;
        if((!gender.equals("Male")) && (!gender.equals("Female"))){
            throw new ErrorGenderValueException("The gender of " + name + "is incorrect");
        }
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
    public static double[] averageAgePerGender(List<Person> persons){
        double sumAgeOfMale = 0;
        int maleCounts = 0;
        double sumAgeOfFemale = 0;
        int femaleCounts = 0;
        double[] averageResults = new double[2];
        for(Person p : persons){
            //son comportamiento que puse para evitar negativo y error de value de gender
            //pero posteriormente me di cuenta que era mejor prevenirlo en el constructor
            /*if(p.age < 0){
                throw new NegativeValueException("The age of " + p.name + "is negative.");
            }*/
            /*if ((!p.gender.equals("Male")) || (!p.gender.equals("Female"))) {

            }*/
            if(p.gender.equals("Male")){
                sumAgeOfMale += p.age();
                maleCounts++;
            }else {
                sumAgeOfFemale += p.age();
                femaleCounts++;
            }
        }

        averageResults[0] = sumAgeOfMale/maleCounts;
        averageResults[1] = sumAgeOfFemale/femaleCounts;
        return averageResults;
    }

}
