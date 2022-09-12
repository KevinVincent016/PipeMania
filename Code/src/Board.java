public class Board {

    //Connections
    private Box head;
    private Box tail;
    private Leaderboard theLeaderboard = new Leaderboard();

    //Atributes
    private Box board[][] = new Box[8][8];

    private int contTubes;
    private int contErrors = 0;

    private long startTime;

    private long endTime;
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

    public void setContErrors(int contErrors) {
        this.contErrors = contErrors;
    }

    public int getContErrors() {
        return contErrors;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
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

    public void createBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new Box(i, j, TypeTube.NONE);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j].toString());
                if (board[i][j].getRow() == 0 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 1 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 2 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 3 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 4 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 5 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 6 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
                if (board[i][j].getRow() == 7 && board[i][j].getColum() == 7) {
                    System.out.print("\n");
                }
            }
        }
    }

    public void putTube(int row, int colum, TypeTube tubeType) {
        //Set Fuente and Drenaje
        if (tubeType == TypeTube.F) {
            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }
        if (tubeType == TypeTube.D) {
            board[row][colum].setTubeType(tubeType);
        }

        //avoid replacement of F and D
        if ((tubeType != TypeTube.F && tubeType != TypeTube.D) && (board[row][colum].getTubeType() == TypeTube.F || board[row][colum].getTubeType() == TypeTube.D)) {
            System.out.println("Movimiento ilegal, no se puede reemplazar la Fuente o el Drenaje");
            return;
        }

        //Set tubes
        if (tubeType == TypeTube.TYPEHORIZONTAL) {
            if (colum == 0) {
                if (board[row][colum + 1].getTubeType() == TypeTube.TYPEVERTICAL) {
                    contErrors++;
                }
                if (board[row][colum + 1].getTubeType() == TypeTube.TYPENINETY && board[row][colum + 2].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPEVERTICAL) {
                    contErrors++;
                }
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPENINETY && board[row][colum - 2].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else {
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPEVERTICAL || board[row][colum + 1].getTubeType() == TypeTube.TYPEVERTICAL) {
                    contErrors++;
                }
            }

            if (row == 0) {
                if (board[row + 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            }
            if (row == 7) {
                if (board[row - 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else {
                if (board[row + 1][colum].getTubeType() != TypeTube.NONE || board[row - 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }

        if (tubeType == TypeTube.TYPEVERTICAL) {
            if (colum == 0) {
                if (board[row][colum + 1].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else {
                if (board[row][colum - 1].getTubeType() != TypeTube.NONE || board[row][colum + 1].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            }

            if (row == 0) {
                if (board[row + 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrors++;
                }
                if (board[row + 1][colum].getTubeType() == TypeTube.TYPENINETY && board[row + 2][colum].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else if (row == 7) {
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrors++;
                }
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPENINETY && board[row - 2][colum].getTubeType() != TypeTube.NONE) {
                    contErrors++;
                }
            } else {
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL || board[row + 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrors++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }

        if (tubeType == TypeTube.TYPENINETY) {
            if (colum == 0) {
                if (board[row][colum + 1].getTubeType() == TypeTube.F || board[row][colum + 1].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() == TypeTube.F || board[row][colum - 1].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            } else {
                if (board[row][colum + 1].getTubeType() == TypeTube.F || board[row][colum + 1].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
                if (board[row][colum - 1].getTubeType() == TypeTube.F || board[row][colum - 1].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            }
            if (row == 0) {
                if (board[row + 1][colum].getTubeType() == TypeTube.F || board[row + 1][colum].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            } else if (row == 7) {
                if (board[row - 1][colum].getTubeType() == TypeTube.F || board[row - 1][colum].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            } else {
                if (board[row + 1][colum].getTubeType() == TypeTube.F || board[row + 1][colum].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
                if (board[row - 1][colum].getTubeType() == TypeTube.F || board[row - 1][colum].getTubeType() == TypeTube.D) {
                    contErrors++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }
    }

    public boolean auxVerifyTubes() {
        return auxVerifyTubes(head);
    }

    private boolean auxVerifyTubes(Box current) {
        if (current == null) {
            return false;
        }

        if (current.getTubeType() == TypeTube.NONE) {
            return false;
        }

        if (current.getTubeType() == TypeTube.D && current == tail){
            return true;
        }

        return auxVerifyTubes(current.getNext());
    }

    public boolean verifyTubes(int lastRow, int lastColum, TypeTube lastTypeTube) {
        if (lastTypeTube == TypeTube.TYPEHORIZONTAL) {
            if (board[lastRow][lastColum + 1].getTubeType() == TypeTube.D) {
                addLast(board[lastRow][lastColum + 1]);
            }else if (board[lastRow][lastColum - 1].getTubeType() == TypeTube.D){
                addLast(board[lastRow][lastColum - 1]);
            }else{
                System.out.println("La Fuente aun no se conecta con el Drenaje");
            }
        }

        if (lastTypeTube == TypeTube.TYPEVERTICAL) {
            if (board[lastRow + 1][lastColum].getTubeType() == TypeTube.D) {
                addLast(board[lastRow][lastColum + 1]);
            }else if(board[lastRow - 1][lastColum].getTubeType() == TypeTube.D){
                addLast(board[lastRow][lastColum - 1]);
            }else{
                System.out.println("La fuente aun no se conecta con el Drenaje");
            }
        }

        if (!auxVerifyTubes() || contErrors > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int calculateScore(long startTime, long endTime, int contTubes){
        return (int) (contTubes*100-(60-(endTime-startTime))*10);
    }

    public void registerPlayer(Player player){
        theLeaderboard.addScore(player);
    }
}
