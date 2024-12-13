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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

public class work extends javax.swing.JFrame {

    private Connection con;
     private PreparedStatement pst;
     private ResultSet rs;
     DefaultTableModel df;
     
    public work() {
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
        String sql = "SELECT * FROM tasking ORDER BY due ASC"; // Change "ASC" to "DESC" for descending order
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

        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        dat = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 580, 120, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 580, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 445, -1, -1));

        jButton6.setBackground(new java.awt.Color(204, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Log out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 315, 202, 112));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 231, 210, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Descriptions");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Remark");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 508, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Title");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 269, 488, 270));

        jButton4.setBackground(new java.awt.Color(0, 204, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 238, -1, -1));

        Search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 319, 31));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 580, 150, 37));
        getContentPane().add(dat, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 445, 137, 36));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Incomplete", "Inprogress", "Complete", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 499, -1, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FocusFlow");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stay in the flow of getting things done");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(308, 308, 308))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 811, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/manager/h.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            int selectedRowIndex = jTable2.getSelectedRow();
            if (selectedRowIndex != -1) {
                try {
                    String tit = (String) jTable2.getValueAt(selectedRowIndex, 0);
                    pst = con.prepareStatement("DELETE FROM tasking WHERE title = ?");
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

                workup page;
                page = new workup(ad1, ad2, ad3, ad4);
                page.setVisible(true);
                loadDataIntoTable();
            } else {
                JOptionPane.showMessageDialog(this, "Error: One or more values retrieved from the table are null.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a valid row from the table.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
    } else if (!isDueDateInCurrentYearAndDate(ldate)) { // Validate that the date is within the current year and not past
        JOptionPane.showMessageDialog(this, "Due date must be today or in the future!");
    } else {
        try {
            // Prepare SQL query to insert the data into the database
            String sql = "INSERT INTO tasking (title, des, due, remark) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, Tit);
            statement.setString(2, descrip);
            statement.setString(3, ldate);
            statement.setString(4, rem);

            // Execute the insertion
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // If insertion was successful, clear fields and reload table
                JOptionPane.showMessageDialog(this, "Record inserted successfully!");
                clearFields();   // Clear input fields after successful insert
                loadDataIntoTable(); // Reload table with updated data
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(urgent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

        if(option == JOptionPane.YES_OPTION) {
            // Clear any session data or user authentication
            // For example, you can reset the logged-in user's session or clear any stored authentication tokens

            // After clearing the session data, navigate back to the login screen or perform any other necessary actions
            work Frame = new work(); // Replace LoginFrame with your actual login frame class name
            Frame.setVisible(false);
            this.dispose(); // Close the current frame
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
      int selectedRowIndex = jTable2.getSelectedRow();

    if (selectedRowIndex != -1 && selectedRowIndex < jTable2.getRowCount()) {
        // Convert the selected row index to model index
        int modelRowIndex = jTable2.convertRowIndexToModel(selectedRowIndex);

        // Retrieve data from the selected row
        Object add1 = jTable2.getModel().getValueAt(modelRowIndex, 0);
        Object add2 = jTable2.getModel().getValueAt(modelRowIndex, 1);
        Object add3 = jTable2.getModel().getValueAt(modelRowIndex, 2);
        Object add4 = jTable2.getModel().getValueAt(modelRowIndex, 3);

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadDataIntoTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        DefaultTableModel ob = (DefaultTableModel) jTable2.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        jTable2.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(Search.getText()));
    }//GEN-LAST:event_SearchKeyReleased

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
            java.util.logging.Logger.getLogger(work.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(work.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(work.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(work.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new work().setVisible(true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
