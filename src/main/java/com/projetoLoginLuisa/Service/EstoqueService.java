package com.projetoLoginLuisa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginLuisa.Entity.Estoque;
import com.projetoLoginLuisa.Repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	final private EstoqueRepository estoqueRepository;

	public EstoqueService(EstoqueRepository estoqueRepository) {
		this.estoqueRepository = estoqueRepository;
	}

	public List<Estoque> buscarTodosEstoque() {
		return estoqueRepository.findAll();
	}

	public Estoque buscarEstoquePorId(Long id) {
		Optional<Estoque> Estoque = estoqueRepository.findById(id);
		return Estoque.orElse(null);
	}

	public Estoque salvarEstoque(Estoque atEstoque) {
		return estoqueRepository.save(atEstoque);
	}

	public Estoque atualizarEstoque(Long id, Estoque atEstoque) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);
		if (exeEstoque.isPresent()) {
			atEstoque.setId(id);
			return estoqueRepository.save(atEstoque);
		} else {
			return null;
		}
	}

	public Boolean apagarEstoque(Long id) {
		Optional<Estoque> exeEstoque = estoqueRepository.findById(id);
		if (exeEstoque.isPresent()) {
			estoqueRepository.deleteById(id);
			return true;
		}
		return false;
	}
}