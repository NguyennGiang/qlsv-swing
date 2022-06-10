package giang.hust.qlsv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private StudentView studentView;

    public LoginController(LoginView view){
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView(){
        loginView.setVisible(true);
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();

            if (userDao.checkUser(user)){
                studentView = new StudentView();
                StudentController studentController = new StudentController(studentView);
                studentController.showStudentView();
                loginView.setVisible(true);
            }
            else {
                loginView.showMessage("Username hoặc password không đúng");
            }
        }
    }
}
