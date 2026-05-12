'use client';

import { useState } from 'react';
import { useRouter } from 'next/navigation';
import api from '../lib/api';
import Cookies from 'js-cookie';

export function useCadastro() {
  const router = useRouter();

  // Estados simples e separados, iguais aos do cadastro de produtos
  const [name, setName] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  // Função disparada ao clicar no botão Entrar
  function cadastro(evento: React.FormEvent) {
    evento.preventDefault(); // Evita que a página recarregue

    // Montamos o objeto que vai para a API
    const dadosCadastro = {
      name: name,
      username: username,
      password: password
    };

    api.post('/users/', dadosCadastro)
      .then((resposta) => {
        alert("Usuário cadastrado com sucesso!");

        router.push('/');
      })
      .catch(() => {
        // Mostra o erro simples se a senha estiver errada
        alert('Erro: Dados informados inválidos!');
      });
  }

  // Exportamos tudo que a tela vai precisar
  return {
    name, setName,
    username, setUsername,
    password, setPassword,
    cadastro
  };
}