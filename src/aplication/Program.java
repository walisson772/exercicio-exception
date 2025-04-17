package aplication;

import model.entities.Conta;
import model.exception.DomainException;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Insira os dados da conta");
            System.out.print("Numero: ");
            int numero = sc.nextInt();
            System.out.print("Titular: ");
            sc.next();
            String titular = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldoInicial = sc.nextDouble();
            System.out.print("Limite inicial: ");
            double limite = sc.nextDouble();

            System.out.print("Insira o valor para saque: ");
            double saque = sc.nextDouble();

            Conta conta = new Conta(numero, titular, saldoInicial, limite);
            conta.sacar(saque);
            System.out.println(conta);
            sc.close();
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }

    }
}
