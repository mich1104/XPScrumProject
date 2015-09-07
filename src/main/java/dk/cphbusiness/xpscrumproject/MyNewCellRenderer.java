/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Dennis
 */
public class MyNewCellRenderer extends DefaultTableCellRenderer {
     
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        if (table.getValueAt(row, 5).equals("0.0") || table.getValueAt(row, 5).equals("2.0")|| table.getValueAt(row, 5).equals("0.2")) {
            setText(value.toString());
            setBackground(Color.RED);
        }else if(table.getValueAt(row, 5).equals("1.0") || table.getValueAt(row, 5).equals("2.2") || table.getValueAt(row, 5).equals("0.1")){
            System.out.println(value);
            setText(value.toString());
            setBackground(Color.YELLOW);
        }else{
            setText(value.toString());
            setBackground(Color.green);
        }
 
        return this;
    }
}

