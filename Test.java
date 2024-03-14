public class Test {
    public static void main(String[] args) {
        String s = "dao     tu      phat";
        String [] part = s.split("\\s+");
        System.out.println(part[0]);
        System.out.println(part[1]);
        System.out.println(part[2]);
    }
}
