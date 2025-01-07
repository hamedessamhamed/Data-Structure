/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

class MemBlock { //used to manage available memory.
    int size;
    int startAddress;
    int endAddress;

    MemBlock(int size, int startAddress) { //Constructor
        this.size = size;
        this.startAddress = startAddress;
        this.endAddress = startAddress + size - 1;
    }

    @Override
    public String toString() {
        return "MemBlock[" + "start=" + startAddress + ", end=" + endAddress + ", size=" + size + "]";
    }
}

