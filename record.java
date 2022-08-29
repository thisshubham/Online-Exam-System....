
import java.awt.Button;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobinath
 */
public class record extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form record
     */
    public record() {
        initComponents();
   
        Connection();
        
        NullAllGivenAnswers();
    

    }
    
    private void NullAllGivenAnswers(){
             // here we have to call this method
    try {
                    String query = "UPDATE questions SET givenanswer = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, null);
                    pst.execute();
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }

    }
    
   
    
       Connection con;
       
       int answercheck =0;
   int marks=0;
    
    PreparedStatement pst;
    Statement stat = null;
    ResultSet ResultSet;
  
    
    int total_q;
    int attempted_q=0;
    int remain_q=total_q-attempted_q;
    int correct;
    int incorrect =-1;
    int notattempt=0;
      
    
    
    
 
    public boolean answerCheck()
            
        {
            String answerAnswer="";

            if(r1.isSelected())
            {
                answerAnswer = r1.getText();

            }

           else if(r2.isSelected())
            {
                answerAnswer = r2.getText();

            }

               else if(r3.isSelected())
            {
                answerAnswer = r3.getText();

            }

                else if(r4.isSelected())
            {

                answerAnswer = r4.getText();

            }
           
            if(answerAnswer.equals(cor) && (answer == null  || !answer.equals(cor)))
            {
                marks = marks + 1;
          
                txtc.setText(String.valueOf(marks));
               
             
            }
            
           else if(!answerAnswer.equals(cor) && answer != null)
            {
                
                // Only deduct if marks greater than zero
                if( marks > 0){
        
                marks = marks - 1;
                
                }
               
               
                txtc.setText(String.valueOf(marks));
               

            }
            // use to store answers
            if(!answerAnswer.equals("")){
                try {
                    String query = "UPDATE questions SET givenanswer = ? WHERE question = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, answerAnswer);
                    pst.setString(2, txtques.getText());
                    pst.execute();
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
                   return true;
            }
            // when no button is selected
            return false;

}
    
    
    
    
    
    
    
    
       
       
       
       
       
       
       
       
       
  //     int question1 = Integer.parseInt(questionid);
       
     //  question1 = question1 + 1;
     //  questionid = String.valueOf(question1);
       
       
   //    if(questionid.equals("3"))
   //    {
  //         jButton4.setVisible(false);
    //   }
       
       
 //  }
    
    String newans;
  
      String cor=null;
    
    
   public void Connection()
   {
       
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/onlineex","root","");
               String query = "select * from questions";
              stat = con.createStatement();
              
              
              ResultSet = stat.executeQuery(query);
  
               
              while(ResultSet.next()){
                txtqu.setText(ResultSet.getString("id"));
                txtques.setText(ResultSet.getString("question"));
                r1.setText(ResultSet.getString(3));
                r2.setText(ResultSet.getString(4));
                r3.setText(ResultSet.getString(5));
                r4.setText(ResultSet.getString(6));
                 cor = ResultSet.getString(7);
            
                 
                 // for one row only
                 break;
                }
              
              

   }    catch (ClassNotFoundException ex) {
            Logger.getLogger(record.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(record.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      
      
      
      
      
    
       }
    
    
     
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtques = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        txtqu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtc = new javax.swing.JLabel();
        kj = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtques.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtques.setText("jLabel1");

        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r1.setText("jRadioButton1");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r2);
        r2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r2.setText("jRadioButton2");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r3.setText("jRadioButton3");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r4.setText("jRadioButton4");
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        txtqu.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        txtqu.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r4)
                            .addComponent(r3)
                            .addComponent(r2)
                            .addComponent(r1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtques)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(txtqu)
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtques)
                    .addComponent(txtqu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(r1)
                .addGap(26, 26, 26)
                .addComponent(r2)
                .addGap(32, 32, 32)
                .addComponent(r3)
                .addGap(34, 34, 34)
                .addComponent(r4)
                .addGap(29, 29, 29))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setText("Mock up Exam");

        jButton4.setText("Previos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Next");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtc.setText("jLabel1");

        kj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kj.setForeground(new java.awt.Color(255, 51, 0));
        kj.setText("Marks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(kj)
                        .addGap(37, 37, 37)
                        .addComponent(txtc)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kj)
                    .addComponent(txtc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

       
   
               
       if(answerCheck()){
           
          
        
         
                
        try
           {
               
            if(ResultSet.next())
            {   
             
              
                
           //     txtqu.setText(ResultSet.getInt("id"));
                txtques.setText(ResultSet.getString("question"));
                r1.setText(ResultSet.getString(3));
                r2.setText(ResultSet.getString(4));
                r3.setText(ResultSet.getString(5));
                r4.setText(ResultSet.getString(6));
            
            cor=ResultSet.getString(7);
            
                
            if(!AlreadyAnswered()){
            
                     // clear all buttons when proceed to next question and it is not answered
                    buttonGroup1.clearSelection();
            }
           
            
            }
            else
                {
                    JOptionPane.showMessageDialog(this, "This is first record of student");
                }
        
      }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

//  String course=jLabel1.getText();
       
     try
           {
     
            if(ResultSet.previous())
            {   
               
           //     txtqu.setText(ResultSet.getInt("id"));
                txtques.setText(ResultSet.getString("question"));
             
                r1.setText(ResultSet.getString(3));
                r2.setText(ResultSet.getString(4));
                r3.setText(ResultSet.getString(5));
                r4.setText(ResultSet.getString(6));
            
            cor=ResultSet.getString(7);
            
             AlreadyAnswered();

            }
          
   
      }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed
private String answer;
    private boolean AlreadyAnswered(){
        try {
            String query = "SELECT givenanswer FROM questions WHERE question = '"+txtques.getText()+"'";
            stat = con.prepareStatement(query);
            
            ResultSet res = stat.executeQuery(query);
            
              while(res.next()){
               
                  answer = res.getString("givenanswer");
                if( answer  == null){
                    return false;
                }
            break;
            }
             
               if(r1.getText().equals(answer)){
             
               r1.setSelected(true);
               
           }
           
               else if(r2.getText().equals(answer)){
               r2.setSelected(true);
              
           }
            
           else if(r3.getText().equals(answer)){
               r3.setSelected(true);
         
           }
             
           else if(r4.getText().equals(answer)){
               r4.setSelected(true);
         
           }
              
        } catch (SQLException ex) {
            System.out.println("Exception Caught");
            ex.printStackTrace();
        }
        return true;
}
    
   
    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
        
    
     
        
        
        
        
        
        
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
        
       
        
        
    }//GEN-LAST:event_r2ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
     
        
        
        
    }//GEN-LAST:event_r3ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
     
        
    }//GEN-LAST:event_r4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new record().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel kj;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JLabel txtc;
    private javax.swing.JLabel txtqu;
    private javax.swing.JLabel txtques;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
