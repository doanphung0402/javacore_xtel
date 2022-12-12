package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectProperties {
      public static final String FILE_CONFIG = "config.properties";

      public Properties createProperties() {
            InputStream inputStream = null;
            Properties properties = new Properties();
            try {
                  inputStream = new FileInputStream(FILE_CONFIG);
                  properties.load(inputStream);
                  if (inputStream != null) {
                        inputStream.close();
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }
            return properties;
      }
}
