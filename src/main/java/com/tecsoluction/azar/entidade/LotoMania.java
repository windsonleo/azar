package com.tecsoluction.azar.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name="lotomania")
public class LotoMania  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7431268579112864367L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id")
	private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    
	@Column(name = "concurso")
    private String concurso ;
	
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
	
	@Column(name = "decimasextadezena", nullable = false)
	private int decimasextadezena ;
	
	@Column(name = "decimasetimadezena", nullable = false)
	private int decimasetimadezena ;
	
	@Column(name = "decimaoitavadezena", nullable = false)
	private int decimaoitavadezena ;
	
	@Column(name = "decimanonadezena", nullable = false)
	private int decimanonadezena ;
	
	@Column(name = "vigesimadezena", nullable = false)
	private int vigesimadezena;
	
	@Column(name = "G20", nullable = false)
	private int G20;
	
	@Column(name = "G19", nullable = false)
	private int G19;
	
	@Column(name = "G18", nullable = false)
	private int G18;
	
	@Column(name = "G17", nullable = false)
	private int G17;
	
	@Column(name = "G16", nullable = false)
	private int G16;
	
	@Column(name = "GNN", nullable = false)
	private int GNN;
	
	
	//construtor padrão
	public LotoMania() {
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
				"" + decimaquintadezena + "," +
				"" + decimasextadezena + "," +
				"" + decimasetimadezena + "," +
				"" + decimaoitavadezena + "," +
				"" + decimanonadezena + "," +
				"" + vigesimadezena ;
	}
	
	
	

}
