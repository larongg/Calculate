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
            String rim_str = "";
            byte rim_cif = Byte.parseByte(calculation_arab(new String[]{Integer.toString((int)s[0].charAt(0)-8495-'0'), s[1], Integer.toString((int)s[2].charAt(0)-8495-'0')}));

            if (rim_cif < 1) {return "throws Exception";}

            if (rim_cif >= 10 && rim_cif < 40) {
                for (byte i=0;i<rim_cif/10;i++) {rim_str += (char)8553;}
                if (rim_cif % 10 != 0) {rim_str += (char)(rim_cif % 10 + '0' + 8495);}
            }

            if (rim_cif >= 40 && rim_cif < 50) {
                rim_str += Character.toString((char)8553) + Character.toString((char)8556);
                if (rim_cif % 10 != 0) {rim_str += (char)(rim_cif % 10 + '0' + 8495);}
            }

            if (rim_cif >= 50 && rim_cif < 90) {
                rim_str += (char)8556;
                for (byte i=0;i<(rim_cif-50)/10;i++) {rim_str += (char)8553;}
                if (rim_cif % 10 != 0) {rim_str += (char)(rim_cif % 10 + '0' + 8495);}
            }
            if (rim_cif >= 90 && rim_cif < 100) {
                rim_str += Character.toString((char)8553) + Character.toString((char)8557);
                if (rim_cif % 10 != 0) {rim_str += (char)(rim_cif % 10 + '0' + 8495);}
            }
            if (rim_cif == 100) {rim_str += (char)8557;}

            if (rim_cif >= 1 && rim_cif < 10) {rim_str += (char)(rim_cif + '0' + 8495);}

            return rim_str;
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
        //Integer.toString((int)h.charAt(0)-8495-'0');

        /*char[] rim = {8544,8545,8546,8547,8548,8549,8550,8551,8552,8553};
        for (char i:rim){
            for (char j:rim){
                String s = "";
                s += i + " * " + j;
                System.out.print(calc(s) + " ");
            }
            System.out.println();*/
        }
    }
}