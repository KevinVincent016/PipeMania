import java.util.*;

public class Main {

	//Objects
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();

	static Board theBoard = new Board();

	public static void main(String[] args) {

		//Menu
		boolean start = true;
		while(start){

			switch (displayMenu()){

				case 1:
					System.out.println("Inicia la partida");
					theBoard.setStartTime(System.currentTimeMillis());

					//Set player
					System.out.println("Indica el nick que desea usar");
					String playerName = sc.next();

					//Set board
					theBoard.createBoard();

					//Set points
					theBoard.putTube((int)(Math.random()*7+1), (int)(Math.random()*7+1), TypeTube.F);
					theBoard.putTube((int)(Math.random()*7+1), (int)(Math.random()*7+1), TypeTube.D);

					//Menu 2
					boolean inGame = true;
					int row = 0;
					int colum = 0;
					TypeTube typeTube = null;
					while(inGame) {

						int option;
						theBoard.printBoard();
						System.out.println("\n" +
								"(1) Poner tuberia" + "\n" +
								"(2) Simular" + "\n" +
								"(3) Salir");
						option = sc.nextInt();

						if (option == 1) {
							System.out.println("Indica la fila");
							row = sc.nextInt();
							while (row>7 || row<0){
								System.out.println("El rango permitido es de 0-7");
								System.out.println("Indicar denuevo la fila");
								row = sc.nextInt();
							}
							System.out.println("Indica la columna");
							colum = sc.nextInt();
							while (colum>7 || colum<0){
								System.out.println("El rango permitido es de 0-7");
								System.out.println("indicar denuevo la columna");
								colum = sc.nextInt();
							}
							System.out.println("Indica el tipo de tuberia");
							System.out.println("(1) Tuberia horizontal (==)");
							System.out.println("(2) Tuberia vertical (||)");
							System.out.println("(3) Tuberia 90 Grados (O)");
							int aux = sc.nextInt();
							while (aux<1 || aux>3){
								System.out.println("Solo se permiten las opciones mostradas, por favor seleccionar denuevo el tipo de tuberia");
								System.out.println("(1) Tuberia horizontal (==)");
								System.out.println("(2) Tuberia vertical (||)");
								System.out.println("(3) Tuberia 90 Grados (O)");
								aux = sc.nextInt();
							}
							if(aux == 1){
								typeTube = TypeTube.TYPEHORIZONTAL;
							}
							if(aux == 2){
								typeTube = TypeTube.TYPEVERTICAL;
							}
							if(aux == 3){
								typeTube = TypeTube.TYPENINETY;
							}
							theBoard.putTube(row, colum,typeTube);
						}
						if (option == 2) {
							boolean validation = theBoard.verifyTubes(row, colum, typeTube);
							if (validation){
								System.out.println("La solucion es correcta");
								theBoard.setEndTime(System.currentTimeMillis());
								theBoard.registerPlayer(new Player(playerName, theBoard.calculateScore(theBoard.getStartTime(), theBoard.getEndTime(), theBoard.getContTubes())));
								theBoard.setHead(null);
								theBoard.setTail(null);
								theBoard.setEndTime(0);
								theBoard.setStartTime(0);
								theBoard.setContTubes(0);
								theBoard.setContErrors(0);
								inGame = false;
							}else{
								System.out.println("La tuberia no funciona, numero de errores " + theBoard.getContErrors());
							}
						}
						if (option == 3) {
							theBoard.setEndTime(System.currentTimeMillis());
							theBoard.registerPlayer(new Player(playerName, theBoard.calculateScore(theBoard.getStartTime(), theBoard.getEndTime(), theBoard.getContTubes())));
							inGame = false;
							theBoard.setHead(null);
							theBoard.setTail(null);
							theBoard.setEndTime(0);
							theBoard.setStartTime(0);
							theBoard.setContTubes(0);
							theBoard.setContErrors(0);
						}
					}
					break;

				case 2:
					System.out.println("Tablero de puntuaciones");
					theBoard.getTheLeaderboard().printLeaderboard();
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

}