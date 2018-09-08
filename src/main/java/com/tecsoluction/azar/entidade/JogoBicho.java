package com.tecsoluction.azar.entidade;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name="jogobicho")
public class JogoBicho   implements Serializable{
	

	private static final long serialVersionUID = 6545642662183499303L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id")
	private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    
	@Column(name = "hora")
    private String hora;
    

	@Column(name = "banca", nullable = false)
	private String banca;
	
		
	@Column(name = "primeiropremio", nullable = false)
	private int primeiropremio ;
	
	@Column(name = "segundopremio", nullable = false)
	private int segundopremio ;
	
	
	@Column(name = "terceiropremio", nullable = false)
	private int terceiropremio ;
	
	@Column(name = "quartopremio", nullable = false)
	private int quartopremio ;

	@Column(name = "quintopremio", nullable = false)
	private int quintopremio ;
	
		
	//construtor padrão
	public JogoBicho() {
		super();
	
	}
	
	
	@Override
	public String toString() {

		return 	"1º = " + primeiropremio +", "+
				"2º = " + segundopremio +", "+
				"3º = " + terceiropremio +", "+
				"4º = " + quartopremio +", "+
				"5º = " + quintopremio ;
		
	}
	
	
	
	

}
