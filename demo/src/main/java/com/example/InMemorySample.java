package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InMemorySample {
	public static void main(String[] args) throws Exception {
        // JDBC ドライバロード
        Class.forName("org.hsqldb.jdbcDriver");

        // データベースに接続
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:sample", "sa", "");

        // テーブル作成
        Statement st = connection.createStatement();
        st.executeUpdate("CREATE TABLE TEST_TABLE (ID INTEGER, VALUE VARCHAR(10))");

        // データ挿入
        st.executeUpdate("INSERT INTO TEST_TABLE VALUES (1, 'HOGE')");
        st.executeUpdate("INSERT INTO TEST_TABLE VALUES (2, 'FUGA')");

        // データ取得
        ResultSet rs = st.executeQuery("SELECT * FROM TEST_TABLE");

        while (rs.next()) {
            System.out.println("ID=" + rs.getInt("ID") + ", VALUE=" + rs.getString("VALUE"));
        }

        st.close();
        connection.close();
	}
}
