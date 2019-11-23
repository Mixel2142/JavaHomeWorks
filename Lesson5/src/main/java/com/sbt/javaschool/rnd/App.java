package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.client.Terminal;
import com.sbt.javaschool.rnd.client.TerminalImpl;

import java.util.Scanner;

public class App {

    Scanner scanner = new Scanner(System.in);
    Terminal terminal = new TerminalImpl();

    public void main(String[] args) {
        while (true) {

            terminal.doWelcomeAccount();
            String accountName = scanner.nextLine();

            if (terminal.initSession(accountName)) {
                sessionRun();
            }
        }
    }

    void sessionRun() {
        while (true) {

            terminal.doWelcomePinCode();
            Integer pinCode = scanner.nextInt();

            if (terminal.checkPinCode(pinCode.toString())) {
                accountRun();
            }
        }
    }

    void accountRun() {
        while (true) {
            terminal.showActions();

        }
    }

}