package InsertSort;

import Common.Order;

import java.util.ArrayList;
import java.util.List;

public class InsertSort {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(1, 5, 2, 4, 3, 7, 6, 8, 0, 9));
        try {
            System.out.println(sort(input, Order.ASCENDING));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> sort(List<Integer> input, Order order) throws Exception {
        int iterations = 0;
        for(int i = 1; i < input.size(); i++){
            int key = input.get(i);
            int j = i - 1;

            switch (order){
                case ASCENDING:
                    while(j >= 0 && input.get(j) > key){
                        input.set(j + 1, input.get(j));
                        j--;
                        iterations++;
                    }
                    break;

                case DESCENDING:
                    while(j >= 0 && input.get(j) < key){
                        input.set(j + 1, input.get(j));
                        j--;
                        iterations++;
                    }
                    break;

                default:
                    throw new Exception("Wrong order");
            }


            input.set(j + 1, key);
        }

        System.out.println("Iterations: " + iterations);
        return input;
    }
}
