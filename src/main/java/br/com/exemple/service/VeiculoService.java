package br.com.exemple.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.exemple.model.Veiculo;
import br.com.exemple.repository.VeiculoRepository;

@Service
public class VeiculoService {
	private final VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	public Veiculo salvar(Veiculo veiculo) {
		Veiculo addVeiculo = veiculoRepository.save(veiculo);	
		addVeiculo.rodizioAtivo();
		addVeiculo.diaRodizio();;
		return addVeiculo;
	}

	public List<Veiculo> listaVeiculosUsuario(String cpf) {
		List<Veiculo> veiculoList = veiculoRepository.findByCPF(cpf);
		for (Veiculo veiculo : veiculoList) {
			veiculo.rodizioAtivo();
			veiculo.diaRodizio();
		}
		return veiculoList;
	}

}
