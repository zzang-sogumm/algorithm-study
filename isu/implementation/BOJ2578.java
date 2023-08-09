package isu.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BOJ2578 {
    static Scanner sc = new Scanner(System.in);
    static int[][] bingoBoard = new int[5][5];
    static int numRows = bingoBoard.length;
    static int numCols = bingoBoard[0].length;

    public static void main(String[] args) throws IOException {
        new BOJ2578().run();
    }

    private void run() throws IOException {
        int hostCount = 0;
        int maxNum = numRows * numCols;

        setBingoBoard();

        // 숫자 확인
        for (int num = 1; num <= maxNum; num++) {
            int number = sc.nextInt();
            hostCount++;

            markingBingoBoard(number);

            if (bingo()) {
                break;
            }
        }

        sc.close();
        System.out.println(hostCount);
    }

    // 2차원 배열에 빙고판 숫자 담기
    private void setBingoBoard() throws IOException {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                bingoBoard[row][col] = sc.nextInt();
            }
        }
    }

    // 빙고판에 불린 숫자 마킹
    private void markingBingoBoard(int number) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (bingoBoard[row][col] == number) {
                    bingoBoard[row][col] = -1;
                    return;
                }
            }
        }
    }

    private boolean bingo() {
        int bingoCount = 0;

        bingoCount += countRowBingo();
        bingoCount += countColBingo();

        if (isMainDiagonalBingo()) {
            bingoCount++;
        }

        if (isSubDiagonalBingo()) {
            bingoCount++;
        }

        return bingoCount >= 3;
    }

    // 행 빙고 개수 카운트
    private int countRowBingo() {
        return (int) Arrays.stream(bingoBoard)
                .filter(row -> Arrays.stream(row)
                        .allMatch(value -> value == -1))
                .count();
    }

    // 열 빙고 개수 카운트
    private int countColBingo() {
        // 행과 열을 바꾸어서 각 열을 스트림 처리
        return (int) IntStream.range(0, numCols)
                .filter(col -> IntStream.range(0, numRows)
                        .allMatch(row -> bingoBoard[row][col] == -1))
                .count();
    }

    // 주 대각선 빙고인지 확인
    private boolean isMainDiagonalBingo() {
        for (int index = 0; index < numRows; index++) {
            if (bingoBoard[index][index] != -1) {
                return false;
            }
        }

        return true;
    }

    // 부 대각선 빙고인지 확인
    private boolean isSubDiagonalBingo() {
        for (int index = 0; index < numCols; index++) {
            if (bingoBoard[index][numCols - 1 - index] != -1) {
                return false;
            }
        }

        return true;
    }
}
