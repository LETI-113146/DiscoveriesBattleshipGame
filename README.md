# Battleship

Basic academic version of Battleship game to build upon.


### Nickname do Grupo: Reis dos 8 Mares

> | Curso | Número | Nome |
> | :--- | :--- | :--- |
> | LETI | 129360 | Francisco Farinha |
> | LETI | 113146 | Ricardo Oliveira |
> | LETI | 129763 | Rebeca Noronha |

## Índice

- [Tipos de Navios](#tipos-de-navios)
- [Regras do Jogo](#regras-do-jogo)
- [Navios da Época dos Descobrimentos](#navios-da-época-dos-descobrimentos)
- [Respostas a Perguntas](#respostas-a-perguntas)
  
## Tipos de Navios

Nesta versão da Batalha Naval, denominada **Discoveries Battleship Game**,
os navios recebem nomes associados à época dos Descobrimentos.

Cada jogador dispõe da mesma frota, com a seguinte composição:

| Navio | Nome em inglês | Equivalente na Batalha Naval atual | Dimensão (quadrados) | Quantidade por jogador |
| :--- | :--- | :--- | :---: | :---: |
| Galeão | Galleon | Porta-aviões | 5 | 1 |
| Fragata | Frigate | Navio de 4 canhões | 4 | 1 |
| Nau | Carrack | Navio de 3 canhões | 3 | 2 |
| Caravela | Caravel | Navio de 2 canhões | 2 | 3 |
| Barca | Barge | Submarino | 1 | 4 |

A dimensão indica o número de quadrados que cada navio ocupa na grelha.
Por exemplo, um Galeão ocupa 5 quadrados e uma Barca ocupa apenas 1.

No total, cada jogador possui **11 navios**, que ocupam **25 quadrados**
da sua grelha de 10 × 10.

## Regras do Jogo

Cada jogador dispõe de duas grelhas de **10x10 quadrados**:

- uma grelha representa o seu próprio mar, onde é posicionada a sua frota;
- a outra representa o mar do adversário, onde são registados os resultados dos tiros efetuados.

### Posicionamento da Frota

Antes do início do jogo, cada jogador deve posicionar todos os seus navios na sua própria grelha.

O posicionamento dos navios deve respeitar as seguintes regras:

- os navios podem ser colocados na horizontal ou na vertical;
- todos os navios devem ficar completamente dentro dos limites da grelha;
- os navios não se podem sobrepor;
- os navios não se podem tocar entre si;
- os navios podem ficar encostados às bordas da grelha;
- a posição dos navios não é visível pelo adversário.

### Desenvolvimento do Jogo

Depois de ambos os jogadores posicionarem as suas frotas, o jogo decorre por turnos.

Em cada turno:

1. O jogador efetua uma rajada de **três tiros** sobre a grelha do adversário, indicando as coordenadas de cada tiro.
2. O adversário informa o resultado de cada tiro.
3. Cada tiro pode corresponder a:
   - um tiro na água;
   - um acerto num navio.
4. Quando aplicável, é também indicado o tipo de navio atingido.
5. O jogador regista na grelha do adversário os resultados obtidos, incluindo os navios que já foram afundados.
6. O turno passa para o outro jogador.

### Fim do Jogo

O jogo termina quando um dos jogadores consegue atingir todos os navios da frota adversária.

O primeiro jogador a destruir toda a frota do adversário é declarado vencedor.

## Navios da Época dos Descobrimentos

Nesta versão do jogo, os navios seguem os nomes usados na Era dos Descobrimentos. Abaixo encontra uma breve descrição de cada tipo, com links para saber mais.

### Galeão (Porta-aviões — 5 casas)
O galeão era um navio de grande porte, com vários conveses, usado tanto para exploração como para transporte de mercadorias e defesa militar.
[Wikipédia: Galeão](https://pt.wikipedia.org/wiki/Gale%C3%A3o)

### Fragata (Navio de 4 canhões — 4 casas)
Navio de guerra rápido e manobrável, normalmente armado com um número intermédio de canhões.
[Wikipédia: Fragata](https://pt.wikipedia.org/wiki/Fragata)

### Nau (Navio de 3 canhões — 3 casas)
A nau foi o principal navio de longo curso português, usada por Vasco da Gama na rota marítima para a Índia.
[Wikipédia: Nau](https://pt.wikipedia.org/wiki/Nau)

### Caravela (Navio de 2 canhões — 2 casas)
Embarcação leve e ágil, com velas latinas, essencial nas primeiras viagens de exploração portuguesas.
[Wikipédia: Caravela](https://pt.wikipedia.org/wiki/Caravela)

![Caravela Portuguesa](https://commons.wikimedia.org/wiki/Special:FilePath/Caravel_Boa_Esperanca_Portugal.jpg)

### Barca (Submarino — 1 casa)
Embarcação pequena e versátil, usada sobretudo para transporte costeiro e apoio a operações navais.
[Wikipédia: Barca](https://pt.wikipedia.org/wiki/Barca)

## Respostas a Perguntas
### Questão D.7 
Escolhendo como exemplo o primeiro pull request feito: 
Após analisar o Network Graph, observamos que a branch readme-rules foi criado a partir da main para adicionar as regras do jogo ao README.

O grafo mostra que a branch recebeu um commit e foi posteriormente integrada na main através de um Pull Request. Deste modo, é possível observar a bifurcação da branch e a sua posterior união com a branch principal.
Assim, como resultado, as regras do jogo foram integradas na main, preservando o histórico de desenvolvimento da branch.

### Questão E.6

1. **Como escolher uma nova User Story durante o Daily Scrum?**
   - Aceder ao separador **Issues** do repositório.
   - Selecionar uma User Story do Product Backlog.
   - Atribuir a Issue a si próprio através de `Assignees`.
   - Criar uma branch dedicada à implementação da User Story.

2. **Como indicar que uma User Story já foi implementada?**
   - Concluir a implementação e verificar os Acceptance Criteria.
   - Criar um Pull Request associado à respetiva Issue.
   - Solicitar a revisão por outro membro da equipa.
   - Após a aprovação, integrar as alterações na branch `main`.
   - Fechar a Issue como `Completed`.

3. **Como indicar que o Product Owner desistiu de uma User Story?**
   - Aceder à Issue correspondente.
   - Adicionar a etiqueta `status: WONTFIX`.
   - Publicar um comentário a explicar a decisão e o motivo do abandono.
   - Fechar a Issue como `Not planned`.
