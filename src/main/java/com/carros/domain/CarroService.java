package com.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository rep;
	
	public Iterable<Carro> getCarros() {
		return rep.findAll();
	}

	public Optional<Carro> getCarrosById(Long id) {
		return rep.findById(id);
	}

	public Iterable<Carro> getCarrosByTipo(String tipo) {
		return rep.findByTipo(tipo);
	}
	
	public List<Carro> getCarrosFake() {
		List<Carro> carros = new ArrayList<>();

		carros.add(new Carro(1L, "Fusca"));
		carros.add(new Carro(1L, "Brasilia"));
		carros.add(new Carro(1L, "Chevette"));

		return carros;
	}

	public Carro save(Carro carro) {
		return rep.save(carro);
	}

	public Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro.");
		
		// BUSCA O CARRO NO BANCO DE DADOS
		Optional<Carro> optional = getCarrosById(id);
		if (optional.isPresent()) {
			Carro db = optional.get();
			// Copia as propriedades
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());
			System.out.println("Carro id " + db.getId());
			// Atualiza o carro
			rep.save(db);
			
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro.");
		}
	}

	public void delete(Long id) {
		// BUSCA O CARRO NO BANCO DE DADOS
		Optional<Carro> carro = getCarrosById(id);
		if (carro.isPresent()) {
			rep.deleteById(id);
		} else {
			throw new RuntimeException("Não foi possivel deletar o registro.");
		}
	}
}
