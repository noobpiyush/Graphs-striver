public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        //get initial color

        int initialColor = image[sr][sc];
        int ans[][] = image;

        //delRow & delCol for neighbors

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        dfs(image,ans,delRow,delCol,sr,sc,initialColor,newColor);

        return ans;
    }

    public static void dfs(int image[][],int ans[][],
                           int delRow[], int delCol[], int sr, int sc, int initialColor, int newColor){

        ans[sr][sc] = newColor;
        int n = ans.length;
        int m = ans[0].length;

        for (int i =0;i<4;i++){
            int nRow  = sr + delRow[i];
            int nCol = sc + delCol[i];

            // check for valid coordinate
            // then check for same initial color and unvisited pixel

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                image[nRow][nCol] == initialColor && ans[nRow][nCol] != newColor){
                dfs(image,ans,delRow,delCol,nRow,nCol,initialColor,newColor);
            }

        }
    }
}
