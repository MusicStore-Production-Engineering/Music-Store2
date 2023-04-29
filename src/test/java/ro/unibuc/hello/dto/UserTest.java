package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    User test = new User("test", "test@", "testpass");

    @Test
    void test_userame(){
        Assertions.assertEquals("test", test.getUsername());
    }
    @Test
    void test_email(){
        Assertions.assertEquals("test@", test.getEmail());
    }
    @Test
    void test_password(){
        Assertions.assertEquals("testpass", test.getPassword());
    }
    @Test
    void test_set_username() {
        String testName = "test";
        test.setUsername(testName);
        Assertions.assertEquals(testName, test.getUsername());
    }
    @Test
    void test_set_email() {
        String testEmail= "test@";
        test.setEmail(testEmail);;
        Assertions.assertEquals(testEmail, test.getEmail());
    }
    @Test
    void test_set_password() {
        String testPassword = "testpass";
        test.setPassword(testPassword);
        Assertions.assertEquals(testPassword, test.getPassword());
    }


}
