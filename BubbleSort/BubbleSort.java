package BubbleSort;

import Common.Order;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

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
        for(int j = 0; j < input.size(); j++){
            for(int i = 0; i < input.size() - 1; i++){
                switch(order){
                    case ASCENDING:
                        if(input.get(i) > input.get(i + 1)){
                            int temp = input.get(i);
                            input.set(i, input.get(i + 1));
                            input.set(i + 1, temp);
                            iterations++;
                        }
                        break;

                    case DESCENDING:
                        if(input.get(i) < input.get(i + 1)){
                            int temp = input.get(i);
                            input.set(i, input.get(i + 1));
                            input.set(i + 1, temp);
                            iterations++;
                        }
                        break;

                    default:
                        throw new Exception("Wrong order");
                }
            }
        }

        System.out.println("Iterations: " + iterations);
        return input;
    }
}
