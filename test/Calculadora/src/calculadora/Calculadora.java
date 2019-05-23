/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author gdguerrerog
 */
public class Calculadora {

    
    public static double suma(double n1, double n2){
        return n1 + n2;
    }
    
    /**
    
     * @param args the command line arguments
     */

    public static double multiplicacion(double a, double b){
        return a*b;
    }
    public static double division(double a, double b){
        if (b==0) {
            return -1;
        }else {
            return a/b;

        }
    }
   public static double resta (double x,double y){
       return x-y;
    }
    public static void main(String[] args) {
        boolean running = true, validOperation;
        Scanner scan = new Scanner(System.in);
        
        double n1, n2, result = 0;
        int selectedOperation;
        
        while(running){
            System.out.println("Bienvenido a la calculadora");
            System.out.print("Ingresa el primero número a operar: ");
            n1 = scan.nextDouble();
            System.out.print("Ingresa el segundo número a operar: ");
            n2 = scan.nextDouble();
            System.out.println("Selecciona la operación deseada:");
            System.out.println("1) suma");
            System.out.println("2) resta");
            System.out.println("3) multiplicación");
            System.out.println("4) división");
            validOperation = false;
            
            while(!validOperation){
                selectedOperation = scan.nextInt();
                validOperation = true;
                switch(selectedOperation){
                    case 1: result = suma(n1, n2); break;
                    case 2: result = resta(n1, n2); break;
                    case 3: result = multiplicacion(n1, n2); break;
                    case 4: result = division(n1, n2); break;
                    default: validOperation = false;
                }
                
                if(!validOperation) System.out.println("Operación Invalida");
            }
            
            System.out.println("Resultado: " + result);
            
             
        }
        
    }
    
}
