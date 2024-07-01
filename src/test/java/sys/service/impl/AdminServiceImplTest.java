package sys.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sys.entity.Address;
import sys.entity.Admin;
import sys.entity.Expert;
import sys.entity.ExpertState;
import sys.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private ExpertServiceImpl expertService;


    private static Admin admin;
    private static Expert expert;


    @BeforeAll
     static void setUp() {
        admin = Admin.builder()
                .phoneNumber("1234567890")
                .build();

        List<Address> address = new ArrayList<>();

        expert = Expert.builder()
                .firstName("javad")
                .lastName("javad")
                .email("javad")
                .addresses(address)
                .expertiseState(ExpertState.NEW)
                .creditAmount(1d)
                .build();
    }


    @Test
    public void testLoadAdminByPhoneNumber_UserFound() {
        String phoneNumber = "1234567890";

        Admin loadedAdmin = adminService.loadUserByPhone(phoneNumber.trim());

        assertNotNull(loadedAdmin.getPhoneNumber());
        assertEquals(loadedAdmin.getPhoneNumber().trim(), phoneNumber.trim().trim(), loadedAdmin.getPhoneNumber().trim());
    }


    @Test
    public void testLoadAdminByUsername_UserNotFound() {

        String phoneNumber = "9876543210";

        Assertions.assertThrows(NotFoundException.class, () -> adminService.loadUserByPhone(phoneNumber));
    }


    @Test
    public void testConfirmExpert_Success() throws InterruptedException {

        List<Address> address = new ArrayList<>();
        System.out.println(expert.toString());

        expertService.saveExpert(expert);

        adminService.confirmExpert(3L);
        Expert confirmed = expertService.getExpertById(3L);

        Assertions.assertEquals(ExpertState.CONFIRMED.ordinal(), confirmed.getExpertiseState().ordinal()
                , "Expert confirmation is not confirmed");

    }


    @Test
    public void testConfirmExpert_ExpertNotFound() {
        long nonExistentExpertId = 999L;

        assertThrows(NotFoundException.class, () -> expertService.getExpertById(nonExistentExpertId));
    }

}
