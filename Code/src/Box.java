public class Box {

    //Atribute
    private int id;
    private TypeTube tubeType;

    //Connections
    private Box next;
    private Box prev;

    //Constructor
    public Box(int id, TypeTube tubeType){
        this.id = id;
        this.tubeType = tubeType;
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

    public String toString(){
        if(tubeType==TypeTube.TYPEHORIZONTAL){
            return "[ == ]";
        }
        if(tubeType==TypeTube.TYPEVERTICAL){
            return  "[ || ]";
        }
        if(tubeType==TypeTube.TYPENINETY){
            return "[  O ]";
        }
        if(tubeType==TypeTube.F){
            return "[  F ]";
        }
        if(tubeType==TypeTube.D){
            return "[  D ]";
        }else{
            return "[  X ]";
        }
    }

}
