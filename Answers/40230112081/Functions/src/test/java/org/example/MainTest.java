package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Functions obj = new Functions();
    @Test
    public void fullName_test() {
        assertEquals("Amir Salehi", obj.fullName("aMIr", "SalEhI"));
        assertEquals("Hossein Javid", obj.fullName("Hossein", "JaViD"));
    }

    @Test
    public void phoneNumber_test() {
        assertEquals("09114567890", obj.phoneNumber("9114567890"));
        assertEquals("Wrong entry. Try again.", obj.phoneNumber("091234"));
        assertEquals("Wrong entry. Try again.",obj.phoneNumber("0912***3344"));
    }

    @Test
    public void userID() {
        assertEquals("Wrong entry. Try again.",obj.userID("123"));
        assertEquals("4990123567",obj.userID("4990123567"));
    }

    @Test
    public void informationEncoder() {
        assertEquals("Khoor, pb qdph lv Dubdqrru. L dp ohduqlqj Mdyd.",obj.informationEncoder("Hello, my name is Aryanoor. I am learning Java.",3));
        assertEquals("Eqmv", obj.informationEncoder("Amir", 4));
    }

    @Test
    public void informationDecoder() {
        assertEquals("You found me correctly.", obj.informationDecoder("Fvb mvbuk tl jvyyljasf.", 7));
        assertEquals("Amir", obj.informationDecoder("Eqmv", 4));
    }
}