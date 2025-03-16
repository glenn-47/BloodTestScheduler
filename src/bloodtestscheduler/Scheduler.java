/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author glenn
 */
import java.util.*;

public class Scheduler {
    // ADT 1: List to store all requests.
    private final List<Person> allRequests = new ArrayList<>();
    // ADT 2: PriorityQueue with custom comparator.
    private final PriorityQueue<Person> priorityQueue;
    
    // ADT 3: Fixed-size queue to track last 5 no-shows.
    private final Deque<Person> noShowQueue = new ArrayDeque<>();
    private static final int MAX_NO_SHOWS = 5;

    public Scheduler() {
        this.priorityQueue = new PriorityQueue<>((Person p1, Person p2) -> Integer.compare(p2.getPriorityScore(), p1.getPriorityScore()) // Higher score should come first.
        );
    }
    
    public void addRequest(Person p) {
        allRequests.add(p);
        priorityQueue.offer(p);
    }
    
    public Person getNextTest() {
        return priorityQueue.peek();
    }
    
    public Person scheduleNext() {
        Person next = priorityQueue.poll();
        return next;
    }
    
    public void markNoShow(Person p) {
        // Remove from list or mark as no-show.
        if (noShowQueue.size() >= MAX_NO_SHOWS) {
            noShowQueue.poll(); // remove oldest no-show.
        }
        noShowQueue.offer(p);
    }
    
    // recursive method to print all test requests.
    public void printRequestsRecursively() {
        printRequestsRecursively(0);
    }
    
    private void printRequestsRecursively(int index) {
        if (index >= allRequests.size()) {
            return;
        }
        System.out.println(allRequests.get(index));
        printRequestsRecursively(index + 1);
    }
    
    public List<Person> getAllRequests() {
        return allRequests;
    }
    
    public Deque<Person> getNoShowQueue() {
        return noShowQueue;
    }
}
