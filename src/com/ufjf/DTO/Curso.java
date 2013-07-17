package com.ufjf.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCurso", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idCurso;

	@Column(name = "nomeCurso", length = 45, nullable = false)
	private String nomeCurso;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	private List<Questionario> questionarios = new ArrayList<Questionario>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	private List<CalendarioSemestre> calendarios = new ArrayList<CalendarioSemestre>();

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Questionario> getQuestionarios() {
		return questionarios;
	}

	public void setQuestionarios(List<Questionario> questionarios) {
		this.questionarios = questionarios;
	}

	public List<CalendarioSemestre> getCalendarios() {
		return calendarios;
	}

	public void setCalendarios(List<CalendarioSemestre> calendarios) {
		this.calendarios = calendarios;
	}

}
