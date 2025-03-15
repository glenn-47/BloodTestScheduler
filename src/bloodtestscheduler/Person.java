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
    public String getName() {
        return name;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public String getGpDetails() {
        return gpDetails;
    }
    
    public int getAge() {
        return age;
    }
    
    public boolean isFromHospitalWard() {
        return fromHospitalWard;
    }
    
    @Override
    public int getPriorityScore() {
        int score = priority.getValue() * 100;
        if(fromHospitalWard) {
            score += 50; // boost for hospital ward patients.
        }
        score += age; // older age increases the score.
        return score;
    }
    
    @Override
    public String toString() {
        return name + " (" + priority + ", Age: " + age + ", Ward: " + fromHospitalWard + ")";
    }
}
