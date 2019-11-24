package com.sbt.javaschool.rnd;

import com.sbt.javaschool.rnd.client.Terminal;
import com.sbt.javaschool.rnd.client.TerminalImpl;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Terminal terminal = new TerminalImpl();

    public static final int CHECK_BALANCE = 0;
    public static final int PUT_MONEY = 1;
    public static final int WITHDRAW_MONEY = 2;
    public static final int CLOSE_SESSION = 3;

    public static void main(String[] args) {
        while (true) {

            doWelcomeAccount("");
            String accountName = scanner.nextLine();

            if (terminal.initSession(accountName)) {
                doWelcomeAccount(accountName);
                sessionRun(accountName);
            }
        }
    }

    static void sessionRun(String accountName) {
        while (true) {

            doWelcomePinCode(accountName);
            String pinCode = scanner.nextLine();

            if (terminal.checkPinCode(pinCode)) {
                accountRun();
                return;
            }
        }
    }

    static void accountRun() {
        while (true) {
            showActions();
            String action = scanner.nextLine();
            String amount;

            if (action.matches("[0-4]{1}")) {
                switch (Integer.parseInt(action)) {
                    case CHECK_BALANCE:
                        System.out.println("Ваш баланс:"+terminal.checkBalance());
                        break;
                    case PUT_MONEY:
                        System.out.println("Введите сумму денег, которую вы хотите положить на счёт.");
                        System.out.print("Ввод:>");
                        amount = scanner.nextLine();
                        terminal.putMoney(amount);
                        break;
                    case WITHDRAW_MONEY:
                        System.out.println("Введите сумму денег(кратна 100-м), которую вы хотите снять с счёта.");
                        System.out.print("Ввод:>");
                        amount = scanner.nextLine();
                        terminal.withdrawMoney(amount);
                        break;
                    case CLOSE_SESSION:
                        terminal.closeSession();
                        System.out.println("Сессия была закрыта.");
                        return;
                    default:
                        System.out.println("Введено не верное значение:"+Integer.parseInt(action)+".");
                }
            }
        }
    }

    static void doWelcomeAccount(String accountName) {
        if (accountName.isEmpty()) {
            System.out.println("\nВведите имя аккаунта.");
            System.out.print("Ввод:> ");
        } else {
            System.out.println("Добро пожаловать," + accountName + "!");
        }
    }

    static void doWelcomePinCode(String accountName) {
        System.out.println(accountName + ", введите пинкод состоящий из 4 цифр.");
        System.out.print("Ввод:> ");
    }

    static void showActions() {
        System.out.println("Введите код одного из действий:");
        System.out.println("(0): Проверить баланс.");
        System.out.println("(1): Пополнить баланс.");
        System.out.println("(2): Снять деньги.");
        System.out.println("(3): Покинуть аккаунт.");
        System.out.print("Ввод:> ");
    }

}