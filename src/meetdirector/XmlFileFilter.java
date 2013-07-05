/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meetdirector;

import java.io.File;

/**
 *
 * @author nhorman
 */
public class XmlFileFilter extends javax.swing.filechooser.FileFilter {
    
    
    @Override
    public String getDescription() {
        // This description will be displayed in the dialog,
        // hard-coded = ugly, should be done via I18N
        return "USA Swimming XSDIFdocuments (*.xml)";
    }
    
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".xml");
    }
    
}
