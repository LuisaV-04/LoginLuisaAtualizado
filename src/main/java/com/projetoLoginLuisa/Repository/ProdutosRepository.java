package com.projetoLoginLuisa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLoginLuisa.Entity.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
}
