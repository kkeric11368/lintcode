//Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

//Example 1:
//
//Input:
//26
//
//Output:
//"1a"

//Example 2:
//
//Input:
//-1
//
//Output:
//"ffffffff"

//Notice
//1.All letters in hexadecimal (a-f) must be in lowercase.
//2.The hexadecimal string must not contain extra leading 0s. 
//    If the number is zero, it is represented by a single zero character '0'; 
//    otherwise, the first character in the hexadecimal string will not be the zero character.
//3.The given number is guaranteed to fit within the range of a 32-bit signed integer.
//4.You must not use any method provided by the library which converts/formats the number to hex directly.




public class Solution {
    public String toHex(int number) {
        if (number == 0) {
            return "0";
        }
    
        char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', 
                        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        boolean isLeadingZero = true;
        
        for (int last_4_bit = 28; last_4_bit >= 0; last_4_bit -= 4) {
            char hex = charArray[(number >> last_4_bit) & 0xF];
            if (hex != '0' || !isLeadingZero) {
            sb.append(hex);
            isLeadingZero = false;
            }
        }    
        return sb.toString();
    }     
}



