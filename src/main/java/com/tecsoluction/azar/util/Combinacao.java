package com.tecsoluction.azar.util;

public class Combinacao {
	 private int numeros[] = {15,05,23,10,52,01,16,54,9,28,29,12,61,20,02,04,22,06,59,19,03,56,31,68,11,48,13,60,53,25,07,14,30,21,18,35,27};
//	 private int numeros[] = {15,05,23,35,27};

	
	private int quantidade = 6;
	    private int resultado[] = new int[6];
	 
	    private int count = 0;
	 
	    private void busca(int inicio,int fim, int profundidade){
	 
	        if ( (profundidade + 1) >= quantidade)
	        for(int x = inicio; x <= fim; x++){
	            resultado[profundidade] = numeros[x];
	            // faz alguma coisa com um dos resultados possiveis
	            count++;
	            System.out.println(count + "º : "+ resultado[0] + ", " + resultado[1] + ", " + resultado[2] + ", " + resultado[3] +", " + resultado[4] +", " + resultado[5] + "\n");
//	            System.out.println(count + "º : "+ resultado[0] + ", " + resultado[1] + ", " + resultado[2] + "\n");

	        }
	    else
	        for(int x = inicio; x <= fim; x++){
	            resultado[profundidade] = numeros[x];
	            busca(x + 1,fim + 1,profundidade + 1);
	        }
	    }
	 
	    public static void main(String args[]){
	 
	        Combinacao comb = new Combinacao();
	        comb.busca(0, (37-6), 0);
	        System.out.println("Total de combinacoes: " + comb.count);
	 
	    }
	}
