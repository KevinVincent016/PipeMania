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

    public void top10(){
        top10(root, 0);
    }

    private void top10(Player current, int n){
        if(current==null){
            return;
        }

        if(n<10) {
            top10(current.getRight(),n);
            System.out.println(current.toString());
            top10(current.getLeft(),n++);
        }
    }
}
