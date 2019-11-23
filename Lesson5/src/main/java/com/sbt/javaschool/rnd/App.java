package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.client.Terminal;
import com.sbt.javaschool.rnd.client.TerminalImpl;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Terminal terminal = new TerminalImpl();

    public static void main(String[] args) {
        while (true) {

            terminal.doWelcomeAccount();
            String accountName = scanner.nextLine();

            if (terminal.initSession(accountName)) {
                sessionRun();
            }
        }
    }

    static void sessionRun() {
        while (true) {

            terminal.doWelcomePinCode();
            Integer pinCode = scanner.nextInt();

            if (terminal.checkPinCode(pinCode.toString())) {
                accountRun();
            }
        }
    }

    static void accountRun() {
        while (true) {
            terminal.showActions();

        }
    }

}