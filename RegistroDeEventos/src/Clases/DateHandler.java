
package Clases;

import javax.swing.JComboBox;
import java.awt.event.*;

public class DateHandler {
    private JComboBox<String> yearCombo;
    private JComboBox<String> monthCombo;
    private JComboBox<String> dayCombo;
    
    public DateHandler(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day) {
        this.yearCombo = year;
        this.monthCombo = month;
        this.dayCombo = day;
        
        // Añadir listeners para actualizar los días cuando cambie el año o mes
        yearCombo.addActionListener(e -> updateDays());
        monthCombo.addActionListener(e -> updateDays());
        
        // Inicializar los días
        updateDays();
    }
    
    private void updateDays() {
        dayCombo.removeAllItems();
        int year = Integer.parseInt(yearCombo.getSelectedItem().toString());
        int month = monthCombo.getSelectedIndex() + 1; // +1 porque los índices empiezan en 0
        int days = getDaysInMonth(year, month);
        
        for (int i = 1; i <= days; i++) {
            dayCombo.addItem(String.valueOf(i));
        }
    }
    
    private int getDaysInMonth(int year, int month) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
