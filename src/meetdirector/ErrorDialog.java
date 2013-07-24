/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meetdirector;

/**
 *
 * @author nhorman
 */
public class ErrorDialog extends javax.swing.JDialog {

    /**
     * Creates new form ErrorDialog
     */
    public ErrorDialog(String msg) {
        super(new javax.swing.JFrame(), true);
        initComponents();
        this.ErrorLabel.setText("ERROR: " + msg);
    }

    public static void DisplayErrorDialog(String msg) {
        ErrorDialog err = new ErrorDialog(msg);
        err.setVisible(true);
        return;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DismissButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ErrorLabel = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DismissButton.setText("Dismiss");
        DismissButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DismissButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DismissButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        ErrorLabel.setEditable(false);
        jScrollPane1.setViewportView(ErrorLabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DismissButtonActionPerformed
        this.dispose();        
    }//GEN-LAST:event_DismissButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DismissButton;
    private javax.swing.JTextPane ErrorLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}