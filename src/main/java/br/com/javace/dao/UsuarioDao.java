package br.com.javace.dao;

import java.util.List;

import br.com.javace.model.Usuario;

public interface UsuarioDao {

	public List<Usuario> listar();

	public void adiciona(Usuario usuario);

}
