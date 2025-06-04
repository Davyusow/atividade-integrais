
---

# Cálculo de Integrais Numéricas

> Programa desenvolvido para calcular integrais numéricas utilizando métodos como **trapézio** e **Simpson**, com suporte a múltiplas regras e cálculo de erro associado.

---

## Métodos Suportados

### Método do Trapézio
- **Regra simples**  
- **Regra composta**  

### Método de Simpson
- **Regra 1/3**  
- **Regra 3/8**  
- **Regra composta**  

---

## Como Usar

1. **Inicie o programa** e selecione o método desejado (trapézio ou Simpson).  
2. **Escolha a regra** (simples, composta, 1/3, ou 3/8).  
3. **Insira os valores solicitados**:  
   - Limites de integração (`a` e `b`).  
   - Função a ser integrada (use `x` como variável).  
   - Número de subintervalos (para regras compostas).  

⚠️ **Observação**: O programa reconhece apenas a incógnita `x`.

---

## Sintaxe Usada

### Operadores Matemáticos
| Operação        | Sintaxe |
|-----------------|---------|
| Adição          | `+`     |
| Subtração       | `-`     |
| Multiplicação   | `*`     |
| Divisão         | `/`     |
| Potência        | `^`     |
| Módulo          | `%`     |

### Constantes
| Constante       | Sintaxe |
|-----------------|---------|
| Euler           | `e`     |
| Pi(π)           | `pi`    |


### Funções Matemáticas
| Função           | Sintaxe    | Exemplo     |
|------------------|------------|-------------|
| Seno             | `sen(x)`   | `sen(pi/2)` |
| Cosseno          | `cos(x)`   | `cos(0)`    |
| Tangente         | `tan(x)`   | `tan(pi/4)` |
| Secante          | `sec(x)`   | `sec(1)`    |
| Cossecante       | `cosec(x)` | `cosec(1)`  |
| Cotangente       | `cotg(x)`  | `cotg(0.5)` |
| Logaritmo natural| `ln(x)`    | `ln(1)`     |
| Arco tangente    | `arctg(x)` | `arctg(1)`  |
| Arco seno        | `arcsen(x)`| `arcsen(1)` |
| Arco cosseno     | `arccos(x)`| `arccos(1)` |
| Exponencial      | `^(x)`     | `e^(2)`     |


---


## Instalação e Execução

### Pré-requisitos
- **Java** instalado (versão 8 ou superior).  
- Download do executável: [Releases](https://github.com/Davyusow/atividade-integrais/releases).  

### Linux
1. Abra o terminal no diretório do arquivo.  
2. Execute:  
   ```bash
   java -jar atividade-integral.jar
   ```
   *Ou*:  
   ```bash
   chmod +x Linux.sh  # Dar permissão de execução
   ./Linux.sh         # Rodar o script
   ```
   Também é possível clicando com o botão direito no arquivo > propriedades > Executável como programa  
   Após isso é só clicar com o botão direito no arquivo e **Executar como programa**

### Windows (PowerShell)
1. Navegue até o diretório do arquivo.  
2. Execute:  
   ```powershell
   java -jar atividade-integral.jar
   ```
   *Ou Caso não tenha permitido a execução de scripts*:  
   ```powershell
   Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass  # Permitir scripts
   ```
   Ou Clique com o botão direito no arquivo **Windows.ps1** e execute com o powershell


---

## Grupo

- Caio Vinicius Marinho  
- Dayvson da Silva Farias  
- Giovanna Costa da Silva  
- Matheus Aroxa Teixeira de Souza  
- Miguel Monteiro Alves Paes  

---
