public class LibraryFine {


    public static void main(String[] args) {
        //sample Input: 7 4 2023 3 4 2023 as given in the document
        //to run this use the following command only works for java 11+,  java LibraryFine.java 7 4 2023 3 4 2023
        //this technique called running single file programs without compiling
        try {
            int d1 = Integer.parseInt(args[0]);
            int m1 = Integer.parseInt(args[1]);
            int y1 = Integer.parseInt(args[2]);
            int d2 = Integer.parseInt(args[3]);
            int m2 = Integer.parseInt(args[4]);
            int y2 = Integer.parseInt(args[5]);

            int fine = libraryFine(d1, m1, y1, d2, m2, y2);
            System.out.println("the fine amount for being late is = " + fine);
        }
        catch (Exception e) {
            System.err.println("an exception has occurred " + e.getMessage());
        }
    }
    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 < y2 || (y1 == y2 && m1 < m2) || (y1 == y2 && m1 == m2 && d1 <= d2)) {
            //book returned on or before the due date
            return 0;
        } else if (y1 == y2 && m1 == m2) {
            //book returned within the same month and year but after due date
            return 15 * (d1 - d2);
        } else if (y1 == y2 && m1 > m2) {
            //book returned within the same year but after due month
            return 500 * (m1 - m2);
        } else {
            //book returned after the due year
            return 10000;
        }
    }
}