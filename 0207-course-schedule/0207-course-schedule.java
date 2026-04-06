/*
INTUITION:

This problem is about checking whether all courses can be finished.

A course can be completed only after its prerequisites are completed first.
That means the courses form a directed graph:
- course -> prerequisite

If there is a cycle in this graph, then some course depends on itself indirectly,
so it becomes impossible to finish all courses.

So the real question is:
- Does the prerequisite graph contain a cycle?

-----------------------------------------------------

BRUTE FORCE APPROACH:

Try all possible course orders and check whether prerequisites are satisfied.

But this is not practical because:
- there can be many permutations of course order
- checking all of them is extremely expensive

Time Complexity: very large / exponential
Space Complexity: very large

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use DFS cycle detection on the directed graph.

We use:
1. Adjacency list (map)
   - map[course] = list of prerequisites for that course

2. visited set
   - tracks the current DFS path (recursion stack)
   - if we revisit a node already in the current path, it means a cycle exists

How DFS works:
- If a course has no prerequisites, it is safe
- If during DFS we reach a course that is already in the current recursion path,
  then we found a cycle
- After fully exploring a course, we remove it from visited and mark it as "done"
  by clearing its prerequisite list

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Build graph:
   - for each pair [a, b], add b as a prerequisite of a

2. Run DFS from every course:
   - if any DFS returns false, there is a cycle → return false

3. In DFS:
   - if course is already in visited:
       -> cycle found, return false
   - if course has no prerequisites:
       -> return true
   - add course to visited
   - recursively check all prerequisites
   - remove course from visited after exploration
   - clear its prerequisite list to avoid recomputation
   - return true

-----------------------------------------------------

TIME COMPLEXITY:
O(V + E)
- V = number of courses
- E = number of prerequisite pairs

SPACE COMPLEXITY:
O(V + E)
- adjacency list
- recursion stack
- visited set
*/

class Solution {

    // Adjacency list:
    // course -> list of its prerequisites
    private Map<Integer, List<Integer>> map = new HashMap<>();

    // Tracks the current DFS path to detect cycles
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int n, int[][] prerequisites) {
        // Initialize graph for all courses
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Build graph
        for (int[] curr : prerequisites) {
            map.get(curr[0]).add(curr[1]);
        }

        // Check every course for cycle
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int c) {
        // If course is already in the current DFS path,
        // we found a cycle
        if (visited.contains(c)) {
            return false;
        }

        // If this course has already been fully processed
        // and has no remaining prerequisites, it is safe
        if (map.get(c).isEmpty()) {
            return true;
        }

        // Mark course as part of current recursion stack
        visited.add(c);

        // Check all prerequisites of this course
        for (int pre : map.get(c)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        // Backtrack: remove from current path
        visited.remove(c);

        // Mark as processed so we don't recompute it again
        map.put(c, new ArrayList<>());

        return true;
    }
}