// Program to implement Disjoint Set Data Structure.

/*
5 = number of friends
3 = number of relationships
2 = number of friendship check
input=5
3
0 2
4 2
3 1
2
4 0
1 0
output=4 is a friend of 0
1 is not a friend of 0

*/
import java.io.*;
import java.util.*;

class DisjointUnionSets {
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	// Creates n sets with single item in each
	void makeSet(){
	    for(int i=0;i<n;i++) parent[i]=i;
		
	}

	// Returns representative of x's set
	int find(int x){
		if(parent[x]==x) return x;
		return find(parent[x]);
	}

	// Unites the set that includes x and the set that includes x
	void union(int xr, int yr){
	    int x=find(xr);
	    int y=find(yr);
	    if(x==y) return;
	    if(rank[x]==rank[y]){
	        parent[y]=x;
	        rank[x]+=1;
	    }else if(rank[x]>rank[y]){
	        parent[y]=x;
	        rank[x]+=1;
	    }else{
	        parent[x]=y;
	        rank[y]+=1;
	    }
	}
}

class disjointSetUnion {
    static void check(int[][] c,DisjointUnionSets dus){
        for(int[] ch: c){
		    if(dus.find(ch[0])==dus.find(ch[1])) System.out.println(ch[0]+" is a friend of "+ch[1]);
		    else System.out.println(ch[0]+" is not a friend of "+ch[1]);
		}
		return;
    }
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		DisjointUnionSets dus= new DisjointUnionSets(n);
		int rel=sc.nextInt();
		for(int i=0;i<rel;i++){
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    dus.union(x,y);   
		}
		int check=sc.nextInt();
		int[][] c= new int[check][2];
		for(int i=0;i<check;i++){
		    c[i][0]=sc.nextInt();
		    c[i][1]=sc.nextInt();
		}
		check(c,dus);
		}		
	}






