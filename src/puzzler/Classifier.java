package puzzler;

//尽量使用“//” 而不用块注释，块注释中出现的任何结束符都会结束

public class Classifier {
	
    public static void main(String[] args) {
        System.out.println(
            classify('n') + classify('+') + classify('2')); 
    }

    static String classify(char ch) {
        if ("0123456789".indexOf(ch) >= 0)
            return "NUMERAL ";
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(ch) >= 0)
            return "LETTER ";
/*
 *      (Operators not supported yet) 
 *      if ("+-(本来是有乘除符号的)&|!=".indexOf(ch) >= 0)
 *          return "OPERATOR "; 
 */
        return "UNKNOWN "; 
    } 
}
