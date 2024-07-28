class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, firstChangeTime = 0;

        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new ArrayList<>();

        for(int[] e: edges) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] visited = new int[n+1];
        int[] visitTime = new int[n+1];
        visited[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int nextChangeTime = change, totalTime = 0;
        while(!q.isEmpty()) {
            int sz = q.size();

            int waitTime = 0;
            if(totalTime >= nextChangeTime) {
                nextChangeTime = (totalTime / change + 1) * change;
                if((nextChangeTime / change) % 2 == 0) waitTime = nextChangeTime - totalTime;
            }

            while(sz-- > 0) {
                int curr = q.poll();
                if(curr == n) {
                    if(totalTime < first) {
                        second = first;
                        first = totalTime;
                        firstChangeTime = nextChangeTime;
                    } else if(totalTime < second) {
                        second = totalTime;
                    }
                    continue;
                }

                for(int next: adj[curr]) {
                    if(visited[next] == 0 || (visited[next] == 1 && visitTime[next] != totalTime)) {
                        visited[next]++;
                        visitTime[next] = totalTime;
                        q.add(next);
                    }
                }
            }

            totalTime += time + waitTime;
        }

        if(second != Integer.MAX_VALUE && second != first) return second;
        else {
            int waitTime = 0;
            // going back one node
            if(first >= firstChangeTime) {
                firstChangeTime = (first / change + 1) * change;
                if((firstChangeTime / change) % 2 == 0) waitTime = firstChangeTime - first;
            }

            first += time + waitTime;
            // going to the last node
            if(first >= firstChangeTime) {
                firstChangeTime = (first / change + 1) * change;
                if((firstChangeTime / change) % 2 == 0) waitTime = firstChangeTime - first;
            }

            return first + waitTime + time;
        }
    }
}