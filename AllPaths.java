/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-05-05T21:59:45-07:00
 * @Filename: AllPaths.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-05-06T10:46:17-07:00
 */

import java.util.Arrays; // Using this to make appending easier. Not truly necessary.

public class AllPaths {

  private int[][] paths; // Defined as a global class property so that every level of recursion can access this item

  public int[][] allPaths(int[][] graph) {

    int[] path = {0}; // We start out journey at 0
    paths = new int[0][0]; // Make paths non-null (or reset it if already populated)

    findPath(graph, path); // Call the private function from the start

    return paths;

  }

  private void findPath(int[][] graph, int[] path) {

    int start = path[path.length-1]; // The journey begins were the current path ends (philosophical)

    for (int adj: graph[start]) { // visit all nodes ajdecent to 'starting' node

      // Log the visit to a new path array
      int[] newPath = Arrays.copyOf(path, path.length + 1);
      newPath[newPath.length - 1] = adj;

      if (adj == graph.length-1) { // If we reached the destination...
        paths = Arrays.copyOf(paths, paths.length + 1); // Grow paths
        paths[paths.length - 1] = newPath; // Append the current route
      } else { // Otherwise...
        findPath(graph, newPath); // Go a level deeper, until you reach a terminal node
      }

    }

  }

}
