package com.ufjf.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Permissoes")
public class Permissoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPermissao", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idPermissao;

	@Column(name = "nomePermissao", length = 45, nullable = false)
	private String nomePermissao;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissoes")
	private List<TipoUsuario> tipousuario = new ArrayList<TipoUsuario>();

	public int getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(int idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}

	public List<TipoUsuario> getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(List<TipoUsuario> tipousuario) {
		this.tipousuario = tipousuario;
	}

}
