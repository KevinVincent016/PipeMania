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
					int option = createMatch();
					if(option==1){
						theBoard.putTube();
					}
					if(option==2){
						theBoard.verifyTubes();
					}
					if(option==3){
						start = false;
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

	public static int displayMenu2(){
		int option;
		System.out.println("(1) Poner tuberia" + "\n" +
				"(2) Simular" + "\n" +
				"(3) Salir");
		option = sc.nextInt();
		return option;
	}

	public static int createMatch(){
		theBoard.createBoard(64);
		return displayMenu2();
	}

	public static void verifyTubes(){

	}

}