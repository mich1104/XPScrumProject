/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Muggi
 */
public class CSVFileChooser {

    private static CSVReader reader = new CSVReader();

    public static ArrayList<Student> run() throws IOException {
        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".csv", "csv");
        openFile.setFileFilter(filter);
        int returnVal = openFile.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = openFile.getSelectedFile();  
            //I know a string split might have been more straight forward, but for some reason i could not manage to split the string from file.getName()
            String filetype = file.getName().substring(file.getName().length()-3);
            if (filetype.equals("csv")) {
                System.out.println("csv file opened and sendt to file reader");
                return reader.loadStudents(file.getPath());
            } else {
                System.out.println("Wrong filetype. Only csv are accepted. Aborting opening file.");
                return null;
            }
        } else {
            System.out.println("No file opened");
            return null;
        }
    }
}
