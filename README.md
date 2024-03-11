# Introduction to Functions

This time, we want to delve into creating different types of functions and using them in Java. Your task is to implement some functions and use them correctly to reach the program's goal. Let's start with the program.

## What is the project about?

In this assignment, we want you to create a simple resume maker. There are some functions to collect the user's information and, at the end, show the user's information.

## Functions

Let's talk about functions.

### fullName(firstName, lastName)

This function takes two parameters: the first name and last name of the user and returns their full name. This function should correct the format of the user's first name and last name. For example:

```plaintext
First name: ArYAn
Last name: nourBAKhsh

Full name: Aryan Nourbakhsh
```

### phoneNumber(phone)

This function receives a phone number, and if the phone number starts with a 9 and is 10 digits long, it returns the phone number and adds a 0 at the beginning. Note: If the entered number is incorrect, the program shouldn't stop, and it should prompt the user to enter another phone number.

```plaintext
Phone: 9123456789
Output: 09123456789

Phone: 912345
Output: Wrong entry. Try again.
```

### userId(id)

This function is responsible for student IDs. It checks the format, and if correct, it returns it. If the format is incorrect, it prompts the user for another entry. The userID should be between 4 to 13 digits.

```plaintext
ID: 40030111111
Output: 40030111111
```

### getInterests(interests)

This function gives users interests and returns an array of interests. The maximum number of interests is 10.

```plaintext
Input: swimming
Input: gym
Input: video games

Output: {"swimming", "gym", "video games"}
```

### userFullInformation(fullName, phoneNumber, userID, interests)

This function gets user data and returns the full information of the user.

```plaintext
Full name: Aryan Nourbakhsh
Phone number: 09123456789
User ID: 40030111111
Interests: {"swimming", "gym", "video games"}

Output: Hello! My name is Aryan Nourbakhsh. My ID is 40030111111. Here are some of my interests:
1. Swimming
2. Gym
3. Video games

You can reach me via my phone number 09123456789.
```

### informationEncoder(information, shift)

In this function, we get user information and use the Caesar algorithm to encrypt the information, returning the result. You can read about the Caesar Cipher [here](https://en.wikipedia.org/wiki/Caesar_cipher). Here is a sample of input and output:

```plaintext
Information: Hello, my name is Aryanoor. I am learning Java.
Shift: 3

Output: Khoor, pb qdph lv Dubdqrru. L dp ohduqlqj Mdyd.
```

### informationDecoder(information, shift)

This function receives an encoded text and decodes it back to readable text, providing the reversed form of the last function.

```plaintext
Information: Fvb mvbuk tl jvyyljasf.
Shift: 7

Output: You found me correctly.
```

Note that initially, you should encode the user information, and the user may choose whether to see the encoded details or not. Create a main function to get user information from input and pass them to each function.

Good luck!