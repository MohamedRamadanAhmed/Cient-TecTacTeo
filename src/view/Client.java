package view;
public class Client {

    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        TicTacToeProject game =new TicTacToeProject();
        game.launch();
    }
}