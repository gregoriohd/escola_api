package br.com.gregoriohd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gregoriohd.entity.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	@Query("SELECT DISTINCT s FROM Serie s LEFT JOIN FETCH s.alunos")
	List<Serie> findSeriesWithAlunos();
	

}
