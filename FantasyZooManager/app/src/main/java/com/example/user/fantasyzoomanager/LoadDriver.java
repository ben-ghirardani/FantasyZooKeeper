package com.example.user.fantasyzoomanager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 16/08/2017.
 */

public class LoadDriver {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jbdc.Driver").newInstance();
        } catch (Exception ex) {

        }
    }

}
