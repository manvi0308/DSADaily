package graphs;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    /*
    prerequisites[i] = [ai, bi] indicates that you
    must take course bi first if you want to take course ai.

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]

    1 ----> 0
    dependency --> [ 1, 0 ]

    complete course 1
    dependency --> [ 0, 0]
    track --> [ false, true ]


     */

    public boolean canFinish(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> ajdList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            ajdList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            ajdList.get(b).add(a);
        }
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            for (Integer it : ajdList.get(i)){
                indegrees[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int course = queue.poll();
            for (Integer it : ajdList.get(course)){
                indegrees[it]--;
                if (indegrees[it] == 0)
                    queue.add(it);
            }
        }

        for (int i = 0; i < numCourses; i++){
            if (indegrees[i] != 0)
                return false;
        }
        return true;
    }
}
