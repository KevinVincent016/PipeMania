public class Board {

    //Connections
    private Box head;
    private Box tail;
    private Leaderboard theLeaderboard;

    //constructor
    public Board(){

    }

    //Getter and Setter
    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public Box getTail() {
        return tail;
    }

    public void setTail(Box tail) {
        this.tail = tail;
    }

    public Leaderboard getTheLeaderboard() {
        return theLeaderboard;
    }

    public void setTheLeaderboard(Leaderboard theLeaderboard) {
        this.theLeaderboard = theLeaderboard;
    }

    //Methods
    private void addLast(Box box) {
        if (head == null) {
            head = box;
            tail = box;
        } else {
            tail.setNext(box);
            tail = box;
        }
    }

    public void createBoard(int boxes) {

        createBoard(boxes, 1);
    }

    private void createBoard(int boxes, int id) {

        if (id > boxes) {
            return;
        }

        addLast(new Box(id));
        createBoard(boxes, id + 1);
    }

    public Box search(int goal) {
        return search(goal, head);
    }

    private Box search(int goal, Box current) {

        if (current == null) {
            return null;
        }

        if (current.getId() == goal) {
            return current;
        }

        return search(goal, current.getNext());
    }

    public void putTube(int coordinate, TypeTube tubeType){

    }

    public void verifyTubes(){

    }
}
