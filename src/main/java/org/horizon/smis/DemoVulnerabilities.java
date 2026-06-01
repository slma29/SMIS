package org.horizon.smis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoVulnerabilities {

    public void unsafeSql(String username) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/smis",
            "root",
            "password"
        );

        Statement stmt = conn.createStatement();

        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }

    public void commandInjection(String input) throws Exception {
        Runtime.getRuntime().exec("ping " + input);
    }
}
