package br.com.javace.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.javace.model.Usuario;

@SessionScoped
@Named("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao, Serializable {
	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarioList = new ArrayList<Usuario>(); 
	
	public List<Usuario> listar() {
		return usuarioList;
	}

	public void adiciona(Usuario usuario) {
		usuarioList.add(usuario);
	}

}
