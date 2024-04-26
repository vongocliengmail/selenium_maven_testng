package utilities;

import enums.Environments;

public class EnvironmentConfiguration {
    private static final String environmentDirectory = "src/test/resources/environments/";
    private static final String defaultEnvironment = String.valueOf(Environments.PRODUCTION);

public EnvironmentConfiguration(String env) {
    env = (env == null) ? defaultEnvironment + ".properties" : env + ".properties";
    PropertyFile.loadRunConfigProps(environmentDirectory + env);

}
    public String getBaseUrl() {
        return PropertyFile.getProp("baseUrl");
    }
    public String getUserName() {
        return PropertyFile.getProp("userName");
    }
    public String getPassword() {
        return PropertyFile.getProp("password");
    }
    public String getBrowserName() {
        return PropertyFile.getProp("browserName");
    }
}