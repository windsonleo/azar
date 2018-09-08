package com.tecsoluction.azar.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tecsoluction.azar.entidade.MegaSena;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AnaliseCombinatoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private List<Integer>objetos= new ArrayList<Integer>() ;
	
	
	private List<Integer>posicoes = new ArrayList<Integer>() ;
	
	
	
	
//	arranjo  a n,p = n!/(n-p)!   n= objetos p = posicoes
	
	
//	combinacao   a n,p = n!/(n-p)!p!   n= objetos p = posicoes
	
//	permutacao   p = n!   n= objetos p = posicoes (nº objetos = numeros posicoes)


	
	
	public AnaliseCombinatoria(int objetoss,int posicoess) {
		
		this.objetos = PreencherObjetos(objetoss);
		this.posicoes = PreencherPosicoes(posicoess);

	
	
	
	}

	
	//p=n!
	public int Permutacao(int numeroobjetos){
		
		int permutacao = Fatorial(numeroobjetos);
		
		return permutacao;
	}
	
	
	//a n,p = n!/(n-p)!
	public int Arranjo(){
		
		int arranjo = Fatorial(getObjetos().size()) / Fatorial((getObjetos().size() - getPosicoes().size()));
		
		return arranjo;

	}
	
//	combinacao   a n,p = n!/(n-p)!p!   n= objetos p = posicoes
	public int Combinacao(){
		
		int combinacao = Fatorial(getObjetos().size()) / Fatorial((getObjetos().size() - getPosicoes().size())) + Fatorial(getPosicoes().size());
		
		return combinacao;

	}
	
	public int  Fatorial(int numerofatorial){
		
		int fat = 1;
//		int anterior = 0;
		
		for(int um = 1 ; um < numerofatorial; numerofatorial --){
			
			int ant = numerofatorial - 1 ;
			
			fat *= numerofatorial;
			
			System.out.println("fat" + fat);
			System.out.println("numerofatorial" + numerofatorial);
			System.out.println("numeroanterior" + ant);

			

			
		}
		
		
		return fat;
	}
	
	
	public List<Integer> PreencherObjetos(int numeroobjetos){
		
		objetos = new ArrayList<Integer>();
		
		
		for(int i = 0; i <= numeroobjetos; i++){
			
			objetos.add(i);
			
		}
		
		return objetos;
		
		
	}
	
	public List<Integer> PreencherPosicoes(int numeroposicoes){
		
		posicoes = new ArrayList<Integer>();
		
		for(int i = 0; i <= numeroposicoes; i++){
			
			posicoes.add(i);
			
		}
		
		return posicoes;
		
	}
	
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return objetos.toString();
		}

}
