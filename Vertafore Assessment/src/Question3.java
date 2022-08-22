import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question3 {
    private Question2 question2;
    public Question3(Question2 question2) {
        this.question2=question2;

    }

    public List<String> isListValidAbbreviation(List<String> inputList) throws Exception {

        if(inputList.isEmpty() || inputList==null ){ throw new Exception("List empty or null");}
        ArrayList<String> resList=new ArrayList<String>();
        HashMap<String, List<String>> hMap=new HashMap<String,List<String>>();
        for (String val:inputList)
        {
        hMap=addToHashMap(hMap,val);
        }

       for (String val: inputList){
           try {
               String abbrev = question2.abbreviationBuilder(val);
               boolean isValid=isValidAbbreviation(hMap,abbrev);
               if (isValid){
                   resList.add("true");
               }
               else{
                   resList.add("false");
               }
               System.out.println(val+"->"+isValid);
           }
           catch (Exception e){}
       }
       return resList;

    }

    public boolean isValidAbbreviation(HashMap<String, List<String>> hMap,String abbrev){

        if (hMap.containsKey(abbrev)){
            if (hMap.get(abbrev).size()>1) {
                return false;
            }
            }
        return true;
    }



    public HashMap<String, List<String>> addToHashMap(HashMap<String, List<String>> currMap,String values){

        try {
            String key = question2.abbreviationBuilder(values);

            ArrayList<String> arrList = new ArrayList<String>();

            if (currMap.containsKey(key)) {
                arrList=(ArrayList<String>) currMap.getOrDefault(key,new ArrayList<String>());
                arrList.add(values);
                currMap.put(key,arrList);

            }
            else
            {
                arrList.add(values);
                currMap.put(key, arrList);
            }
        }
           catch(Exception e) {
        }
        return currMap;
    }

    @Test
    void test1() throws Exception {
        Question2 question2a=new Question2();
        Question3 question3a= new Question3(question2a);
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("internationalization", "localization","accessibility","automatically"));
        ArrayList<String> outputList=new ArrayList<String>(Arrays.asList("true", "true","false","false"));
        Assert.assertEquals(outputList,question3a.isListValidAbbreviation(arrayList));
    }

    @Test
    void test2() throws Exception {
        Question2 question2a=new Question2();
        Question3 question3a= new Question3(question2a);
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("internationalization", "localization","manual","automatically"));
        ArrayList<String> outputList=new ArrayList<String>(Arrays.asList("true", "true","true","true"));
        Assert.assertEquals(outputList,question3a.isListValidAbbreviation(arrayList));
    }

    public static void main(String[] args){
        Question2 question2=new Question2();
        Question3 question3= new Question3(question2);
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("internationalization", "localization","accessibility","automatically"));

        try {
            question3.isListValidAbbreviation(arrayList);
            System.out.println();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            question3.test1();
            System.out.println();
            question3.test2();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
