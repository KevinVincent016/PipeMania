public class Box {

    //Atribute
    private int id;
    private TypeTube tubeType;

    //Connections
    private Box next;
    private Box prev;

    //Constructor
    public Box(int id){
        this.id = id;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTube getTubeType() {
        return tubeType;
    }

    public void setTubeType(TypeTube tubeType) {
        this.tubeType = tubeType;
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }

    public Box getPrev() {
        return prev;
    }

    public void setPrev(Box prev) {
        this.prev = prev;
    }

}
