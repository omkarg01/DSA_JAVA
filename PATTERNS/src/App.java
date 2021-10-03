public class App {

    public static void main(String[] args) throws Exception {
        pattern31(5);
    }

    private static void pattern34(int n) {
    }

    private static void pattern33(int n) {
    }

    private static void pattern32(int n) {
    }

    private static void pattern31(int n) {
        for (int i = 0; i <= 2*n; i++) {
            for (int j = 0; j <= 2*n; j++) {
               int atEveryIndex = n - Math.min(Math.min(i, j), Math.min(2*n - i, 2*n - j));
               System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    private static void pattern30(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 5; j >= 1; j--) {
                System.out.print(j <= i ? j + " " : "  ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern29(int n) {
    }

    private static void pattern28(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(
                        i <= 5 ? (j >= (n + 1) - i && j < n + i ? "* " : " ") : (j > i - n && j <= n ? "* " : " "));
            }
            System.out.println();
        }
    }

    private static void pattern27(int n) {
    }

    private static void pattern26(int n) {
    }

    private static void pattern25(int n) {
    }

    private static void pattern24(int n) {
    }

    private static void pattern23(int n) {
    }

    private static void pattern22(int n) {
    }

    private static void pattern21(int n) {
    }

    private static void pattern20(int n) {
    }

    private static void pattern19(int n) {
    }

    private static void pattern18(int n) {
    }

    private static void pattern17(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            for (int j = 5; j >= 1; j--) {
                System.out.print(j <= i ? j : " ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void pattern16(int n) {
    }

    private static void pattern15(int n) {
    }

    private static void pattern14(int n) {
    }

    private static void pattern13(int n) {
    }

    private static void pattern12(int n) {
    }

    private static void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j >= i && j < n + 1 ? "* " : " ");
            }
            System.out.println();
        }
    }

    private static void pattern10(int n) {
    }

    private static void pattern9(int n) {
    }

    private static void pattern8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n * 2; j++) {
                System.out.print(j >= (n + 1) - i && j < n + i ? "*" : " ");
            }
            System.out.println();
        }
    }

    private static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j >= i ? "*" : " ");
            }
            System.out.println();
        }
    }

    private static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(j >= (n + 1) - i ? "*" : " ");
            }
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        for (int i = 1; i < 2 * n; i++) {
            int row = i <= n ? i : 2 * n - i;
            for (int j = 1; j <= row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern1(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
