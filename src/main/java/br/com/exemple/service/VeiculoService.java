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
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> getVeiculoUsuario(Long idUsuario) {
		List<Veiculo> veiculoList = getVeiculoUsuario(idUsuario);
		for (Veiculo veiculo : veiculoList) {
			veiculo.rodizioAtivo();
			veiculo.diaRodizio();
		}
		return veiculoList;
	}

}
