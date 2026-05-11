package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"karthikrajan2210@gmail.com", "Appamma@123"},
                {"wrongemail@example.com", "wrongpassword"}
        };
    }
}