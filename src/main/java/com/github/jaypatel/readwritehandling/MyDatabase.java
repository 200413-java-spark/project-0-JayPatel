package com.github.jaypatel.readwritehandling;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.github.jaypatel.hangman.Word;
import com.github.jaypatel.hangman.Hangman;

public class MyDatabase {

    // public List<String[]> readHighScores () {
    //     List<String[]> listOfScores = new ArrayList<>();
    //     try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "mydb", "mydb")){
    //         Statement stmt =  conn.createStatement();
    //         ResultSet rs = stmt.executeQuery("select * from scores");
    //         while(rs.next()) {

    //             String[] args = new String[4];
    //             args[0] = rs.getString("player");
    //             args[1] = rs.getString("wins");
    //             args[2] = rs.getString("games_played");
    //             args[3] = rs.getString("ratio");

    //             listOfScores.add(args);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return listOfScores;
    // }

    public static void updateTable() {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "mydb", "mydb")) {
             PreparedStatement stmt =  conn.prepareStatement("insert into words values(?)");

            // PreparedStatement stmt =  conn.prepareStatement("insert into scores values(?, ?, ?, ?)");
            // stmt.setString(1, Player.getName());
            // stmt.setString(2, Hangman.getGameStart());
            // stmt.setString(3, Hangman.getGameWon());
            stmt.setString(1, Word.getWord());
            stmt.addBatch();
            stmt.executeBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}