package br.com.gregoriohd.contrroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gregoriohd.entity.Aluno;
import br.com.gregoriohd.service.AlunoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
		alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> obterAlunoPorId(@PathVariable Long id) {
		Aluno aluno = alunoService.obterPorId(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
		Aluno alunoValid = alunoService.atualizar(id, aluno);
        if (alunoValid != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerAluno(@PathVariable Long id) {
		Aluno aluno = alunoService.obterPorId(id);
		if (aluno != null) {
			alunoService.remover(aluno);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}

}
