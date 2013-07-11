package com.ufjf.DTO;

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
@Table(name = "Usuario")
public class Usuario {

	@Id
	@Column(name = "idUsuario", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idUsuario;

	@Column(name = "matricula", unique = true, length = 45, nullable = false)
	private String matricula;

	@Column(name = "senha", length = 45, nullable = false)
	private String senha;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@Column(name = "nomeUsuario", length = 45, nullable = false)
	private String nomeUsuario;

	@Column(name = "titulacao", length = 45, nullable = true)
	private String titulacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoUsuario", nullable = true)
	private TipoUsuario tipoUsuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCurso", nullable = true)
	private Curso curso;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	private List<TCC> TCC = new ArrayList<TCC>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orientador")
	private List<TCC> orienta = new ArrayList<TCC>();

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TCC> getTCC() {
		return TCC;
	}

	public void setTCC(List<TCC> tCC) {
		TCC = tCC;
	}

	public List<TCC> getOrienta() {
		return orienta;
	}

	public void setOrienta(List<TCC> orienta) {
		this.orienta = orienta;
	}

}
