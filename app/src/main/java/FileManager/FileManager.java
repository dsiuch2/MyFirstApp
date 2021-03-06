/**
 * Author: Donald Siuchninski
 * Date: October 2014
 * Description: Module for basic file operations.
 */

package FileManager;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private String absolutePath;

    /**
     * Constructor
     */
    public FileManager (){
        absolutePath = null;
    }

    /**
     * Constructor
     * @param absolutePath Absolute path of the file to open
     */
    public FileManager (String absolutePath){
        this.absolutePath = absolutePath;
    }

    /**
     * Get the absolute path to the internal storage folder for the given app
     * @param context Which application
     * @return Absolute path to the internal storage.
     */
    public static String getFileSaveLocation(Context context){
        return context.getFilesDir().getAbsolutePath();
    }

    /**
     * Creates file if file doesn't already exist.
     * Appends the given string to the file.
     * @param stringToWrite The string to write
     */
    public boolean appendToFile(String stringToWrite){
        if (absolutePath == null || stringToWrite == null)
            return false;

        try {
            File file = new File(absolutePath);
            // True indicates appending
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Creates file if file doesn't already exist.
     * Writes the given string to the file. Will overwrite the file if
     * the file already exists.
     * @param stringToWrite The string to write
     */
    public boolean writeToFile(String stringToWrite){
        if (absolutePath == null || stringToWrite == null)
            return false;

        try {
            File file = new File(absolutePath);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stringToWrite);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}