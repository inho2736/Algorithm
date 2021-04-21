import java.util.*;

class skjfl {
    public static void main(String[] args) {
        int n = 2;
        String[] strs = { "abce", "abcd", "cdx" };

        String[] answer = solution(strs, n);
        for (String i : answer) {
            System.out.println(i);
        }
    }

    public static String[] wrongSolution(String[] strings, int n) {

        // 해당 인덱스의 알파벳이 같을 경우, 사전순으로 비교하는 코드가 추가로 필요함.
        Arrays.sort(strings, (a, b) -> a.charAt(n) - b.charAt(n));
        return strings;
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                char aChar = a.charAt(n);
                char bChar = b.charAt(n);
                if (aChar == bChar) {
                    return a.compareTo(b);
                } else {
                    return aChar - bChar;
                }
            }
        });
        return strings;
    }
}