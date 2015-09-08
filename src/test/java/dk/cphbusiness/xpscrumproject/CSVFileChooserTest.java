/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Muggi
 */
public class CSVFileChooserTest {

    private CSVReader reader;

    public CSVFileChooserTest() {
    }

    @Before
    public void setUp() {
        reader = new CSVReader();
    }

    @Test
    public void testLoadExistingFile() throws IOException {
        
        String fileName = "testFileChooser.csv";
        String path = System.getProperty("user.dir") + System.getProperty("path.seperator") + fileName;
        createTestFile(path);
        ArrayList<StudentInterface> list = CSVFileChooser.run(fileName);
        assertThat(list.size(), is(2));
    }
    
    @Test(expected = IOException.class)
    public void testNonExistingFile()throws Exception{
        String path = "This path does not exist";
        CSVFileChooser.run(path);
    }
    
    @Test(expected = IOException.class)
    public void testWrongFileType() throws Exception{
        String fileName = "testFileChooser.txt";
        String path = System.getProperty("user.dir") + System.getProperty("path.seperator") + fileName;
        createTestFile(path);
        CSVFileChooser.run(fileName);
    }
    
    @Test(expected = IOException.class)
    public void testUserCancelOption() throws Exception{
        String fileName = "testReturnValNotZero23QsdF";
        CSVFileChooser.run(fileName);
    }

    public void createTestFile(String path) throws IOException{
        String toFile = "name, prio1, prio1.1, prio2, prio2.1;name2, prio1, prio1.1, prio2, prio2.1";
        PrintWriter pw = new PrintWriter(path);
        pw.print(toFile);
        pw.flush();
        pw.close();
    }
//    @Test
//    public void FileChooserInvalid() throws IOException {
//        ArrayList<StudentInterface> array = CSVFileChooser.run();
//        assertTrue(array == null);
//    }
//
//    @Test
//    public void FileChooserCancel() throws IOException {
//        ArrayList<StudentInterface> array = CSVFileChooser.run();
//        assertTrue(array == null);
//    }

}
