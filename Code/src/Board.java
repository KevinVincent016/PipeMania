public class Board {

    //Connections
    private Box head;
    private Box tail;
    private Leaderboard theLeaderboard;

    //Atributes
    private int contTubes;

    //constructor
    public Board() {
        contTubes = 0;
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

    public void setContTubes(int contTubes) {
        this.contTubes = contTubes;
    }

    public int getContTubes() {
        return contTubes;
    }

    //Methods
    private void addLast(Box box) {
        if(head==null){
            head = box;
            head.setNext(box);
            head.setPrev(box);
        }else{
            Box tail = head.getPrev();

            //Enlaces next
            tail.setNext(box);
            box.setNext(head);

            //Enlaces prev
            head.setPrev(box);
            box.setPrev(tail);
        }
    }

    public void createBoard(int boxes) {
        createBoard(boxes, 1);
    }

    private void createBoard(int boxes, int id) {

        if (id > boxes) {
            return;
        }

        addLast(new Box(id, TypeTube.NONE));
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

    public void printBoard() {
        if (head == null) {
            System.out.println("Tablero no creado");
        } else {
            Box aux = head;
            int cont = 0;
            while (aux != null) {
                System.out.print(aux.toString());
                aux = aux.getNext();
                cont++;
                switch (cont) {
                    case 8:
                        System.out.print("\n");
                        break;
                    case 16:
                        System.out.print("\n");
                        break;
                    case 24:
                        System.out.print("\n");
                        break;
                    case 32:
                        System.out.print("\n");
                        break;
                    case 40:
                        System.out.print("\n");
                        break;
                    case 48:
                        System.out.print("\n");
                        break;
                    case 56:
                        System.out.print("\n");
                        break;
                    case 64:
                        aux = null;
                        break;
                }
            }
        }
    }

    public void putTube(int coordinate, TypeTube tubeType) {
        Box current = search(coordinate);
        if (current.getTubeType() == TypeTube.F || current.getTubeType() == TypeTube.D) {
            System.out.println("Posicion no valida");
        }

        if(tubeType == TypeTube.F){
            current.setTubeType(TypeTube.F);
        }

        if(tubeType == TypeTube.D){
            current.setTubeType(TypeTube.D);
        }

        if (tubeType == TypeTube.TYPEHORIZONTAL) {
            if (current.getPrev().getTubeType() == TypeTube.NONE && current.getNext().getTubeType() == TypeTube.NONE) {
                System.out.println("Posicion no valida, la tuberia no se conecta a ningun lugar");
            }
            if (current.getPrev().getTubeType() == TypeTube.TYPEVERTICAL || current.getNext().getTubeType() == TypeTube.TYPEVERTICAL) {
                System.out.println("Posicion no valida, no se puede conectar directamente a una tuberia vertical");
            } else {
                current.setTubeType(TypeTube.TYPEHORIZONTAL);
                current.getPrev().setNext(current);
                current.getNext().setPrev(current);
                contTubes++;
            }
        }

        if (tubeType == TypeTube.TYPEVERTICAL) {
            Box upBox = search(current.getId() - 8);
            Box downBox = search(current.getId() + 8);
            if (current.getPrev().getTubeType() != TypeTube.NONE || current.getNext().getTubeType() != TypeTube.NONE) {
                System.out.println("Posicion no valida, la tuberia vertical no puede estar conectada lateralmente a ninguna otra tuberia");
            } else {
                current.setTubeType(TypeTube.TYPEVERTICAL);
                current.setPrev(downBox);
                current.setNext(upBox);
                downBox.setNext(current);
                upBox.setPrev(current);
                contTubes++;
            }
        }

        if (tubeType == TypeTube.TYPENINETY) {
            Box upBox = search(current.getId() - 8);
            Box downBox = search(current.getId() + 8);
            if (current.getPrev().getTubeType() == TypeTube.NONE && current.getNext().getTubeType() == TypeTube.NONE && upBox.getTubeType() == TypeTube.NONE && downBox.getTubeType() == TypeTube.NONE) {
                System.out.println("Posicion no valida, la tuberia no se conecta a ningun lugar");
            }
            if (current.getPrev().getTubeType() == TypeTube.TYPEVERTICAL || current.getNext().getTubeType() == TypeTube.TYPEVERTICAL) {
                System.out.println("Posicion no valida, la tuberia 90 grados no puede unirse por izquierda o derecha a una tuberia vertical");
            }
            if(upBox.getTubeType()==TypeTube.TYPEHORIZONTAL || downBox.getTubeType()==TypeTube.TYPEHORIZONTAL){
                System.out.println("Posicion no valida, la tuberia 90 grados no puede unirse arriba o abajo de una tuberia horizontal");
            }else{
                if(current.getPrev().getTubeType()!=TypeTube.NONE){
                    current.setTubeType(TypeTube.TYPENINETY);
                    current.setPrev(current.getPrev());
                    current.setNext(upBox);
                }else{
                    current.setTubeType(TypeTube.TYPENINETY);
                    current.setNext(current.getNext());
                    current.setPrev(upBox);
                }
            }
        }
    }

    public void verifyTubes() {

    }
}
