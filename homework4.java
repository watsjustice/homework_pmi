import java.util.Random;
import java.util.Scanner;

class Main {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победа достается человеку");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победа достается ии");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Game over");
    }

    // Changed
    public static boolean checkWin(char symb) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == symb) {
                    count += 1;
                }
                if (count == DOTS_TO_WIN) return true;
            }
            count = 0;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == symb) {
                    count += 1;
                }
                if (count == DOTS_TO_WIN) return true;
            }
            count = 0;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == symb) {
                count += 1;
            }
            if (count == map.length) {
                return true;
            }
        }

        count = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[map.length - i - 1][i] == symb) {
                count += 1;
            }
            if (count == map.length) {
                return true;
            }
        }

        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x = rand.nextInt(SIZE);
        int y = rand.nextInt(SIZE);
        int dotsToBlock = DOTS_TO_WIN - 1;

        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_X) {
                    count += 1;
                }
                if (count >= dotsToBlock) {
                    y = i;
                    for (int k = 0; k < DOTS_TO_WIN + 1; k++) {
                        x = k;
                        if (isCellValid(x, y)) {
                            System.out.println("ии походил в точку " + (x + 1) + " " + (y + 1));
                            map[y][x] = DOT_O;
                            return;
                        }
                    }
                }
            }
            count = 0;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == DOT_X) {
                    count += 1;
                }
                if (count >= dotsToBlock) {
                    x = i;
                    for (int k = 0; k < DOTS_TO_WIN + 1; k++) {
                        y = k;
                        if (isCellValid(x, y)) {
                            System.out.println("ии походил в точку " + (x + 1) + " " + (y + 1));
                            map[y][x] = DOT_O;
                            return;
                        }
                    }
                }
            }
            count = 0;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == DOT_X) {
                count += 1;
            }
            if (count >= dotsToBlock) {
                for (int k = 0; k < DOTS_TO_WIN + 1; k++) {
                    y = k;
                    x = k;
                    if (isCellValid(x, y)) {
                        System.out.println("ии походил в точку " + (x + 1) + " " + (y + 1));
                        map[y][x] = DOT_O;
                        return;
                    }
                }
            }
        }

        count = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[map.length - i - 1][i] == DOT_X) {
                count += 1;
            }
            if (count >= dotsToBlock) {
                for (int k = 0; k < DOTS_TO_WIN + 1; k++) {
                    y = DOTS_TO_WIN - k - 1;
                    x = k;
                    if (isCellValid(x, y)) {
                        System.out.println("ии походил в точку " + (x + 1) + " " + (y + 1));
                        map[y][x] = DOT_O;
                        return;
                    }
                }
            }
        }

        if (!isCellValid(x, y)) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("ии походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты (X и Y)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }


    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }


    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
