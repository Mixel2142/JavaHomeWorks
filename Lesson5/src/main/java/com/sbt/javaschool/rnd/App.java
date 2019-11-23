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
            String pinCode = scanner.nextLine();

            if (terminal.checkPinCode(pinCode)) {
                accountRun();
                return;
            }
        }
    }

    static void accountRun() {
        while (true) {
            terminal.showActions();
            String action = scanner.nextLine();

            if (action.matches("[0-4]{1}")) {
                switch (Integer.parseInt(action)) {
                    case CHECK_BALANCE:
                        terminal.checkBalance();
                        break;
                    case PUT_MONEY:

                        terminal.putMoney();
                        break;
                    case WITHDRAW_MONEY:
                        terminal.withdrawMoney();
                        break;
                    case CLOSE_SESSION:
                        terminal.closeSession();
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + Integer.parseInt(action));
                }
            }
        }
    }

    public static final int CHECK_BALANCE = 0;
    public static final int PUT_MONEY = 1;
    public static final int WITHDRAW_MONEY = 2;
    public static final int CLOSE_SESSION = 4;
}