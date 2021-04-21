
class sdfdfg {
    public static void main(String[] args) {
        System.out.println(solution2(123));
    }

    public static int solution1(int n) {
        int answer = 0;

        // String 으로 만드는 법 1, String 을 char[] 로
        char[] str = ((Integer) n).toString().toCharArray();
        for (char i : str) {
            // char는 아스키코드 계산
            answer += i - 48;
        }
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;

        // String 으로 만드는 법 2, String을 한글자씩 String[] 로
        String[] str = String.valueOf(n).split("");
        for (String i : str) {
            // String을 int화 하기
            answer += Integer.parseInt(i);
        }

        return answer;
    }

}