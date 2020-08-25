package ru.safarov.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UserCollections implements Serializable {

    private Collection<User> usersCollection;

    public Collection<User> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(User user) {
        this.usersCollection.add(user);
    }
}

