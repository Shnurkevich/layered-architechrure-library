package by.htp.library.view;

import by.htp.library.controller.Controller;

public class Main {

    public static void main(String[] args) {

        String role = null;

        Controller controller = new Controller();
        String signIn = controller.executeTask("sign_in alex 111");
        System.out.println(signIn);

        role = getRole(signIn);
        System.out.println(role);


    }

    public static String getRole(String signIn) {

        if (signIn.contains("admin")) {
            return "admin";
        }

        if (signIn.contains("parent")) {
            return "parent";
        }

        if (signIn.contains("child")) {
            return "child";
        }

        return "undefined";

    }
}
