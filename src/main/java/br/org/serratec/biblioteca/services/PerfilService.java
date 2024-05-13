package br.org.serratec.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repositories.PerfilRepository;

@Service // contem a lógica de negocio da aplicaçao
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> findAll() { // procura todos e retorna uma lista
		return perfilRepository.findAll();
	}

	public Perfil findById(Integer id) { // procura os id e traz um somente
		return perfilRepository.findById(id).orElse(null); // ele procura o id e se nao encontrar nada devolve nulo. se
															// for get() vai dar erro
	}

	public Perfil save(Perfil perfil) { 
		return perfilRepository.save(perfil);
	}
	
	public Perfil updatePerfil(Perfil perfil, Perfil perfilNovo) {		
		try {
			perfil.setNome(perfilNovo.getNome());
			perfil.setDescricao(perfilNovo.getDescricao());
			
			return perfilRepository.save(perfil);	
		} catch (Exception e) {
			System.out.println(e);
		}
		return perfilRepository.save(perfil);
	}
	

	public Perfil update(Perfil perfil) { 
		return perfilRepository.save(perfil);
	}

	public Perfil delete(Integer id) {
		Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
		
		if (perfilDeletado != null) {
			try {
				perfilRepository.deleteById(id);
				return perfilDeletado;
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return perfilDeletado;
		
	}

	public long count() { //conta os numeros de registros, serve para paginação.
		return perfilRepository.count();	
	}
}
