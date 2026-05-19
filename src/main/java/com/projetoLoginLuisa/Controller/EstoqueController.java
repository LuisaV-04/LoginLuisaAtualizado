package com.projetoLoginLuisa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoLoginLuisa.Entity.Estoque;
import com.projetoLoginLuisa.Service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	public EstoqueController(EstoqueService estoqueService) {
		this.estoqueService = estoqueService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estoque> buscarEstoqueId(@PathVariable Long id) {
		Estoque estoque = estoqueService.buscarEstoquePorId(id);
		if (estoque != null) {
			return ResponseEntity.ok(estoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Estoque>> buscarTodosEstoque() {
		List<Estoque> produtos = estoqueService.buscarTodosEstoque();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping("/")
	public ResponseEntity<Estoque> salvaProduto(@RequestBody Estoque estoque) {
		Estoque saveEstoque = estoqueService.salvarEstoque(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEstoque);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estoque> alteraProdutos(@PathVariable Long id, @RequestBody Estoque estoque) {
		Estoque atualizaEstoque = estoqueService.atualizarEstoque(id, estoque);
		if (atualizaEstoque != null) {
			return ResponseEntity.ok(atualizaEstoque);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Estoque> apagaEstoque(@PathVariable Long id) {
		boolean apagaEstoque = estoqueService.apagarEstoque(id);
		if (apagaEstoque) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}