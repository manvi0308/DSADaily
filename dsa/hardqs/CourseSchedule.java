package hardqs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adjList.get(b).add(a);
        }
        int[] indegreees = new int[numCourses];
      //  int[] topoSort = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            for (Integer it : adjList.get(i)){
                indegreees[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegreees[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()){
            int course = queue.peek();
           // topoSort[index] = course;
            index++;
            queue.poll();

            for (Integer it : adjList.get(course)){
                indegreees[it]--;
                if (indegreees[it] == 0)
                    queue.add(it);
            }
        }

        for (int i = 0; i < indegreees.length; i++){
            if (indegreees[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
       int numCourses = 2;
       int[][] prerequisites = {{ 1,0 }};
       System.out.println(canFinish(numCourses, prerequisites));
    }
}
