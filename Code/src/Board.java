public class Board {

    //Connections
    private Box head;
    private Box tail;
    private Leaderboard theLeaderboard;

    //Atributes
    private int contTubes;

    private Box board[][] = new Box[8][8];

    private int contErrores = 0;

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

    public void setContErrores(int contErrores) {
        this.contErrores = contErrores;
    }

    public int getContErrores() {
        return contErrores;
    }

    //Methods
    private void addLast(Box box) {
        if (head == null) {
            head = box;
            head.setNext(box);
            head.setPrev(box);
        } else {
            Box tail = head.getPrev();

            //Enlaces next
            tail.setNext(box);
            box.setNext(head);

            //Enlaces prev
            head.setPrev(box);
            box.setPrev(tail);
        }
    }

    public void createBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new Box(i, j, TypeTube.NONE);
            }
        }
    }

    public Box search(int row, int colum) {
        return search(row, colum, head);
    }

    private Box search(int row, int colum, Box current) {

        if (current == null) {
            return null;
        }

        if (current.getRow() == row && current.getColum() == colum) {
            return current;
        }

        return search(row, colum, current.getNext());
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
                    contErrores++;
                }
                if (board[row][colum + 1].getTubeType() == TypeTube.TYPENINETY && board[row][colum + 2].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPEVERTICAL) {
                    contErrores++;
                }
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPENINETY && board[row][colum - 2].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else {
                if (board[row][colum - 1].getTubeType() == TypeTube.TYPEVERTICAL || board[row][colum + 1].getTubeType() == TypeTube.TYPEVERTICAL) {
                    contErrores++;
                }
            }

            if (row == 0) {
                if (board[row + 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            }
            if (row == 7) {
                if (board[row - 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else {
                if (board[row + 1][colum].getTubeType() != TypeTube.NONE || board[row - 1][colum].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }

        if (tubeType == TypeTube.TYPEVERTICAL) {
            if (colum == 0) {
                if (board[row][colum + 1].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else {
                if (board[row][colum - 1].getTubeType() != TypeTube.NONE || board[row][colum + 1].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            }

            if (row == 0) {
                if (board[row + 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrores++;
                }
                if (board[row + 1][colum].getTubeType() == TypeTube.TYPENINETY && board[row + 2][colum].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else if (row == 7) {
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrores++;
                }
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPENINETY && board[row - 2][colum].getTubeType() != TypeTube.NONE) {
                    contErrores++;
                }
            } else {
                if (board[row - 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL || board[row + 1][colum].getTubeType() == TypeTube.TYPEHORIZONTAL) {
                    contErrores++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }

        if (tubeType == TypeTube.TYPENINETY) {
            if (colum == 0) {
                if (board[row][colum + 1].getTubeType() == TypeTube.F || board[row][colum + 1].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            } else if (colum == 7) {
                if (board[row][colum - 1].getTubeType() == TypeTube.F || board[row][colum - 1].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            } else {
                if (board[row][colum + 1].getTubeType() == TypeTube.F || board[row][colum + 1].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
                if (board[row][colum - 1].getTubeType() == TypeTube.F || board[row][colum - 1].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            }
            if (row == 0) {
                if (board[row + 1][colum].getTubeType() == TypeTube.F || board[row + 1][colum].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            } else if (row == 7) {
                if (board[row - 1][colum].getTubeType() == TypeTube.F || board[row - 1][colum].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            } else {
                if (board[row + 1][colum].getTubeType() == TypeTube.F || board[row + 1][colum].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
                if (board[row - 1][colum].getTubeType() == TypeTube.F || board[row - 1][colum].getTubeType() == TypeTube.D) {
                    contErrores++;
                }
            }

            board[row][colum].setTubeType(tubeType);
            addLast(new Box(row, colum, tubeType));
        }
    }

    public boolean auxVeifyTubes() {
        return auxVerifyTubes(head);
    }

    private boolean auxVerifyTubes(Box current) {
        if (current == tail) {
            return true;
        }
        if (current.getTubeType() != TypeTube.NONE) {
            return false;
        }
        return auxVerifyTubes(current.getNext());
    }

    public boolean verifyTubes(int lastRow, int lastColum, TypeTube lastTypeTube) {
        if (lastTypeTube == TypeTube.TYPEHORIZONTAL) {
            if (board[lastRow][lastColum + 1].getTubeType() == TypeTube.D || board[lastRow][lastColum + 1].getTubeType() == TypeTube.NONE) {
                addLast(board[lastRow][lastColum + 1]);
            }
            if (board[lastRow][lastColum - 1].getTubeType() == TypeTube.D || board[lastRow][lastColum - 1].getTubeType() == TypeTube.NONE){
                addLast(board[lastRow][lastColum - 1]);
            }
        }

        if (lastTypeTube == TypeTube.TYPEVERTICAL) {
            if (board[lastRow + 1][lastColum].getTubeType() == TypeTube.D || board[lastRow + 1][lastColum].getTubeType() == TypeTube.NONE) {
                addLast(board[lastRow][lastColum + 1]);
            }
            if(board[lastRow - 1][lastColum].getTubeType() == TypeTube.D || board[lastRow - 1][lastColum].getTubeType() == TypeTube.NONE){
                addLast(board[lastRow][lastColum - 1]);
            }
        }

        if (!auxVeifyTubes() || contErrores > 0) {
            return false;
        } else {
            return true;
        }
    }
}
