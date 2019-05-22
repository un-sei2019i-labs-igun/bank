/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author gdguerrerog
 */
public class Calculadora {

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
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
