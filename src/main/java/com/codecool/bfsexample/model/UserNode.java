package com.codecool.bfsexample.model;

import java.util.*;

public class UserNode {

    // feel free to add new properties or methods here

    private long id;
    private static long idCounter = 0;
    private String firstName;
    private String lastName;

    private Set<UserNode> friends = new HashSet<>();

    public UserNode(String firstName, String lastName) {
        this.id = idCounter;
        idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + "_" + lastName;
    }

    public long getId() {
        return id;
    }

    public String fullName;

    public String getFullName() {
        return fullName;
    }

    public Set<UserNode> getFriends() {
        return friends;
    }

    public void addFriend(UserNode friend) {
        friends.add(friend);
        friend.friends.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDistanceBetweenUsers(String fullname, List<UserNode> users) {
        Integer distance = 0;
        if (this.fullName.equals(fullname)) {
            return distance;
        }

        Queue<UserNode> usersToCheck = new LinkedList<>();
        Set<UserNode> checkedUsers = new HashSet<>();
        usersToCheck.addAll(this.getFriends());
        Set<UserNode> nextUsersToCheck = new HashSet<>();
        while (!usersToCheck.isEmpty()) {
            distance++;
            for (UserNode user : usersToCheck) {
                checkedUsers.add(user);
                if (user.fullName.equals(fullname)) {
                    return distance;
                }
               Set <UserNode> friends = user.getFriends();
                for (UserNode friend : friends) {
                    if(!nextUsersToCheck.contains(friend)|| !usersToCheck.contains(friend) || checkedUsers.contains(friend)){
                        nextUsersToCheck.add(friend);
                    }
                }

            }
            usersToCheck.clear();
            usersToCheck.addAll(nextUsersToCheck);
            nextUsersToCheck.clear();

        }
        return -1;

    }

    public String toString() {
        return firstName + "_" + lastName + " (" + id + ")";
    }

}
