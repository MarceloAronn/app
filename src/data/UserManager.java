package data;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import data.models.User;

public class UserManager {
    private String pathFile;
    private ArrayList<User> users;
    public UserManager(String pathFile) {
        this.pathFile = pathFile;
        this.users = new ArrayList<>();
    }
    public String getPathDirectory() {
        return pathFile;
    }
    public void setPathDirectory(String pathDirectory) {
        this.pathFile = pathDirectory;
    }
    public ArrayList<User> getUsers() {
        this.users = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(this.pathFile))) {
            String line = reader.readLine();
            while(line != null) {
                String[] data = line.split(",");
                User user = new User(data[0], data[1], data[2], data[3]);
                this.users.add(user);
                line = reader.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return this.users;
    }
    public void saveInOneShot() {
        String allData = "";
        for (User user : this.users) {
            allData += user.toString() + "\n";
        }
        saveFileLines(allData);
    }
    public void saveUser(User user) {
        getUsers();
        this.users.add(user);
        saveInOneShot();
    }
    public void saveFileLines(String allData) {
        try {
            FileWriter writer = new FileWriter(this.pathFile);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(allData);
            buffer.newLine();
            buffer.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
