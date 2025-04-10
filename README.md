# 📦 Backend - TudoAqui

Este repositório armazena o **back-end principal** do aplicativo **TudoAqui**, desenvolvido como parte do Projeto Integrador do Centro Universitário Salesiano. O projeto consiste em uma plataforma (app e site) que funciona como um **marketplace de serviços autônomos**, facilitando o encontro entre clientes e profissionais freelancers de diversas áreas, como encanadores, manicures, trancistas, eletricistas, cabeleireiros, entre outros.

---

## 💡 Visão Geral do Projeto

O **TudoAqui** é composto por múltiplos serviços e tecnologias, divididos em repositórios distintos para facilitar a organização, escalabilidade e manutenibilidade da aplicação.

---

## 🧩 Estrutura dos Serviços

A arquitetura do back-end é composta por **três serviços independentes**, cada um com responsabilidades específicas:

### 🔐 Serviço de Autenticação

- Responsável pelo login e autenticação de usuários.
- Utiliza o **Supabase Authenticator**.
- Retorna um **JWT** para autenticação entre os serviços.
- 🔗 **Repositório:** [Adicionar link aqui]

---

### 💬 Serviço de Mensagens

- Responsável por armazenar e gerenciar mensagens trocadas entre usuários.
- Desenvolvido em **Node.js**.
- Banco de dados separado no **Supabase**.
- **Deploy** realizado no **Render**.
- 🔗 **Repositório:** [Adicionar link aqui]

---

### 🧾 Serviço de Dados (Este Repositório)

- Armazena os **dados dos usuários** e dos **serviços prestados**.
- Desenvolvido em **Java** com **Spring Boot**.
- Banco de dados separado e gerenciado via **Supabase**.
- **Deploy** realizado no **Render**.
- 🔗 **Swagger:** [Adicionar link se disponível]

---

## 🎨 Front-end

### 📱 Aplicativo Mobile
- Desenvolvido em **Flutter**.
- Interface moderna e responsiva para Android.
- 🔗 **Repositório:** https://github.com/Samueldg23/Freela_Flutter

### 💻 Site
- Desenvolvido em **React**.
- Hospedado via **Vercel**.
- 🔗 **Repositório:** [Adicionar link aqui]

---

## 🚀 Tecnologias Utilizadas

- **Java + Spring Boot**
- **Node.js**
- **Flutter**
- **React**
- **Supabase (Auth + Banco de Dados)**
- **Render** (Deploy back-end)
- **Vercel** (Deploy front-end web)

---

## 👨‍💻 Time de Desenvolvimento

Projeto desenvolvido por estudantes do curso de Análise e Desenvolvimento de Sistemas com o objetivo de aplicar conhecimentos práticos em desenvolvimento de software fullstack.
Este projeto é apenas para fins educacionais e de apresentação acadêmica.
---
