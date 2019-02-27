/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfil.gui;

import java.util.List;
import javax.swing.JButton;
import perfil.business.Perfil;

/**
 *
 * @author alexqno
 */
public class Perfis_Controller {
    private Perfis_Form tela;

    public Perfis_Controller(Perfis_Form tela) {
        this.tela = tela;
    }

    public void carregarPerfis(List<Perfil> perfis) {
        int idx = 1;
        for (Perfil perfil : perfis) {
            JButton btn = new JButton();
            btn.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
            btn.setText("Perfil " + idx++);
            btn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tela.controller.abrirTelaDoPerfil(perfil, (JButton)evt.getSource());
                }
            });
            tela.jPanel1.add(btn);
        }
    }

    private void abrirTelaDoPerfil(Perfil perfil, JButton btn) {
        Dicas_Form telaDicas = new Dicas_Form(tela, true);
        telaDicas.controller.carregarDicas(perfil.getDicas());
        telaDicas.setVisible(true);
        
        while(telaDicas.isVisible()){}
        
        btn.setText("<html><center>" + perfil.getNome() + "<br/>" + (perfil.getDicas().size() - telaDicas.controller.getShowedButtons().size()) + "</center></html>");
        btn.setEnabled(false);
    }
    
    
}
