import java.util.Arrays;
public class Anagram {


        static void isAnagram(String s1, String s2)
        {
            boolean status = true;
            if(s1.length() != s2.length())
            {
                status = false;
            }
            else
            {
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);
                status = Arrays.equals(c1,c2);
            }
            if(status)
            {
                System.out.println(s1+" and "+s2+" are anagrams");
            }
            else
            {
                System.out.println(s1+" and "+s2+" are not anagrams");
            }
        }
        public static void main(String[] args)
        {
            isAnagram("Abhinav", "abhinav");
            isAnagram("Nikhil", "nikhil.");
            isAnagram("R@avi", "R@vI");
            isAnagram("hello", "olleh");
        }
    }



