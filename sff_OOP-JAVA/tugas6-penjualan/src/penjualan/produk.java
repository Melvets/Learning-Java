package penjualan;

import java.sql.*; //membaca sql guna membaca koneksi antar basis data
import javax.swing.JOptionPane; //membaca komponen JOptionPane
import javax.swing.table.DefaultTableModel; //membaca table
import java.util.Scanner; // membaca suatu inputan
import java.awt.*; //membaca gui

public class produk extends javax.swing.JFrame {

    //mendeklarasikan table dan recorset
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    
    public produk() {
        initComponents();
        tampilanTengah ( );
        tampilData( );
        SetEditOff();
        //menghidupkan semua komponen guna memfungsikan button update
        seteditOn();
        //mematikan JTextKodeProduk agar tidak bisa diedit karena bersifat unik
        JTextKodeProduk.setEnabled(false); 
        //memanggil tblKeForm dan menampilkan data table ke textfield
        tblKeForm();

    }
    
    //method baru tampilTengah
    void tampilanTengah(){
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
           frameSize.height=screenSize.height;
           }
           if(frameSize.width > screenSize.width){
              frameSize.width=screenSize.width;
              }
           this.setLocation((screenSize.width - frameSize.width) / 2,
           (screenSize.height = screenSize.height) / 20);
    }
    
    //fungsi untuk menampilkan data produk ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Kode Barang", "Nama Barang", "Satuan", "Harga", "Stok", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
             
            RsProduk=stt.executeQuery("SELECT * from produk ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("KodeProduk"),
                    RsProduk.getString("NamaProduk"),
                    RsProduk.getString("Satuan"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Stok"),
                    RsProduk.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    // disable button guna mengutamakan fungsi utama AddNew (hanya button AddNew yang bisa diklik)
        JButtonSave.setEnabled(false);
        JButtonUpdate.setEnabled(false);
        JButtonDelete.setEnabled(false);
        JButtonCancel.setEnabled(false);
    }
    
    //guna mematikan semua komponen 
    private void SetEditOff(){
        JTextKodeProduk.setEnabled(false);
        JTextNama.setEnabled(false);
        JComboBoxSatuan.setEnabled(false);
        JTextHarga.setEnabled(false);
        JTextStok.setEnabled(false);
   }
    
    //guna menghidupkan kembali semua komponen agar bisa digunakan
    private void seteditOn(){
        JTextKodeProduk.setEnabled(true);
        JTextNama.setEnabled(true);
        JComboBoxSatuan.setEnabled(true);
        JTextHarga.setEnabled(true);
        JTextStok.setEnabled(true);
   }
 
    //membersihkan form
    private void BersihData(){ 
        JTextKodeProduk.setText("");
        JTextNama.setText("");
        JComboBoxSatuan.setSelectedIndex(0);
        JTextHarga.setText(""); 
        JTextStok.setText("");
        JTextKodeProduk.requestFocus(); //memfokuskan kursor ke kode produk
    }
    
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String KodeProduk=JTextKodeProduk.getText();
                String NamaProduk=JTextNama.getText();
                String Satuan=JComboBoxSatuan.getSelectedItem().toString();
                String Harga=JTextHarga.getText();
                String Stok=JTextStok.getText();

                java.util.Date tanggal = new java.util.Date();
                java.text.SimpleDateFormat TanggalFormat= new 
        java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String CreateDate=TanggalFormat.format(tanggal);

                if (KodeProduk.isEmpty() ) {
                    JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
                    JTextKodeProduk.requestFocus();
                }else if (NamaProduk.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
                    JTextNama.requestFocus();
                }else if (Satuan.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Satuan produk tidak boleh kosong");
                    JComboBoxSatuan.requestFocus();
                }else if (Harga.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
                    JTextHarga.requestFocus();
                }else if (Stok.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
                    JTextStok.requestFocus();
                }
                else if (!(new Scanner(Harga).hasNextInt())) {
                    JOptionPane.showMessageDialog(null,"Harga produk harus angka");
                    JTextHarga.requestFocus();
                }else if (!(new Scanner(Stok).hasNextInt())) {
                    JOptionPane.showMessageDialog(null,"Stok produk harus angka");
                    JTextStok.requestFocus();
                }else{
                    try{
                        Connection conn=(Connection)koneksi.koneksiDB();
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("insert into produk(KodeProduk,NamaProduk,Satuan,Harga,Stok,CreateDate)"+

        "VALUES('"+KodeProduk+"','"+NamaProduk+"','"+Satuan+"','"+Harga+"','"+Stok+"','"+CreateDate+"')");
                        BersihData(); 
                        tampilData();
                        SetEditOff();
                        JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
                    } catch(SQLException e){
                        JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
    }
    
    //menampilkan data ke form saat data pada tabel di klik 
    void tblKeForm(){
        JTextKodeProduk.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),0)+"");
        JTextNama.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),1)+"");
        JComboBoxSatuan.setSelectedItem(tabModel.getValueAt(TabelProduk.getSelectedRow(),2)+"");
        JTextHarga.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),3)+"");
        JTextStok.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),4)+"");
        
    //mematikan tombol save, menghidupkan button update, delete dan cancel (guna meminimalis tidak save data kembar)
        JButtonUpdate.setEnabled(true);
        JButtonDelete.setEnabled(true);
        JButtonCancel.setEnabled(true);
        JButtonSave.setEnabled(false);
    }


 
    
    




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLabelDataProduk = new javax.swing.JLabel();
        JLabelKodeProduk = new javax.swing.JLabel();
        JLabelNama = new javax.swing.JLabel();
        JLabelSatuan = new javax.swing.JLabel();
        JLabelHarga = new javax.swing.JLabel();
        JLabelStok = new javax.swing.JLabel();
        JTextKodeProduk = new javax.swing.JTextField();
        JTextNama = new javax.swing.JTextField();
        JTextHarga = new javax.swing.JTextField();
        JTextStok = new javax.swing.JTextField();
        JComboBoxSatuan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        JButtonAdd = new javax.swing.JButton();
        JButtonSave = new javax.swing.JButton();
        JButtonUpdate = new javax.swing.JButton();
        JButtonDelete = new javax.swing.JButton();
        JButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabelDataProduk.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        JLabelDataProduk.setText("DATA PRODUK");

        JLabelKodeProduk.setText("Kode Produk");

        JLabelNama.setText("Nama");

        JLabelSatuan.setText("Satuan");

        JLabelHarga.setText("Harga");

        JLabelStok.setText("Stok");

        JTextKodeProduk.setText("jTextField1");

        JTextNama.setText("jTextField1");

        JTextHarga.setText("jTextField2");

        JTextStok.setText("jTextField3");

        JComboBoxSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JComboBoxSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxSatuanActionPerformed(evt);
            }
        });

        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        JButtonAdd.setText("AddNew");
        JButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAddActionPerformed(evt);
            }
        });

        JButtonSave.setText("Save");
        JButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSaveActionPerformed(evt);
            }
        });

        JButtonUpdate.setText("Update");
        JButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonUpdateActionPerformed(evt);
            }
        });

        JButtonDelete.setText("Delete");
        JButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonDeleteActionPerformed(evt);
            }
        });

        JButtonCancel.setText("Cancel");
        JButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JLabelDataProduk)
                        .addGap(178, 178, 178))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLabelKodeProduk)
                            .addComponent(JLabelNama)
                            .addComponent(JLabelSatuan)
                            .addComponent(JLabelHarga)
                            .addComponent(JLabelStok))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextHarga)
                                    .addComponent(JComboBoxSatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JTextNama)
                                    .addComponent(JTextStok, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTextKodeProduk))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelDataProduk)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLabelKodeProduk)
                            .addComponent(JTextKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelNama)
                            .addComponent(JTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelSatuan)
                            .addComponent(JComboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelHarga)
                            .addComponent(JTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelStok)
                            .addComponent(JTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonSave)
                    .addComponent(JButtonDelete)
                    .addComponent(JButtonCancel)
                    .addComponent(JButtonUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JComboBoxSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxSatuanActionPerformed

    private void JButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSaveActionPerformed
        //menghidupkan save karena akan melakukan input data baru dan mengfungsikan button save sehingga sementara mematikan update dan delete
            JButtonSave.setEnabled(true);
            JButtonUpdate.setEnabled(false);
            JButtonDelete.setEnabled(false);
        //setelah fungsi simpan berfungsi maka menghidupkan kembali semua komponen agar bisa digunakan kembali       
            seteditOn();

    }//GEN-LAST:event_JButtonSaveActionPerformed

    private void JButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAddActionPerformed
        //menghidupkan Button Save
        JButtonSave.setEnabled(true);
        //mematikan/nonaktifkan Button Update dan Delete
        JButtonUpdate.setEnabled(false);
        JButtonDelete.setEnabled(false);
        //menyalakan semua tools dalam gui
        seteditOn();
    }//GEN-LAST:event_JButtonAddActionPerformed

    private void TabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProdukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelProdukMouseClicked

    private void JButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUpdateActionPerformed
        String KodeProduk=JTextKodeProduk.getText();
        String NamaProduk=JTextNama.getText();
        String Satuan=JComboBoxSatuan.getSelectedItem().toString();
        String Harga=JTextHarga.getText();
        String Stok=JTextStok.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            JTextKodeProduk.requestFocus();
        }else if (NamaProduk.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama produk tidak boleh kosong");
            JTextNama.requestFocus();
        }else if (Satuan.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Satuan produk tidak boleh kosong");
            JComboBoxSatuan.requestFocus();
        }else if (Harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga produk tidak boleh kosong");
            JTextHarga.requestFocus();
        }else if (Stok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Stok produk tidak boleh kosong");
            JTextStok.requestFocus();
        }
        else if (!(new Scanner(Harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga produk harus angka");
            JTextHarga.requestFocus();
        }else if (!(new Scanner(Stok).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Stok produk harus angka");
            JTextStok.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE produk SET NamaProduk='"+NamaProduk+"', Satuan='"+Satuan+"',Harga='"+Harga+"',"+"Stok='"+Stok+"' WHERE KodeProduk='"+KodeProduk+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_JButtonUpdateActionPerformed

    private void JButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonDeleteActionPerformed
        String KodeProduk=JTextKodeProduk.getText();

        if (KodeProduk.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong"); 
            JTextKodeProduk.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?", "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM produk WHERE KodeProduk='"+KodeProduk+"'");
            BersihData();
            tampilData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_JButtonDeleteActionPerformed

    private void JButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCancelActionPerformed
        BersihData();
        JButtonSave.setEnabled(false);
        JButtonUpdate.setEnabled(false);
        JButtonDelete.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_JButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonAdd;
    private javax.swing.JButton JButtonCancel;
    private javax.swing.JButton JButtonDelete;
    private javax.swing.JButton JButtonSave;
    private javax.swing.JButton JButtonUpdate;
    private javax.swing.JComboBox<String> JComboBoxSatuan;
    private javax.swing.JLabel JLabelDataProduk;
    private javax.swing.JLabel JLabelHarga;
    private javax.swing.JLabel JLabelKodeProduk;
    private javax.swing.JLabel JLabelNama;
    private javax.swing.JLabel JLabelSatuan;
    private javax.swing.JLabel JLabelStok;
    private javax.swing.JTextField JTextHarga;
    private javax.swing.JTextField JTextKodeProduk;
    private javax.swing.JTextField JTextNama;
    private javax.swing.JTextField JTextStok;
    private javax.swing.JTable TabelProduk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
