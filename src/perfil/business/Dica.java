/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfil.business;

import java.util.Objects;

/**
 *
 * @author alexqno
 */
public class Dica {
    
    private String dica;

    public Dica(String dica) {
        this.dica = dica;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.dica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dica other = (Dica) obj;
        if (!Objects.equals(this.dica, other.dica)) {
            return false;
        }
        return true;
    }
    
}
