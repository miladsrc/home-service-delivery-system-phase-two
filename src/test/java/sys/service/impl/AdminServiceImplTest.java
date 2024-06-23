package sys.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sys.entity.Admin;
import sys.exceptions.NotFoundException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminService;


    private static Admin admin;


    @BeforeAll
    static void setUp() {
         admin = Admin.builder()
                .phoneNumber("1234567890")
                .build();
    }


    @Test
    public void testLoadUserByPhoneNumber_UserFound() {
        String phoneNumber = "1234567890";

        Admin loadedAdmin = adminService.loadUserByPhone(phoneNumber.trim());

        assertNotNull(loadedAdmin.getPhoneNumber());
        assertEquals(loadedAdmin.getPhoneNumber().trim(), phoneNumber.trim().trim(), loadedAdmin.getPhoneNumber().trim());
    }


    @Test
    public void testLoadUserByUsername_UserNotFound() {

        String phoneNumber = "9876543210";

        Assertions.assertThrows(NotFoundException.class, () -> adminService.loadUserByPhone(phoneNumber));
    }
}
