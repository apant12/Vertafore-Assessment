import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Question2 {

    /*
     * Consider the following style of abbreviation:
     *   (first letter) + (count of removed letters) + (last letter)
     * For example:
     *   "internationalization" -> "i18n"
     *   "localization" -> "l10n"
     * Write a function that given any word returns its abbreviation.
     */

    public Question2(){

    }
    //The abbreviation builder builds abbreviation by taking in an input. The time complexity is O(1)
    public String abbreviationBuilder(String input ) throws Exception {
        if (input.length()==0){
            throw new Exception("Empty String");
        }
        if (input==null){
            throw new NullPointerException();
        }

        char firstChar=input.charAt(0);
        char lastChar=input.charAt(input.length()-1);
        String lengthOfWordAftRemoval=Integer.toString(input.length()-2);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(firstChar).append(lengthOfWordAftRemoval).append(lastChar);
        return stringBuilder.toString();
    }
    @Test
    public void test1() throws Exception {
        Question2 question2=new Question2();

        Assert.assertEquals("a11y",question2.abbreviationBuilder("accessibility"));
    }

    @Test
    public void test2() throws Exception {
        Question2 question2=new Question2();

        Assert.assertEquals("i18n",question2.abbreviationBuilder("internationalization"));

    }

    public static void main(String[] args) throws Exception {
        Question2 question2=new Question2();
        try {
            System.out.println("accessibility"+"->"+question2.abbreviationBuilder("accessibility"));
        }
        catch (Exception e){}

        try {
            System.out.println("automatically"+"->"+question2.abbreviationBuilder("automatically"));
        }
        catch (Exception e){}

        try {
            System.out.println("internationalization"+"->"+question2.abbreviationBuilder("internationalization"));
        }
        catch (Exception e){}
        try {
            System.out.println("localization"+"->"+question2.abbreviationBuilder("localization"));
        }
        catch (Exception e){}

        question2.test1();
        question2.test2();
    }
}
