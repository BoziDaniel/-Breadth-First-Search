package com.codecool.bfsexample;

import com.codecool.bfsexample.model.UserNode;

import java.util.*;


public class BFSExample {

    private static List<UserNode> populateDB() {

        RandomDataGenerator generator = new RandomDataGenerator();
        List<UserNode> users = generator.generate();
        System.out.println(users.toString());
        System.out.println("Done!");
        return users;
    }

    public static void main(String[] args) {
        List<UserNode> users = populateDB();

        UserNode emeryJohnoson = users.get(0);
        UserNode anotherUser = findUser("Hadley_Kibo", users);
        Set<UserNode> anotherUsers = new HashSet<>();
        anotherUsers.add(anotherUser);
        GraphPlotter graphPlotter = new GraphPlotter(users);
        graphPlotter.highlightNodes(anotherUsers, emeryJohnoson);
        int distance = emeryJohnoson.getDistanceBetweenUsers(anotherUser.getFullName(), users);
        System.out.println( "distance: " + distance);
    }

    private static UserNode findUser(String username, List<UserNode> users) {
        for (UserNode user : users) {
            if (user.getFullName().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
