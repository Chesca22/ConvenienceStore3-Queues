package org.francisca.Models;

import org.francisca.Roles;
import org.francisca.Services.ManagerRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerRoleTest {
    Users applicant;
    Roles roles;
    Users manager;
    ManagerRole managerRole;



    @org.junit.jupiter.api.Test
    void canHire() {
        ManagerRole managerRole = new ManagerRole();
        applicant = new Users("Maryv", Roles.APPLICANT);
        manager = new Users("Manjo", Roles.MANAGER);
        Users tester = managerRole.canHire(20, "OND", applicant, manager);
        assertEquals(applicant.getName(), tester.getName());
        assertEquals(applicant.getRoles(), tester.getRoles());
    }

    @Test
    void testCanHire() {
        ManagerRole managerRole = new ManagerRole();
        applicant = new Users("Mark", Roles.APPLICANT);
        manager = new Users("Miles", Roles.MANAGER);
        Users tester = managerRole.canHire(16, "BSC", applicant, manager);
        assertNotEquals(applicant.getName(), tester);
        assertNotEquals(applicant.getRoles(), tester);
    }

}