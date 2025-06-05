// package Day46;
/*
 * You are given an integer N which denotes the number of courses numbered from 1 to N and a matrix ‘prerequisites’,
in which each row contains exactly two integers ‘A’ and ‘B’ which represents the course ‘A’ 
has to be studied in some semester before studying course ‘B’.

In one semester, you can take at most k courses as long as you have taken all the prerequisites in the 
previous semesters for the courses you are taking.

You are supposed to find the minimum number of semesters required to study all the courses. 
If it is impossible to study all the courses, then return -1.

Input Format:
-------------
The first line represents N, which denotes the number of courses
The second line represents M, which denotes the number of rows of the matrix prerequisites.
The next M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], 
denoting that prerequisites[i][0] has to be studied before prerequisites[i][1].
Last line k, denotes number of courses can be taken in a semester.

Output Format:
---------------
Print the minimum number of semesters required to study all the courses

Sample Input 1
--------------
4
3
2 1
3 1
4 1
2

Sample output 1
---------------
3


Explanation: 
------------
In the first semester, you can take courses 2 and 3.
In the second semester, you can take course 4.
In the third semester, you can take course 1.

Sample input 2
--------------
4
3
1 3
2 3
3 1
3
Sample output 2
----------------
-1

Constraints:
1<= N <= 50
1<=k<=N
1 <= prerequisites[i][0], prerequisites[i][1] <= N
Prerequisites[i][0] != prerequisites[i][1], for any valid i
 */
import java.util.*;

class ParallelCourses {
    public int minimumSemesters(int numCourses, int[][] prerequisites, int maxCourses) {
        // create an adjacency list to represent the graph
        int[][] graph = new int[numCourses + 1][numCourses + 1];
        int[] indegree = new int[numCourses + 1];

        // populate the adjacency list using the prerequisites array
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            graph[u][v] = 1;
            indegree[v]++; 
        }

        Queue<Integer> queue = new LinkedList<>();
        // Add all courses with no prerequisites to the queue
        for (int i = 1; i <= numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int semesters = 0;
        int coursesTaken = 0;

        while (!queue.isEmpty()) {
            int currentSemesterCourses = Math.min(queue.size(), maxCourses);
            semesters++;
            
            // Process courses for this semester8
		    for (int i = 0; i < currentSemesterCourses; i++) {
                int course = queue.poll();
                coursesTaken++;
                
                // Decrement indegree for all neighbors
                for (int neighbor = 1; neighbor <= numCourses; neighbor++) {
                    if (graph[course][neighbor] == 1) {
                        indegree[neighbor]--;
                        if (indegree[neighbor] == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return coursesTaken == numCourses ? semesters : -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCourses = s.nextInt();
        int c = s.nextInt();
        int[][] prerequisites = new int[c][2];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                prerequisites[i][j] = s.nextInt();
            }
        }
        int maxCourses = s.nextInt();
        ParallelCourses p = new ParallelCourses();
        System.out.println(p.minimumSemesters(numCourses, prerequisites, maxCourses));
    }
}