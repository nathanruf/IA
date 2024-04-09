/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author natha
 */
public class TelaFinal extends javax.swing.JFrame {

    /**
     * Creates new form TelaExecucao
     */
	
	Tabuleiro tab;
	
    public TelaFinal(Tabuleiro tab) {
    	this.tab = tab;
        initComponents();
        URL iconURL = getClass().getResource("/img/icone.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        prox1 = new javax.swing.JButton();
        prox2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dots");
        setMaximumSize(new java.awt.Dimension(478, 250));
        setMinimumSize(new java.awt.Dimension(478, 250));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(627, 465));

        prox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prox1.setText("Tela inicial");
        prox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prox1ActionPerformed(evt);
            }
        });

        prox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prox2.setText("Jogar novamente");
        prox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(prox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(prox2)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prox2)
                    .addComponent(prox1))
                .addGap(119, 119, 119))
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
    }// </editor-fold>                        

    private void prox1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        TelaInicial ti = new TelaInicial();
        ti.setVisible(true);
        
        tab.dispose();
        this.dispose();
    }                                     

    private void prox2ActionPerformed(java.awt.event.ActionEvent evt) {   
    	new Tabuleiro(tab.getIA()).setVisible(true);
        tab.dispose();
        this.dispose();
    }                                   

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton prox1;
    private javax.swing.JButton prox2;
    // End of variables declaration                   
}
