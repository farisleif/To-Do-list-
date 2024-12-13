/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class proup extends javax.swing.JFrame {

     private Connection con;
    private PreparedStatement pst;
     private ResultSet rs;
     DefaultTableModel df;
    public proup() throws SQLException {
        initComponents();
        connectToDatabase();
        loadDataIntoTable();
        setLocationRelativeTo(null);
          setResizable(false);
    }

    proup(String ad1, String ad2, String ad3, String ad4) {
       initComponents();
    setLocationRelativeTo(null);
    
   
    jTextField1.setText(ad1);
    jTextArea1.setText(ad2);
    jTextField2.setText(ad3);
    jComboBox2.setSelectedItem(ad4);
   
    }

    public void connectToDatabase() throws SQLException
{
    try{
      Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listing","root","");
    }catch(ClassNotFoundException | SQLException ex){
        Logger.getLogger(proup.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    private void loadDataIntoTable() {
    try {
        String sql = "SELECT * FROM task ORDER BY due ASC";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

       

        while (rs.next()) {
           String add1 = rs.getString("title");
            String add2 = rs.getString("des");
            String add3 = rs.getString("due");
            String add4 = rs.getString("remark");
           
            
         
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
     private boolean isDueDateInCurrentYearAndDate(String ldate) {
    try {
        // Parse the date using SimpleDateFormat to match the format of "yyyy-MM-dd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dueDate = dateFormat.parse(ldate);

        // Get the year from the selected date
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dueDate);
        int selectedYear = cal.get(java.util.Calendar.YEAR);

        // Get the current date
        java.util.Calendar currentCal = java.util.Calendar.getInstance();
        java.util.Date currentDate = currentCal.getTime();
        currentCal.setTime(currentDate); // Reset time part of current date

        // Compare the selected year with the current year
        int currentYear = currentCal.get(java.util.Calendar.YEAR);

        // Check if the year matches the current year and if the due date is today or in the future
        return selectedYear == currentYear && !dueDate.before(currentDate);
        
    } catch (java.text.ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format: " + ldate);
        return false;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Remark:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 374, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Incomplete", "Inprogress", "Complete", " " }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 374, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 451, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 451, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Title");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 51, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 98, 383, 42));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descriptions");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 158, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 198, 383, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 327, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 327, 227, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/3.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String ad1 = jTextField1.getText();  // Title
    String ad2 = jTextArea1.getText();   // Description
    String ad3 = jTextField2.getText();  // Due Date
    String ad4 = (String) jComboBox2.getSelectedItem();  // Remark

    // Validate the date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
        // Parse the due date to check if it's valid
        dateFormat.parse(ad3);  
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format. Please use 'yyyy-MM-dd'.");
        return;  // Stop the update if the date is invalid
    }

    // Check if the due date is in the current year
    if (!isDueDateInCurrentYearAndDate(ad3)) {
        JOptionPane.showMessageDialog(this, "Due date must be today or in the future!");
        return;  // Stop the update if the year is not the current year
    }

    // Proceed with the update logic
    try {
        connectToDatabase();

        if (con != null) {
            // Build the SQL query dynamically
            StringBuilder queryBuilder = new StringBuilder("UPDATE task SET ");
            boolean isFirstField = true;

            // Check and add fields to the query only if they are modified
            if (!ad1.isEmpty()) {
                queryBuilder.append("title = ?");
                isFirstField = false;
            }
            if (!ad2.isEmpty()) {
                if (!isFirstField) queryBuilder.append(", ");
                queryBuilder.append("des = ?");
                isFirstField = false;
            }
            if (!ad3.isEmpty()) {
                if (!isFirstField) queryBuilder.append(", ");
                queryBuilder.append("due = ?");
                isFirstField = false;
            }
            if (!ad4.isEmpty()) {
                if (!isFirstField) queryBuilder.append(", ");
                queryBuilder.append("remark = ?");
            }

            queryBuilder.append(" WHERE title = ?");  // Use title as the primary key to identify the row

            // Prepare the statement
            pst = con.prepareStatement(queryBuilder.toString());
            int paramIndex = 1;

            // Bind parameters dynamically
            if (!ad1.isEmpty()) pst.setString(paramIndex++, ad1);
            if (!ad2.isEmpty()) pst.setString(paramIndex++, ad2);
            if (!ad3.isEmpty()) pst.setString(paramIndex++, ad3);
            if (!ad4.isEmpty()) pst.setString(paramIndex++, ad4);
            pst.setString(paramIndex, ad1);  // Assuming 'title' is the identifier

            // Execute the update
            int updatedRows = pst.executeUpdate();

            if (updatedRows > 0) {
                
                this.dispose();  // Close the frame after updating
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update record. No record found with this ID.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Database connection is not established.");
        }
    } catch (SQLException | NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);
    
    if(option == JOptionPane.YES_OPTION) {
      
        
       
        proup Frame = null; 
               try {
                   Frame = new proup();
               } catch (SQLException ex) {
                   Logger.getLogger(proup.class.getName()).log(Level.SEVERE, null, ex);
               }
        Frame.setVisible(false);
        this.dispose();
    }     
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(proup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new proup().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(proup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
