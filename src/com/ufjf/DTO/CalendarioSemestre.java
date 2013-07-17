package com.ufjf.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CalendarioSemestre")
public class CalendarioSemestre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCalendarioSemestre", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idCalendarioSemestre;

	@Column(name = "inicioSemestre", nullable = false)
	private Date inicioSemestre;

	@Column(name = "finalSemestre", nullable = false)
	private Date finalSemestre;

	@Column(name = "nomeCalendarioSemestre", nullable = false)
	private int nomeCalendarioSemestre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", nullable = false)
	private Curso curso;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calendarioSemestre")
	private List<Questionario> questionarios = new ArrayList<Questionario>();

	public int getIdCalendarioSemestre() {
		return idCalendarioSemestre;
	}

	public void setIdCalendarioSemestre(int idCalendarioSemestre) {
		this.idCalendarioSemestre = idCalendarioSemestre;
	}

	public Date getInicioSemestre() {
		return inicioSemestre;
	}

	public void setInicioSemestre(Date inicioSemestre) {
		this.inicioSemestre = inicioSemestre;
	}

	public Date getFinalSemestre() {
		return finalSemestre;
	}

	public void setFinalSemestre(Date finalSemestre) {
		this.finalSemestre = finalSemestre;
	}

	public int getNomeCalendarioSemestre() {
		return nomeCalendarioSemestre;
	}

	public void setNomeCalendarioSemestre(int nomeCalendarioSemestre) {
		this.nomeCalendarioSemestre = nomeCalendarioSemestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Questionario> getQuestionarios() {
		return questionarios;
	}

	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
	}

}
