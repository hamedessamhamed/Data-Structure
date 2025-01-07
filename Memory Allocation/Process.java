/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import java.util.Random;

/**
 *
 * @author user
 */
import java.util.Random;
/*
>>>>Starting List → Running List → End List.
>>>>Or Starting List → Waiting List → Running List.

*/
class Process {
    static int nextId = 1;
    int id;
    int memorySize;
    int timeNeeded;
    MemBlock assignedBlock;

    Process(int memorySize, int timeNeeded) {
        this.id = nextId++;
        this.memorySize = memorySize;
        this.timeNeeded = timeNeeded;
    }

    @Override
    public String toString() {
        if(timeNeeded>0){
            return "Process[id=" + this.id + ", size=" + this.memorySize + ", timeRemaining=" + this.timeNeeded + "ms "+" ,start = "+assignedBlock.startAddress+",end = "+assignedBlock.endAddress+"]";
        }else{  
          return "Process[id=" + this.id + ", size=" + this.memorySize +" ,start = "+assignedBlock.startAddress+",end = "+assignedBlock.endAddress+"]";
        }
    }
    
     public String h() {
        return "Process[id=" + this.id + ", size=" + this.memorySize + ", timeRemaining=" + this.timeNeeded + "ms]";
    }
}



