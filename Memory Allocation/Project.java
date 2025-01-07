/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;
import java.lang.Thread;


/**
 *
 * @author user
 */
public class Project {      
             
  public static void main(String[] args) throws InterruptedException {
        MemAlloc memAlloc = new MemAlloc();
        memAlloc.initialize();
        memAlloc.simulate();
  }
}          
    
