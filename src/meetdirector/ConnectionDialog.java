/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meetdirector;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author nhorman
 */
public class ConnectionDialog extends javax.swing.JDialog {

    private Properties DBConfigProps;
    private String configFileName = "./.meetdirector.conf";
    
    /**
     * Creates new form ConnectionDialog
     */
    public ConnectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DBConfigProps = new Properties();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CreateCheckBox = new javax.swing.JCheckBox();
        DBAddrText = new javax.swing.JTextField();
        DBPortText = new javax.swing.JTextField();
        DBNameText = new javax.swing.JTextField();
        DBUserText = new javax.swing.JTextField();
        DBPasswordText = new javax.swing.JPasswordField();
        CancelButton = new javax.swing.JButton();
        ConnectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connect to Database");

        jLabel1.setText("DB Address");

        jLabel2.setText("DB Port");

        jLabel3.setText("DB Name");

        jLabel5.setText("User Name");

        jLabel6.setText("Password");

        CreateCheckBox.setText("Create DB");

        DBAddrText.setText("127.0.0.1");

        DBPortText.setText("1527");

        DBNameText.setText("NewMeet");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ConnectButton.setText("Connect");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateCheckBox)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DBAddrText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(DBPortText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DBNameText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(DBUserText, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(DBPasswordText)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConnectButton)
                .addGap(37, 37, 37)
                .addComponent(CancelButton)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DBAddrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DBUserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DBPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DBPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DBNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreateCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConnectButton)
                    .addComponent(CancelButton))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_CancelButtonActionPerformed

     public void saveDBConfig() {
        FileOutputStream outstream = null;
        try {
            outstream = new FileOutputStream(configFileName);
            DBConfigProps.storeToXML(outstream, "Meet Director Configuration");
        }
        catch (Exception except) {
        }
        try {
            if (outstream != null)
                outstream.close();
        } catch (Exception except) {
            
        }
    }
     
    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed

        MeetDBConnection meet = MeetDBConnection.getDBConnection();
        meet.SetConnectionParams(DBAddrText.getText(), DBPortText.getText(), DBNameText.getText(), DBUserText.getText(), DBPasswordText.getText());
        if (meet.Connect(CreateCheckBox.isSelected()) == false) {
            // Note throw up a error dialog here
            return;
        }
        DBConfigProps.setProperty("Server", DBAddrText.getText());
        DBConfigProps.setProperty("Port", DBPortText.getText());
        DBConfigProps.setProperty("UserName", DBUserText.getText());
        DBConfigProps.setProperty("Password", DBPasswordText.getText());
        DBConfigProps.setProperty("DBName", DBNameText.getText());
        this.saveDBConfig();
        this.dispose();
    }//GEN-LAST:event_ConnectButtonActionPerformed

    public void loadDBConfig() {
        FileInputStream instream = null;
        try {
            instream = new FileInputStream(configFileName);
            DBConfigProps.loadFromXML(instream);
        } catch (Exception except) {
            DBConfigProps.setProperty("Server", "127.0.0.1");
            DBConfigProps.setProperty("Port", "1527");
            DBConfigProps.setProperty("UserName", "User");
            DBConfigProps.setProperty("Password", "password");
            DBConfigProps.setProperty("DBName", "GenericSwimMeet");
        }
        try {
            if (instream != null)
                instream.close();
        } catch (Exception except) {
            
        }
        DBAddrText.setText(DBConfigProps.getProperty("Server"));
        DBPortText.setText(DBConfigProps.getProperty("Port"));
        DBUserText.setText(DBConfigProps.getProperty("UserName"));
        DBPasswordText.setText(DBConfigProps.getProperty("Password"));
        DBNameText.setText(DBConfigProps.getProperty("DBName"));   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void OpenWindow() {
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
            java.util.logging.Logger.getLogger(ConnectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConnectionDialog dialog = new ConnectionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        return;
                    }
                });
                dialog.loadDBConfig();
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JCheckBox CreateCheckBox;
    private javax.swing.JTextField DBAddrText;
    private javax.swing.JTextField DBNameText;
    private javax.swing.JPasswordField DBPasswordText;
    private javax.swing.JTextField DBPortText;
    private javax.swing.JTextField DBUserText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
