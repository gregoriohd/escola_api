package br.com.gregoriohd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gregoriohd.entity.Aluno;
import br.com.gregoriohd.entity.Serie;
import br.com.gregoriohd.repository.AlunoRepository;
import br.com.gregoriohd.repository.SerieRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Transactional(readOnly = false)
	public Aluno salvarSerie(Aluno aluno, Long serieId) {
		Serie serie = serieRepository.findById(serieId)
	            .orElseThrow(() -> new RuntimeException("Série não encontrada"));
		aluno.setSerie(serie);
		
		return alunoRepository.save(aluno);
		
	}
	
	@Transactional(readOnly = false)
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@Transactional(readOnly = true)
	public Aluno obterPorId(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Aluno> obterAlunos() {
		return alunoRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public Aluno atualizar(Long id, Aluno aluno) {
		Optional<Aluno> alunoFind = alunoRepository.findById(id);
		
		if(!alunoFind.isPresent()) {
			return null;
		}
		aluno.setId(alunoFind.get().getId());
		
		alunoRepository.save(aluno);
		
		return aluno;
		
	}
	
	@Transactional(readOnly = false)
	public void remover(Aluno aluno) {
		alunoRepository.delete(aluno);
	}	

}
