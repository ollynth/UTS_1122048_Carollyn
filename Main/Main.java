package Main;
import Controller.*;
import View.MainMenuScreen;

public class Main {
    public static void main(String[] args) {
        Controller cntrl = new Controller();
        String idUser = "u123";
        String idPost = "1002";
        cntrl.showUserPosts(idUser); 
        // cntrl.showPost(idPost);      -- pass
        // new MainMenuScreen(cntrl);
    }
}
