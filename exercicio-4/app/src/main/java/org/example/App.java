package org.example;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

            File arquivo = new File(args[0]);
            Scanner leitor = new Scanner(arquivo);
            int navios_desconhecidos = 0;

            String[][] mar = new String[10][10];
            int linha = 0;
            int[] linhaP = new int[10], linhaE = new int[10], linhaC = new int[10], linhaS = new int[10], linhaN = new int[10];
            int[] colunaP = new int[10], colunaE = new int[10], colunaC = new int[10], colunaS = new int[10], colunaN = new int[10];
            int contC = 0, contN = 0, contP = 0, contE = 0, contS = 0;

            while (leitor.hasNextLine() && linha < 10) {
                String[] elementos = leitor.nextLine().split(" ");

                if (elementos.length != 10) {//não tem dimensão 10x10
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }

                for (int coluna = 0; coluna < 10; coluna++) {
                    mar[linha][coluna] = elementos[coluna];
                    if(!(elementos[coluna].equals("P") || elementos[coluna].equals("N") || elementos[coluna].equals("S") || elementos[coluna].equals("E") || elementos[coluna].equals("C") || elementos[coluna].equals("."))){
                        navios_desconhecidos++;
                    }
                    if (elementos[coluna].equals("P")) {
                        linhaP[contP] = linha;
                        colunaP[contP] = coluna;
                        contP++;
                    }
                    if (elementos[coluna].equals("E")) {
                        linhaE[contE] = linha;
                        colunaE[contE] = coluna;
                        contE++;
                    }
                    if (elementos[coluna].equals("C")) {
                        linhaC[contC] = linha;
                        colunaC[contC] = coluna;
                        contC++;
                    }
                    if (elementos[coluna].equals("S")) {
                        linhaS[contS] = linha;
                        colunaS[contS] = coluna;
                        contS++;
                    }
                    if (elementos[coluna].equals("N")) {
                        linhaN[contN] = linha;
                        colunaN[contN] = coluna;
                        contN++;
                    }
                }
                linha++;
            }

        if (linha != 10) {// tabuleiro não tem dim 10x10
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        if(contP != 5 || contE != 4 || contC != 3 || contS != 3 || contN != 2){// verifica sem tem navios de cada tipo e se não são repetidos
                System.out.println("Tabuleiro Inválido!");
                return;
        }
        if(navios_desconhecidos > 0){// verifica navios desconhecidos
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        boolean alinhadoEmLinha = false;
        boolean alinhadoEmColuna = false;

        // verificando se os navios são incluidos na horizontal e vertical para P
        int p = colunaP[0];
        int p_linha = linhaP[0];
        for (int i = 1; i < contP; i++) {
            int p2 = colunaP[i];
            int p_linha2 = linhaP[i];
            if (linhaP[i] == linhaP[0]) {
                alinhadoEmLinha = true;
            }
            if (colunaP[i] == colunaP[0]) {
                alinhadoEmColuna = true;
            }
            if(colunaP[i] != colunaP[0]){
                if(p2 - p != 1){// se a coluna ta em sequencia P P P em vez de P . . P e por ai vai
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                p = p2;
            }
            if(linhaP[i] != linhaP[0]){
                if(p_linha2 - p_linha != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                p_linha = p_linha2;
            }

        }
        if (alinhadoEmLinha && alinhadoEmColuna) {
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        alinhadoEmLinha = false;
        alinhadoEmColuna = false;

        // verificando se os navios são incluidos na horizontal e vertical para E
        int e = colunaE[0];
        int e_linha = linhaE[0];
        for (int i = 1; i < contE; i++) {
            int e2 = colunaE[i];
            int e2_linha = linhaE[i];
            if (linhaE[i] == linhaE[0]) {
                alinhadoEmLinha = true;
            }
            if (colunaE[i] == colunaE[0]) {
                alinhadoEmColuna = true;
            }
            if(colunaE[i] != colunaE[0]){
                if(e2 - e != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                e = e2;
            }
            if(linhaE[i] != linhaE[0]){
                if(e2_linha - e_linha != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                e_linha = e2_linha;
            }
        }
        if (alinhadoEmLinha && alinhadoEmColuna) {
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        alinhadoEmLinha = false;
        alinhadoEmColuna = false;

        // verificando se os navios são incluidos na horizontal e vertical para C
        int c = colunaC[0];
        int c_linha = linhaC[0];
        for (int i = 1; i < contC; i++) {
            int c2 = colunaC[i];
            int c2_linha = linhaC[i];
            if (linhaC[i] == linhaC[0]) {
                alinhadoEmLinha = true;
            }
            if (colunaC[i] == colunaC[0]) {
                alinhadoEmColuna = true;
            }
            if(colunaC[i] != colunaC[0]){
                if(c2 - c != 1){// se a coluna ta em sequencia C C C em vez de C . . C e por ai vai
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                c = c2;
            }
            if(linhaC[i] != linhaC[0]){
                if(c2_linha - c_linha != 1){
                    System.out.println("Tabuleiro Inválido!");
                }
                c_linha = c2_linha;
            }

        }
        if (alinhadoEmLinha && alinhadoEmColuna) {
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        alinhadoEmLinha = false;
        alinhadoEmColuna = false;

        // verificando se os navios são incluidos na horizontal e vertical para S
        int s = colunaS[0];
        int s_linha = linhaS[0];
        for (int i = 1; i < contS; i++) {
            int s2 = colunaS[i];
            int s2_linha = linhaS[i];
            if (linhaS[i] == linhaS[0]) {
                alinhadoEmLinha = true;
            }
            if (colunaS[i] == colunaS[0]) {
                alinhadoEmColuna = true;
            }
            if(colunaS[i] != colunaS[0]){
                if(s2 - s != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                s = s2;
            }
            if(linhaS[i] != linhaS[0]){
                if(s2_linha - s_linha != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                s_linha = s2_linha;
            }
        }
        if (alinhadoEmLinha && alinhadoEmColuna) {
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        alinhadoEmLinha = false;
        alinhadoEmColuna = false;

        // verificando se os navios são incluidos na horizontal e vertical para N
        int n = colunaN[0];
        int n_linha = linhaN[0];
        for (int i = 1; i < contN; i++) {
            int n2 = colunaN[i];
            int n2_linha = linhaN[i];
            if (linhaN[i] == linhaN[0]) {
                alinhadoEmLinha = true;
            }
            if (colunaN[i] == colunaN[0]) {
                alinhadoEmColuna = true;
            }
            if(colunaN[i] != colunaN[0]){
                if(n2 - n != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                n = n2;
            }
            if(linhaN[i] != linhaN[0]){
                if(n2_linha - n_linha != 1){
                    System.out.println("Tabuleiro Inválido!");
                    return;
                }
                n_linha = n2_linha;
            }
        }
        if (alinhadoEmLinha && alinhadoEmColuna) {
            System.out.println("Tabuleiro Inválido!");
            return;
        }

        //se passou e deu tudo certo
        System.out.println("Tabuleiro Válido!");

    }
}