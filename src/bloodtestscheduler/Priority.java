/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author glenn
 */
public enum Priority {
    URGENT, MEDIUM, LOW;
    
    public int getValue() {
        // higher value = higher priority.
        return switch (this) {
            case URGENT -> 3;
            case MEDIUM -> 2;
            case LOW -> 1;
            default -> 0;
        };
    
    }
}