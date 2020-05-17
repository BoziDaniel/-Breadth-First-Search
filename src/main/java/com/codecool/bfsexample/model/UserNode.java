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

    public Set<UserNode> getFriends() {return friends;}

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
        Integer counter = 0;
        Queue<UserNode> usersToCheck = new LinkedList<>();
        Set<UserNode> checkedUsers = new HashSet<>();
        usersToCheck.add(this);
        if (this.fullName.equals(fullname)) {
            return counter;
        }
        while (!usersToCheck.isEmpty()) {
            counter++;
            UserNode actualUser;
            System.out.println("usersToCheck: " + usersToCheck.toString());
            actualUser = usersToCheck.poll();
            System.out.println("actualUser: " + actualUser );
            if (actualUser.fullName.equals(fullname)) {
                return counter;
            }
            Set<UserNode> friends = actualUser.getFriends();
            for (UserNode friend : friends) {
                if (!usersToCheck.contains(friend) || !checkedUsers.contains(friend)) {
                    usersToCheck.add(friend);
                }
            }
            checkedUsers.add(actualUser);
            System.out.println("checkedusers:" + checkedUsers.toString());
        }
        return -1;

    }
    public String toString() {
        return firstName + "_" + lastName + " (" + id + ")";
    }

}
