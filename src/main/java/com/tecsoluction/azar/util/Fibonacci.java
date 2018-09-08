package com.tecsoluction.azar.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.tecsoluction.azar.entidade.MegaSena;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class Fibonacci implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private int limite;
	
	private MegaSena megasena;
	
	//fibonacci no range do jogo
	private List<Integer> fibs = new ArrayList<Integer>();
	//numeros de fibonnaci no resultado jogo
	private List<Integer> fibsnoResult = new ArrayList<>();

	//armazenará os seis numeros do resultado do jogo
	private	List<Integer> ints = new ArrayList<>(); ;

	
	
	
	public Fibonacci() {

	}
	
	
	public Fibonacci(MegaSena megasena) {
		
		this.megasena = megasena;
		this.limite = megasena.getRange();
	

	}
	
	//retorna os numeros de fibonnaci em determinado faixa
	public List<Integer> fibonaccinoRange(int limite){

		
        int n1 = 0;
        int n2 = 1;
        
        for ( int i = 0; i < limite; i++ ) {
           
//        	System.out.println( n1 );
            
            n2 = n1 + n2 + ( n1 = n2 ) - n2;
            
            fibs.add(n2);
            
        }
		
		return fibs;
	}
	
	//metodo que calculara o fibonacci 
	public int CalculaFibonacci(int n2){
		
		int n1 = 0;
		return  n2 = n1 + n2 + ( n1 = n2 ) - n2;
	}
	
	
	//retornara a quantidade de numeros de fibonacci no resultado do jogo
	public int QtdFibonacciResult(MegaSena megasena){
		
		int contador = 0;
		
		ints.clear();

		
		int bola = megasena.getPrimeiradezena();
		int bola2 = megasena.getSegundadezena();
		int bola3 = megasena.getTerceiradezena();
		int bola4 = megasena.getQuartadezena();
		int bola5 = megasena.getQuintadezena();
		int bola6 = megasena.getSextadezena();
				
		ints.add(bola);
		ints.add(bola6);
		ints.add(bola2);
		ints.add(bola3);
		ints.add(bola4);
		ints.add(bola5);
		
		List<Integer> lsint;
		lsint = fibonaccinoRange(60);
		
		for (int i = 0; i < ints.size(); i++) {
			
			int x = ints.get(i);
			
			if(lsint.contains(x)){
				
				
				contador = contador + 1;
			}
			
		}
		
		return contador;
	}
	
	
//	retornara os numeros de fibonnaci de um jogo
	public List<Integer> FibonacciResult(MegaSena megasena){
		
		ints.clear();
		fibsnoResult.clear();
		
		int bola = megasena.getPrimeiradezena();
		int bola2 = megasena.getSegundadezena();
		int bola3 = megasena.getTerceiradezena();
		int bola4 = megasena.getQuartadezena();
		int bola5 = megasena.getQuintadezena();
		int bola6 = megasena.getSextadezena();
				
		ints.add(bola);
		ints.add(bola6);
		ints.add(bola2);
		ints.add(bola3);
		ints.add(bola4);
		ints.add(bola5);
		
		for (int i = 0; i < ints.size(); i++) {
			
			int x = ints.get(i);
			
			List<Integer> lsfi = fibonaccinoRange(megasena.getRange());
			
			if(lsfi.contains(x)){
				
				getFibsnoResult().add(x);
				
			}
			
		}

		
		return fibsnoResult;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
