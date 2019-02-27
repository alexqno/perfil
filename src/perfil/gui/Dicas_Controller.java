/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfil.gui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import perfil.business.Dica;

/**
 *
 * @author alexqno
 */
public class Dicas_Controller {
    private Dicas_Form tela;
    private Set<JButton> showedButtons;

    public Set<JButton> getShowedButtons() {
        return showedButtons;
    }

    public Dicas_Controller(Dicas_Form tela) {
        this.showedButtons = new HashSet<>();
        this.tela = tela;
    }

    public void carregarDicas(List<Dica> perfis) {
        int idx = 1;
        for (Dica dica : perfis) {
            JButton btn = new JButton();
            btn.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
            btn.setText("Dica " + idx++);
            btn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tela.controller.exibirDica(dica, (JButton)evt.getSource());
                }
            });
            tela.jPanel1.add(btn);
        }
    }

    private void exibirDica(Dica dica, JButton btn) {
        ShowDica_Form showDica = new ShowDica_Form(tela, dica.getDica(), true);
        showDica.setVisible(true);
        
        while (showDica.isVisible()) {}
        
        showedButtons.add(btn);
        btn.setEnabled(false);
    }
}
