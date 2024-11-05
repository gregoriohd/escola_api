package br.com.gregoriohd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gregoriohd.entity.Serie;
import br.com.gregoriohd.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository serieRepository;

	@Transactional(readOnly = true)
	public List<Serie> obterSeries() {
		return serieRepository.findSeriesWithAlunos();
	}
}
