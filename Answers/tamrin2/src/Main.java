class Main {
    public static void main(String[] args) {
        System.out.println("Full Name: " + fullName("ArYAn", "nourBAKhsh") + "\n");
    }
    static String fullName(String firstName, String lastName) {
        return firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase()
                + " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
}
