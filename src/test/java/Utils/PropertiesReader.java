package Utils;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

        @Getter
        private Properties prop;

        public PropertiesReader(String propertiesFile){
            try (InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream(propertiesFile)) {
                this.prop = new Properties();

                if (input == null) {
                    System.out.println("Sorry, unable to find config.properties");
                    return;
                }

                this.prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
}
