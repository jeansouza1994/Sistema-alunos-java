# Sistema de Gestão de Notas de Alunos

Este projeto é um sistema simples para gerenciar dados de alunos, permitindo realizar operações de cadastro, edição, exclusão e consulta, além de gerar relatórios estatísticos baseados nas notas. Desenvolvido em **Java**, utilizando **MySQL** como banco de dados, e rodado no ambiente **IntelliJ IDEA**.

---

##  Funcionalidades

1. **Gerenciamento de Alunos:**
   - Inserir novo aluno
   - Alterar dados do aluno
   - Excluir aluno
   - Consultar dados de alunos cadastrados

2. **Regras de Negócio:**
   - `simulado1` e `simulado2`: valores entre **0 e 1 ponto**
   - `av` (Avaliação Final): valor entre **0 e 10 pontos**
   - `genero`: 
     - `1` - Masculino
     - `2` - Feminino
   - **Nota final** = simulado1 + simulado2 + av (máximo de **10 pontos**)

3. **Relatórios:**
   - Total de alunos com nota final **acima de 7**
   - Total de **alunas** (gênero feminino) com nota final **acima de 7**
   - Listagem de todos os alunos com suas notas
   - Cálculo da **média geral da turma**

---

## Como Executar

**Clone o repositório**:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

 Para executar o sistema, é necessário criar o banco de dados e a tabela de alunos no MySQL. Utilize o script abaixo:

```sql
CREATE DATABASE IF NOT EXISTS escola;

USE escola;

CREATE TABLE IF NOT EXISTS alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    simulado1 DOUBLE,
    simulado2 DOUBLE,
    av DOUBLE,
    genero INTEGER,
    notafinal DOUBLE
);
```
