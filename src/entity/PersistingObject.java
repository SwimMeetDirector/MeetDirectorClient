/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
    
}
