package br.com.gregoriohd.contrroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.entity.Aluno;
import br.com.gregoriohd.service.AlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("alunos/")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	public Aluno salvarAluno(@RequestBody Aluno aluno) {

		alunoService.salvar(aluno);
		return aluno;
	}

}
