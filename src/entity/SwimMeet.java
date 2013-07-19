/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.usa_swimming.xsdif.MeetType;
 

/**
 *
 * @author nhorman
 */
@Entity
public class SwimMeet extends PersistingObject implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public static int EMAIL_INDEX=1;
    public static int NAME_INDEX=0;
    private String MeetName;
    private String MeetHost;
    private String Address;
    private String[] Director;
    private String[] EntryCoordinator;
    private String[] Referee;
    private String[] Marshall;
    private String Sanction;
    private String AnnouncementText;
    private GregorianCalendar StartTime;
    private GregorianCalendar EndTime;
    
    protected SwimMeet(SwimMeet orig) {
        this.MeetName = new String(orig.getMeetName());
        this.MeetHost = new String(orig.getMeetHost());
        this.Address = new String(orig.getAddress());
        this.Director[this.NAME_INDEX] = new String(orig.getDirector()[this.NAME_INDEX]);
        this.Director[this.EMAIL_INDEX] = new String(orig.getDirector()[this.EMAIL_INDEX]);
        this.EntryCoordinator[this.NAME_INDEX] = new String(orig.getEntryCoordinator()[this.NAME_INDEX]);
        this.EntryCoordinator[this.EMAIL_INDEX] = new String(orig.getEntryCoordinator()[this.EMAIL_INDEX]);
        this.Referee[this.NAME_INDEX] = new String(orig.getReferee()[this.NAME_INDEX]);
        this.Referee[this.EMAIL_INDEX] = new String(orig.getReferee()[this.EMAIL_INDEX]);
        this.Marshall[this.NAME_INDEX] = new String(orig.getMarshall()[this.NAME_INDEX]);
        this.Marshall[this.EMAIL_INDEX] = new String(orig.getMarshall()[this.EMAIL_INDEX]);
        this.Sanction = new String (orig.getSanction());
        this.AnnouncementText = new String(orig.getAnnouncementText());
        this.StartTime = orig.getStartTime();
        this.EndTime = orig.getEndTime();
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
        this.StartTime = new GregorianCalendar();
        this.EndTime = new GregorianCalendar();
    }
    
    public SwimMeet(MeetType meetimport) throws Exception{
        this();
        if (SwimMeet.swimMeetCreated())
            throw new Exception("Meet Entry already Created");
        this.setMeetName(meetimport.getMeetName());
        this.setMeetHost(meetimport.getHosts().get(0).getName());
        this.setAddress(meetimport.getLocation().toString());
        this.setStartTime(meetimport.getStart().toGregorianCalendar());
        this.setEndTime(meetimport.getEnd().toGregorianCalendar());
        // Note we need to Modify the dialog to support the Start and End Times
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
    
    public static Boolean swimMeetCreated() {
        SwimMeet meet;
        List<SwimMeet> results = PersistingObject.queryClassObjects("SELECT * From SwimMeet", SwimMeet.class);
        if (results.isEmpty())
            return false;
        return true;
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
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SwimMeet)) {
            return false;
        }
        SwimMeet other = (SwimMeet) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SwimMeet[ id=" + getId() + " ]";
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
        this.setDirector(Director);
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
        this.setEntryCoordinator(EntryCoordinator);
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
        this.setReferee(Referee);
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
        this.setMarshall(Marshall);
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

    /**
     * @return the StartTime
     */
    public GregorianCalendar getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(GregorianCalendar StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the EndTime
     */
    public GregorianCalendar getEndTime() {
        return EndTime;
    }

    /**
     * @param EndTime the EndTime to set
     */
    public void setEndTime(GregorianCalendar EndTime) {
        this.EndTime = EndTime;
    }
    
}
