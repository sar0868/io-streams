package ru.safarov.serializer;


import ru.safarov.model.UserCollections;

import java.io.File;

public interface UserSerializer {

    public void serializer(UserCollections userCollections, String filename);
}
