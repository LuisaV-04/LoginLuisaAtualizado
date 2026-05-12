package com.projetoLoginLuisa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoLoginLuisa.Entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	Login findByUsername (String username);
}
