package iscteiul.ista.battleship;

/**
 * Representa uma Barca no jogo Batalha Naval (versão "Descobrimentos").
 * <p>
 * A Barca corresponde ao navio mais pequeno do jogo (equivalente ao
 * "Submarino" da versão tradicional), ocupando apenas uma célula do
 * tabuleiro. Cada frota deve conter quatro barcas, de acordo com a
 * especificação do jogo.
 *
 * @author (o teu nome aqui)
 * @see Ship
 */
public class Barge extends Ship {

    /**
     * Dimensão fixa da Barca: ocupa sempre uma única célula do tabuleiro.
     */
    private static final Integer SIZE = 1;

    /**
     * Nome do navio, usado para identificação e apresentação ao utilizador.
     */
    private static final String NAME = "Barca";

    /**
     * Cria uma nova Barca na posição indicada.
     * <p>
     * Como a Barca tem dimensão 1, a orientação (bearing) não influencia
     * as células ocupadas: a única posição do navio corresponde sempre
     * à posição inicial fornecida.
     *
     * @param bearing orientação da barca (horizontal ou vertical)
     * @param pos     posição superior esquerda (linha, coluna) da barca no tabuleiro
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Devolve a dimensão da Barca.
     *
     * @return o valor fixo {@code 1}, correspondente ao tamanho da Barca
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
