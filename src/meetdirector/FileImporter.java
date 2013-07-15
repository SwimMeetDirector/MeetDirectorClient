/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meetdirector;

import entity.SwimMeetAthlete;
import entity.SwimMeetClub;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import org.usa_swimming.xsdif.AthleteEntryType;
import org.usa_swimming.xsdif.ClubEntryType;
import org.usa_swimming.xsdif.MeetEntryFileType;

/**
 *
 * @author nhorman
 */
public class FileImporter {
    
    private File importFile;
    private javax.swing.JTextArea outputText;
    
    public FileImporter(File file) {
        importFile = file;
        this.outputText = null;
    }
    
    public FileImporter (File file, javax.swing.JTextArea output) {
        this(file);
        this.outputText = output;
    }
    
    protected <T> T getTopLevelDocument(Class DocClassType) throws ObjectNotFoundException {
        
        T objectInstance = null;
        
        try {
            JAXBContext context = JAXBContext.newInstance(DocClassType);
            Unmarshaller u = context.createUnmarshaller();
            InputStreamReader in = new InputStreamReader(new FileInputStream(this.importFile));
            XMLEventReader xer = XMLInputFactory.newInstance().createXMLEventReader(in);
            JAXBElement <T> ObjectElement = u.unmarshal(xer, DocClassType);
            objectInstance = ObjectElement.getValue();
            
        } catch (Exception e) {
            this.updateOutputText("Unable to find meet entry information in file");
            throw new ObjectNotFoundException("Could not find Document type " + DocClassType.getName());
        }
        
        return objectInstance;
    }
    
    public void ImportMeetEntryFile() {
        MeetEntryFileType meetEntry;
        List<ClubEntryType> clubs;
        
        try {
            meetEntry = this.getTopLevelDocument(MeetEntryFileType.class);
        } catch (ObjectNotFoundException e) {
            this.updateOutputText("Aborting File Import");
            return;
        }
        this.updateOutputText("Found Meet Entry " + meetEntry.getMeet().getMeetName());
        this.updateOutputText("Importing Clubs");
       
        this.ImportClubs(meetEntry.getClubs().getClub());
        
    }
    
    public void ImportClubs(List<ClubEntryType> clubs) {
        ClubEntryType club;
        Iterator<ClubEntryType> iterator = clubs.iterator();
        while (iterator.hasNext()) {
            club = iterator.next();
            SwimMeetClub DbClub = SwimMeetClub.GetClub(club.getClubCode());
            if (DbClub == null) {
                DbClub = new SwimMeetClub(club);
            } else {
                this.updateOutputText("Found Existing swim club " + DbClub.getClubCode() + " ...updating athletes");
            }
            // for each club update the athletes in that club
            this.ImportAthletes(DbClub, club.getAthleteEntries().getAthleteEntry());
        }
    }
    
    public void ImportAthletes(SwimMeetClub DbClub, List <AthleteEntryType> athletes) {
        Iterator<AthleteEntryType> iterator = athletes.iterator();
        List<SwimMeetAthlete> newAthletes = new ArrayList<SwimMeetAthlete>();
        
        while (iterator.hasNext()) {
                AthleteEntryType athlete = iterator.next();
                String usasid = athlete.getAthlete().getUsasID();
                SwimMeetAthlete check = SwimMeetAthlete.getAthleteByUsasId(athlete.getAthlete().getUsasID());
                if (check != null) {
                    this.updateOutputText("Already have swimmer " + usasid);
                    newAthletes.add(check);
                } else {
                    newAthletes.add(new SwimMeetAthlete(athlete, true));
                }
        }
        // Now that we have a list of Athletes, lets update the club with the new list
        DbClub.startUpdate();
        DbClub.setAthletes(newAthletes);
        if (DbClub.commitUpdate() == false)
            this.updateOutputText("Hmm, Problem updating Club in DB");
        
    }
    
    public void updateOutputText(String msg) {
        if (this.outputText != null)
            this.outputText.append(msg + "\n");
        else
            System.out.println(msg + "\n");
    }
    
}
