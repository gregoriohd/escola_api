package br.com.gregoriohd.service;

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

}
