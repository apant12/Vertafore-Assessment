import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question3 {
    private Question2 question2;
    public Question3(Question2 question2) {
        this.question2=question2;

    }

    public List<String> isValidAbbreviation(List<String> inputList){
        ArrayList<String> resList=new ArrayList<String>();
        HashMap<String, List<String>> hMap=new HashMap<String,List<String>>();
        for (String val:inputList)
        {
        hMap=addToHashMap(hMap,val);
        }

       for (String val: inputList){
           try {
               String abbrev = question2.abbreviationBuilder(val);
               if (hMap.containsKey(abbrev)){
                   if (hMap.get(abbrev).size()>1){
                       resList.add("false");
                       System.out.println(val+"->"+"false");
                   }
                   else{
                       resList.add("true");
                       System.out.println(val+"->"+"true");
                   }
               }
           }
           catch (Exception e){}
       }
       return resList;

    }


    public HashMap<String, List<String>> addToHashMap(HashMap<String, List<String>> currMap,String values){

        try {
            String key = question2.abbreviationBuilder(values);

            ArrayList<String> arrList = new ArrayList<String>();

            if (currMap.containsKey(key)) {
                arrList=(ArrayList<String>) currMap.getOrDefault(key,new ArrayList<String>());
                arrList.add(values);
                currMap.put(key,arrList);

            } else
            {
                arrList.add(values);
                currMap.put(key, arrList);
            }
        }
           catch(Exception e) {
        }
        return currMap;
    }

    public static void main(String[] args){
        Question2 question2=new Question2();
        Question3 question3= new Question3(question2);
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList("internationalization", "localization","accessibility","automatically"));
        question3.isValidAbbreviation(arrayList);

    }
}
