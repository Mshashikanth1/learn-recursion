package DesignPatterns.CreationalDesignPatterns;


/*
Singleton desing patterns states that there should be only one object created for that class and
it should be globally accessible entire project
the use cases of these  are data base classess

        */

public class SingletonCreationalDesignPattern {

    static class DatabaseConnection{}


    private static DatabaseConnection instance;

    private void DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {   // double locking, because ,to access the threads, initialized
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

}
