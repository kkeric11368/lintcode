//Given an array of integers, find two numbers such that they add up to a specific target number.

//The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are zero-based.

//Example
//numbers=[2, 7, 11, 15], target=9
//
//return [0, 1]


    // using HashMap
    // O(n) Space, O(n) Time
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return null;
    }
    
    

//     // using two pointers
//     // O(n) Space, O(nlogn) Time
//     class Pair {
//         Integer value;
//         Integer index;

//         Pair(Integer value, Integer index) {
//             this.value = value;
//             this.index = index;
//         }
//         Integer getValue() {
//             return this.value;
//         }
//     }

//     class ValueComparator implements Comparator<Pair> {

//         @Override
//         public int compare(Pair o1, Pair o2) {
//             return o1.getValue().compareTo(o2.getValue());
//         }
//     }

//     public int[] twoSum(int[] numbers, int target) {
//         Pair[] number = new Pair[numbers.length];
//         for (int i = 0; i < numbers.length; i++) {
//             number[i] = new Pair(numbers[i], i);
//         }
//         Arrays.sort(number, new ValueComparator());
//         int L = 0, R = numbers.length-1;
//         while (L < R) {
//             if (number[L].getValue() + number[R].getValue() == target){
//                 int t1 = number[L].index;
//                 int t2 = number[R].index;
//                 int[] result = {Math.min(t1,t2), Math.max(t1,t2)};
//                 return result;
//             }
//             if (number[L].getValue() + number[R].getValue() < target){
//                 L++;
//             } 
//             else {
//                 R--;
//             }
//         }
//         return null;
//     }


