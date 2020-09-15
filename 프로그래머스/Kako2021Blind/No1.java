package Kakao2021Blind;

public class No1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String src = "abcdefghijklmn.p";
        String res = "abcdefghijklmn";
        System.out.println(s.solution(src));
        System.out.println(res);

    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";
            String str = new_id.toLowerCase();
            StringBuilder sb = new StringBuilder();

            // 먼저 들어올수없는 캐릭터 제거
            System.out.println(str);
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 48 && c <= 57 || c >= 97 && c <= 122 || c == '.' || c == '-' || c == '_') {
                    sb.append(c);
                }
            }

            str = sb.toString();
            System.out.println(str);
            sb = new StringBuilder();
            int s = 0, e;
            int pointCnt = 0;
            while (s <= str.length() - 1) {
                e = s + 1;
                char c = str.charAt(s);
                if (c == '.') {
                    pointCnt++;
                    for (int i = e; i < str.length() - 1; i++) {
                        if (str.charAt(i) == '.') {
                            pointCnt++;
                        } else {
                            e = i;
                            break;
                        }
                    }
                } else {
                    if (s < str.length())
                        sb.append(str.charAt(s));
                }
                if (pointCnt == 1) {
                    if (s < str.length() - 1)
                        sb.append(str.charAt(s));
                    pointCnt = 0;
                } else if (pointCnt >= 2) {
                    sb.append(str.charAt(s));
                    s = e;
                    pointCnt = 0;
                    continue;
                }

                s++;
            }

            str = sb.toString();
            System.out.println("점제거" + str);
            if (str.length() > 0) {
                if (str.charAt(0) == '.') {
                    str = str.substring(1, str.length());
                }
            }
            if (str.length() > 0) {
                if (str.charAt(str.length() - 1) == '.') {
                    str = str.substring(0, str.length() - 1);
                }
            }
            System.out.println(str);

            if (str.length() == 0) {
                sb = new StringBuilder();
                sb.append("a");
                str = sb.toString();
            }
            if (str.length() >= 16) {
                str = str.substring(0, 15);

                if (str.charAt(str.length() - 1) == '.') {
                    str = str.substring(0, str.length() - 1);
                }

            }
            if (str.length() <= 2) {
                char c = str.charAt(str.length() - 1);
                int len = str.length();
                for (int i = len; i < 3; i++) {
                    str += c;
                }
            }
            answer = str;
            return answer;
        }

    }
}
