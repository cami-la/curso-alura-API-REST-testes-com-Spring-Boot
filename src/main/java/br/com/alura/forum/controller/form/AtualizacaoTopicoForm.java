package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
}
