package br.com.controleAcesso

import br.com.eventos.Endereco;
import br.com.eventos.TipoInscricao;
import br.com.eventos.UniaoJuvenil;

class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String nome
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false
	UsuarioGrupo usuarioGrupo
	String email
	TipoInscricao tipoInscricao
	Endereco endereco
	UniaoJuvenil juventude
	Date nascimento
	boolean membroIelb 
	boolean participaSantaCeia 
	String estadoCivil
	String sexo
	
	Usuario(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof Usuario && other.username == username)
	}

	Set<Permissao> getAuthorities() {
		UsuarioPermissao.findAllByUsuario(this)*.permissao
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		nome nullable: true
		username blank: false, unique: true
		password blank: false
		usuarioGrupo nullable: false
		email nullable: true
		tipoInscricao nullable: true
		endereco nullable: true
		juventude nullable: true
		nascimento nullable: true
		estadoCivil nullable: true
		sexo nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
	
	public String getAtivo() {
		if (enabled)
			return "Sim"
		else
			return "Não"
	}
}
