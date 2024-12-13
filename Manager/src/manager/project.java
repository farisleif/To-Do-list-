/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

public class project extends javax.swing.JFrame {

   private Connection con;
     private PreparedStatement pst;
     private ResultSet rs;
     DefaultTableModel df;
     
    public project() {
        initComponents();          
         setLocationRelativeTo(null);
          setResizable(false);
          connectToDatabase();
          clearFields();
          loadDataIntoTable();
    }

     public void connectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/listing", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
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
       private void clearFields() {
    jTextField1.setText("");
    jTextArea1.setText("");
     dat.setDate(null);
    jComboBox1.setSelectedItem("");

}
     private void loadDataIntoTable() {
    try {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Clear existing rows

        // Update the SQL query to sort by the due date in ascending order
        String sql = "SELECT * FROM task ORDER BY due ASC"; // Change "ASC" to "DESC" for descending order
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            String title = rs.getString("title");
            String description = rs.getString("des");
            String dueDate = rs.getString("due");
            String remark = rs.getString("remark");

            // Add the data from the result set to the table model
            model.addRow(new Object[]{title, description, dueDate, remark});
        }

        // Enable table sorting (optional)
        jTable2.setAutoCreateRowSorter(true);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        dat = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Incomplete", "Inprogress", "Complete", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 507, -1, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 588, 160, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, 210, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 175, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Title:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 173, -1, -1));

        Search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 172, 319, 31));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 590, 130, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0), 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FocusFlow");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stay in the flow of getting things done");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel5)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 769, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 140, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 323, 202, 112));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Descriptions");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 204, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 246, -1, -1));
        getContentPane().add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 453, 137, 36));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 453, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Remark");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 516, -1, -1));

        jTable2.setBackground(new java.awt.Color(0, 204, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title ", "Description", "Due Date", "Remark"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 277, 488, 270));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 590, 150, 37));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Log out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 634, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/n.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 770, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
   String Tit = jTextField1.getText();
    String descrip = jTextArea1.getText();

    // Check if a date is selected in the JDateChooser
    if (dat.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Please select a date.");
        return; // Exit the method if no date is selected
    }

    // Format the selected date to match the format in the database
    String ldate = new SimpleDateFormat("yyyy-MM-dd").format(dat.getDate());
    
    // Retrieve the remark from the combo box
    String rem = (String) jComboBox1.getSelectedItem();

    // Validate the inputs
    if (Tit.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Title.");
    } else if (descrip.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Description.");
    } else if (rem == null || rem.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select Remark.");
    } else if (isDueDateInCurrentYearAndDate(ldate)) { // Validate that the date is within the current year
        JOptionPane.showMessageDialog(this, "Due date must be today or in the future!");
    } else {
        try {
            // Prepare SQL query to insert the data into the database
            String sql = "INSERT INTO task (title, des, due, remark) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, Tit);
            statement.setString(2, descrip);
            statement.setString(3, ldate);
            statement.setString(4, rem);

            // Execute the insertion
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // If insertion was successful, clear fields and reload table
                clearFields();
                loadDataIntoTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(urgent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
 DefaultTableModel ob = (DefaultTableModel) jTable2.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        jTable2.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(Search.getText()));       
    }//GEN-LAST:event_SearchKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
      loadDataIntoTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
  int selectedRowIndex = jTable2.getSelectedRow();

if (selectedRowIndex != -1 && selectedRowIndex < jTable2.getRowCount()) {
    // Retrieve data from the selected row
    Object add1= jTable2.getValueAt(selectedRowIndex, 0);
    Object  add2= jTable2.getValueAt(selectedRowIndex, 1);
    Object add3= jTable2.getValueAt(selectedRowIndex, 2);
    Object add4 = jTable2.getValueAt(selectedRowIndex, 3);
    

    if (add1 != null && add2 != null && add3 != null && add4 != null) {
       
        String funame = add1.toString();
        String sub = add2.toString();
        String add = add3.toString();
        String addad = add4.toString();

        // Now you can use the retrieved data as needed
    } else {
        JOptionPane.showMessageDialog(this, "Error: One or more values retrieved from the table are null.");
    }
} else {
    JOptionPane.showMessageDialog(this, "Please select a valid row from the table.");
}    
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
           int selectedRowIndex = jTable2.getSelectedRow();

if (selectedRowIndex != -1 && selectedRowIndex < jTable2.getRowCount()) {
    // Retrieve data from the selected row
    Object tit = jTable2.getValueAt(selectedRowIndex, 0);
    Object desc = jTable2.getValueAt(selectedRowIndex, 1);
    Object date = jTable2.getValueAt(selectedRowIndex, 2);
    Object rem = jTable2.getValueAt(selectedRowIndex, 3);
   

    if (tit != null && desc != null &&date !=null && rem !=null) {
       
        String ad1 = tit.toString();
        String ad2 = desc.toString();
        String ad3 = date.toString();
        String ad4 = rem.toString();
       
  
        proup page;
        page = new proup(ad1, ad2, ad3, ad4);
            page.setVisible(true);
            loadDataIntoTable();
    } else {
        JOptionPane.showMessageDialog(this, "Error: One or more values retrieved from the table are null.");
    }
} else {
    JOptionPane.showMessageDialog(this, "Please select a valid row from the table.");
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
    
    if(option == JOptionPane.YES_OPTION) {
        // Clear any session data or user authentication
        // For example, you can reset the logged-in user's session or clear any stored authentication tokens
        
        // After clearing the session data, navigate back to the login screen or perform any other necessary actions
        project Frame = new project(); // Replace LoginFrame with your actual login frame class name
        Frame.setVisible(false);
        this.dispose(); // Close the current frame
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        int selectedRowIndex = jTable2.getSelectedRow();
        if (selectedRowIndex != -1) {
            try {
                String tit = (String) jTable2.getValueAt(selectedRowIndex, 0);
                pst = con.prepareStatement("DELETE FROM task WHERE title = ?");
                pst.setString(1, tit);
                
                int deletedRows = pst.executeUpdate();

                if (deletedRows > 0) {
                    
                   
                    loadDataIntoTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete record. No record found with this ID");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          new Main().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new project().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private com.toedter.calendar.JDateChooser dat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
