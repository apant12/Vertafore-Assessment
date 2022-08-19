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
    public static void main(String[] args){
        Question2 question2=new Question2();
        try {
            System.out.println(question2.abbreviationBuilder("accessibility"));
        }
        catch (Exception e){}

        try {
            System.out.println(question2.abbreviationBuilder("automatically"));
        }
        catch (Exception e){}
    }
}
