public class Square {

    //Declare class fields...
    private int length;
    private int [][] numbers;
    private int rotation;
    int sum;
    
    //Constructor to construct a class and initiate the fields...
    Square(int length, int [][] numbers, int rotation){
        this.length = length;
        this.numbers = numbers;
        this.rotation = rotation;
    }

    //This method generates a magic square of length x length and rotate it in 0=0°, 1=90°, 2=180°, 3=270°...
    void generateSquare() {

        int next = 1;
        int count = length * length;
        int i = ((length) / 2);
        int j = 0;
        numbers[i][j] = next++;

        //This loop fills up the square with numbers that are less than a square n ...
        while (next <= count) {
            i++;
            j--;

            if (j < 0 && i >= length) {
                i--;
                j += 2;

                if (numbers[i][j] == 0) {
                    numbers[i][j] = next++;
                }
                else {
                    i--;
                    j += 2;
                }
            }
            else if (j < 0) {
                j = length - 1;

                if (numbers[i][j] == 0) {
                    numbers[i][j] = next++;
                }
                else {
                    i--;
                    j += 2;
                }
            }
            else if (i >= length) {
                i = 0;

                if (numbers[i][j] == 0) {
                    numbers[i][j] = next++;
                }
                else {
                    i--;
                    j += 2;
                }
            }
            else {

                if (numbers[i][j] != 0) {
                    i -= 2;
                    j += 3;
                }
                else {
                    numbers[i][j] = next++;
                }
            }
        }

        //Calculate the sum of a row...
        int rowSum = 0;
        for(int row = 0; row < length; row++){
            rowSum += numbers[row][0];
        }

        //Calculate the sum of a column...
        int colSum = 0;
        for(int col = 0; col < length; col++){
            colSum += numbers[0][col];
        }

        //Calculate the sum of a diagonal...
        int diagonalSum = 0;
        int x1 = 0;
        int y1 = 0;
        while (x1 < numbers.length){
            diagonalSum += numbers[x1][y1];
            y1++;
            x1++;
        }

        if ((rowSum == diagonalSum) && (colSum == diagonalSum)){
            sum = diagonalSum;
        }

        //These statements produce the magic square or rotations an original square...
        if (rotation == 0){
            for(int x = 0; x < length; x++) {
                for (int y = length-1; y >= 0; y--) {
                    printSquare(y,x); //prints out a magic square...
                }
                System.out.println();
            }
        }
        else if (rotation == 1){
            rotationSquare90(length);
        }
        else if (rotation == 2){
            rotationSquare180(length);
        }
        else if (rotation == 3){
            rotationSquare270(length);
        }
    }

    //This method rotations the original square in 1x90°...
    void rotationSquare90(int n) {
        for (int x = n-1; x >= 0; x--) {
            for (int y = n-1; y >= 0; y--) {
                printSquare(x,y); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method rotations the original square in 2x90°...
    void rotationSquare180(int n) {
        for (int x = n-1; x >= 0; x--) {
            for (int y = 0; y < n; y++) {
                printSquare(y,x); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method rotations the original square in 3x90°...
    void rotationSquare270(int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                printSquare(x,y); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method prints out a magic square...
    void printSquare(int x, int y){

        //These statements just aligns numbers perfectly in a grid...
        if (numbers[x][y] < 10){
            System.out.print(" ");
        }
        if (numbers[x][y] < 100){
            System.out.print(" ");
        }
        //Print magic square.
        System.out.print(numbers[x][y] + " ");
    }
}
