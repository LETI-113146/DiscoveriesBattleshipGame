# Battleship

Basic academic version of Battleship game to build upon.


### Nickname do Grupo: Reis dos 8 Mares

> | Curso | Número | Nome |
> | :--- | :--- | :--- |
> | LETI | 129360 | Francisco Farinha |
> | LETI | 113146 | Ricardo Oliveira |
> | LETI | 129763 | Rebeca Noronha |

## Índice

- [Regras do Jogo](#regras-do-jogo)

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
