/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import meetdirector.MeetDBConnection;

/**
 *
 * @author nhorman
 */
public class PersistingObject {
    
    protected String PersistenceUnit = "UnknownPU";
    
    public Boolean persist() {
        MeetDBConnection conn = MeetDBConnection.getDBConnection();
        return conn.storeObject(this, PersistenceUnit);
    }
    
    public void startUpdate() {
        EntityManager em = MeetDBConnection.getDBConnection().getEm(this.PersistenceUnit);
        em.getTransaction().begin();
    }
    
    public Boolean commitUpdate() {
        EntityManager em = MeetDBConnection.getDBConnection().getEm(this.PersistenceUnit);
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
    
}
