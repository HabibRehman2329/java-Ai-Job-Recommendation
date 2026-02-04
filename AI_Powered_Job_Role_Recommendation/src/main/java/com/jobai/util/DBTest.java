package com.jobai.util;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        try (Connection con = DatabaseConnection.getConnection()) {

            if (con != null) {
                System.out.println("✅ Database Connected Successfully");
            } else {
                System.out.println("❌ Database Connection Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
