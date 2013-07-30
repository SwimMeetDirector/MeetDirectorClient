/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.usa_swimming.xsdif.CourseType;
import org.usa_swimming.xsdif.EventSeedType;

/**
 *
 * @author nhorman
 */
@Entity
public class SeedTime extends PersistingObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String rawSeedTime;
    private CourseType rawCourse;
    private String convertedSeedTime;
    private CourseType meetCourse;
    private Boolean isAlternate;
    
    @ManyToOne
    private SwimMeetAthlete swimmer;
            
    @ManyToOne
    private SwimMeetEvent event;
    
    public SeedTime() {
        this.rawSeedTime = "";
        this.rawCourse = CourseType.LCM;
        this.convertedSeedTime = "";
        this.meetCourse  = CourseType.LCM;
        this.isAlternate = false;
        this.swimmer = null;
        this.event = null;
    }
    
    public SeedTime(EventSeedType seed, SwimMeetAthlete swimmer, SwimMeetEvent event, Boolean persist) {
        this();
        this.rawSeedTime = seed.getRawSeedTime();
        this.rawCourse = seed.getRawCourse();
        this.convertedSeedTime  = seed.getConvertedSeedTime();
        this.meetCourse = seed.getMeetCourse();
        this.isAlternate = seed.isIsAlternate();
        this.swimmer = swimmer;
        this.event = event;
        if (persist == true)
            this.persist();
    }
    
    public SeedTime(SwimMeetAthlete swimmer, SwimMeetEvent event, Boolean persist) {
        this.rawSeedTime = "";
        this.rawCourse = CourseType.SCM;
        this.convertedSeedTime = "";
        this.meetCourse = CourseType.SCM;
        this.isAlternate = false;
        this.swimmer = swimmer;
        this.event = event;
        if (persist == true)
            this.persist();
    }
    
    public SeedTime(EventSeedType seed) {
        this(seed, null, null, false);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static SeedTime getSeedForEventSwimmer(SwimMeetAthlete swimmer, SwimMeetEvent event) {
            List<SeedTime> results;
            String queryString = "SELECT * FROM SeedTime WHERE SeedTime.SWIMMER_ID = " + swimmer.getId() + " AND SeedTime.EVENT_ID = " + event.getId();
            results = SeedTime.queryClassObjects(queryString, SeedTime.class);
            try {
                return results.get(0);
            } catch (Exception e)   {
                return null;
            }
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
        if (!(object instanceof SeedTime)) {
            return false;
        }
        SeedTime other = (SeedTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SeedTime[ id=" + id + " ]";
    }

    /**
     * @return the rawSeedTime
     */
    public String getRawSeedTime() {
        return rawSeedTime;
    }

    /**
     * @param rawSeedTime the rawSeedTime to set
     */
    public void setRawSeedTime(String rawSeedTime) {
        this.rawSeedTime = rawSeedTime;
    }

    /**
     * @return the rawCourse
     */
    public CourseType getRawCourse() {
        return rawCourse;
    }

    /**
     * @param rawCourse the rawCourse to set
     */
    public void setRawCourse(CourseType rawCourse) {
        this.rawCourse = rawCourse;
    }

    /**
     * @return the convertedSeedTime
     */
    public String getConvertedSeedTime() {
        return convertedSeedTime;
    }

    /**
     * @param convertedSeedTime the convertedSeedTime to set
     */
    public void setConvertedSeedTime(String convertedSeedTime) {
        this.convertedSeedTime = convertedSeedTime;
    }

    /**
     * @return the meetCourse
     */
    public CourseType getMeetCourse() {
        return meetCourse;
    }

    /**
     * @param meetCourse the meetCourse to set
     */
    public void setMeetCourse(CourseType meetCourse) {
        this.meetCourse = meetCourse;
    }

    /**
     * @return the isAlternate
     */
    public Boolean getIsAlternate() {
        return isAlternate;
    }

    /**
     * @param isAlternate the isAlternate to set
     */
    public void setIsAlternate(Boolean isAlternate) {
        this.isAlternate = isAlternate;
    }

    /**
     * @return the swimmer
     */
    public SwimMeetAthlete getSwimmer() {
        return swimmer;
    }

    /**
     * @param swimmer the swimmer to set
     */
    public void setSwimmer(SwimMeetAthlete swimmer) {
        this.swimmer = swimmer;
    }

    /**
     * @return the event
     */
    public SwimMeetEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(SwimMeetEvent event) {
        this.event = event;
    }
    
}
