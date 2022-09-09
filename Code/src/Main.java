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
							System.out.println("Indica la columna");
							colum = sc.nextInt();
							System.out.println("Indica la fila");
							row = sc.nextInt();
							System.out.println("Indica el tipo de tuberia");
							System.out.println("(1) Tuberia horizontal (==)");
							System.out.println("(2) Tuberia vertical (||)");
							System.out.println("(3) Tuberia 90 Grados (O)");
							int aux = sc.nextInt();
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
								theBoard.setHead(null);
								theBoard.setTail(null);
								inGame = false;
							}else{
								System.out.println("La tuberia no funciona, numero de errores " + theBoard.getContErrores());
							}
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