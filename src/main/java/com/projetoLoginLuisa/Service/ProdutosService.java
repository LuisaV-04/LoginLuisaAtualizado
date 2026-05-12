package com.projetoLoginLuisa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetoLoginLuisa.Entity.Produtos;
import com.projetoLoginLuisa.Repository.ProdutosRepository;

@Service
public class ProdutosService {
	final private ProdutosRepository produtosRepository;

	public ProdutosService(ProdutosRepository produtosRepository) {
		this.produtosRepository = produtosRepository;
	}

	public List<Produtos> buscarTodosProdutos() {
		return produtosRepository.findAll();
	}

	public Produtos buscarProdutosPorId(Long id) {
		Optional<Produtos> Produtos = produtosRepository.findById(id);
		return Produtos.orElse(null);
	}

	public Produtos salvarProdutos(Produtos atProdutos) {
		return produtosRepository.save(atProdutos);
	}

	public Produtos atualizarProdutos(Long id, Produtos atProdutos) {
		Optional<Produtos> exeProdutos = produtosRepository.findById(id);
		if (exeProdutos.isPresent()) {
			atProdutos.setId(id);
			return produtosRepository.save(atProdutos);
		} else {
			return null;
		}
	}

	public Boolean apagarProdutos(Long id) {
		Optional<Produtos> exeProdutos = produtosRepository.findById(id);
		if (exeProdutos.isPresent()) {
			produtosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}