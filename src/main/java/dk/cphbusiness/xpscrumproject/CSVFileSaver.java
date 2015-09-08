/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Muggi
 */
public class CSVFileSaver implements CSVFileSaverInterface {

    JFileChooser chooser;
    final private String subjectSeperator = "$";
    final private String listSeperator = "£";
    final private String detailsSeperator = "%";

    public CSVFileSaver() {
        chooser = new JFileChooser();
    }

    @Override
    public boolean saveFile(boolean manualSave, List<Subject> unaPool, List<Subject> poolA, List<Subject> poolB) {
        StringBuilder strb = new StringBuilder();

        String unaPoolStr = "";
        String poolAStr = "";
        String poolBStr = "";
        for (Subject s : unaPool) {
            strb.append(s.getTitle());
            strb.append(detailsSeperator);
            strb.append(s.getTeacher());
            strb.append(detailsSeperator);
            strb.append(s.getDescription());
            strb.append(subjectSeperator);
        }
        strb.append(listSeperator);

        for (Subject s : poolA) {
            strb.append(s.getTitle());
            strb.append(detailsSeperator);
            strb.append(s.getTeacher());
            strb.append(detailsSeperator);
            strb.append(s.getDescription());
            strb.append(subjectSeperator);
        }
        strb.append(listSeperator);
        for (Subject s : poolB) {
            strb.append(s.getTitle());
            strb.append(detailsSeperator);
            strb.append(s.getTeacher());
            strb.append(detailsSeperator);
            strb.append(s.getDescription());
            strb.append(subjectSeperator);
        }
        String result = strb.toString();
        System.out.println(result);

        boolean success = false;
        String filetype = ".csv";
        if (manualSave) {

            JFileChooser openFile = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    ".csv", "csv");
            openFile.setFileFilter(filter);
            int returnVal = openFile.showSaveDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = openFile.getSelectedFile();

                if (file.getName().substring(file.getName().length() - 3).equals("csv")) {
                    filetype = "";
                }
                try {

                    PrintWriter out = new PrintWriter(file.getPath() + filetype);
                    out.println(result);
                    success = true;
                    out.close();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CSVFileSaver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            try {

                    PrintWriter out = new PrintWriter("pools.csv");
                    out.println(result);
                    success = true;
                    out.close();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CSVFileSaver.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        

        return success;
    }

}
