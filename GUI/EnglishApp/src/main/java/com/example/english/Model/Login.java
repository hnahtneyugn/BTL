package com.example.english.Model;

import java.io.*;
import java.util.LinkedHashMap;

public class Login {
    private final static LinkedHashMap<String, String> account = new LinkedHashMap<>();
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Login.username = username;
    }

    public static boolean checkUsernameContain(String username) {
        return account.containsKey(username);
    }

    public static boolean checkPasswordCorrect(String username, String password) {
        return password.equals(account.get(username));
    }

    public static boolean checkConfirmPassword(String password, String confirmPassword) {
        return confirmPassword.equals(password);
    }

    public static void SignupAccount(String username, String password) {
        account.put(username, password);
    }
    public static void initializeAccount() throws IOException {
        FileReader fr = new FileReader("database/account.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            String username = parts[0];
            String password = parts[1];
            SignupAccount(username, password);
        }
        br.close();
    }

    public static void saveAccount() throws IOException {
        FileWriter fw = new FileWriter("database/account.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (String string : account.keySet()) {
            bw.write(string);
            bw.write("|");
            bw.write(account.get(string));
            bw.write("\n");
        }
        bw.close();
    }
}
