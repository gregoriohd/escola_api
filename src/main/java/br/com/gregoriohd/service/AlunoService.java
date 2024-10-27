package br.com.gregoriohd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gregoriohd.entity.Aluno;
import br.com.gregoriohd.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Transactional(readOnly = false)
	public void salvar(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	@Transactional(readOnly = true)
	public Aluno obterPorId(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = false)
	public Aluno atualizar(Long id, Aluno aluno) {
		Optional<Aluno> alunoFind = alunoRepository.findById(id);
		
		if(!alunoFind.isPresent()) {
			return null;
		}
		aluno.setId(alunoFind.get().getId());
		salvar(aluno);
		
		return aluno;
		
	}
	
	@Transactional(readOnly = false)
	public void remover(Aluno aluno) {
		alunoRepository.delete(aluno);
	}
	
	

}
