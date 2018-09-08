package com.tecsoluction.azar.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.tecsoluction.azar.entidade.MegaSena;

public class TesteFib {

	
	private static List<Integer> fibsRange = new ArrayList<Integer>();

	private static List<MegaSena> megas = new ArrayList<>() ;
	
	private static Estatistica estatistica;
	
	private static Fibonacci fibonacci;

	private static List<Fibonacci> fibonaccis = new ArrayList<>() ; ;

	
	private static List<Estatistica> estatisticas = new ArrayList<>() ; ;

	static int ra = 60;
	
	public static void main(String[] args) {
		
		megas.clear();
		
		
		megas = CriarMegaSena();
		
		estatistica = CriarEstatistica(megas);
				
		fibonacci = new Fibonacci();
		
//		fibsRange = fibonacci.fibonaccinoRange(ra);
	
		Map num = null ; 
		
		num = estatistica.getMapincidencianumero();
				


		for (int i = 0; i < megas.size(); i++) {
			
			System.out.println("concurso" + megas.get(i).getConcurso());
			System.out.println("data" + megas.get(i).getData());
			System.out.println("bola 1 :" + megas.get(i).getPrimeiradezena());
			System.out.println("bola 2 :" + megas.get(i).getSegundadezena());
			System.out.println("bola 3 :" + megas.get(i).getTerceiradezena());
			System.out.println("bola 4 :" + megas.get(i).getQuartadezena());
			System.out.println("bola 5 :" + megas.get(i).getQuintadezena());
			System.out.println("bola 6 :" + megas.get(i).getSextadezena());	
			
			estatistica.NumeroParOuImpar(megas.get(i));
			
			int par = estatistica.getQtdpar();
			int impar = estatistica.getQtdimpar();
			
			System.out.println("**********Estatistica Unitária *************");
			System.out.println("estatistica(PAR) :" + par);
			System.out.println("estatistica(IMPAR) :" + impar);




			
			
			int qtdfib = fibonacci.QtdFibonacciResult(megas.get(i));
			List <Integer> lsfib = fibonacci.FibonacciResult(megas.get(i));
			System.out.println("*********Fibonacci********");

			System.out.println("fibonacci QTD :" + qtdfib);
			System.out.println("fibonacci no resultado :" + lsfib);

			

		}
		
		estatistica.NumeroIncidencia(megas);
		num = estatistica.getMapincidencianumero();

		int obj = 39;
		
		int pos = 7 ;
	    AnaliseCombinatoria analisecomb = new AnaliseCombinatoria(obj, pos);
	    
	    int x = analisecomb.Arranjo();
	    int xx = analisecomb.Combinacao();
	    int xxx = analisecomb.Fatorial(pos);
	    int xxxx = analisecomb.Permutacao(pos);



		
		
		System.out.println("**********Estatistica Geral *************");
		System.out.println("estatistica :" + estatistica);
		System.out.println("Incidencia de Numeros:" + num);
		
		System.out.println("Incidencia dez Numeros:" + estatistica.MaisIncidentesDez(num));

		
		
		System.out.println("**********Analise Combinatoria *************");

		System.out.println(" Arranjo:" + x);
		System.out.println(" Combinacao:" + xx);

		System.out.println(" Fatorial:" + xxx);

		System.out.println(" Permnutacao:" + xxxx);


		
		
	}
	
	
	public static Estatistica CriarEstatistica(List<MegaSena> megas){
		
		Estatistica objetoEstatistica = new Estatistica(megas);
		
		estatisticas.add(objetoEstatistica);
		
		return objetoEstatistica;
	}
	
	
	public static Fibonacci CriarFibonnaci(MegaSena mega){
		
		Fibonacci objetoFibonacci = new Fibonacci(mega);
		
		fibonaccis.add(objetoFibonacci);
		 		
		return objetoFibonacci;
	}
	
	
	
	public static  List<MegaSena> CriarMegaSena(){
		
		
		List<MegaSena> megasenas = new ArrayList<MegaSena>(); 
		
		for (int i = 0; i < 100; i++) {
			
			MegaSena objetoMegaSena = new MegaSena();
			
			objetoMegaSena.setId(i);
			objetoMegaSena.setData(new Date());
			objetoMegaSena.setConcurso(""+ i);
			objetoMegaSena.setPrimeiradezena(meuRandom());
			objetoMegaSena.setSegundadezena(meuRandom());
			objetoMegaSena.setTerceiradezena(meuRandom());

			objetoMegaSena.setQuartadezena(meuRandom());
			objetoMegaSena.setQuintadezena(meuRandom());
			objetoMegaSena.setSextadezena(meuRandom());
			
			objetoMegaSena.setAcumulou(false);
			objetoMegaSena.setEscolhe(06);
			objetoMegaSena.setRange(60);
			
			megasenas.add(objetoMegaSena);
			
			CriarFibonnaci(objetoMegaSena);

		}
		
		
		
		
		return megasenas;
	}
	
	
	public static int meuRandom(){
		
	    return (int) (Math.random() * 60);
	}
	

}
