import java.util.Scanner;

public class Main {

	//Objects
	static Scanner sc = new Scanner(System.in);

	static Board theBoard = new Board();


	public static void main(String[] args) {

		//Menu
		boolean start = true;
		while(start){

			switch (displayMenu()){

				case 1:
					System.out.println("Inicia la partida");

					//Set board
					theBoard.createBoard(64);

					//Menu 2
					boolean inGame = true;
					while(inGame) {

						int option;
						theBoard.printBoard();
						System.out.println("\n" +
								"(1) Poner tuberia" + "\n" +
								"(2) Simular" + "\n" +
								"(3) Salir");
						option = sc.nextInt();

						if (option == 1) {
							System.out.println("Indica la columna");
							int colum = sc.nextInt();
							System.out.println("Indica la fila");
							int row = sc.nextInt();
							System.out.println("Indica el tipo de tuberia");
							System.out.println("(1) Tuberia horizontal (==)");
							System.out.println("(2) Tuberia vertical (||)");
							System.out.println("(3) Tuberia 90 Grados (O)");
							int aux = sc.nextInt();
							TypeTube typeTube = null;
							if(aux == 1){
								typeTube = TypeTube.TYPEHORIZONTAL;
							}
							if(aux == 2){
								typeTube = TypeTube.TYPEVERTICAL;
							}
							if(aux == 3){
								typeTube = TypeTube.TYPENINETY;
							}
							int coordinate = (colum*8)+row;
							theBoard.putTube(coordinate,typeTube);
						}
						if (option == 2) {
							theBoard.verifyTubes();
						}
						if (option == 3) {
							inGame = false;
							theBoard.setHead(null);
							theBoard.setTail(null);
						}
					}
					break;

				case 2:
					System.out.println("Tablero de puntuaciones");
					break;

				case 3:
					System.out.println("Gracias por jugar");
					start = false;
					break;

			}

		}

	}

	//Methods
	public static int displayMenu(){
		int option;
		System.out.println("(1) Nueva partida" + "\n" +
				"(2) Ver puntaje" + "\n" +
				"(3) Salir");
		option = sc.nextInt();
		return option;
	}

	public static void verifyTubes(){

	}

}