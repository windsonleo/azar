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
@Table(name="lotofacil")
public class Lotofacil  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4913925232045056495L;

	/**
	 * 
	 */
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
	
	@Column(name = "setimadezena", nullable = false)
	private int setimadezena ;
	
	@Column(name = "oitavadezena", nullable = false)
	private int oitavadezena ;
	
	
	@Column(name = "nonadezena", nullable = false)
	private int nonadezena ;
	
	
	@Column(name = "decimadezena", nullable = false)
	private int decimadezena ;
	
	
	@Column(name = "decimaprimeiradezena", nullable = false)
	private int decimaprimeiradezena ;
	
	
	@Column(name = "decimasegundadezena", nullable = false)
	private int decimasegundadezena ;
	
	
	@Column(name = "decimaterceiradezena", nullable = false)
	private int decimaterceiradezena ;
	
	
	@Column(name = "decimaquartadezena", nullable = false)
	private int decimaquartadezena ;
	
	
	@Column(name = "decimaquintadezena", nullable = false)
	private int decimaquintadezena ;
	
	@Column(name = "G15", nullable = false)
	private int G15;
	
	@Column(name = "G14", nullable = false)
	private int G14;
	
	@Column(name = "G13", nullable = false)
	private int G13;
	
	@Column(name = "G12", nullable = false)
	private int G12;
	@Column(name = "G11", nullable = false)
	private int G11;
	
	
	//construtor padrão
	public Lotofacil() {
		super();
	
	}
	
	
	@Override
	public String toString() {

		return "" + primeiradezena + "," + 
				"" + segundadezena + "," +
				"" + terceiradezena + "," +
				"" + quartadezena + "," +
				"" + quintadezena + "," +
				"" + sextadezena + "," +
				"" + setimadezena + "," +
				"" + oitavadezena + "," +
				"" + nonadezena + "," +
				"" + decimadezena + "," +
				"" + decimaprimeiradezena + "," +
				"" + decimasegundadezena + "," +
				"" + decimaterceiradezena + "," +
				"" + decimaquartadezena + "," +
				"" + decimaquintadezena ;
		
				
	}
	
	
	

}
