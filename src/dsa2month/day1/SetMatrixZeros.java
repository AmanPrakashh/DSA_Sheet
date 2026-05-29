package dsa2month.day1;

public class SetMatrixZeros {


    public void setMatrixZeros() {
        int[][] arr = new int[3][4];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[0][3] = 1;

        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 1;
        arr[1][3] = 1;

        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        arr[2][3] = 1;


        int[] cols = new int[arr.length];
        int[] rows = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i=0; i<rows.length; i++) {
            if(rows[i]==1)
            {

            }
        }

    }

}
