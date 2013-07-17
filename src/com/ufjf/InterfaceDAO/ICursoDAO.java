package com.ufjf.InterfaceDAO;

import java.util.List;

import org.hibernate.HibernateException;

import com.ufjf.DTO.Curso;

public interface ICursoDAO {

	boolean salvaCurso(Curso curso) throws HibernateException;

	boolean editaCurso(Curso curso) throws HibernateException;

	/**
	 * Retorna uma lista de cursos com quantidade de dados informadas entre o
	 * Ínicio e o Fim informados. Caso Parametros sejam iguais a null, retorna
	 * todos os Cursos do banco.
	 * 
	 * @param inicio
	 * @param fim
	 * @return {@link List}<{@link Curso}>
	 * @throws HibernateException
	 */
	List<Curso> retornaCursos(int inicio, int fim) throws HibernateException;

}
