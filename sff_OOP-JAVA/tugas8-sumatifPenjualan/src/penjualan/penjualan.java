package penjualan;

import java.text.NumberFormat;
import java.util.StringTokenizer;
import java.util.Locale;
import javax.swing.JOptionPane;

public class penjualan extends javax.swing.JFrame {

    String nama_makanan = "";
    int harga_makanan;
    int jumlah_beli;
    int jumlah_harga;
    int kembalian;
    int jumlah_bayar;
    int bayar, beli, harga, bungkus;
    
    public penjualan() {
        initComponents();
        setText();
    }

    public void setText(){
        textHarga.setText("");
        textJumlahBeli.setText("");
        textJumlahHarga.setText("");
        textJumlahBayar.setText("");
        textKembalian.setText("");
    }
    
    public void radio(){
        if(radioBungkus.isSelected()){
            bungkus = bayar + 2000;
            textHarga.setText("" + bungkus);
        } else {
            textHarga.setText("" + bayar);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pilihNamaMakanan = new javax.swing.JComboBox<>();
        textHarga = new javax.swing.JTextField();
        textJumlahBeli = new javax.swing.JTextField();
        buttonJumlahHarga = new javax.swing.JButton();
        textJumlahHarga = new javax.swing.JTextField();
        radioBungkus = new javax.swing.JRadioButton();
        radioMakanDitempat = new javax.swing.JRadioButton();
        textJumlahBayar = new javax.swing.JTextField();
        buttonBayar = new javax.swing.JButton();
        textKembalian = new javax.swing.JTextField();
        pph = new javax.swing.JCheckBox();
        buttonBatal = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA MAKANAN");

        jLabel2.setText("HARGA MAKANAN");

        jLabel3.setText("JUMLAH BELI");

        jLabel4.setText("JUMLAH HARGA");

        jLabel5.setText("JUMLAH BAYAR");

        jLabel6.setText("JUMLAH KEMBALIAN");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel7.setText("PENJUALAN");

        pilihNamaMakanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih makanan", "Ayam Goreng", "Ayam Bakar", "Bebek Bakar", "Bebek Goreng" }));
        pilihNamaMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihNamaMakananActionPerformed(evt);
            }
        });

        textHarga.setText("jTextField1");

        textJumlahBeli.setText("jTextField2");

        buttonJumlahHarga.setText("HITUNG JUMLAH HARGA");
        buttonJumlahHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJumlahHargaActionPerformed(evt);
            }
        });

        textJumlahHarga.setText("jTextField3");

        radioBungkus.setText("Bungkus");
        radioBungkus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBungkusActionPerformed(evt);
            }
        });

        radioMakanDitempat.setText("Makan Ditempat");
        radioMakanDitempat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMakanDitempatActionPerformed(evt);
            }
        });

        textJumlahBayar.setText("jTextField4");
        textJumlahBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textJumlahBayarActionPerformed(evt);
            }
        });

        buttonBayar.setText("BAYAR");
        buttonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBayarActionPerformed(evt);
            }
        });

        textKembalian.setText("jTextField5");

        pph.setText("pph 10%");
        pph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pphActionPerformed(evt);
            }
        });

        buttonBatal.setText("BATAL");
        buttonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBatalActionPerformed(evt);
            }
        });

        buttonKeluar.setText("KELUAR");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pilihNamaMakanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textHarga)
                                    .addComponent(textJumlahBeli)
                                    .addComponent(buttonJumlahHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textJumlahHarga)
                                    .addComponent(textJumlahBayar)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radioBungkus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioMakanDitempat)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(buttonBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textKembalian)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(pph)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 207, Short.MAX_VALUE)
                                        .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(252, 252, 252))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pilihNamaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonJumlahHarga)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textJumlahHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBungkus)
                    .addComponent(radioMakanDitempat))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihNamaMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihNamaMakananActionPerformed
        nama_makanan = (String) pilihNamaMakanan.getSelectedItem();
        
        if(nama_makanan == "Ayam Goreng"){
            harga_makanan = 25000;
        } else if (nama_makanan == "Ayam Bakar") {
            harga_makanan = 27000;
        } else if (nama_makanan == "Bebek Goreng") {
            harga_makanan = 30000;
        } else if (nama_makanan == "Bebek Bakar") {
            harga_makanan = 35000;
        } else {
            harga_makanan = 0;
        }
        
        textHarga.setText("" + harga_makanan);
    }//GEN-LAST:event_pilihNamaMakananActionPerformed

    private void textJumlahBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textJumlahBayarActionPerformed
       harga = Integer.parseInt(textHarga.getText());
       beli = Integer.parseInt(textJumlahBeli.getText());
       
       bayar = harga * beli;
       textHarga.setText("" + bayar);
    }//GEN-LAST:event_textJumlahBayarActionPerformed

    private void buttonJumlahHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJumlahHargaActionPerformed
       harga = Integer.parseInt(textHarga.getText());
       beli = Integer.parseInt(textJumlahBeli.getText());
       
       bayar = harga * beli;
       textJumlahHarga.setText("" + bayar);
    }//GEN-LAST:event_buttonJumlahHargaActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void buttonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBatalActionPerformed
        pilihNamaMakanan.setSelectedIndex(0);
        textHarga.setText("");
        textJumlahBeli.setText("");
        textJumlahBayar.setText("");
        textKembalian.setText("");
        textJumlahHarga.setText("");
        radioBungkus.setSelected(false);
        radioMakanDitempat.setSelected(false);
        pph.setSelected(false);
    }//GEN-LAST:event_buttonBatalActionPerformed

    private void buttonBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBayarActionPerformed
        int duit = Integer.parseInt(textJumlahBayar.getText());
        int kembali = duit - bayar;
        if(radioBungkus.isSelected()){
            kembali = kembali - 2000;
        }
        
        textKembalian.setText("" + kembali);
    }//GEN-LAST:event_buttonBayarActionPerformed

    private void radioBungkusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBungkusActionPerformed
        radio();
    }//GEN-LAST:event_radioBungkusActionPerformed

    private void radioMakanDitempatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMakanDitempatActionPerformed
        radio();
    }//GEN-LAST:event_radioMakanDitempatActionPerformed

    private void pphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pphActionPerformed
        if(pph.isSelected()){
            bayar = bayar / 10;
        }
        
        textKembalian.setText("" + bayar);
    }//GEN-LAST:event_pphActionPerformed

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
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBatal;
    private javax.swing.JButton buttonBayar;
    private javax.swing.JButton buttonJumlahHarga;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> pilihNamaMakanan;
    private javax.swing.JCheckBox pph;
    private javax.swing.JRadioButton radioBungkus;
    private javax.swing.JRadioButton radioMakanDitempat;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textJumlahBayar;
    private javax.swing.JTextField textJumlahBeli;
    private javax.swing.JTextField textJumlahHarga;
    private javax.swing.JTextField textKembalian;
    // End of variables declaration//GEN-END:variables
}
