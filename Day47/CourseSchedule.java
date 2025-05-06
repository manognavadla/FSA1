/*
 * A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi]which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.
 */import java.util.*;
import java.io.*;

class CourseSchedule 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
	{
        //WRITE YOUR CODE HERE and return the order
        int[][]graph= new int[numCourses][numCourses];
        int[] indegree= new int[numCourses];
        for(int[] p: prerequisites){
            graph[p[1]][p[0]]=1;
            indegree[p[0]]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){ 
                count++;
                queue.offer(i);}
        }
        if(count==0) return new int[]{};
        int sem= 0;
        int[] sub= new int[numCourses];
        while(!queue.isEmpty()){
                int c= queue.poll();
                sub[sem]=c;
                sem++;
                for(int j=0;j<numCourses;j++){
                    if(graph[c][j]==1){
                        indegree[j]--;
                        if(indegree[j]==0)  queue.offer(j);
                    
                }
            }
        }
        return sub;
    }
	
	public static void main(String args[] ) throws IOException 
	{	
		Scanner sc=new Scanner(System.in);	
		int courses,nprerequisites;
		courses=sc.nextInt();
		nprerequisites=sc.nextInt();
		int[][] prerequisites=new int[nprerequisites][2];
		for(int i=0; i<nprerequisites; i++)
		{
			int a=sc.nextInt(),b=sc.nextInt();
			prerequisites[i][0]=a;
			prerequisites[i][1]=b;
		}  	   
		int[] result=new CourseSchedule().findOrder(courses, prerequisites);
		System.out.println(Arrays.toString(result));
	} 
}