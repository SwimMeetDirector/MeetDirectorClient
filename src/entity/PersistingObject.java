/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import meetdirector.MeetDBConnection;

/**
 *
 * @author nhorman
 */
public class PersistingObject {
    
    public Boolean persist() {
        MeetDBConnection conn = MeetDBConnection.getDBConnection();
        return conn.storeObject(this);
    }
    
    public void startUpdate() {
        EntityManager em = MeetDBConnection.getDBConnection().getEm();
        em.getTransaction().begin();
    }
    
    public Boolean commitUpdate() {
        EntityManager em = MeetDBConnection.getDBConnection().getEm();
        try {
            em.merge(this);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception except) {
            except.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }
    
    public static <T> List<T> queryClassObjects(String query, Class classtype) {
        MeetDBConnection conn = MeetDBConnection.getDBConnection();
        EntityManager em = conn.getEm();
        Query myquery = em.createNativeQuery(query, classtype);
        List<T> results = myquery.getResultList();
        return results;
    }
}
