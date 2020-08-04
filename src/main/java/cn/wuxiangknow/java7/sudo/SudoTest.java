package cn.wuxiangknow.java7.sudo;

/**
 * @Descirption
 * @Author WuXiang
 * @Date 2020/8/4/
 */
public class SudoTest {
    /*int[][] array  = new int[][]{
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
            };*/

    private static final int[] VALUES = new int[]{1,2,3,4,5,6,7,8,9};

    public void test(){
        int[][] array  = new int[][]{
            {0,0,0, 0,0,5, 7,0,0},
            {0,3,0, 0,9,0, 0,0,5},
            {0,8,0, 0,0,4, 0,0,2},

            {0,0,9, 0,0,1, 0,0,0},
            {7,5,0, 0,0,0, 0,1,8},
            {0,0,0, 5,0,0, 2,0,0},

            {3,0,0, 2,0,0, 0,6,0},
            {6,0,0, 0,7,0, 0,8,0},
            {0,0,5, 3,0,0, 0,0,0},
        };
    }



    private void calculate(int[][] array){
        //从每行每列 去除可能的值


    }


    private boolean checkArray(int[] array){
        //检查是否有重复的值
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0){
                for (int j = 0; j < array.length; j++) {
                    if(array[i] == array[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSudoku(int[][] array){
        //检查九宫格是否有重复的值
        int[] sortedArray = getSortedArray(array, 0, 0);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 0, 3);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 0, 6);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 3, 0);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 3, 3);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 3, 6);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 6, 0);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 6, 3);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        sortedArray = getSortedArray(array, 6, 6);
        if(checkSingleSudoku(sortedArray)){
            return false;
        }
        return true;
    }

    private int[] getSortedArray(int[][] array,int i ,int j){
        int[]  sortedArray = new int[9];
        sortedArray[0] = array[i][j];
        sortedArray[1] = array[i][j+1];
        sortedArray[2] = array[i][j+2];
        sortedArray[3] = array[i+1][j];
        sortedArray[4] = array[i+1][j+1];
        sortedArray[5] = array[i+1][j+2];
        sortedArray[6] = array[i+2][j];
        sortedArray[7] = array[i+2][j+1];
        sortedArray[8] = array[i+2][j+2];
        return sortedArray;
    }


    private boolean checkSingleSudoku(int[] sortedArray){
        //检查九宫格是否有重复的值
        for (int i = 0; i < sortedArray.length; i++) {
            if(sortedArray[i] != 0){
                for (int j = 0; j < sortedArray.length; j++) {
                    if(sortedArray[i] == sortedArray[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
