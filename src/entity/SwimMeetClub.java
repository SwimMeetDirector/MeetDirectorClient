/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import meetdirector.MeetDBConnection;
import org.usa_swimming.xsdif.AthleteEntryType;
import org.usa_swimming.xsdif.ClubEntryType;
import org.usa_swimming.xsdif.LscCodeType;

/**
 *
 * @author nhorman
 */
@Entity
public class SwimMeetClub extends PersistingObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clubFullName;
    private String clubShortName;
    private BigInteger phone;
    private BigInteger fax;
    private BigInteger mobilePhone;
    private String clubCode;
    private LscCodeType lscCode;
    private SwimMeetAthlete[] athletes;
    protected static final String PersistenceUnit = "MeetObjectPU";
    
    public SwimMeetClub(ClubEntryType club) {
        List<AthleteEntryType> athletes;
        int i = 0;
        this.clubFullName = new String(club.getClubFullName());
        this.clubShortName = new String(club.getClubShortName());
        this.phone = club.getPhone();
        this.fax = club.getFax();
        this.mobilePhone = club.getMobilePhone();
        this.clubCode = new String(club.getClubCode());
        this.lscCode = club.getLSCCode();
        this.athletes = new SwimMeetAthlete[club.getAthleteCount().intValue()];
        athletes = club.getAthleteEntries().getAthleteEntry();
        Iterator<AthleteEntryType> iterator = athletes.iterator();
        while (iterator.hasNext()) {
            AthleteEntryType athlete = iterator.next();
            this.athletes[i] = new SwimMeetAthlete(athlete);
        }
        this.persist();
    }
    
    public SwimMeetClub() {
        this.clubFullName = null;
        this.clubShortName = null;
        this.clubCode = null;
        this.athletes = null;
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
        if (!(object instanceof SwimMeetClub)) {
            return false;
        }
        SwimMeetClub other = (SwimMeetClub) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SwimMeetClub[ id=" + id + " ]";
    }
    
    public static SwimMeetClub GetClub(LscCodeType lsc, String clubcode) {
        MeetDBConnection conn = MeetDBConnection.getDBConnection();
        EntityManager em = conn.getEm(PersistenceUnit);
        Query query = em.createNativeQuery("SELECT * FROM SwimMeetClub", SwimMeetClub.class);
        List<SwimMeetClub> results = query.getResultList();
        Iterator<SwimMeetClub> iterator = results.iterator();
        while (iterator.hasNext()) {
            SwimMeetClub club = iterator.next();
            if ((club.getClubCode().equals(clubcode)) &&
                (club.getLscCode().equals(lsc)))
                    return club;
        }
        return null;
    }

    /**
     * @return the clubFullName
     */
    public String getClubFullName() {
        return clubFullName;
    }

    /**
     * @param clubFullName the clubFullName to set
     */
    public void setClubFullName(String clubFullName) {
        this.clubFullName = clubFullName;
    }

    /**
     * @return the clubShortName
     */
    public String getClubShortName() {
        return clubShortName;
    }

    /**
     * @param clubShortName the clubShortName to set
     */
    public void setClubShortName(String clubShortName) {
        this.clubShortName = clubShortName;
    }

    /**
     * @return the phone
     */
    public BigInteger getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
    public BigInteger getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(BigInteger fax) {
        this.fax = fax;
    }

    /**
     * @return the mobilePhone
     */
    public BigInteger getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(BigInteger mobilePhone) {
        this.mobilePhone = mobilePhone;
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
     * @return the lscCode
     */
    public LscCodeType getLscCode() {
        return lscCode;
    }

    /**
     * @param lscCode the lscCode to set
     */
    public void setLscCode(LscCodeType lscCode) {
        this.lscCode = lscCode;
    }
}
