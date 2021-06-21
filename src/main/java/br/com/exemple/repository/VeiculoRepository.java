package br.com.exemple.repository;

import br.com.exemple.model.Veiculo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{

	List<Veiculo> findByCPF(@Param("CPF")String cpf);

}
