import java.io.*;
import java.util.Properties;

/**
 * Class which is used for reading properties file
 */
public class FileUtils {
    public String path;
    public Properties props;
    private File file;

    FileUtils(String path) {
        this.path = path;
        props = new Properties();
        file = new File(path);
    }

    public void read() {
        try {
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                props.load(inputStream);
                inputStream.close();
            }
            else
                throw new FileNotFoundException(path + " not found in classpath");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void write(String key, String value) {
        FileOutputStream fileOut = null;
        FileInputStream fileIn;
        try {
            Properties configProperty = new Properties();

            File file = new File(path);
            fileIn = new FileInputStream(file);
            configProperty.load(fileIn);
            configProperty.setProperty(key, value);
            fileOut = new FileOutputStream(file);
            configProperty.store(fileOut, null);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {

            try {
                fileOut.close();
            } catch (IOException ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    public Properties getProps() {
        return props;
    }
}
