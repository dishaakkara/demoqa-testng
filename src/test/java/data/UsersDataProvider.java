package data;

import org.testng.annotations.DataProvider;

public class UsersDataProvider {

    @DataProvider(name="formData")
    public Object[][] getData() {
        return new Object[][]{
                {"Male","9876543210"},
                {"Female","9876543211"},
                {"Other","9876543212"}
        };
    }
}