//package com.tecsoluction.azar.entidade;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.springframework.format.annotation.DateTimeFormat;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//
//
//
//@Getter
//@Setter
//@EqualsAndHashCode
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public  class Jogo {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)  
//	@Column(name = "id")
//	private long id;
//
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private Date data;
//    
//	@Column(name = "nome")
//    private String nome ;
//	
//	@OneToOne(targetEntity=Sorteio.class,fetch=FetchType.EAGER,mappedBy="jogo")
//	private List<Sorteio> sorteios;
//
//	
//	
//	//construtor padrão
//	public Jogo() {
//	
//	}
//	
//	
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return nome.toString();
//	}
//
//}
