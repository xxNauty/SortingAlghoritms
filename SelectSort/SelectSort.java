package SelectSort;

import Common.Order;

import java.util.ArrayList;
import java.util.List;

public class SelectSort {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(1, 5, 2, 4, 3, 7, 6, 8, 0, 9, 2));
        try {
            System.out.println(sort(input, Order.DESCENDING));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> sort(List<Integer> input, Order order) throws Exception {
        int iterations = 0;
        for(int i = 0; i < input.size(); i++){
            int chosenIndex;

            switch (order){
                case ASCENDING -> chosenIndex = findIndexOfMinElement(input, i);
                case DESCENDING -> chosenIndex = findIndexOfMaxElement(input, i);
                default -> throw new Exception("Wrong order");
            }

            int temp = input.get(i);
            input.set(i, input.get(chosenIndex));
            input.set(chosenIndex, temp);

            iterations++;
        }

        System.out.println("Iterations: " + iterations);
        return input;
    }

    private static int findIndexOfMinElement(List<Integer> input, int startIndex){
        int minValue = input.get(startIndex), minIndex = startIndex;
        for(int i = startIndex; i < input.size(); i++){
            if(input.get(i) < minValue){
                minValue = input.get(i);
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static int findIndexOfMaxElement(List<Integer> input, int startIndex){
        int maxValue = input.get(startIndex), maxIndex = startIndex;
        for(int i = startIndex; i < input.size(); i++){
            if(input.get(i) > maxValue){
                maxValue = input.get(i);
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
