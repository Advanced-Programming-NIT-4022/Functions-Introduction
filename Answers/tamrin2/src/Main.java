import java.util.Scanner;

class Main {
	static String fullName(String firstName, String lastName) {
		return firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase()
				+ " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
	}
	static String phoneNumber(String phone) {
		if ((phone.charAt(0) == '9') && (phone.length() == 10)) {
			return "0" + phone;
		} else {
			return "error";
		}
	}
	static String userId(String id) {
		if ((4 <= id.length()) && (id.length() <= 13)) {
			return id;
		} else {
			return "error";
		}
	}

	public static void main(String[] args) {
//        System.out.println("Full Name: " + fullName("ArYAn", "nourBAKhsh") + "\n");

//        Scanner input = new Scanner(System.in);
//        while (true) {
//			System.out.print("Type: ");
//            String phone_test = input.nextLine();
//			if (phoneNumber(phone_test).equals("error")) {
//				System.out.println("ERROR");
//			} else {
//				System.out.println("Output: " + phoneNumber(phone_test));
//				break;
//			}
//        }
//		input.close();

		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Type: ");
			String id_test = input.nextLine();
			if (userId(id_test).equals("error")) {
				System.out.println("ERROR");
			} else {
				System.out.println("Output: " + userId(id_test));
				break;
			}
		}
		input.close();


    }
}
