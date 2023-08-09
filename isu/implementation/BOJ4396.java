package isu.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ4396 {
    private static final char MINE = '*';
    private static final char OPENED = 'x';
    private static final char DOT = '.';

    static char[][] MINE_MAP;
    static char[][] OPENED_MAP;
    static char[][] PLAYING_MAP;

    public static void main(String[] args) throws IOException {
        new BOJ4396().run();
    }

    private void run() throws IOException {
        initAllMaps(); // map 초기 세팅

        startGame(); // 지뢰찾기 게임 시작

        putPlayingMap(); // 결과 출력
        System.out.println("끝");
    }

    private void initAllMaps() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        // 지뢰 위치 map 설정
        MINE_MAP = new char[num][num];
        setMap(MINE_MAP, reader);

        // 오픈된 위치 map 설정
        OPENED_MAP = new char[num][num];
        setMap(OPENED_MAP, reader);

        // 결과 map 초기 세팅
        initPlayingMap(num);

        reader.close();
    }

    private void startGame() {
        int num = MINE_MAP.length;
        boolean hitMine = false;

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                // 열어보지 않은 칸이면 건너뜀
                if (OPENED_MAP[row][col] != OPENED) {
                    break;
                }

                // 지뢰를 열었다면 종료
                if (MINE_MAP[row][col] == MINE) {
                    hitMine = true;
                    break;
                }

                // 열어본 칸 중 지뢰가 아닌 칸은 그 주위 칸 확인
                checkNeighborBlocks(num, row, col);
            }

            // 지뢰를 밟은 경우 모든 지뢰를 표시함
            if (hitMine) {
                markingMine(num);
                break;
            }
        }
    }

    // 주위 8칸 지뢰 개수 확인
    private void checkNeighborBlocks(int num, int row, int col) {
        int mineCount = 0;
        final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int index = 0; index < dx.length; index++) {
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
        PLAYING_MAP[row][col] = (char) (mineCount + '0');
    }

    // 모든 지뢰 마킹하는 메서드
    private void markingMine(int num) {
        // 모든 map 온점으로 초기화
        initPlayingMap(num);

        IntStream.range(0, num)
                .forEach(row -> IntStream.range(0, num)
                        .filter(col -> MINE_MAP[row][col] == MINE)
                        .forEach(col -> PLAYING_MAP[row][col] = MINE));
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

    private void initPlayingMap(int num) {
        PLAYING_MAP = new char[num][num];
        for (int row = 0; row < num; row++) { // 모두 온점으로 설정
            Arrays.fill(PLAYING_MAP[row], DOT);
        }
    }

    private void putPlayingMap() {
        Arrays.stream(PLAYING_MAP)
                .forEach(System.out::println);
    }
}
