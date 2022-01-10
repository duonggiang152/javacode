/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.IOfile;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangPhanCong;
import model.LaiXe;
import model.Tuyen;

/**
 *
 * @author giang
 */
public class PhanCongView extends javax.swing.JPanel {

    /**
     * Creates new form PhanCongView
     */
    DefaultTableModel dtm = new DefaultTableModel();
    private List<BangPhanCong> m_bpcList = new ArrayList<>();
    private List<LaiXe> m_lxList = new ArrayList<>();
    private List<Tuyen> m_tlist = new ArrayList<>();
    private String LXFILE = "src/controller/LX.DAT";
    private String PhanCongFIle = "src/controller/PHANCONG.DAT";
    private String TuyenFile = "src/controller/TUYEN.DAT";
    public PhanCongView() {
        initComponents();
        dtm.setRowCount(0);
        String[] cols = {"ma lai xe", "ma Tuyen", "ten", "tuyen trong ngay"};
        dtm = new DefaultTableModel(cols,0);
        jTable1.setModel(dtm);
        m_bpcList = IOfile.doc(PhanCongFIle);
        m_lxList = IOfile.doc(LXFILE);
        m_tlist = IOfile.doc(TuyenFile);
        if(m_bpcList == null )  m_bpcList = new ArrayList<>();
        if(m_lxList == null) m_lxList = new ArrayList<>();
        if(m_tlist == null) m_tlist = new ArrayList<>();
        update();
    }
    private LaiXe getbyIDLaiXe(int ma){
        for(int i = 0; i < m_lxList.size(); i++) 
        {
            if(m_lxList.get(i).getMaLaiXe() == ma) return m_lxList.get(i);
        }
        return null;
    
    }
    private Tuyen getbyIDTuyen(int ma) {
        for(int i =0 ; i< m_tlist.size(); i++) {
            if(m_tlist.get(i).getMatuyen() == ma) return m_tlist.get(i);
        }
        return null;
    }
    private BangPhanCong getPhanCong(int maLX, int maTuyen) {
        for(int i = 0; i< m_bpcList.size(); i++) {
            if(m_bpcList.get(i).getMaLaixe() == maLX && m_bpcList.get(i).getMaTuyen() == maTuyen) return m_bpcList.get(i);
        }
        return null;
    }
    private void capnhat() {
        m_bpcList = IOfile.doc(PhanCongFIle);
        m_lxList = IOfile.doc(LXFILE);
        m_tlist = IOfile.doc(TuyenFile);
        if(m_bpcList == null )  m_bpcList = new ArrayList<>();
        if(m_lxList == null) m_lxList = new ArrayList<>();
        if(m_tlist == null) m_tlist = new ArrayList<>();
        update();
    }
    private void update(){
         
        jComboBox1.removeAllItems();
        for(int i = 0; i < m_lxList.size(); i++)  jComboBox1.addItem(String.valueOf(m_lxList.get(i).getMaLaiXe()));
        jComboBox2.removeAllItems();
        for(int i = 0; i < m_tlist.size(); i++) jComboBox2.addItem(String.valueOf(m_tlist.get(i).getMatuyen()));
        
        dtm.setRowCount(0);
        for(int i =0 ; i< m_bpcList.size(); i++){
            int malx = m_bpcList.get(i).getMaLaixe();
            int tuyen = m_bpcList.get(i).getMaTuyen();
            String ten = getbyIDLaiXe(malx).getHoten();
            dtm.addRow(new Object[] {malx, tuyen, ten , tuyenTrongNgay(malx)});
        }
    }
    private void sapxepbyten() {
        m_bpcList.sort(new Comparator<BangPhanCong>(){
            @Override
            public int compare(BangPhanCong o1, BangPhanCong o2) {
                String lx1 = getbyIDLaiXe(o1.getMaLaixe()).getHoten();
                String lx2 = getbyIDLaiXe(o2.getMaLaixe()).getHoten();
                return lx1.compareTo(lx2);
            }
        
        });
        update();
    }
     private void sapxepbysoluong() {
        m_bpcList.sort(new Comparator<BangPhanCong>(){
            @Override
            public int compare(BangPhanCong o1, BangPhanCong o2) {
               
                return tuyenTrongNgay(o1.getMaLaixe()) - tuyenTrongNgay(o2.getMaLaixe());
            }
        
        });
        update();
    }
    private int tuyenTrongNgay(int ma) {
        int count = 0;
        for(int i = 0; i < m_bpcList.size(); i++) if(m_bpcList.get(i).getMaLaixe() == ma) count++; 
        return count;
    }
    private void luu() {
        IOfile.viet(PhanCongFIle, m_bpcList);
    }
    private void them() {
        try{
            int malx = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int maTuyen = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            if(getPhanCong(malx, maTuyen) != null) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            System.out.println(malx);
            BangPhanCong bpc = new BangPhanCong(malx, maTuyen);
            m_bpcList.add(bpc);
            update();
        } catch(HeadlessException  exception) {
               JOptionPane.showMessageDialog(this, "loi");
        } catch(NumberFormatException exception){
               JOptionPane.showMessageDialog(this, "loi");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("lai xe");

        jLabel2.setText("tuyen");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("luu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("them");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("capnhat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("xapsep");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ssten");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 139, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton4)
                        .addGap(65, 65, 65)
                        .addComponent(jButton5)
                        .addContainerGap(85, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addGap(76, 76, 76)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        capnhat();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        sapxepbyten();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sapxepbysoluong();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
