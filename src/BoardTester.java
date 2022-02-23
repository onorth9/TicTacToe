public class BoardTester {

    public static void main(String[] args) {

        System.out.print("Testing Board.getColumn: ");
        if(testGetColumn()){
            System.out.println("PASSED");
        }
        else{
            System.out.println("FAILED");
        }

    }

    public static boolean testGetColumn(){
        Board b = new Board();



        int testMove0 = 7;
        int expectedCol0 = 0;
        if (b.getColumn(testMove0) != expectedCol0) {
            return false;
        }

        int testMove1 = 2;
        int expectedCol1 = 1;
        if (b.getColumn(testMove1) != expectedCol1) {
            return false;
        }

        int testMove2 = 6;
        int expectedCol2 = 2;
        if (b.getColumn(testMove2) != expectedCol2) {
            return false;
        }

        return true;
    }
}
