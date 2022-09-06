public class Player {

    //Atributes
    private String name;
    private int score;

    //Connections
    private Player left;
    private Player right;

    //Constructor
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    //Getter and Setter
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player getLeft() {
        return left;
    }

    public void setLeft(Player left) {
        this.left = left;
    }

    public Player getRight() {
        return right;
    }

    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public void setRight(Player right) {
        this.right = right;
    }
}
