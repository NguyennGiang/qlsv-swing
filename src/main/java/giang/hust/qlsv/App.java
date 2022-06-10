package giang.hust.qlsv;

import java.awt.*;
import java.util.EventListener;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);
                controller.showLoginView();
            }
        });
    }
}
