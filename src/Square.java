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

    //This method generates a magic square of length x length and rotate it in 1=0°, 2=90°, 3=180°, 4=270°...
    void generateSquare() {

        int next = 1;
        int count = length * length;
        int i = ((length) / 2);
        int j = 0;
        numbers[i][j] = next++;

        //This loop fills up the square with numbers that are square (length**2)-1 ...
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

        //These statements produce the magic square and rotates an original square...
        if (rotation == 1){
            rotationSquare1(length);
        }
        else if (rotation == 2){
            rotationSquare2(length);
        }
        else if (rotation == 3){
            rotationSquare3(length);
        }
        else if (rotation == 4){
            rotationSquare4(length);
        }
    }

    //This method rotations the original square in 0°...
    private void rotationSquare1(int length){
        for(int x = 0; x < length; x++) {
            for (int y = length-1; y >= 0; y--) {
                printSquare(y,x); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method rotations the original square in 90°...
    private void rotationSquare2(int length) {
        for (int x = length-1; x >= 0; x--) {
            for (int y = length-1; y >= 0; y--) {
                printSquare(x,y); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method rotations the original square in 180°...
    private void rotationSquare3(int length) {
        for (int x = length-1; x >= 0; x--) {
            for (int y = 0; y < length; y++) {
                printSquare(y,x); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method rotations the original square in 270°...
    private void rotationSquare4(int length) {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                printSquare(x,y); //prints out a magic square...
            }
            System.out.println();
        }
    }

    //This method prints out a magic square...
    private void printSquare(int x, int y){

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
