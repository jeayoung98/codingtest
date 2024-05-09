import java.util.*;
import java.util.stream.*;

public class Solution {
    public String solution(String s, String skip, int index) {
        // skip에 있는 문자 제거
        List<Character> list = "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(c -> (char) c) // int를 char로 변환
                .filter(c -> !skip.contains(String.valueOf(c)))
                .collect(Collectors.toList());
        list.stream().forEach(a -> System.out.print(a+" "));

        // 인덱스만큼 움직이기
        return s.chars()
                .mapToObj(c -> (char) c)
                .map(c -> list.get((list.indexOf(c) + index) % list.size()))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}