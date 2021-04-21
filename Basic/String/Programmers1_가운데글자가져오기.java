class sdfsd{
    public static void main(String[] args){
        System.out.println(solution("qwdddr"));
    }
    public static String solution(String s) {
        int length = s.length();
        return s.substring((int)Math.ceil(length/2.0)-1, length/2 + 1);
    }
}