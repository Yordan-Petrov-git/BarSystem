import Helpers.InitializeObjects;
import Views.JFrameMain;

public class Main {
    public static void main(String[] args) {
        //init OBJECTS
        //Test for username is it unique
        String fullName = "Ivan Ivanov";
        String username = "Ivan";
        String password = "1234";
        InitializeObjects.initializeNewWaiter(fullName, username, password);
        InitializeObjects.initializeNewWaiter("Ivan Ivanov", "Ivan", "1234");

        //Start
        JFrameMain jFrame = new JFrameMain();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}
