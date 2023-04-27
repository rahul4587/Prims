public class Prims{
	static int selectMinVertex(int[] value, boolean[] setMST){
		int minimum = Integer.MAX_VALUE;
		int vertex = 0;
		for(int i = 0; i < value.length; i++){
			if(setMST[i] == false && value[i] < minimum) {
				vertex = i;
				minimum = value[i];
			}
		}
		return vertex;
	}
	static void printMst(int[] parent, int[][] graph){
	    int total_weight=0;
		System.out.println("Edge \t \tWeight\n");
		for(int i = 1; i < parent.length; i++){
			System.out.println(parent[i] + "-" +
			i + " \t " + "-->" + " \t "  + graph[i][parent[i]] + "\n");
			total_weight+=graph[i][parent[i]];
		}
		System.out.println("Total Weight : " +total_weight);
	}
	static void findMST(int graph[][]){
		int V = graph.length;
		int[] parent = new int[V];
		int[] value = new int[V];
		boolean[] setMST = new boolean[V];
		for(int i = 0; i < V; i++){
			value[i] = Integer.MAX_VALUE;
		}
		parent[0] = -1;
		value[0] = 0;
		for(int i = 0; i < V-1; i++){
			int U = selectMinVertex(value, setMST);
			setMST[U] = true;
			for(int j = 0; j < V; j++){
				if(graph[U][j] != 0 && setMST[j] == false && graph[U][j] < value[j]){
					value[j] = graph[U][j];
					parent[j] = U;
				}
			}
		}
		printMst(parent, graph);
	}
	public static void main(String[] args) {    
		int[][] graph = {
			{0, 3, 0, 0, 5},
			{3, 0, 8, 5, 7},
			{0, 8, 0, 2, 0},
			{0, 5, 2, 0, 3},
			{5, 7, 0, 3, 0}
		};
		findMST(graph);
	}
}
