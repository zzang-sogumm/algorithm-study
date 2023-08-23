package isu.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1316 {
    static HashMap<Character, Integer> alphabets = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new BOJ1316().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int answer;

        answer = countGroupWords(num, reader);

        System.out.println(answer);
    }

    private void initAlphabets() {
        for (char alphabet = 97; alphabet <= 122; alphabet++) {
            alphabets.put(alphabet, 0);
        }
    }

    private int countGroupWords(int num, BufferedReader reader) throws IOException {
        int count = 0;

        for (int i = 0; i < num; i++) {
            initAlphabets();
            String word = reader.readLine();

            if (isGroupWord(word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isGroupWord(String word) {
        // 첫번째 알파벳 넣어줌
        char firstAlphabet = word.charAt(0);
        alphabets.put(firstAlphabet, 1);

        for (int index = 1; index < word.length(); index++) {
            char alphabet = word.charAt(index);
            char prevAlphabet = word.charAt(index - 1);

            // 지금 알파벳과 이전 알파벳이 다른 경우
            if (alphabet != prevAlphabet) {
                int alphabetCount = alphabets.get(alphabet);

                // 이전과 중복 알파벳인 경우
                if (alphabetCount > 0) {
                    return false;
                }

                // hashMap의 숫자에 1 더해줌
                alphabets.put(alphabet, alphabetCount + 1);
            }
        }

        return true;
    }
}
