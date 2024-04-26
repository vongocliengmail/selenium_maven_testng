package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class PropertyFile   {
    private static Properties environmentProps;

    public static String getProp(String key) {
        if ((key == null) || key.isEmpty()) {
            return "";
        } else {
            return environmentProps.getProperty(key);
        }
    }

    public static void loadRunConfigProps(String envProfilePath) {
        environmentProps = new Properties();
        try {
            InputStream inputStream = new FileInputStream(envProfilePath);
            environmentProps.load(inputStream);
        } catch (IOException e) {
            out.println("Exception stack trace:" + e);
        }
    }

    public static void loadPropertiesFile(String propertyFile) {
         Properties prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream(propertyFile);
            prop.load(input);

            for (String key : prop.stringPropertyNames()) {
                String val = prop.getProperty(key);

                if (val == null)
                    val = "";
                else
                    val = val.trim();
                System.setProperty(key, val);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
