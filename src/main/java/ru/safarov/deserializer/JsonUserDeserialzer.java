package ru.safarov.deserializer;

import ru.safarov.model.UserCollections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonUserDeserialzer implements UserDeserializer {

    public UserCollections deserialize(String filename) throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserCollections userCollections = (UserCollections) object;
        System.out.println(userCollections);
        ois.close();
        fis.close();
        return userCollections;
    }
}
