/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo_mutex_1;

/**
 *
 * @author nando
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContaBancaria {
    private double saldo;
    private final Lock lock = new ReentrantLock();
    
    public ContaBancaria(double saldoInicial){
        this.saldo = saldoInicial;
    }
    
    //Saque com Mutex
    public void sacar(double valor){
        lock.lock(); //Equivalente a fazer um Down em Mutex
        try{
            if(saldo >= valor){
                System.out.println(Thread.currentThread().getName()+ " esta sacando..: "+valor);
                saldo -= valor;
                System.out.println("Novo saldo apos saque..: "+saldo);
            }else{
                System.out.println("Saldo Insuficiente para o saque de..: "+valor+" solicitado por "+Thread.currentThread().getName());
            }            
        }finally{
            lock.unlock(); //Equivalente a fazer um UP em Mutex
        }
    }
    
    //Deposito com Mutex
    public void depositar(double valor){
        lock.lock(); //Equivalente a fazer um Down em Mutex;
        try{
            System.out.println(Thread.currentThread().getName()+ " esta depositando o valor..: "+valor);
            saldo += valor;
            System.out.println("Novo saldo apos deposito..: "+saldo);
        }finally{
            lock.unlock(); //Equivalente a fazer um UP em Mutex;
        }
    }
    
    public double getSaldo(){
        return saldo;
    }
}
