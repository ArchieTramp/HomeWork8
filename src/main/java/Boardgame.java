/**
 * Класс для сериализации
 * с полями разных типов, в том числе
 * ссылочным полем на другой класс.
 *
 * @author Artur Gilyazov
 */

public class Boardgame {
    private String difficulty = "Hard";
    private String name = "Monopoly1";
    private final int cost = 1500;
    protected double victoryChance = 1.04;
    BGStore bgStore = new BGStore();

    @Override
    public String toString() {
        return "Boardgame " + "name " + name + " is " + difficulty + " you can buy in Store " + bgStore + " and cost "
                + cost + " but your victory chance " + victoryChance;
    }

}
