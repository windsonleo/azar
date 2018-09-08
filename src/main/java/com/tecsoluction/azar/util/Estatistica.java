package com.tecsoluction.azar.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tecsoluction.azar.entidade.LotoMania;
import com.tecsoluction.azar.entidade.Lotofacil;
import com.tecsoluction.azar.entidade.MegaSena;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
public class Estatistica implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Integer,Integer> Mapincidencianumero = new HashMap<>();
	
	private Map<Integer,Integer> Mapincidencianumerodezmais = new HashMap<>();

	
	private Map<Integer,Integer> Mapincidenciadezena = new HashMap<>();
		
	private List<MegaSena> megasenas;
	
	private List<Integer> bolasresultado = new ArrayList<>();
	
//	private double percentUm = 1 /range - escolhe * 100 ;
//	
//	private double probSeis = 6 /range - escolhe * 100 ;

	
	private int qtdpar;
	
	private int qtdimpar;
	


	
	


	public Estatistica(List<MegaSena> megas) {
		
		this.megasenas = megas;
		
		criarMapIncidenciaNumero();
		criarMapIncidenciaDezena();
//		MaisIncidentesDez(NumeroIncidencia(megas));

	}
	
	
	// verifica a quantiddade de vezes que um numero se repetiu
	public Map<Integer , Integer> NumeroIncidencia(List<MegaSena> lista) {
		
		
		for (MegaSena megaSena : lista) {
			
			
			int bola = megaSena.getPrimeiradezena();
			AtualizaMapNumero(bola);
			
			int bola2 = megaSena.getSegundadezena();
			AtualizaMapNumero(bola2);
			
			int bola3 = megaSena.getTerceiradezena();
			AtualizaMapNumero(bola3);
			
			int bola4 = megaSena.getQuartadezena();
			AtualizaMapNumero(bola4);
			
			int bola5 = megaSena.getQuintadezena();
			AtualizaMapNumero(bola5);
			
			int bola6 = megaSena.getSextadezena();
			AtualizaMapNumero(bola6);
			
			
		}
		
		return Mapincidencianumero;
		
	}
	
	
	// verifica a qual casa de dezena um numero representa
	public void IncidenciaDezenas(List<MegaSena> lista){
		
//		for (MegaSena megaSena : lista) {
//			
//			int bola = megaSena.getPrimeiradezena();
//			boolean existe =  Mapincidenciadezena.containsKey(bola);
//			
//			if(existe){
//				
//				Integer valorAntigo = Mapincidenciadezena.get(bola).intValue();
//				Mapincidenciadezena.put(bola, valorAntigo + 1);
//				
//			} 
//			
//			else {
//				
//				Mapincidencianumero.put(bola, 1);	
//				
//			}
//			
//		}
		
		
		
		
	}
	
	
	
	//	cria os valores do array 00 a 99
	public void criarMapIncidenciaNumero(){
		
		Mapincidencianumero.clear();
		
	        for (int i = 0 ;  i <= 99 ; i++) {
	        	
	        	Mapincidencianumero.put(i, 0);
	
        
		}
			
	}
	
	//	cria os valores do array 10 a 90
	public void criarMapIncidenciaDezena(){
		
		Mapincidenciadezena.clear();
		
	        for (int i = 0 ;  i <= 90 ; i=i+10) {
	        	
	        	Mapincidenciadezena.put(i, 0);
	
	        }
        
		}
	
	public void AtualizaMapNumero(int bola){
		
		boolean existe = Mapincidencianumero.containsKey(bola);
		
		Integer valorAntigo = 0;
		
		valorAntigo = Mapincidencianumero.get(bola).intValue();
		
		if(existe)
		
		{
			
			Mapincidencianumero.put(bola, valorAntigo + 1);

			
		}else 
			
		{
			Mapincidencianumero.put(bola, 1);
			
		}
		
		
	}
	
	// Sugere Jogo de Acordo com Probabilidades Matematicas
	public MegaSena ExtrapolarResultado(){
		
		return new MegaSena();

		
	}
	
	//	percentual de acerto por cada numero
	public double ChancesPercentual(MegaSena mega){
		
		return 1.00;
	
		
	}
	
	//verificar se já existe resultado igual passando uma simulação de jogo
	//comprar com incidencia de numeros
	public boolean JogoIgual(MegaSena mega){
		
		return false;	
		
	}
	
	
	public void NumeroParOuImpar(MegaSena megasena){
		
		bolasresultado.clear();
		
		qtdpar = 0;
		qtdimpar=0;
		
		
		int bola = megasena.getPrimeiradezena();
		int bola2 = megasena.getSegundadezena();
		int bola3 = megasena.getTerceiradezena();
		int bola4 = megasena.getQuartadezena();
		int bola5 = megasena.getQuintadezena();
		int bola6 = megasena.getSextadezena();
				
		bolasresultado.add(bola);
		bolasresultado.add(bola6);
		bolasresultado.add(bola2);
		bolasresultado.add(bola3);
		bolasresultado.add(bola4);
		bolasresultado.add(bola5);
		
		for (int i = 0; i < bolasresultado.size(); i++) {
			
			int x = bolasresultado.get(i);
			
			if(x % 2 == 0)
			{
				
				qtdpar = getQtdpar() + 1;
				
			} else 
			 
			{
				
				qtdimpar = getQtdimpar() + 1;
			}
			
			
		}
		
		
	}
	

	public Map<Integer,Integer> MaisIncidentesDez(Map<Integer,Integer> maps){
		
		Map<Integer,Integer> Mapincidencianumerodezmaiss = new HashMap<>();
		
		int indicemaior = 0;
		int indiceaux = 0;
		
   	 for (Integer key : maps.keySet()) {
         
//      	totalpedido = totalpedido.add(key.getTotalItem());
   		 
   	
   		
		System.out.println("key"+ key);
		System.out.println("maps get key "+ maps.get(key));
		
		
		int atual = maps.get(key);
		

   		if ((atual != 0) && (atual >= indicemaior)){
   			
//   			indiceaux = + 1;
			indicemaior = atual;
   			
   			Mapincidencianumerodezmaiss.put(key,maps.get(key));
   			
   		}else {
   			
   			indicemaior = indicemaior;
   			
   		}
   	
   	 
   	 }
		
		
		
		Mapincidencianumerodezmais.putAll(Mapincidencianumerodezmaiss);
		
		
		return Mapincidencianumerodezmais;
		

	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + Mapincidencianumerodezmais ;
	}
	

}
