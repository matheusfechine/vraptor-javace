package br.com.javace.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.javace.dao.UsuarioDao;
import br.com.javace.model.Usuario;

@Controller
@Path("/usuario")
public class UsuarioController {

	private final UsuarioDao usuarioDao;

	private final Result result;

	private Validator validator;

	/**
	 * @deprecated CDI eyes only
	 */
	protected UsuarioController() {
		this(null, null, null);
	}

	@Inject
	public UsuarioController(Result result, UsuarioDao usuarioDao,
			Validator validator) {
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.validator = validator;

	}

	@Get("/lista")
	public void lista() {
		result.include("usuarios", usuarioDao.listar());
	}

	@Post("/adiciona")
	public void adiciona(Usuario usuario) {
		usuarioDao.adiciona(usuario);
		validator.addIf(usuario.getLogin() == null, new SimpleMessage(
				"usuario", "Login não informado!"));
		validator.addIf(usuario.getSenha() == null, new SimpleMessage(
				"senha", "Senha não informada!"));
		validator.onErrorRedirectTo(this).index();
		result.include("sucesso", "Usuario adicionado com sucesso!");
		result.redirectTo(this).index();
	}

	@Get
	@Path("/")
	public void index() {
	}
}