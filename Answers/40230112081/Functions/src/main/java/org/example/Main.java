package org.example;

public class Main {
    
    public static void main(String[] args) {
        Functions obj = new Functions();
        System.out.println(obj.fullName("NIma","fARkhOONDEh"));
        Vector v = new Vector();
        System.out.println(obj.getInterests(v).length);
        String[] arr = v.get_arr();
        obj.userFullInformation("Nima", "09121234567", "40230112081", arr);  
    }
}