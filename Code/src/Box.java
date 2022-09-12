public class Box {

    //Atribute
    private int row;
    private int colum;
    private TypeTube tubeType;

    //Connections
    private Box next;

    //Constructor
    public Box(int row, int colum, TypeTube tubeType){
        this.row = row;
        this.colum = colum;
        this.tubeType = tubeType;
    }

    //Getter and Setter
    public int getRow() {
        return row;
    }

    public void setId(int row) {
        this.row = row;
    }

    public int getColum() { return colum; }

    public void setColum(int colum) { this.colum = colum; }

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
