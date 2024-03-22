import java.util.Scanner;

class Main {
	static String fullName(String firstName, String lastName) {
		return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()
				+ " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
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

	static String[] getInterests() {
		System.out.println("0 = quit");
		String[] array = new String[10];
		Scanner scanner_input = new Scanner(System.in);
		for (int i = 0; i < 10; ) {
			System.out.print("Type: ");
			String input_test = scanner_input.nextLine();
			if (input_test.equals("0")) {
				break;
			} else {
				array[i] = input_test;
				i += 1;
			}
		}
		return array;
	}

	static void userFullInformation(String fullName, String phoneNumber, String userID, String[] interests) {
		System.out.println("Hi xD");
		System.out.println("My name is " + fullName + ".");
		System.out.println("My ID is " + userID + ".");
		System.out.println("Here are some of my interests:");
		for (int i = 0; i < interests.length; i++) {
			System.out.println((i + 1) + ". " + interests[i]);
		}
		System.out.println();
		System.out.println("You can reach me via my phone number " + phoneNumber + ".");
		System.out.println("GoodBye xD");
	}

	static String informationEncoder(String information, int shift) {
		char[] information_new = information.toCharArray();
		for (int i = 0; i < information_new.length; i++) {
			if (('a' <= information_new[i]) & (information_new[i] <= 'z')) {
				information_new[i] += shift;
				if (information_new[i] > 'z') {
					information_new[i] -= 'z' - 'a';
				}
			}
			if (('A' <= information_new[i]) & (information_new[i] <= 'Z')) {
				information_new[i] += shift;
				if (information_new[i] > 'Z') {
					information_new[i] -= 'Z' - 'A';
				}
			}
		}
		information = String.valueOf(information_new);
		return information;
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

//		Scanner input = new Scanner(System.in);
//		while (true) {
//			System.out.print("Type: ");
//			String id_test = input.nextLine();
//			if (userId(id_test).equals("error")) {
//				System.out.println("ERROR");
//			} else {
//				System.out.println("Output: " + userId(id_test));
//				break;
//			}
//		}
//		input.close();

//		String[] amir_interests_array = new String[10];
//		amir_interests_array = getInterests();
//		for (int i = 0; i < 10; i++) {
//			System.out.println("arr[" + i + "] = " + amir_interests_array[i]);
//		}

//		String[] sample_interest_array = {"swimming", "gym", "video games"};
//		userFullInformation("Aryan Nourbakhsh", "09123456789", "40030111111", sample_interest_array);

//		System.out.println(informationEncoder("Hello, my name is Aryanoor. I am learning Java.", 3));
	}
}
