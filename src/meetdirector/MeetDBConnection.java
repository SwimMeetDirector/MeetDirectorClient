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
    private Connection conn = null;
    private String user = null;
    private String pass = null;
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private Boolean connected = false;
    
    protected MeetDBConnection() {
        
    }
    
    public void SetConnectionParams(String server, String port, String name, String user, String pass) {
        this.DbUrl = "jdbc:derby://";
        this.DbUrl = this.DbUrl + server + ":" + port + "/" + name;
        this.user = user;
        this.pass = pass; 
    }
    
    public Map getDBConnectionProperties() {
        Map pmap = new HashMap();
        if (this.pass != null)
            pmap.put("hibernate.connection.password", pass);
        if (this.user != null)
            pmap.put("hibernate.connection.username", user);
        pmap.put("hibernate.connection.url", this.DbUrl);
        return pmap;
    }
    
    public Boolean storeObject(Object obj) {
        EntityManager em;
        Boolean rc = true;
        
        em = (EntityManager)this.em;
        
        if (em == null)
            return false;
        
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception except) {
            except.printStackTrace();
            em.getTransaction().rollback();
            rc = false;
        }
        return rc;
    }
    
    public <T> T findObject(Class classtype, Object pk) {
        Object rc;
        rc = this.em.find(classtype, pk);
        return (T)rc;
    }
    
    public EntityManagerFactory getEmf() {
        return this.emf;
    }
    
    public EntityManager getEm() {
        return this.em;
    }
    public static MeetDBConnection getDBConnection() {
        if (instance == null)
                instance = new MeetDBConnection();
        return instance;
    }
    
    public void Connect(Boolean newDb) throws Exception {
        
       String sendUrl = this.DbUrl;
       if (this.user != null)
           sendUrl = sendUrl + ";user=" + this.user;
       if (this.pass != null)
           sendUrl = sendUrl + ";password=" + this.pass;
       if (newDb == true)
           sendUrl = sendUrl + ";create=true";
            
       Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
       conn = DriverManager.getConnection(sendUrl);
        
        conn.close();
        connected = true;
        
        this.emf = javax.persistence.Persistence.createEntityManagerFactory("MeetObjectPU", this.getDBConnectionProperties());
        this.em = emf.createEntityManager();
    }
    
    public Boolean connected() {
        return connected;
    }
    
}
