
package Clases;

import javax.swing.JCheckBox;

public class AsientoCheckBox extends JCheckBox{
    private Asiento asiento;

    public AsientoCheckBox(Asiento asiento) {
        this.asiento = asiento;
        setText(String.valueOf(asiento.getNumero()));
    }

    public Asiento getAsiento() {
        return asiento;
    }
}
