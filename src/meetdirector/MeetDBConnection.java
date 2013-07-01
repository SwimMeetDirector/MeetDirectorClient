package meetdirector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nhorman
 */
public class MeetDBConnection {
    private static MeetDBConnection instance = null;
    private String DbUrl = null;
    private String status = null;
    private Connection conn = null;
    private String user = null;
    private String pass = null;
    
    protected MeetDBConnection() {
         
    }
    
    public void SetConnectionParams(String server, String port, String name, String user, String pass) {
        DbUrl = "jdbc:derby://";
        DbUrl = DbUrl + server + ":" + port + "/" + name;
        this.user = user;
        this.pass = pass; 
    }
    
    public Map getDBConnectionProperties() {
        Map pmap = new HashMap();
        if (this.pass != null)
            pmap.put("javax.persistence.jdbc.password", pass);
        if (this.user != null)
            pmap.put("javax.persistence.jdbc.user", user);
        pmap.put("javax.persistence.jdbc.url", DbUrl);
        return pmap;
    }
    
    public Boolean storeObject(Object obj, String unit) {
        EntityManagerFactory emf;
        Boolean rc = true;
        emf = javax.persistence.Persistence.createEntityManagerFactory(unit, this.getDBConnectionProperties());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();
        }
        catch (Exception except) {
            except.printStackTrace();
            em.getTransaction().rollback();
            rc = false;
        }
        finally {
            em.close();
            emf.close();
        }
        return rc;
    }
    
    public EntityManagerFactory getEmf(String unit) {
        EntityManagerFactory emf;
        emf = javax.persistence.Persistence.createEntityManagerFactory(unit, this.getDBConnectionProperties());
        return emf;
    }
    
    public static MeetDBConnection getDBConnection() {
        if (instance == null)
                instance = new MeetDBConnection();
        return instance;
    }
    
    public Boolean Connect(Boolean newDb) {
        try {
            String sendUrl = DbUrl;
            if (this.user != null)
                sendUrl = sendUrl + ";user=" + this.user;
            if (this.pass != null)
                sendUrl = sendUrl + ";password=" + this.pass;
            if (newDb == true)
                sendUrl = sendUrl + ";create=true";
            
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(sendUrl);
        }
        catch (Exception except)
        {
            status = except.getLocalizedMessage();
            System.out.println(status);
            if (status == null) {
                status = "Client Driver Error";
            }
            return false;
        }
        status = "Success";
        try {
            conn.close();
        }
        catch (Exception except) {
            status = "Odd problem closing connection";
        }
        return true;
    }
    
    public String getStatus() {
        if (status == null)
            return "Unknown";
        else
            return status;
    }
}
