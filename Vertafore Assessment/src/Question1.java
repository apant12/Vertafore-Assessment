import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Question1 {

/*
    Write an application that satisfies the following:
            •          Small application
•          Given a fully sorted array (ascending or descending), write a method to scramble the values
e.g. (7, 13, 13, 18, 29, 33)
        •          Write the code with useability, debugging, and testing in mind.
    */
    private Object[] initialArr;

    public Question1 (Object[] nums) {
        initialArr = nums.clone();


    }
    // Used to reset the library
    public Object[] reset() {
        return initialArr;
    }

    public Object[] shuffle() { // Method that does the shuffle. At time complexity of O(n)
        Object[] currArr = initialArr.clone();

        for(int i = 0; i < currArr.length; i++) {
            int idx = (int) (Math.random() * (i + 1));
            swap(currArr, idx, i);
        }
        return currArr;

    }

    public void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Main Method, that
    public static void main(String[] args){
        Question1 question1=new Question1(new Object[] {1,2,3,4,5,6,7,8});
        System.out.println(Arrays.toString(question1.shuffle()));
        Question1 question2=new Question1(new Object[] {"a","b","c","d","e","f","g","h"});
        System.out.println(Arrays.toString(question2.shuffle()));
        question1.test1();
        question1.test2();
        question1.test3();
    }

    @Test
    public void test1(){
        Question1 question1=new Question1(new Object[] {1,2,3,4,5,6,7,8});

        Object[] outputArr=question1.shuffle();
        Arrays.sort(outputArr);


        Assert.assertEquals(new Object[] {1,2,3,4,5,6,7,8},outputArr);
    }

    @Test
    public void test2(){
        Question1 question1=new Question1(new Object[] {1,2,3,4,5,6,7,8});

        Object[] outputArr=question1.shuffle();
        Arrays.sort(outputArr);


        Assert.assertEquals(new Object[] {1,2,3,4,5,6,7,8},outputArr);
    }

    @Test
    public void test3(){
        Question1 question1=new Question1(new Object[] {"a","b","c","d","e","f","g","h"});

        Object[] outputArr=question1.shuffle();
        Arrays.sort(outputArr);


        Assert.assertEquals(new Object[] {"a","b","c","d","e","f","g","h"},outputArr);
    }
}
