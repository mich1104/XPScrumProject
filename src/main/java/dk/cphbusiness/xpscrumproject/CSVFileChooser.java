
package dk.cphbusiness.xpscrumproject;

import java.io.File;
import java.io.FileNotFoundException;
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

    public static ArrayList<Student> run(String fileName) throws IOException {
        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                ".csv", "csv");
        openFile.setFileFilter(filter);
        int returnVal = 0;
        if (fileName == null) {
            returnVal = openFile.showOpenDialog(null);
        }else if(fileName.equalsIgnoreCase("testReturnValNotZero23QsdF")){
            returnVal = JFileChooser.CANCEL_OPTION;
        }
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file;
            if (fileName != null) {
                file = new File(System.getProperty("user.dir") + System.getProperty("path.seperator") + fileName);
            } else {
                file = openFile.getSelectedFile();
            }
            if(!file.exists()){throw new FileNotFoundException("File not found");}
            //I know a string split might have been more straight forward, but for some reason i could not manage to split the string from file.getName()
            String filetype = file.getName().substring(file.getName().length() - 3);
            if (filetype.equals("csv")) {
                System.out.println("csv file opened and sendt to file reader");
                return reader.loadStudents(file.getPath());
            } else {
                System.out.println("Wrong filetype. Only csv are accepted. Aborting opening file.");
                throw new IOException("Wrong filetype. Only csv are accepted");
            }
        } else {
            System.out.println("No file selected");
            throw new IOException("No file selected");
        }
    }
}
