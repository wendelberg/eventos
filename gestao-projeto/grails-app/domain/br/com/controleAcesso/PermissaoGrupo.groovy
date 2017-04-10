package br.com.controleAcesso

class PermissaoGrupo {

	String nome
	PermissaoGrupoMenu permissaoGrupoMenu

	static constraints = {
		nome blank: false, unique: true
	}

}
