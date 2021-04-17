package com.testAutomation.helpers;

import java.io.*;
import java.util.Properties;

public class CommonHelpers {

    Properties prop = new Properties();

    /**
     * This method is used to set Properties for a given file
     * @param propertiesFilename
     * @return
     */
    public Properties getFileProperties(String propertiesFilename){
        InputStream input = null;
        try{
            input=new FileInputStream(propertiesFilename);
            prop.load(input);
        }catch (IOException ioe){
            System.out.println("IO Exception : " + ioe.getMessage());
            ioe.getStackTrace();
        }finally {
            if(input != null){
                try{
                    input.close();
                }catch (IOException ioe){
                    System.out.println("IO Exception : " + ioe.getMessage());
                    ioe.getStackTrace();
                }
            }
        }
        return prop;
    }
}
