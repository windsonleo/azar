package com.tecsoluction.azar.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="megasena")
public class MegaSena   implements Serializable{
	


	private static final long serialVersionUID = 6545642662183499303L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id")
	private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    

	@Column(name = "concurso", nullable = false)
	private String concurso;
	
	@Column(name = "primeiradezena", nullable = false)
	private int primeiradezena ;
	
	@Column(name = "segundadezena", nullable = false)
	private int segundadezena ;
	
	@Column(name = "terceiradezena", nullable = false)
	private int terceiradezena ;
	
	@Column(name = "quartadezena", nullable = false)
	private int quartadezena ;
	
	@Column(name = "quintadezena", nullable = false)
	private int quintadezena ;
	
	@Column(name = "sextadezena", nullable = false)
	private int sextadezena ;

	
	@Column(name = "qtdganhadorsena", nullable = false)
	private int qtdganhadorsena ;
	
	@Column(name = "qtdganhadorquina", nullable = false)
	private int qtdganhadorquina ;
	
	@Column(name = "qtdganhadorquadra", nullable = false)
	private int qtdganhadorquadra; 
	
	@Column(name = "acumulou", nullable = false)
	private boolean acumulou ;
	
	@Column(name = "range", nullable = false)
	private int range = 60;
	
	@Column(name = "escolhe", nullable = false)
	private int escolhe = 06;
	
	
	
	
	//construtor padrão
	public MegaSena() {
		super();
	
	}
	
	
	@Override
	public String toString() {

		return "" + primeiradezena + "," + 
		       "" + segundadezena + "," +
		       "" + terceiradezena + "," +
		       "" + quartadezena + "," +
		       "" + quintadezena + "," +
		       "" + sextadezena + "";
	}
	
	
	
	

}
