/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import meetdirector.MeetDBConnection;

/**
 *
 * @author nhorman
 */
@Entity
public class SwimMeetSession extends PersistingObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String SessionName;
    private int LaneCount;
    
    
    public SwimMeetSession() {
        SessionName = "";
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SwimMeetSession)) {
            return false;
        }
        SwimMeetSession other = (SwimMeetSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SwimMeetSession[ id=" + id + " ]";
    }

    /**
     * @return the SessionName
     */
    public String getSessionName() {
        return SessionName;
    }

    /**
     * @param SessionName the SessionName to set
     */
    public void setSessionName(String SessionName) {
        this.SessionName = SessionName;
    }
    
}
