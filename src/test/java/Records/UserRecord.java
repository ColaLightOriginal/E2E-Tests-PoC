package Records;

import Enums.UsersEnum;
import Utils.PropertiesReader;

public record UserRecord(String name, String username, String password) {

    public UserRecord(String name, String username, String password){
        PropertiesReader propertiesReaderUtils = new PropertiesReader("users.properties");

        UsersEnum userEnumValue = UsersEnum.valueOf(name);
        this.name = userEnumValue.toString();
        switch(UsersEnum.valueOf(name)){
            case STANDARD -> {
                this.username = propertiesReaderUtils.getProp().getProperty("standard.username");
                this.password = propertiesReaderUtils.getProp().getProperty("standard.password");
            }
            case PROBLEM -> {
                this.username = propertiesReaderUtils.getProp().getProperty("problem.username");
                this.password = propertiesReaderUtils.getProp().getProperty("problem.password");
            }
            case LOCKED -> {
                this.username = propertiesReaderUtils.getProp().getProperty("locked.username");
                this.password = propertiesReaderUtils.getProp().getProperty("locked.password");
            }
            default -> {
                this.username = username;
                this.password = password;
            }
        }
    }

}
