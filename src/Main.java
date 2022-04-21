import java.util.Scanner;

public class Main {
    public static boolean rim_true(String num){
        if ((int)num.charAt(0)>=8544 && (int)num.charAt(0)<=8553){return true;}
        return false;
    }

    public static boolean arab_true(String num){
        if ((int)num.charAt(0)>=49 && (int)num.charAt(0)<=57) {
            if (Long.parseLong(num)<=10) {return true;}
        }
        return false;
    }
    
    public static String calculation_arab(String[] s){
        if (s[1].charAt(0) == '+' ) {return Byte.toString((byte)(Byte.parseByte(s[0]) + Byte.parseByte(s[2])));}
        if (s[1].charAt(0) == '-' ) {return Byte.toString((byte)(Byte.parseByte(s[0]) - Byte.parseByte(s[2])));}
        if (s[1].charAt(0) == '*' ) {return Byte.toString((byte)(Byte.parseByte(s[0]) * Byte.parseByte(s[2])));}
        return Byte.toString((byte)(Byte.parseByte(s[0]) / Byte.parseByte(s[2])));
    }

    public static String calc(String input) {
        String[] s = input.split(" ");
        if (s.length != 3) {return "throws Exception";}
// римские
        if (rim_true(s[0]) && rim_true(s[2])) {
            byte rim_cif = Byte.parseByte(calculation_arab(new String[]{Integer.toString((int)s[0].charAt(0)-8495-'0'), s[1], Integer.toString((int)s[2].charAt(0)-8495-'0')}));
            if (rim_cif < 1) {return "throws Exception";}
            if (rim_cif > 10) {
                return (Character.toString((char)8553) + ((char)(rim_cif-10+'0'+8495)));
            }
        }
// арабские
        if (arab_true(s[0]) && arab_true(s[2])) {return calculation_arab(s);}

        return "throws Exception";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));
        //System.out.println(((int)'Ⅰ' - (int)'1'));
        //System.out.println(((char)((int)'Ⅴ'-8495))-'0');
        //System.out.println((char)(5+2+'0'+8495));
    }
}
//Integer.toString((int)h.charAt(0)-8495-'0')