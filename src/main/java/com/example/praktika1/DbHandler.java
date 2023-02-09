package com.example.praktika1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DbHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(String login, String password) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_USERNAME +
                "," + Const.USER_PASSWORD + ")" + "VALUES(?,?)";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(insert);
            prst.setString(1, login);
            prst.setString(2, password);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_USERNAME +
                "=? AND " + Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, user.getLogin());
            prst.setString(2, user.getPassword());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet table(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM films";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet admin(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM users";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getAdmin(Admin admin) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.ADMIN_TABLE + " WHERE " + Const.ADMIN_USERNAME +
                "=? AND " + Const.ADMIN_PASSWORD + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, admin.getAdminName());
            prst.setString(2, admin.getAdminPassword());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void getAdd(String filmName, String filmGenre, String filmYear, String filmRating,
                       String filmActor, String filmProducer, String filmFrom) {
        String insert = "INSERT INTO " + Const.FILM_TABLE + "(" + Const.FILM_NAME +
                "," + Const.FILM_GENRE + "," +Const.FILM_YEAR + "," + Const.FILM_RATING + "," + Const.FILM_ACTOR +
                "," + Const.FILM_PRODUCER + "," + Const.FILM_FROM + ")" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(insert);
            prst.setString(1, filmName);
            prst.setString(2, filmGenre);
            prst.setString(3, filmYear);
            prst.setString(4, filmRating);
            prst.setString(5, filmActor);
            prst.setString(6, filmProducer);
            prst.setString(7, filmFrom);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getFilter(Filter filter) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.FILM_TABLE + " WHERE " + Const.FILM_GENRE + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, filter.getFilmGenre());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getDel(Delete delete) {
        ResultSet resultSet = null;
        String select = "DELETE * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, delete.getIdFilm());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
