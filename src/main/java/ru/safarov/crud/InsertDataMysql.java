package ru.safarov.crud;

import com.mysql.cj.jdbc.MysqlDataSource;
import ru.safarov.model.User;
import ru.safarov.model.UserCollections;

import javax.sql.DataSource;
import java.sql.*;


public class InsertDataMysql {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;



    public void operationInsert(User user) {
        try {
            DataSource dataSource = createDataSource();
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO users (name, age, email) VALUES ('%s', %d, '%s')",
                    user.getName(), user.getAge(), user.getEmail()));


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

    }


    public DataSource createDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("sar");
        dataSource.setPassword("123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/userGb");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }
}
