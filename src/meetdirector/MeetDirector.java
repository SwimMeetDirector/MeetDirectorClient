/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meetdirector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.swing.JFileChooser;


/**
 *
 * @author nhorman
 */
public class MeetDirector extends javax.swing.JFrame {
    
    /**
     * Creates new form MeetSetup
     */
    
    public MeetDirector() {
        initComponents();
        
        this.setTitle("Meet Director");
        this.MainPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImportChooser = new javax.swing.JFileChooser();
        MainPanel = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        ConnecttoDBMenuItem = new javax.swing.JMenuItem();
        ImportMenuItem = new javax.swing.JMenuItem();
        ExitMenuItem = new javax.swing.JMenuItem();
        MeetDataMenu = new javax.swing.JMenu();
        MeetInfoMenu = new javax.swing.JMenuItem();
        SwimmerEditMenuItem = new javax.swing.JMenuItem();

        ImportChooser.setDialogTitle("Import Meet XML");
        ImportChooser.getAccessibleContext().setAccessibleParent(MainPanel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MeetDirector"); // NOI18N

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        jMenu3.setText("File");

        ConnecttoDBMenuItem.setText("Connect. to DB...");
        ConnecttoDBMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnecttoDBMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(ConnecttoDBMenuItem);

        ImportMenuItem.setText("Import Meet Entries");
        ImportMenuItem.setEnabled(false);
        ImportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(ImportMenuItem);

        ExitMenuItem.setLabel("Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(ExitMenuItem);

        jMenuBar2.add(jMenu3);

        MeetDataMenu.setText("Meet Data");
        MeetDataMenu.setEnabled(false);

        MeetInfoMenu.setText("Meet announcement");
        MeetInfoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeetInfoMenuActionPerformed(evt);
            }
        });
        MeetDataMenu.add(MeetInfoMenu);

        SwimmerEditMenuItem.setText("Edit Swimmers");
        SwimmerEditMenuItem.setToolTipText("");
        SwimmerEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwimmerEditMenuItemActionPerformed(evt);
            }
        });
        MeetDataMenu.add(SwimmerEditMenuItem);

        jMenuBar2.add(MeetDataMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void MeetInfoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeetInfoMenuActionPerformed

        MeetAnnouncementDialog.openWindow(null);// TODO add your handling code here:
    }//GEN-LAST:event_MeetInfoMenuActionPerformed

    private void ImportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportMenuItemActionPerformed

        ImportChooser.setFileFilter(new XmlFileFilter());
        int retval = ImportChooser.showOpenDialog(this.MainPanel);// TODO add your handling code here:
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = ImportChooser.getSelectedFile();
            MeetEntriesImportDialog importerWindow = new MeetEntriesImportDialog(new javax.swing.JFrame(), true, file);
            importerWindow.OpenWindow();
        }
    }//GEN-LAST:event_ImportMenuItemActionPerformed

    private void SwimmerEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwimmerEditMenuItemActionPerformed
        SwimmerEditDialog.OpenWindow();      // TODO add your handling code here:
    }//GEN-LAST:event_SwimmerEditMenuItemActionPerformed

    private void ConnecttoDBMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnecttoDBMenuItemActionPerformed
        ConnectionDialog dialog = new ConnectionDialog(new javax.swing.JFrame(), true);
        dialog.loadDBConfig();
        dialog.setVisible(true);
        // Return when the dialog is removed
        // Check to see if we're connected
        if (MeetDBConnection.getDBConnection().connected()) {
            this.ImportMenuItem.setEnabled(true);
            this.MeetDataMenu.setEnabled(true);
            this.ConnecttoDBMenuItem.setEnabled(false);
        }
        
    }//GEN-LAST:event_ConnecttoDBMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MeetDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeetDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeetDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeetDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MeetDirector().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConnecttoDBMenuItem;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JFileChooser ImportChooser;
    private javax.swing.JMenuItem ImportMenuItem;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenu MeetDataMenu;
    private javax.swing.JMenuItem MeetInfoMenu;
    private javax.swing.JMenuItem SwimmerEditMenuItem;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
