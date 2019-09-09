package com;

import com.auxiliardb.UserDAO;
import com.model.User;
import com.utilities.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    private UserDAO userDAO;
    private List<User> users;
    private Scanner scanner;

    public Application(){
        userDAO = UserDAO.getInstance(Constants.URL_MY_DB);
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() throws IOException{
        try {
            int op;
            do {
                menu();
                //scanner.nextLine();
                op = scanner.nextInt();
                //Clean the newline input from the scanner
                scanner.nextLine();

                switch (op) {
                    case 1:
                        insertUser();
                        break;
                    case 2:
                        users = userDAO.getAll();
                        printFormatedUsers();
                        break;
                    case 3:
                        searchUser();
                        break;
                    case 4:
                        updateUser();
                        break;
                    case 5:
                        deleteUser();
                        break;

                }

                if (op == 0)
                    break;

                System.out.println("\n\nPress Enter to continue...");
                System.in.read();
                //Constants.clearCMD();
            } while (op != 0);

            System.out.println("\nFIM DO PROGRAMA!");
            System.exit(0);
        } catch (InputMismatchException e) {
            //Constants.clearCMD();
            System.out.println("buu buu desu wa");
        }
    }

    private void menu(){
        System.out.println("1 - INSERIR USER");
        System.out.println("2 - MOSTRAR USERS");
        System.out.println("3 - BUSCAR USER");
        System.out.println("4 - ATUALIZAR USER");
        System.out.println("5 - REMOVER USER");
        System.out.println("0 - EXIT");
    }

    private void printFormatedUsers(){
        System.out.format("%4s%30s%36s\n", "ID", "NOME", "EMAIL");
        for(int i = 0; i < 70; i++)
            System.out.format("-");
        System.out.println();
        for(User user : users){
            if (user != null)
                System.out.format("%4d%25s%36s\n", user.id, user.nome, user.email);
        }
        users.clear();
    }
    private void insertUser(){
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("E-Mail:");
        String email = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();

        if (userDAO.insert(new User(nome,email,senha)))
            System.out.println("\nUsuário Inserido com Sucesso!");
        else
            System.out.println("\nErro ao Inserir Usuário.");
    }
    private void searchUser(){
        System.out.println("BUSCANDO...\nID:");
        String id = scanner.nextLine();
        User user = userDAO.get(id);
        users.add(user);

        if (users.isEmpty())
            System.out.println("User Not Found");

        printFormatedUsers();
        users.clear();
    }
    private void updateUser(){
        System.out.println("ID do Usuario a ser alterado:");
        String id = scanner.nextLine();

        User user = userDAO.get(id);

        if (user == null) {
            System.out.println("\nUser not Found...\nCancelling Operation.\n");
            return;
        }

        users.add(user);
        printFormatedUsers();
        users.clear();

        System.out.println("Atualizar Qual Campo?...");
        System.out.println("1 - Nome");
        System.out.println("2 - E-Mail");
        System.out.println("3 - Senha");

        int op = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Novo Valor:");
        String temp = scanner.next();

        switch (op){
            case 1: user.nome = temp; break;
            case 2: user.email = temp; break;
            case 3: user.email = temp; break;
            default:
                System.out.println("Invalid Entry...\nCancelling.");
                return;
        }

        System.out.println("Atualizando...\n");
        userDAO.update(id, user);
    }
    private void deleteUser(){
        System.out.println("ID do Usuário a ser Deletado:");
        String id = scanner.nextLine();

        System.out.println("Removendo...\n");

        if (userDAO.remove(id))
            System.out.println("Usuário Removido com Sucesso!");
        else
            System.out.println("Erro ao remover o usuário.");
    }
}
