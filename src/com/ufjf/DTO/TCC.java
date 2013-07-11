package com.ufjf.DTO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TCC")
public class TCC {

	@Id
	@Column(name = "idTCC", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idTCC;

	@Column(name = "nomeTCC", length = 45, nullable = true)
	private String nomeTCC;

	@Column(name = "arquivoTCCBanca", length = 45, nullable = true)
	private String arquivoTCCBanca;

	@Column(name = "arquivoTCCFinal", length = 45, nullable = true)
	private String arquivoTCCFinal;

	@Column(name = "salaDefesa", length = 45, nullable = true)
	private String salaDefesa;

	@Column(name = "resumoTCC", length = 45, nullable = true)
	private String resumoTCC;

	@Column(name = "parecerBanca", length = 45, nullable = true)
	private String parecerBanca;

	@Column(name = "conceitoFinal", nullable = true)
	private float conceitoFinal;

	@Column(name = "dataApresentacao", nullable = true)
	private Timestamp dataApresentacao;

	@Column(name = "dataEnvioBanca", nullable = true)
	private Timestamp dataEnvioBanca;

	@Column(name = "dataEnvioFinal", nullable = true)
	private Timestamp dataEnvioFinal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idAluno", nullable = true)
	private Usuario aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrientador", nullable = true)
	private Usuario orientador;

	public int getIdTCC() {
		return idTCC;
	}

	public void setIdTCC(int idTCC) {
		this.idTCC = idTCC;
	}

	public String getNomeTCC() {
		return nomeTCC;
	}

	public void setNomeTCC(String nomeTCC) {
		this.nomeTCC = nomeTCC;
	}

	public String getArquivoTCCBanca() {
		return arquivoTCCBanca;
	}

	public void setArquivoTCCBanca(String arquivoTCCBanca) {
		this.arquivoTCCBanca = arquivoTCCBanca;
	}

	public String getArquivoTCCFinal() {
		return arquivoTCCFinal;
	}

	public void setArquivoTCCFinal(String arquivoTCCFinal) {
		this.arquivoTCCFinal = arquivoTCCFinal;
	}

	public String getSalaDefesa() {
		return salaDefesa;
	}

	public void setSalaDefesa(String salaDefesa) {
		this.salaDefesa = salaDefesa;
	}

	public String getResumoTCC() {
		return resumoTCC;
	}

	public void setResumoTCC(String resumoTCC) {
		this.resumoTCC = resumoTCC;
	}

	public String getParecerBanca() {
		return parecerBanca;
	}

	public void setParecerBanca(String parecerBanca) {
		this.parecerBanca = parecerBanca;
	}

	public float getConceitoFinal() {
		return conceitoFinal;
	}

	public void setConceitoFinal(float conceitoFinal) {
		this.conceitoFinal = conceitoFinal;
	}

	public Timestamp getDataApresentacao() {
		return dataApresentacao;
	}

	public void setDataApresentacao(Timestamp dataApresentacao) {
		this.dataApresentacao = dataApresentacao;
	}

	public Timestamp getDataEnvioBanca() {
		return dataEnvioBanca;
	}

	public void setDataEnvioBanca(Timestamp dataEnvioBanca) {
		this.dataEnvioBanca = dataEnvioBanca;
	}

	public Timestamp getDataEnvioFinal() {
		return dataEnvioFinal;
	}

	public void setDataEnvioFinal(Timestamp dataEnvioFinal) {
		this.dataEnvioFinal = dataEnvioFinal;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Usuario getOrientador() {
		return orientador;
	}

	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}

}
