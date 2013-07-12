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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TipoUsuario")
public class TipoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idTipoUsuario", unique = true, nullable = false)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int idTipoUsuario;

	@Column(name = "nomeTipoUsuario", length = 45, nullable = false)
	private String nomeTipoUsuario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TipoUsuario_Permissoes", joinColumns = { @JoinColumn(name = "idTipoUsuario", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "idPermissao", nullable = false, updatable = false) })
	private List<Permissoes> permissoes = new ArrayList<Permissoes>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoUsuario")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNomeTipoUsuario() {
		return nomeTipoUsuario;
	}

	public void setNomeTipoUsuario(String nomeTipoUsuario) {
		this.nomeTipoUsuario = nomeTipoUsuario;
	}

	public List<Permissoes> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissoes> permissoes) {
		this.permissoes = permissoes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
