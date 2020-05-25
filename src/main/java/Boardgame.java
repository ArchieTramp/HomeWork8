public class Boardgame {
    private String difficulty = "Hard";
    private String name = "Monopoly";
    private final int cost = 1500;
    protected double victoryChance = 1.04;
    BGStore bgStore = new BGStore();

    @Override
    public String toString() {
        return "Boardgame " + "name " + name + "is" + difficulty + "in Store" + bgStore + "and cost" + cost + "but your victory chance" + victoryChance;
    }

}
