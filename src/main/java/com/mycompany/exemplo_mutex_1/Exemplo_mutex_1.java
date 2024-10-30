/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exemplo_mutex_1;

/**
 *
 * @author nando
 */
public class Exemplo_mutex_1 {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);
        
        Thread t1 = new Thread(() ->{
            conta.depositar(500);
            conta.sacar(300);
        },"Thread 1");
        
        Thread t2 = new Thread(() ->{
            conta.depositar(200);
            conta.sacar(400);
        },"Thread 2");
        
        t1.start();
        t2.start();
    }
}
