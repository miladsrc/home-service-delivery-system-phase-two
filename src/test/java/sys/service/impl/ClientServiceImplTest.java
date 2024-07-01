package sys.service.impl;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sys.entity.Client;
import sys.exceptions.DuplicateException;
import sys.service.ClientService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientServiceImplTest {

    @Autowired
    private ClientServiceImpl clientService ;

    private static Client client;

    @BeforeAll
    static void setup() {
        client = Client.builder()
                .firstName("reza")
                .lastName("moshiri")
                .password("ehsani")
                .phoneNumber("123")
                .build();
    }

    @Test
    @Order(1)
    void testSaveClient_Success() {
        Client client = new Client();
        client.setFirstName("javad");
        client.setPhoneNumber("1234567890");
        client.setPassword("14353");

        Client savedClient = clientService.saveClient(client);

        assertEquals("John", savedClient.getFirstName());
        assertEquals("1234567890", savedClient.getPhoneNumber());
    }

    @Test
    @Order(2)
    void testSaveClient_Duplicate() {
        Client existingClient = new Client();
        client.setFirstName("javad");
        client.setPhoneNumber("1234567890");
        client.setPassword("14353");

        assertThrows(DuplicateException.class, () -> clientService.saveClient(existingClient));
    }
}

