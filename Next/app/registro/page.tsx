'use client';

import Link from 'next/link';
import { useCadastro } from '../hooks/useCadastro';
import '../formStyle.css';

export default function Cadastro() {
  // Puxamos as funções e variáveis do nosso Hook
  const { 
    username, setUsername, 
    password, setPassword,
    name, setName, 
    cadastro
  } = useCadastro();

  return (
    <div className="login-container">
      <div className="login-card">
        <h1>Cadastro de usuários</h1>
        
        {/* Quando o formulário for submetido, chama a função entrar */}
        <form onSubmit={cadastro}>
          
          <div className="input-group">
            <input
              type="text"
              placeholder="Digite seu Nome"
              value={name}
              onChange={(e) => setName(e.target.value)} // Atualiza apenas o username
              className="input-field"
              required
            />
          </div>


          <div className="input-group">
            <input
              type="text"
              placeholder="Digite seu Usuário"
              value={username}
              onChange={(e) => setUsername(e.target.value)} // Atualiza apenas o username
              className="input-field"
              required
            />
          </div>
          
          <div className="input-group">
            <input
              type="password"
              placeholder="Digite sua Senha"
              value={password}
              onChange={(e) => setPassword(e.target.value)} // Atualiza apenas o password
              className="input-field"
              required
            />
          </div>

          <button type="submit" className="btn-login">
            Cadastrar
          </button>
        </form>

        <div className="footer-link">
          <span>Já possui uma conta? </span>
          <Link href="/">Faça login aqui</Link>
        </div>
      </div>
    </div>
  );
}