package com.ufjf.DTO;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "Questionario")
public class Questionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idQuestionario", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idResposta;

	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", nullable = false)
	private Curso curso;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionarios")
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCalendarioSemestre", nullable = false)
	private CalendarioSemestre calendarioSemestre;

	public int getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public CalendarioSemestre getCalendarioSemestre() {
		return calendarioSemestre;
	}

	public void setCalendarioSemestre(CalendarioSemestre calendarioSemestre) {
		this.calendarioSemestre = calendarioSemestre;
	}

}
