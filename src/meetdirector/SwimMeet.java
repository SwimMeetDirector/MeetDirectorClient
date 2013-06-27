package meetdirector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nhorman
 */
public class SwimMeet {
    private String DbUrl = null;
    private String status = null;
    private Connection conn = null;
    
    public SwimMeet(String server, String port, String name, String user, String pass) {
        DbUrl = "jdbc:derby://";
        DbUrl = DbUrl + server + ":" + port + "/" + name;
        if (user != null) {
            DbUrl = DbUrl + ";user=" + user;
        }
        if (pass != null) {
            DbUrl = DbUrl + ";password=" + pass;
        }
    }
    
    public Boolean Connect(Boolean newDb) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(DbUrl);
        }
        catch (Exception except)
        {
            status = except.getLocalizedMessage();
            if (status == null) {
                status = "Client Driver Error";
            }
            return false;
        }
        status = "Success";
        return true;
    }
}
