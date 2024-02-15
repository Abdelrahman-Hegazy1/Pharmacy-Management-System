
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.op;
import common.openPdf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import dao.pharmacyUtils;
import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.ImageIcon;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author win10
 */
public class sell_medicine extends javax.swing.JFrame {

    /**
     * Creates new form sell_medicine
     * @param tmpusername
     */
    public String numberPattern ="^[0-9]*$";
    private int finalTotalPrice =0;
    private String billId ="";
    private String username ="";
  
    public sell_medicine() {
        initComponents();
           buy.setBackground(Color.WHITE);
        buy.setForeground(new Color(56,78,220));
           cartButton.setBackground(Color.WHITE);
        cartButton.setForeground(new Color(56,78,220));
         bsearch.setBackground(Color.WHITE);
        bsearch.setForeground(new Color(56,78,220));
    }
    public sell_medicine(String tmpusername  ) {
        initComponents();
        username=tmpusername;
     setLocationRelativeTo(null);
        buy.setBackground(Color.WHITE);
        buy.setForeground(new Color(56,78,220));
           cartButton.setBackground(Color.WHITE);
        cartButton.setForeground(new Color(56,78,220));
         bsearch.setBackground(Color.WHITE);
        bsearch.setForeground(new Color(56,78,220));
    }

