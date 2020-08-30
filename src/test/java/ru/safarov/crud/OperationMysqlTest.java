package ru.safarov.crud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OperationMysqlTest {

    @Test
    void operationSelect() {
        SelectDataMysql selectDataMysql = new SelectDataMysql();
        UserCollections users = new UserCollections();
        users = selectDataMysql.operationSelect();
        for (User user: users.getUsers()) {
            if(user.getName() == "ivan"){
                Assertions.assertEquals("ivan@mail.ru", user.getEmail());
            }
        }
    }

    @Test
    void operationSelectBeetwenAge() {
        SelectUsersByAge selectUsersByAge = new SelectUsersByAge();
        UserCollections users = new UserCollections();
        selectUsersByAge.showUsersByAge(30, 32);
    }

    @Test
    void operationInsert() {
        User user1 = new User();
        user1.setName("Bob");
        user1.setAge(32);
        user1.setEmail("Bob32@gmail.com");
        InsertDataMysql insertDataMysql = new InsertDataMysql();
        insertDataMysql.operationInsert(user1);
        SelectDataMysql selectDataMysql = new SelectDataMysql();
        UserCollections users = new UserCollections();
        users = selectDataMysql.operationSelect();
        for (User user: users.getUsers()) {
            if(user.getName() == "Bob"){
                Assertions.assertEquals("Bob32@gmail.com", user.getEmail());
            }
        }
    }
    @Test
    void operationDelete() {

        DeleteDataMysql deleteDataMysql = new DeleteDataMysql();
        deleteDataMysql.operationDelete("Bob");
        SelectDataMysql selectDataMysql = new SelectDataMysql();
        UserCollections users = new UserCollections();
        users = selectDataMysql.operationSelect();
        Assertions.assertTrue(users.getUsers().size() ==1);
    }

}