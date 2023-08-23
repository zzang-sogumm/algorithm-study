package isu.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ4396 {
    private static final char MINE = '*';
    private static final char OPENED = 'x';

    static char[][] MINE_MAP, OPENED_MAP;
    static int num;

    public static void main(String[] args) throws IOException {
        new BOJ4396().run();
    }

    private void run() throws IOException {
        initAllMaps(); // map 초기 세팅

        startGame(); // 지뢰찾기 게임 시작

        putPlayingMap(); // 결과 출력
    }

    private void initAllMaps() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(reader.readLine());

        // 지뢰 위치 map 설정
        MINE_MAP = new char[num][num];
        setMap(MINE_MAP, reader);

        // 오픈된 위치 map 설정
        OPENED_MAP = new char[num][num];
        setMap(OPENED_MAP, reader);

        reader.close();
    }

    private void startGame() {
        boolean stepMine = false;

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                // 열어보지 않은 칸이면 건너뜀
                if (OPENED_MAP[row][col] != OPENED) {
                    continue;
                }

                // 지뢰를 밟았는지 확인
                if (MINE_MAP[row][col] == MINE) {
                    stepMine = true;
                } else {
                    // 열어본 칸 중 지뢰가 아닌 칸은 그 주위 칸 확인
                    checkNeighborBlocks(num, row, col);
                }
            }
        }

        if (stepMine) {
            markingMine(num);
        }
    }

    // 주위 8칸 지뢰 개수 확인
    private void checkNeighborBlocks(int num, int row, int col) {
        int mineCount = 0;
        final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        final int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int index = 0; index < 8; index++) {
            int nx = row + dx[index];
            int ny = col + dy[index];

            // map을 벗어나지 않는 주위의 지뢰 개수 카운트
            if (nx >= 0 && nx < num && ny >= 0 && ny < num
                    && MINE_MAP[nx][ny] == MINE) {
                mineCount++;
            }

            markingPlayingMap(mineCount, row, col);
        }
    }

    // 주위 지뢰 개수 마킹
    private void markingPlayingMap(int mineCount, int row, int col) {
        OPENED_MAP[row][col] = (char) (mineCount + '0');
    }

    // 모든 지뢰 마킹하는 메서드
    private void markingMine(int num) {
        IntStream.range(0, num)
                .forEach(row -> IntStream.range(0, num)
                        .filter(col -> MINE_MAP[row][col] == MINE)
                        .forEach(col -> OPENED_MAP[row][col] = MINE));
    }

    private void setMap(char[][] map, BufferedReader reader) throws IOException {
        int num = map.length;

        for (int row = 0; row < num; row++) {
            String line = reader.readLine();

            for (int col = 0; col < num; col++) {
                map[row][col] = line.charAt(col);
            }
        }
    }

    private void putPlayingMap() {
        Arrays.stream(OPENED_MAP)
                .forEach(System.out::println);
    }
}
