package com.ufjf.InterfaceDAO;

import org.hibernate.HibernateException;

import com.ufjf.DTO.Pergunta;

public interface IPerguntaDAO {

	boolean salvaPergunta(Pergunta pergunta) throws HibernateException;

	boolean editaPergunta(Pergunta pergunta) throws HibernateException;


}
