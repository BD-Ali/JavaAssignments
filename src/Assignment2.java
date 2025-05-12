public class Assignment2 {

    // task 1.1
    // No input assumptions
    // Checks if the given matrix is a valid instance of the Big Trip Problem
    public static boolean isLegalInstance(boolean[][] matrix) {
        boolean result = false; // default return value
        // ---------------write your code BELOW this line only! ------------------
        if (matrix==null && matrix.length==0 && matrix[0].length==0) {
            result = true;
        }
        if (isSquareMatrix(matrix) && isSymmetricMatrix(matrix) && isAntiReflexiveMatrix(matrix)) {
            result = true;
        }

        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.2
    // Assumes matrix is not null
    // Checks if the matrix is square.
    public static boolean isSquareMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        for (int i = 0; i < matrix.length; i++) {
        if (matrix[i].length != matrix.length)
            result = false;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }
    
    // task 1.3
    // Assumes matrix is a non-null, square boolean matrix.
    // Checks if the matrix is symmetric.
    public static boolean isSymmetricMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[j][i] != matrix[i][j])
                    result = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.4
    // Assumes matrix is a non-null, square boolean matrix.
    // Checks if the matrix is anti-reflexive (no self-loops).
    public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
        boolean result = true; // default return value
        // ---------------write your code BELOW this line only! ------------------
         for (int i = 0; i < matrix.length; i++) {{
                 if (matrix[i][i]){
                     result = false;
                 }
             }
         }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.5
    // Assumes flights is a boolean matrix representing valid flights
    // and tour is an array of integers matching the size of flights.
    // Validates if the given tour is a correct solution for the flight's matrix.
    public static boolean isValidSolution(boolean[][] flights, int[] tour) {
        boolean result = false; // default return value
        // ---------------write your code BELOW this line only! ------------------
        result = isPermutation(tour) && areStepsLegal(flights, tour);
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.6
    // Assumes array is not null
    // Checks if the array is a permutation of numbers from 0 to array.length-1.
    public static boolean isPermutation(int[] array) {
        boolean result = true; // default return value, CHANGED IT TO TRUE.
        // ---------------write your code BELOW this line only! ------------------
        int x =0;
        if (array != null) {
            while (x < array.length) {
                for (int i = 0; i < array.length; i++) {
                    if (array[x] == array[array.length - 1 - i] && array.length - 1 - i != x || array[i] > array.length - 1 || array[i] < 0) {
                        result = false;
                    }
                }
                x++;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 1.7
    // Assumes flights is a valid instance matrix and tour only includes valid city indices
    // Checks if there are legal flights between consecutive cities in the tour.
    public static boolean areStepsLegal(boolean[][] flights, int[] tour) {
        boolean result = true;
        // ---------------write your code BELOW this line only! ------------------
        if (tour != null) {
            for (int i = 0; i < tour.length - 1; i++) {
                if (!(flights[flights.length - 1][0]) || !(flights[tour[i]][tour[i + 1]])) {
                    result = false;
                }
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;    }

    ///////////////////////////////////
    /////// Part 1 ends here ////////
    ///////////////////////////////////

    // Assumes n is a non-negative integer.
    // Creates an array of integers from 0 to n-1.
    public static int[] createRange(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    // Assumes source and destination arrays are of the same length.
    // Copies the contents of source array into destination array.
    public static void copyArray(int[] source, int[] destination) {
        if (source == null || destination == null || source.length != destination.length) {
            throw new IllegalArgumentException("Source and null must be initialized arrays of the same length.");
        }
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    // Assumes n is a non-negative integer.
    // Computes the factorial of n.
    public static int factorial(int n) {
        if (n<0) {
            throw new IllegalArgumentException("n must be non-negative.");
        }
        int res = 1;
        for(; n > 1; n--) {
            res = res * n;
        }
        return res;
    }

    // task 2.1
    // Assumes n is a positive integer.
    // Generates all permutations of numbers from 0 to n-1 using the Johnson-Trotter algorithm.
    public static int[][] generatePermutations(int n) {
        int[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        result = new int[factorial(n)][n]; // 0-5 0-2
        int[] directions = new int[n];
        int[] RA = createRange(n); //012
        for (int i = 0; i < directions.length; i++) {
            directions[i] = -1;
        }
        copyArray(RA,result[0]);
        for (int i = 1; i < factorial(n); i++) {
            int mbi= findMobileIndex(RA,directions);
                swap(RA, directions, mbi);
                if(mbi==0 && directions[0]==-1 || mbi==RA.length-1 && directions[directions.length-1]==1 )
                    reverseDirections(RA, directions, RA[mbi]);
                copyArray(RA, result[i]);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 2.2
    // Assumes permutation and directions are arrays of the same length.
    // Swaps elements in permutation and directions based on the mobile index.
    public static void swap(int[] permutation, int[] directions, int mobileIndex) {
        // ---------------write your code BELOW this line only! ------------------

           if(mobileIndex>=0 && mobileIndex < permutation.length && (mobileIndex+directions[mobileIndex]>=0) && mobileIndex+directions[mobileIndex]<permutation.length) {
                int tempP = permutation[mobileIndex + directions[mobileIndex]];
                permutation[mobileIndex + directions[mobileIndex]] = permutation[mobileIndex];
                permutation[mobileIndex] = tempP;
                int tempD = directions[mobileIndex + directions[mobileIndex]];
                directions[mobileIndex + directions[mobileIndex]] = directions[mobileIndex];
                directions[mobileIndex] = tempD;
           }
        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.3
    // Assumes permutation and directions are arrays of the same length.
    // Reverses the directions of elements greater than the given mobile element.
    public static void reverseDirections(int[] permutation, int[] directions, int mobileElement) {
        // ---------------write your code BELOW this line only! ------------------
        for (int i=0; i<directions.length; i++) {
            if (mobileElement< permutation[i])
                directions[i] = -directions[i];
        }
        // ---------------write your code ABOVE this line only! ------------------
    }

    // task 2.4
    // Assumes permutation and directions are arrays of the same length.
    // Finds and returns the index of the largest mobile element or -1 if none exist.
    public static int findMobileIndex(int[] permutation, int[] directions) {
        int result = -1; // default return value
        // ---------------write your code BELOW this line only! ------------------
        int Maxmb = -1;

        for (int i = 0; i < permutation.length; i++) {
            if (i + directions[i] >= 0 && i + directions[i] < permutation.length && permutation[i] > permutation[i + directions[i]] && permutation[i] > Maxmb) {
                    Maxmb = permutation[i];
                    result = i;
            }
        }

        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }


    // task 2.5
    // Assumes flights is a valid problem instance.
    // Finds a valid solution to the Big Trip Problem using exhaustive search.
    public static int[] solveBigTripProblemExhaustive(boolean[][] flights) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------

        for (int i = 0; i < factorial(flights.length); i++) {
            int[] tour = generatePermutations(flights.length)[i];
            if (isValidSolution(flights, tour)) {
                result = tour;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    ///////////////////////////////////
    /////// Part 2 ends here ////////
    ///////////////////////////////////

    // Assumes flights is a valid instance of the Big Trip Problem.
    // Solves the Big Trip Problem using reduction
    public static int[] solveBigTripProblemReduction(boolean[][] flights) {
        if (!isLegalInstance(flights)) {
            throw new IllegalArgumentException("Flights instance must be valid.");
        }
        boolean[][] encodedFlights = encoder(flights);
        int[] hamiltonianPath = HamiltonianPathSolver.solve(encodedFlights);
        return decoder(hamiltonianPath);
    }

    // task 3.1
    // Assumes flights is a valid matrix.
    // Adds a dummy city to the matrix and returns the new matrix.
    public static boolean[][] encoder(boolean[][] flights) {
        boolean[][] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------
        result = new boolean[flights.length+1][flights[0].length+1];
        for (int i = 0; i < flights.length; i++) {
            for (int j = 0; j < flights[0].length; j++) {
                result[i][j] = flights[i][j];
            }
        }
        for (int i = 0; i < flights.length; i++) {
            result[i][result.length-1] = flights[0][i];
            result[result.length-1][i] = flights[0][i];
        }
        result[result.length-1][result.length-1] = false;

        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

    // task 3.2
    // Assumes hamiltonianPath is a valid Hamiltonian path or null.
    // Converts the Hamiltonian path back to the original Big Trip Problem solution.
    public static int[] decoder(int[] hamiltonianPath) {
        int[] result = null; // default return value
        // ---------------write your code BELOW this line only! ------------------

        if (hamiltonianPath != null){
            result = new int[hamiltonianPath.length-1];
            for (int i = 0; i < hamiltonianPath.length-1; i++) {
                result[i] = hamiltonianPath[i];
            }
        }

        // ---------------write your code ABOVE this line only! ------------------
        return result;
    }

}
