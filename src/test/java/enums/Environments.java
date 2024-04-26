package enums;

public enum Environments {
    DEV("dev"),
    STAGING("staging"),
    PRODUCTION("production");

    String env;

    Environments(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return this.env;
    }
}
