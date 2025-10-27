package student.management.system;

public class Validation {
    public static  boolean isValidId(String id){
        id=id.trim();
        int len = id.length();
        for(int i = 0;i<len;i++){
            if(id.charAt(i)>='0'&&id.charAt(i)<='9'){
                continue;
            }
                else
                return false;

        }
        return  true;
    }

    public static boolean isValidName(String name) {
        name = name.trim();
        int len = name.length();
        if (name.isEmpty()) return false;
        for (int i = 0; i <len; i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' '  && c != '\'') {
                return false;
            }
        }
        return true;
    }
}
