# 🚀Dominó em Java

Desenvolvedores: Helder Nicollas, Gabriel Dias, Maria Julya e Cayo de Almeida.

## Estrutura da aplicação
### Classe Player
Propriedades:
-Nome
-Peça
-Avaliação da peça
-pontos na rodada
-total de pontos no jogo

Métodos:
-ganhar pontos totais

### Classe Piece
Propriedades:
-lado 1
-lado 2
Métodos:
-Regras para avaliação de peça

### Funcionamento da classe Game

1 - São criados 3 jogadores que recebem o nome no método registerPlayers.
2 - Ocorre uma repetição de 3 rodadas e em cada rodada ocorre a vericação do player que está fazendo a jogada atual.
3 - Será feita a avaliação da peça atual e o player atual que receberá a avaliação da peça.
4 - No método executeRulesOfPoints, o jogo irá realizar todas as verificações das avaliações das 
    peças de todos os jogadores e determinar a pontuação de cada um.
5 - O método showPlayersPointsOfRound serve para mostrar os pontos de todos os jogadores na rodada.
6 - No método showFinalRanking, o jogo irá mostrar um ranking com o 1º, 2º e 3º colocado de acordo suas pontuações totais.

