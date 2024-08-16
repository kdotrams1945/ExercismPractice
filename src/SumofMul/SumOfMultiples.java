package SumofMul;


import java.util.HashSet;
class SumOfMultiples {
    private int number;
    private int[] set;
    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        var list = new HashSet<Integer>();
        for (int num : set) {
            if (num != 0) {
                for (int multiple = num; multiple < number; multiple += num) {
                    list.add(multiple);
                }
            }
        }
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

}
