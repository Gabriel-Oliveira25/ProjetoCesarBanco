package br.com.cesarschool.next.oo.dao;

import java.io.Serializable;

import br.com.cesarschool.next.oo.entidade.ContaCorrente;
import br.com.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOGenerico {
	private CadastroObjetos cadastro;
	
	DAOGenerico(){
		
	}
	
	DAOGenerico(Class tipoEntidade){
		cadastro = new CadastroObjetos(tipoEntidade);
	}
	
	public boolean incluir(ContaCorrente reg) {
		RegistroIdentificavel busca = buscar(reg.obterChaves()); 
		if (busca != null) {
			return false;
		} else {
			cadastro.incluir(reg, reg.obterChaves());
			return true;
		}
	}
	
	public boolean alterar(RegistroIdentificavel reg) {
		RegistroIdentificavel busca = buscar(reg.obterChaves());
		if (busca == null) {
			return false;
		}else {
			cadastro.alterar(reg, reg.obterChaves());
			return true;
		}
	}
	
	public boolean excluir(String chave) {
		RegistroIdentificavel busca = buscar(chave);
		if (busca == null) {
			return false;
		} else {
			cadastro.excluir(chave);
			return true;
		}
	}
	
	public RegistroIdentificavel buscar(String chave) {
		return (RegistroIdentificavel)cadastro.buscar(chave);
	}
	
	public RegistroIdentificavel[] buscarTodos() {
		Serializable[] ser = cadastro.buscarTodos(RegistroIdentificavel.class);
		RegistroIdentificavel[] reg = new RegistroIdentificavel[ser.length];
		for(int i = 0; i<ser.length; i++) {
			reg[i] = (RegistroIdentificavel)ser[i];
		}
		return reg;	
	}
}
