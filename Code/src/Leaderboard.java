public class Leaderboard {

    //Connections
    private Player root;

    //Constructor
    public Leaderboard(){

    }

    //Getter and Setter
    public Player getRoot() {
        return root;
    }

    public void setRoot(Player root) {
        this.root = root;
    }

    //Methods
    public void addScore(Player obj){
        if(root==null){
            root = obj;
        }else{
            addScore(obj,root);
        }
    }

    private void addScore(Player obj, Player current){

        if(obj.getScore()<current.getScore()){
            //izquierda
            if(current.getLeft()!=null){
                addScore(obj,current.getLeft());
            }else{
                current.setLeft(obj);
            }

        } else if (obj.getScore()>current.getScore()) {
            //derecha
            if (current.getRight() != null) {
                addScore(obj,current.getRight());
            }else{
                current.setRight(obj);
            }
        }
    }

    public void printLeaderboard(){
        printLeaderboard(root);
    }

    private void printLeaderboard(Player current){
        if(current==null){
            return;
        }

        printLeaderboard(current.getRight());
        System.out.println(current.toString());
        printLeaderboard(current.getLeft());

    }
}
