package database;

import java.sql.*;

/**
 * Костыль на текущий момент
 */
public class DBConnection {

    //Доступ к БД: Login/Password/URL
    private  String LOGIN = "root";
    private  String PASSWORD = "root";
    private  String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private  Connection conn = null;


    public DBConnection() {
        /** Загрузка Драйвера JDBC */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDicsepline( int id){
        try {

            // Statement
            Statement stat = conn.createStatement();
            ResultSet resultSets = stat.executeQuery("SELECT * FROM account");

            while (resultSets.next()) {
                System.out.print(resultSets.getInt("id") + " ");
                System.out.print(resultSets.getString("login") + " ");
                System.out.print(resultSets.getString("password") + " ");
                System.out.println("");
            }

            if (resultSets != null) resultSets.close();
            if (stat != null) stat.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
