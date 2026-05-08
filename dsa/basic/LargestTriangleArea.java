package basic;

public class LargestTriangleArea {
    /*
        Formula: The area of a triangle with vertices is
        (x1(y2 - y3) + x2(y3-y1) + c3(y1-y2))/2
    */
    public double largestTriangleArea(int[][] points){
        double maxArea = 0;
        int n = points.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for (int k = j + 1; k < n; k++){
                    double area = Math.abs(
                            (double)points[i][0] * ( points[j][1] - points[k][1]) +
                            (double)points[j][0] * ( points[k][1] - points[i][1]) +
                            (double)points[k][0] * ( points[i][1] - points[j][1])
                    )/2.0;

                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

}
