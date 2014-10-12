/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_l5;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Артем
 */
public class Bd_l5 {
    private static final String charset = "cp1251";
    
    private static final int SIZE = 128;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        Properties info = new Properties();
        info.put("user", "lai");
        info.put("password", "1123");
        info.put("useUnicode", "false");

        Connection connection;
        byte[] buffer = new byte[100];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is;
        int b = 0;
        try {
            connection = DriverManager.getConnection("jdbc:odbc:students", info);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from students;");
            ResultSetMetaData rsmd = rs.getMetaData();
            CharBuffer cb = CharBuffer.allocate(100);
            while (rs.next()) {
                System.out.println(rs.getString("fname"));
                baos.reset();
                buffer = new byte[SIZE];
            }
            
            st.executeQuery("update students set fname='Guryanov' where num=12304");
            
            connection.close();
        } catch (Exception sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
