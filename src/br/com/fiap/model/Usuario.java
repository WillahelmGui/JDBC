package br.com.fiap.model;

import java.sql.Date;

import br.com.fiap.util.CriptograficaUtils;

public class Usuario {
	private long id;
	private String nome,senha;
	private Date data;
	
	
	public Usuario(String nome, String senha) {
		this.id = id;
		this.nome = nome;
		setSenha(senha);
		this.data = new Date(System.currentTimeMillis());
	}


	public Usuario() {
	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		try {
			this.senha = CriptograficaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
}
