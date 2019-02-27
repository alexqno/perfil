/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import perfil.business.Dica;
import perfil.business.Perfil;
import perfil.gui.Perfis_Form;

/**
 *
 * @author alexqno
 */
public class PerfilMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Selecione um arquivo de perfis");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .txt", "txt");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        File perfilFile = null;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            perfilFile = new File(jfc.getSelectedFile().getPath());
        }

        List<Perfil> perfis = new ArrayList<>();
        if (perfilFile != null) {
            try {
                FileReader arq = new FileReader(perfilFile);
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine();
                while (linha != null) {
                    Perfil perfil = new Perfil(null);
                    if (linha.startsWith("***")) {
                        perfil.setNome(linha.substring(3));
                    }

                    LinkedList<Dica> dicas = new LinkedList<>();
                    linha = lerArq.readLine();
                    while (linha != null && linha.startsWith("---")) {
                        dicas.add(new Dica(linha.substring(3)));
                        linha = lerArq.readLine();
                    }

                    if (perfil.getNome() != null) {
                        perfil.setDicas(dicas);
                        perfis.add(perfil);
                    }
                }

                arq.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (perfis.size() > 0) {
            Perfis_Form perfisTela = new Perfis_Form();
            perfisTela.controller.carregarPerfis(perfis);

            perfisTela.setVisible(true);
        }

    }

}
