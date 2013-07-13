/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import meetdirector.MeetDBConnection;
 

/**
 *
 * @author nhorman
 */
@Entity
public class SwimMeet extends PersistingObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public static int EMAIL_INDEX=1;
    public static int NAME_INDEX=0;
    protected String MeetName;
    protected String MeetHost;
    protected String Address;
    protected String[] Director;
    protected String[] EntryCoordinator;
    protected String[] Referee;
    protected String[] Marshall;
    protected String Sanction;
    protected String AnnouncementText;
    
    
    protected SwimMeet(SwimMeet orig) {
        this.MeetName = new String(orig.MeetName);
        this.MeetHost = new String(orig.MeetHost);
        this.Address = new String(orig.Address);
        this.Director[this.NAME_INDEX] = new String(orig.Director[this.NAME_INDEX]);
        this.Director[this.EMAIL_INDEX] = new String(orig.Director[this.EMAIL_INDEX]);
        this.EntryCoordinator[this.NAME_INDEX] = new String(orig.EntryCoordinator[this.NAME_INDEX]);
        this.EntryCoordinator[this.EMAIL_INDEX] = new String(orig.EntryCoordinator[this.EMAIL_INDEX]);
        this.Referee[this.NAME_INDEX] = new String(orig.Referee[this.NAME_INDEX]);
        this.Referee[this.EMAIL_INDEX] = new String(orig.Referee[this.EMAIL_INDEX]);
        this.Marshall[this.NAME_INDEX] = new String(orig.Marshall[this.NAME_INDEX]);
        this.Marshall[this.EMAIL_INDEX] = new String(orig.Marshall[this.EMAIL_INDEX]);
        this.Sanction = new String (orig.Sanction);
        this.AnnouncementText = new String(orig.AnnouncementText);
    }
    
    protected SwimMeet() {
        this.MeetName = "";
        this.MeetHost = "";
        this.Address = "";
        this.Director = new String[2];
        this.Director[this.NAME_INDEX] = "";
        this.Director[this.EMAIL_INDEX] = "";
        this.EntryCoordinator = new String[2];
        this.EntryCoordinator[this.NAME_INDEX] = "";
        this.EntryCoordinator[this.EMAIL_INDEX] = "";
        this.Referee = new String[2];
        this.Referee[this.NAME_INDEX] = "";
        this.Referee[this.EMAIL_INDEX] = "";
        this.Marshall = new String[2];
        this.Marshall[this.NAME_INDEX] = "";
        this.Marshall[this.EMAIL_INDEX] = "";
        this.Sanction = "";
        this.AnnouncementText = "";
    }
    
    public static SwimMeet getSwimMeet() {
        SwimMeet meet;
        List<SwimMeet> results = PersistingObject.queryClassObjects("SELECT * From SwimMeet", SwimMeet.class);
        
        if (results.isEmpty()) {
            meet = new SwimMeet();
            if (meet.persist() == false) {
                System.out.println("Unable to persist Swimmeet");
            }
        } else {
            // There should only ever be one SwimMeet object per database
            meet = results.get(0);
        }
        
        return meet;
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
        if (!(object instanceof SwimMeet)) {
            return false;
        }
        SwimMeet other = (SwimMeet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SwimMeet[ id=" + id + " ]";
    }

    /**
     * @return the MeetName
     */
    public String getMeetName() {
        return MeetName;
    }

    /**
     * @param MeetName the MeetName to set
     */
    public void setMeetName(String MeetName) {
        this.MeetName = MeetName;
    }

    /**
     * @return the MeetHost
     */
    public String getMeetHost() {
        return MeetHost;
    }

    /**
     * @param MeetHost the MeetHost to set
     */
    public void setMeetHost(String MeetHost) {
        this.MeetHost = MeetHost;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Director
     */
    public String[] getDirector() {
        return Director;
    }

    /**
     * @param Director the Director to set
     */
    public void setDirector(String[] Director) {
        this.Director = Director;
    }

    /**
     * @return the EntryCoordinator
     */
    public String[] getEntryCoordinator() {
        return EntryCoordinator;
    }

    /**
     * @param EntryCoordinator the EntryCoordinator to set
     */
    public void setEntryCoordinator(String[] EntryCoordinator) {
        this.EntryCoordinator = EntryCoordinator;
    }

    /**
     * @return the Referee
     */
    public String[] getReferee() {
        return Referee;
    }

    /**
     * @param Referee the Referee to set
     */
    public void setReferee(String[] Referee) {
        this.Referee = Referee;
    }

    /**
     * @return the Marshall
     */
    public String[] getMarshall() {
        return Marshall;
    }

    /**
     * @param Marshall the Marshall to set
     */
    public void setMarshall(String[] Marshall) {
        this.Marshall = Marshall;
    }

    /**
     * @return the Sanction
     */
    public String getSanction() {
        return Sanction;
    }

    /**
     * @param Sanction the Sanction to set
     */
    public void setSanction(String Sanction) {
        this.Sanction = Sanction;
    }

    /**
     * @return the AnnouncementText
     */
    public String getAnnouncementText() {
        return AnnouncementText;
    }

    /**
     * @param AnnouncementText the AnnouncementText to set
     */
    public void setAnnouncementText(String AnnouncementText) {
        this.AnnouncementText = AnnouncementText;
    }
    
}
