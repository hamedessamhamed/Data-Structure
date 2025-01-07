/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.LinkedList;
import java.util.Comparator;





/**
 *
 * @author user
 */

public class node {
    // LinkedList to store processes in order of their timeNeeded (ascending order)
    private LinkedList<Process> queue;

    public node() {
        queue = new LinkedList<>();
    }

    // Add a process to the priority queue, inserting in the correct position based on timeNeeded
  public void addProcessw(Process process) {
    if (queue.isEmpty()) {
        queue.add(process); //add it to the start
    } else {
        boolean inserted = false;
        // Iterate over the list to find the correct position based on memorySize
        for (int i = 0; i < queue.size(); i++) {
            if (process.memorySize < queue.get(i).memorySize) {
                queue.add(i, process);  // Insert process at the correct position
                inserted = true;
                break;
            }
        }
        // If no position is found (process has smallest memory size), add it to the end
        if (!inserted) {
            queue.add(process);
        }
    }
}
  
    public void addProcessr(Process process) {
    if (queue.isEmpty()) {
        queue.add(process);
    } else {
        boolean inserted = false;
        // Iterate over the list to find the correct position based on memorySize
        for (int i = 0; i < queue.size(); i++) {
            if (process.memorySize > queue.get(i).memorySize) {
                queue.add(i, process);  // Insert process at the correct position
                inserted = true;
                break;
            }
        }
        // If no position is found (process has smallest memory size), add it to the end
        if (!inserted) {
            queue.add(process);
        }
    }
}


    // Remove and return the highest-priority process (the one with the least timeRemaining)
    public Process removeProcess() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();  // Remove and return the first process (highest priority)
        }
        return null;
    }

    // Peek at the highest-priority process without removing it
    public Process peekProcess() {
        if (!queue.isEmpty()) {
            return queue.getFirst();  // Peek at the first process (highest priority)
        }
        return null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Print the current processes in the queue
    public void printQueuer() {
        if (queue.isEmpty()) {
            System.out.println("No processes in the Running list.");
        } else {
            for (Process p : queue) {
                System.out.println(p);
            }
        }
    }
    
     public void printQueuew() {
        if (queue.isEmpty()) {
            System.out.println("No processes in the waiting list.");
        } else {
            for (Process p : queue) {
                System.out.println(p.h());
            }
        }
    }
}
