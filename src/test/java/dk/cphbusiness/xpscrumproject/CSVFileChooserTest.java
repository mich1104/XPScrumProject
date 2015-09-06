/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
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
    public void testFileChooserTxt() throws IOException {
        ArrayList<StudentInterface> array = CSVFileChooser.run();
        assertTrue(array.get(0).getName().equals("Kurt Mikkelsen"));
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