    private void medicineName(String nameOrUniqueId)
    {
    DefaultTableModel model =(DefaultTableModel) medicineTable.getModel();
    model.setRowCount(0);
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
    String sql="select *from medicine where name like \""+nameOrUniqueId+"\"or uniqueId like \""+nameOrUniqueId+"\"";
    Statement st=con.createStatement();
    ResultSet r=st.executeQuery(sql);
    while(r.next()){
    model.addRow(new Object[]{r.getString("uniqueId")+"- "+r.getString("name")});
    
    }
    con.close();
    }
    catch (Exception e){JOptionPane.showMessageDialog(null,e);}
    
    }
    
     private void sell(){
         DefaultTableModel m=(DefaultTableModel)cartTable.getModel();
         cartTable.setDefaultEditor(Object.class, null);
         String nunits=nou.getText();
         String uniqueId=txtid.getText();
         if (!nunits.equals("") && !uniqueId.equals("")){
         String name=txtname.getText();
         String cname=txtcname.getText();
         String price=ppu.getText();
         String tprice=tp.getText();
         int checkStock= 0;
         int checkR=0;
      
         
         try{Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
         String sql="select *from medicine where uniqueid= ?";
         PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1,uniqueId);
         ResultSet r=pst.executeQuery();
         while(r.next()){if(r.getInt("quantity") >= Integer.parseInt(nunits)){checkStock=1;}else{JOptionPane.showMessageDialog(null,"Medicine is out of Stock.only "+r.getInt("quantity")+" available");}
         
         }
         
         }
         catch(Exception e){JOptionPane.showMessageDialog(null,e);}
         if (checkStock==1){
            if(m.getRowCount()!= 0){
                for(int i=0;i<m.getRowCount();i++){
                    if(Integer.parseInt(m.getValueAt(i,0).toString() ) == Integer.parseInt(uniqueId)){checkR=1;JOptionPane.showMessageDialog(null,"Medicine Already Exists in Cart");}
                }
                   
            }
            if(checkR!=1){m.addRow(new Object[]{uniqueId,name,cname,price,nunits,tprice});
           finalTotalPrice=finalTotalPrice+Integer.parseInt(tprice);
           lftp.setText(String.valueOf(finalTotalPrice));
           JOptionPane.showMessageDialog(null,"Added Successfully");
           }
           
           clearMedicineFields();
         }
         }
         else{JOptionPane.showMessageDialog(null, "Number of units and Medicine ID field is required");}
       }
    
     
    private void clearMedicineFields(){
    txtid.setText("");
    txtname.setText("");
    txtcname.setText("");
    ppu.setText("");
    nou.setText("");
    tp.setText("");
    txtsearch.setText("");
    }
    
    public String getUniqueId(String p){
    return p+System.nanoTime();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bcart = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ppu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nou = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tp = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        buy = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lftp = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        bcart.setText("Add To Cart");
        bcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcartActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(247, 249, 250));
        jPanel1.setForeground(new java.awt.Color(56, 78, 220));

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 78, 220));
        jLabel2.setText("Sell Medicine");

        bsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image2/search.png"))); // NOI18N
        bsearch.setText("Search");
        bsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsearchMouseExited(evt);
            }
        });
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });
        bsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bsearchKeyReleased(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Medicine"
            }
        ));
        medicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicineTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(56, 78, 220));
        jLabel3.setText("Medicine ID");

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 78, 220));
        jLabel4.setText("Name");

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(56, 78, 220));
        jLabel5.setText("Company Name");

        txtcname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 78, 220));
        jLabel6.setText("Price Per Unit ");

        ppu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ppu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(56, 78, 220));
        jLabel7.setText("No. Of Units");

        nou.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouActionPerformed(evt);
            }
        });
        nou.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nouKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(56, 78, 220));
        jLabel8.setText("Total Price");

        tp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cartTable.setForeground(new java.awt.Color(56, 78, 220));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Medicine ID", "Company Name", "NO.of.Items", "Price Per Unit", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        buy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image2/generate bill & print.png"))); // NOI18N
        buy.setText("Purchase & Print");
        buy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyMouseExited(evt);
            }
        });
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });

        cartButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image2/add to cart.png"))); // NOI18N
        cartButton.setText("Add To Cart");
        cartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartButtonMouseExited(evt);
            }
        });
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 78, 220));
        jLabel1.setText("LE :");

        lftp.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lftp.setForeground(new java.awt.Color(56, 78, 220));
        lftp.setText("00");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close Window.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(313, 313, 313)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(ppu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(343, 343, 343)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(nou, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(290, 290, 290)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(510, 510, 510)
                                .addComponent(cartButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lftp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(buy)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(548, 548, 548)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(bsearch)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ppu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(cartButton)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buy)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lftp)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bsearchKeyReleased

        String search=txtsearch.getText();
        medicineName(search);

        // TODO add your handling code here:
    }//GEN-LAST:event_bsearchKeyReleased

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void ppuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppuActionPerformed

    private void nouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nouActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

         medicineName("");
        txtid.setEditable(false);
        txtname.setEditable(false);
        txtcname.setEditable(false);
        ppu.setEditable(false);
       // nou.setEditable(false);
        tp.setEditable(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void medicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTableMouseClicked

        int index=medicineTable.getSelectedRow();
        TableModel model= medicineTable.getModel();
        String nameOrUniqueId=model.getValueAt(index,0).toString();
        String uniqueId[]=nameOrUniqueId.split("-",0);
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
        Statement s=con.createStatement();
        ResultSet r=s.executeQuery("select *from medicine where uniqueId = \""+uniqueId[0]+"\"");
        while(r.next()){
        
            txtid.setText(uniqueId[0]);
            txtname.setText(r.getString("name"));
            txtcname.setText(r.getString("companyName"));
            ppu.setText(r.getString("price"));
            nou.setText((""));
            tp.setText((""));
            
            
        
        }
        con.close();
        }
        catch (Exception e){JOptionPane.showMessageDialog(null,e);}
        
        // TODO add your handling code here:
    }//GEN-LAST:event_medicineTableMouseClicked

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed

        medicineName(txtsearch.getText());

        
        // TODO add your handling code here:
    }//GEN-LAST:event_bsearchActionPerformed

    private void nouKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nouKeyReleased

        String nounits=nou.getText();
        if (!nounits.equals("")){
        
            String price=ppu.getText();
            if(!nounits.matches(numberPattern)){JOptionPane.showMessageDialog(null,"No.OF Units Field is invalid");}
            int totalPrice=Integer.parseInt(nounits)*Integer.parseInt(price);
            tp.setText(String.valueOf(totalPrice));
            
        }
        else {
            tp.setText("");}
        // TODO add your handling code here:
    }//GEN-LAST:event_nouKeyReleased

    private void bcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcartActionPerformed
        
       /* String nunits=nou.getText();
         String Uniqueid=txtid.getText();
        
        if(!nunits.equals("") && !Uniqueid.equals("") ){
        
            int checkStock=0;
            int chek_already_in_cart=0;
            //DefaultTableModel model =(DefaultTableModel) medicineTable.getModel();
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
            String sql="select *from medicine where uniqueId uniqueId ="+Uniqueid+"";
            Statement st=con.createStatement();
            ResultSet r=st.executeQuery(sql);
            while(r.next()){
            if(r.getInt("quantity") >= Integer.parseInt(nunits) ){ checkStock=1;}
            else {JOptionPane.showMessageDialog(null,"This Medicine is out of Stock.Only"+r.getInt("quantity")+"available");}

            }
            //con.close();
            }
            catch (Exception e){JOptionPane.showMessageDialog(null,e);}

            }
    
        }
        //*/
  
       
    }//GEN-LAST:event_bcartActionPerformed

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartButtonActionPerformed
        // TODO add your handling code here:   
        sell();
        
    }//GEN-LAST:event_cartButtonActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked

        int index=cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "DO You Want TO Delete This Medicine","select",JOptionPane.YES_NO_OPTION);
        if(a==0){TableModel m=cartTable.getModel();
        String Total=m.getValueAt(index,5).toString();
        finalTotalPrice=finalTotalPrice-Integer.parseInt(Total);
        lftp.setText(String.valueOf(finalTotalPrice));
        ((DefaultTableModel) cartTable.getModel()).removeRow(index);}
        // TODO add your handling code here:
    }//GEN-LAST:event_cartTableMouseClicked

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed

        if(finalTotalPrice!=0){
            billId=getUniqueId("Bill-");
            DefaultTableModel m =(DefaultTableModel) cartTable.getModel();
            if(cartTable.getRowCount() != 0)
            {
              for(int i=0;i<cartTable.getRowCount();i++)
              {
                 try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
                  Statement st=con.createStatement();
                  st.executeUpdate("update medicine set quantity = quantity - "+Integer.parseInt(m.getValueAt(i,4).toString())+" where uniqueId = "+Integer.parseInt(m.getValueAt(i,0).toString()));
                  con.close();
                 }
                 catch (Exception e){JOptionPane.showMessageDialog(null,e);}
              }
            }
            
       
        
        try{
        SimpleDateFormat mf=new SimpleDateFormat("yyyy-MM-dd ");
        String d=mf.format(new Date());
        
        //Calendar cal=Calendar.getInstance();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","abdo","abdo1234");
        PreparedStatement p =con.prepareStatement("insert into bill(id,date,totalpaid,generatedby) values (?,?,?,?)");
        p.setString(1,billId);
        p.setString(2,d);System.out.println(d);
        p.setInt(3,finalTotalPrice);
        p.setString(4, username);
        p.executeUpdate();
        con.close();
        }
        catch (Exception e){JOptionPane.showMessageDialog(null,e);}
         com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
         //SimpleDateFormat mf=new SimpleDateFormat("yyyy-mm-dd");
         // Calendar cal=Calendar.getInstance();
        try{
            PdfWriter.getInstance(doc,new FileOutputStream(pharmacyUtils.billPath+""+billId+".pdf"));
            doc.open();
            Paragraph pharmacyName=new Paragraph("                                                         Pharmacy Management System\n");
            doc.add(pharmacyName);
            Paragraph startLine=new Paragraph("***************************************************************************************************************");
            doc.add(startLine);
            Paragraph details=new Paragraph("\tBill ID: "+billId+"\nDate: "+new Date()+"\nToatl Price: "+finalTotalPrice);
            doc.add(details);
            doc.add(startLine);
            PdfPTable t=new PdfPTable(6);
            t.addCell("Medicine ID");
            t.addCell("Name");
            t.addCell("Company Name");
            t.addCell("Price Per Unit");
            t.addCell("Number of Units");
            t.addCell("Total Price");
            for(int i=0;i<cartTable.getRowCount();i++){
               String a= cartTable.getValueAt(i,0).toString();
               String b= cartTable.getValueAt(i,1).toString();
               String c= cartTable.getValueAt(i,2).toString();
               String d= cartTable.getValueAt(i,3).toString();
               String e= cartTable.getValueAt(i,4).toString();
               String f= cartTable.getValueAt(i,5).toString();
               t.addCell(a);
               t.addCell(b);
               t.addCell(c);
               t.addCell(d);
               t.addCell(e);
               t.addCell(f);
            }
            doc.add(t);
            doc.add(startLine);
            Paragraph thankm=new Paragraph("Thank You, Please Visit Again.");
            doc.add(thankm);
            op.open(String.valueOf(billId));
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        doc.close();
        setVisible(false);
        new sell_medicine(username).setVisible(true);
         }
        else {JOptionPane.showMessageDialog(null, "Please add some medicine to cart.");}
        
        // TODO add your handling code here:*/
    }//GEN-LAST:event_buyActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyMouseEntered
        // TODO add your handling code here:
                // TODO add your handling code here:
         // TODO add your handling code here:
         buy.setBackground(new Color(56,78,220));
        buy.setForeground(Color.WHITE);
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\generate bill & print.png");
    buy.setIcon(icon);
    }//GEN-LAST:event_buyMouseEntered

    private void buyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyMouseExited
        // TODO add your handling code here:
          buy.setBackground(Color.WHITE);
        buy.setForeground(new Color(56,78,220));
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\generate bill & print.png");
    buy.setIcon(icon);
    }//GEN-LAST:event_buyMouseExited

    private void cartButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseEntered
        // TODO add your handling code here:
          cartButton.setBackground(new Color(56,78,220));
        cartButton.setForeground(Color.WHITE);
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\add to cart.png");
    cartButton.setIcon(icon);
    }//GEN-LAST:event_cartButtonMouseEntered

    private void cartButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseExited
        // TODO add your handling code here:
            cartButton.setBackground(Color.WHITE);
        cartButton.setForeground(new Color(56,78,220));
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\add to cart.png");
    cartButton.setIcon(icon);
    }//GEN-LAST:event_cartButtonMouseExited

    private void bsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsearchMouseEntered
        // TODO add your handling code here:
         bsearch.setBackground(new Color(56,78,220));
       bsearch.setForeground(Color.WHITE);
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\search.png");
    bsearch.setIcon(icon);
    }//GEN-LAST:event_bsearchMouseEntered

    private void bsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsearchMouseExited
        // TODO add your handling code here:
         bsearch.setBackground(Color.WHITE);
        bsearch.setForeground(new Color(56,78,220));
    // Set icon for the button
    ImageIcon icon = new ImageIcon("src\\image2\\search.png");
    bsearch.setIcon(icon);
    }//GEN-LAST:event_bsearchMouseExited

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
            java.util.logging.Logger.getLogger(sell_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sell_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sell_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sell_medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sell_medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcart;
    private javax.swing.JButton bsearch;
    private javax.swing.JButton buy;
    private javax.swing.JButton cartButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lftp;
    private javax.swing.JTable medicineTable;
    private javax.swing.JTextField nou;
    private javax.swing.JTextField ppu;
    private javax.swing.JTextField tp;
    private javax.swing.JTextField txtcname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
