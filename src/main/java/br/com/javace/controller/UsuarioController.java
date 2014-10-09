package br.com.javace.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.javace.model.Usuario;
import br.com.javace.service.UsuarioService;

@Controller
@Path("/usuario")
public class UsuarioController {

	private final UsuarioService service;
	
	private final Result result;
	
	private Validator validator;
	
	/**
     * @deprecated CDI eyes only
     */
    protected UsuarioController() {
        this(null, null, null);
    }
	
    @Inject
    public UsuarioController(Result result, UsuarioService service, Validator validator){
    	this.result = result;
    	this.service = service;
    	this.validator = validator;
    	
    }
    
	public void listar() {
		result.include("usuarios", service.listar());
	}

	@Post
	@Path("/adiciona")
	public void adiciona(Usuario usuario) {
		service.adiciona(usuario);
		validator.addIf(usuario.getUsername() == null, new SimpleMessage("usuario", "Login não informado!"));
		validator.addIf(usuario.getPassword() == null, new SimpleMessage("senha", "Senha não informada!"));
		validator.onErrorRedirectTo(this).paginaDeIncluir();
		result.include("sucesso", "Usuario adicionado com sucesso!");
	}

	@Get
	@Path("/")
	public void paginaDeIncluir() {
	}
}