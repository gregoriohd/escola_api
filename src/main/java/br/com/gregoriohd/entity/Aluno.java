package br.com.gregoriohd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = -4549014692818241289L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "numero_matricula", nullable = false)
	private String numeroMatricula;

	@ManyToOne
	@JoinColumn(name = "serie_id")
	@JsonBackReference
	private Serie serie;

	private String email;
	private String telefone;
	private String endereco;
	private int anoIngresso;
	private String status;

}
