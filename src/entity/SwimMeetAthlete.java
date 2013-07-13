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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import meetdirector.MeetEntriesImportDialog;
import org.usa_swimming.xsdif.AthleteEntryType;
import org.usa_swimming.xsdif.AthleteType;
import org.usa_swimming.xsdif.Gender;
import org.usa_swimming.xsdif.LscCodeType;
import org.usa_swimming.xsdif.OrganizationType;

/**
 *
 * @author nhorman
 */
@Entity
public class SwimMeetAthlete extends PersistingObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn
    private AthleteName name;
    private GregorianCalendar birthDate;
    private Gender gender;
    private boolean isAttached;
    private LscCodeType lsc;
    private String clubCode;
    private String[] citizenOf;
    private OrganizationType organization;
    private String usasID;
    
    public SwimMeetAthlete(AthleteEntryType swimmer, Boolean persist) {
        if (swimmer != null) {
            AthleteType athlete = swimmer.getAthlete();
            MeetEntriesImportDialog.UpdateLog("Adding Swimmer " + athlete.getUsasID());
            this.name = new AthleteName(athlete.getName(), true);
            this.birthDate = athlete.getBirthDate().toGregorianCalendar();
            this.gender = athlete.getGender();
            this.isAttached = athlete.isIsAttached();
            this.lsc = athlete.getLSC();
            this.clubCode = new String(athlete.getClubCode());
            this.citizenOf = new String[athlete.getCitizenOf().size()];
            this.citizenOf = athlete.getCitizenOf().toArray(this.citizenOf);
            this.organization = athlete.getOrganization();
            this.usasID = athlete.getUsasID();
            MeetEntriesImportDialog.UpdateLog("Done adding swimmer " + athlete.getUsasID());
        }
        if (persist == true)
            this.persist();
    }
    
    
    public SwimMeetAthlete() {
        this(null, false);
        this.id = null;
    }
    
    public static SwimMeetAthlete getAthleteByUsasId(String usasid){
        List<SwimMeetAthlete> results;
        String myquery = "SELECT * FROM SwimMeetAthlete WHERE SwimMeetAthlete.usasid = '" + usasid +"'";
        results = SwimMeetAthlete.queryClassObjects(myquery, SwimMeetAthlete.class);
        if (results.isEmpty())
            return null;
        if (results.size() > 1) {
            MeetEntriesImportDialog.UpdateLog("ERROR!  MULTIPLE SWIMMERS IN DB WITH USASID " + usasid);
            return null;
        }
        return results.get(0);
    }
    
    public Long getId() {
        return this.id;
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
        if (!(object instanceof SwimMeetAthlete)) {
            return false;
        }
        SwimMeetAthlete other = (SwimMeetAthlete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entity.SwimMeetAthlete[ id=" + id + " ]";
        return "entity.SwimMeetAthlete[ usasID=" + getUsasID() + " ]";
        
    }

    /**
     * @return the name
     */
    public AthleteName getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(AthleteName name) {
        this.name = name;
    }



    /**
     * @return the clubCode
     */
    public String getClubCode() {
        return clubCode;
    }

    /**
     * @param clubCode the clubCode to set
     */
    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }


    /**
     * @return the usasID
     */
    public String getUsasID() {
        return usasID;
    }

    /**
     * @param usasID the usasID to set
     */
    public void setUsasID(String usasID) {
        this.usasID = usasID;
    }
    
}

