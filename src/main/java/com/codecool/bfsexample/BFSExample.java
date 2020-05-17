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
        UserNode user1 = users.get(0);
        UserNode user2 = findUser("Naomi_Prescott",users);

        //getDistanceBetweenTwoUsers(user1, user2, users);

        Set<UserNode> friendsOfFriends = user1.getFriendsOfFriendsAtAGivenDistance(1);


        GraphPlotter graphPlotter = new GraphPlotter(users);
        graphPlotter.highlightNodes(friendsOfFriends, user1);
    }

    public static void getDistanceBetweenTwoUsers(UserNode user1, UserNode user2, List<UserNode> allUsers ) {

        Set<UserNode> anotherUsers = new HashSet<>();
        anotherUsers.add(user2);
        GraphPlotter graphPlotter = new GraphPlotter(allUsers);
        graphPlotter.highlightNodes(anotherUsers, user1);
        int distance = user1.getDistanceBetweenUsers(user2.getFullName(), allUsers);
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
