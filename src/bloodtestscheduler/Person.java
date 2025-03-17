/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author glenn
 */
public class Person implements Schedulable {
    private final String name;
    private final Priority priority;
    private final String gpDetails;
    private final int age;
    private final boolean fromHospitalWard;
    
    public Person(String name, Priority priority, String gpDetails, int age, boolean fromHospitalWard) {
        this.name = name;
        this.priority = priority;
        this.gpDetails = gpDetails;
        this.age = age;
        this.fromHospitalWard = fromHospitalWard;
    }
    
    // Getter for the person's name
    public String getName() {
        return name;
    }
    
    // Getter for the priority level
    public Priority getPriority() {
        return priority;
    }
    
    // Getter for the GP details
    public String getGpDetails() {
        return gpDetails;
    }
    
    // Getter for the person's age
    public int getAge() {
        return age;
    }
    
    // Checks if the person is coming from a hospital ward
    public boolean isFromHospitalWard() {
        return fromHospitalWard;
    }
    
    // Computes and returns the priority score for this person
    @Override
    public int getPriorityScore() {
        int score = priority.getValue() * 100;
        if(fromHospitalWard) {
            score += 50; // boost for hospital ward patients.
        }
        score += age; // older age increases the score.
        return score;
    }
    
    // Returns a string representation of the Person object
    @Override
    public String toString() {
        return name + " (" + priority + ", Age: " + age + ", Ward: " + fromHospitalWard + ")";
    }
}
