
package com.mycompany.project;
import java.util.LinkedList;
import java.util.Random;
import java.util.Comparator;
import java.util.*;

class MemAlloc {
    LinkedList<MemBlock> memoryBlocks = new LinkedList<>();
    Queue<Process> startingList = new LinkedList<>(); //Holds processes waiting to start.
    LinkedList<String> end = new LinkedList<>();
    node runningList = new node();
    node waitingList = new node(); 
    static int nextId = 1;
     


    void initialize() { //Sets up memory and processes.
        memoryBlocks.add(new MemBlock(1024, 0)); 
        generateProcesses(20);
    }

    void generateProcesses(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int memorySize = random.nextInt(256) + 1; 
            int timeNeeded = random.nextInt(20000) + 1; 
            startingList.add(new Process(memorySize, timeNeeded));
        }
    }

    void simulate() throws InterruptedException {
        
            System.out.println("\n-------------------------------------------");
            System.out.println("At time "+nextId++);
            displayLists();

        while (!startingList.isEmpty() || !runningList.isEmpty() || !waitingList.isEmpty()) {
            while (!end.isEmpty()) {
                end.removeLast();
            }
            
            System.out.println("\n-------------------------------------------");
            System.out.println("At time "+nextId++);

            if (!startingList.isEmpty()) {
                Process process = startingList.poll();
                allocateMemory(process);
            }
            updateLists();
            displayLists();
            Thread.sleep(1000);
            System.out.println("\n\n\n");
        }
        System.out.println("\nSimulation completed.");
    }

    void allocateMemory(Process process) {
        for (MemBlock block : memoryBlocks) {
            if (block.size >= process.memorySize) {
                process.assignedBlock = new MemBlock(process.memorySize, block.startAddress);
                runningList.addProcessr(process);

                block.startAddress += process.memorySize;
                block.size -= process.memorySize;

                if (block.size == 0) memoryBlocks.remove(block);
                return;
            }
        }

        // If no block fits, move to waiting list (priority queue)
        waitingList.addProcessw(process);
    }

    void releaseMemory(Process process) {
        if (process.assignedBlock != null) {
            memoryBlocks.add(new MemBlock(process.assignedBlock.size, process.assignedBlock.startAddress));
            mergeMemoryBlocks();
        }
    }

    void mergeMemoryBlocks() {
       memoryBlocks.sort(Comparator.comparingInt(block -> block.startAddress));
        for (int i = 0; i < memoryBlocks.size() - 1; i++) {
            MemBlock current = memoryBlocks.get(i);
            MemBlock next = memoryBlocks.get(i + 1);

            if (current.endAddress + 1 == next.startAddress) {
                current.size += next.size;
                current.endAddress = next.endAddress;
                memoryBlocks.remove(i + 1);
                i--; // Re-check for further merges
            }
        }
    }

   void updateLists() {

    LinkedList<Process> tempRunningList = new LinkedList<>();

    while (!runningList.isEmpty()) {
        Process process = runningList.removeProcess();
        process.timeNeeded -= 1000;

        if (process.timeNeeded > 0) {
            tempRunningList.add(process);
        } else {
            end.add(process.toString());
            releaseMemory(process);
        }
    }

    for (Process process : tempRunningList) {
        runningList.addProcessr(process);
    }

    while (!waitingList.isEmpty()) {
        Process process = waitingList.peekProcess(); 
        if (allocateWaitingProcess(process)) {
            waitingList.removeProcess(); 
        } else {
            break; 
        }
    }

   }

       

    boolean allocateWaitingProcess(Process process) {
        for (MemBlock block : memoryBlocks) {
            if (block.size >= process.memorySize) {
                process.assignedBlock = new MemBlock(process.memorySize, block.startAddress);
                runningList.addProcessr(process);

                block.startAddress += process.memorySize;
                block.size -= process.memorySize;

                if (block.size == 0) memoryBlocks.remove(block);
                return true;
            }
        }
        return false;
    }

    
    
    void displayLists() {
        System.out.println("Running Processes:");
        runningList.printQueuer(); // Print the processes in the rinning queuer

        System.out.print("--------------------------------------------------");
        
        System.out.println("\nWaiting Processes:");
        waitingList.printQueuew(); // Print the processes in the waiting queue

        System.out.print("--------------------------------------------------");

        System.out.println("\nAvailable Memory Blocks:");
        for (MemBlock block : memoryBlocks) {
            System.out.println(block);
        }
        System.out.print("--------------------------------------------------");
                System.out.println("\nEnded process");
  
                
        if(!end.isEmpty()){
            for (String block : end){
                System.out.println(block);
            }
        }else{
            System.out.println("No process ended in this Second");
        }
        System.out.println("--------------------------------------------------");
    }
}