package giang.hust.qlsv;

import giang.hust.qlsv.controller.LoginController;
import giang.hust.qlsv.view.LoginView;

import java.awt.*;

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
