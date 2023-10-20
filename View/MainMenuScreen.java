package View;

import javax.swing.JOptionPane;

import Controller.Controller;

public class MainMenuScreen {
    public MainMenuScreen(Controller cntrl) {
        showMainMenu(cntrl);
    }

    private void showMainMenu(Controller cntrl) {
        Boolean menu = true;
        while(menu) {
            int choosen = Integer.parseInt(JOptionPane.showInputDialog(null, "Input Menu: \n1.Show User Chats \n2.Change Chat State \n3.Send Message \n4.Show Message \n5.Change User Profile \n6.Show User Favorite Class \n7.Exit"));
            switch(choosen) {
                case 1: 
                    new ShowUserPosts(cntrl);
                    break;
                case 2: 
                    new ShowPost(cntrl);
                    break;
                case 3: 
                    new ChangePostState(cntrl);
                    break;
                case 4: 
                    new ShowUserBestPost(cntrl);
                    break;
                case 5:
                    menu = false;
                    break;
            }
        }
    }
}
