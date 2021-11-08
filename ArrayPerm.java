import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;
public class ArrayPerm {
    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);
        System.out.println("Type in the first array:");
        String aInput = a.nextLine();

        Scanner b = new Scanner(System.in);
        System.out.println("Type in the second array:");
        String bInput = b.nextLine();
        longestCommonSubsequence(aInput, bInput);
    }
    public static void longestCommonSubsequence(String a, String b)  {
        double startTime = Instant.now().toEpochMilli();
        if (a.isEmpty() || b.isEmpty()) {
            System.out.println("One or both of the given arrays is/are invalid. \nPls check your input.");
        } else {
            a = a.replaceAll("\\s+", "").toLowerCase();
            b = b.replaceAll("\\s+", "").toLowerCase();

            ArrayList<Character> ArrayA = new ArrayList<>();
            for (int i = 0; i <= a.length() - 1; i++) {
                ArrayA.add(a.charAt(i));
            }
            System.out.println("First Array: " + ArrayA);

            ArrayList<Character> ArrayB = new ArrayList<>();
            for (int j = 0; j <= b.length() - 1; j++) {
                ArrayB.add(b.charAt(j));
            }
            System.out.println("Second Array: " + ArrayB);

            ArrayList<Character> CommonElemenets1 = new ArrayList<>(ArrayA.stream()
                    .filter(ArrayB::contains)
                    .collect(Collectors.toList()));
            ArrayList<Character> CommonElemenets2 = new ArrayList<>(ArrayB.stream()
                    .filter(ArrayA::contains)
                    .collect(Collectors.toList()));
            CommonElemenets1.addAll(CommonElemenets2);
            HashSet<Character> CommonSet = new LinkedHashSet<>(CommonElemenets1);
            ArrayList<Character> finalFoo = new ArrayList<>(CommonSet);
            System.out.println("Common Elements: " + finalFoo + "\nAll permutations of the common elements:"    );
            int n = finalFoo.size();
            printPermutations(finalFoo, 0, n - 1);
            if(finalFoo.size() <= 0){
                System.out.println("There is/are " + 1 + " permutation(s) of the array with \ncommon elements between the first and the second initial array.");
            }else {
                System.out.println("There is/are " + factorial(finalFoo.size()) + " permutation(s) of the array with \ncommon elements between the first and the second initial array.");
            }
            double endTime = Instant.now().toEpochMilli();
            double totalTime = endTime - startTime;
            System.out.println("Execution time in milliseconds: " + totalTime/1000);
        }
    }
    public static void printPermutations(ArrayList<Character> a, int l,int r ) {
        if(l == r){
            HashSet<ArrayList> ArrSet  = new HashSet<ArrayList>(Collections.singleton(a));
            System.out.println(ArrSet.toString().replaceAll("\\[", "").replaceAll("\\]",""));
        }else {
            for (int i = l; i <= r; i++)        {
                Collections.swap(a, l, i);
                printPermutations(a,l+1,r);
                Collections.swap(a,l,i);
            }
        }
    }
    public static long factorial(int number){
        if (number >= 1){
            return number * factorial(number-1);
        }else {
            return 1;
        }
    }


}






