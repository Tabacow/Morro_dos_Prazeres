package com;

import com.auxiliardb.UserDAO;
import com.model.User;
import com.utilities.Constants;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Application app = new Application();
        try {
            app.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
