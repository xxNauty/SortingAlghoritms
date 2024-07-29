package BogoSort;

import Common.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BogoSort {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(List.of(1, 5, 2, 4, 3, 7, 6, 8, 0, 9, 2));
        System.out.println(sort(input, Order.DESCENDING));
    }

    public static List<Integer> sort(List<Integer> input, Order order){
        try {
            while (!isSorted(input, order)){
                shuffle(input);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return input;
    }

    private static void shuffle(List<Integer> input){
        Random random = new Random();

        for(int i = 0; i < input.size(); i++){
            int randomNumber = random.nextInt(input.size());
            int temp = input.get(i);
            input.set(i, input.get(randomNumber));
            input.set(randomNumber, temp);
        }
    }

    private static boolean isSorted(List<Integer> input, Order order) throws Exception {
        switch (order){
            case ASCENDING:
                for(int i = 0; i < input.size() - 1; i++){
                    if(input.get(i) > input.get(i + 1)){
                        return false;
                    }
                }
                break;

            case DESCENDING:
                for(int i = 0; i < input.size() - 1; i++){
                    if(input.get(i) < input.get(i + 1)){
                        return false;
                    }
                }
                break;

            default:
                throw new Exception("Wrong order");
        }
        return true;
    }
}
