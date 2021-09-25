package com.codestream.cssubmitserver.parasite;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parasite3 {

    int[][] grid;

    static class Coord {
        int x;
        int y;
        int depth;

        Coord(int _x, int _y) {
            x = _x;
            y = _y;
            depth = 0;
        }

        Coord(int _x, int _y, int _d) {
            x = _x;
            y = _y;
            depth = _d;
        }
    }

    public Parasite3(int[][] _grid) {
        grid = _grid;
    }

    public int timeB() {
        Deque<Coord> queue = new ArrayDeque<>();
        Coord start = stringToCoord(startPoint(grid));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start.x][start.y] = true;
        queue.offerLast(start);
        int time = 0;
        while (!queue.isEmpty()) {
            Coord cur = queue.pollFirst();
            if (cur.depth > time) time = cur.depth;
            if (cur.x - 1 >= 0 && !visited[cur.x - 1][cur.y] && grid[cur.x - 1][cur.y] == 1) {
                visited[cur.x - 1][cur.y] = true;
                queue.offerLast(new Coord(cur.x - 1, cur.y, cur.depth + 1));
            }
            if (cur.y - 1 >= 0 && !visited[cur.x][cur.y - 1] && grid[cur.x][cur.y - 1] == 1) {
                visited[cur.x][cur.y - 1] = true;
                queue.offerLast(new Coord(cur.x, cur.y - 1, cur.depth + 1));
            }
            if (cur.x + 1 < grid.length && !visited[cur.x + 1][cur.y] && grid[cur.x + 1][cur.y] == 1) {
                visited[cur.x + 1][cur.y] = true;
                queue.offerLast(new Coord(cur.x + 1, cur.y, cur.depth + 1));
            }
            if (cur.y + 1 < grid[0].length && !visited[cur.x][cur.y + 1] && grid[cur.x][cur.y + 1] == 1) {
                visited[cur.x][cur.y + 1] = true;
                queue.offerLast(new Coord(cur.x, cur.y + 1, cur.depth + 1));
            }

            if (cur.x - 1 >= 0 && cur.y - 1 >= 0 &&
                    !visited[cur.x - 1][cur.y - 1] && grid[cur.x - 1][cur.y - 1] == 1) {
                visited[cur.x - 1][cur.y - 1] = true;
                queue.offerLast(new Coord(cur.x - 1, cur.y - 1, cur.depth + 1));
            }
            if (cur.x + 1 < grid.length && cur.y - 1 >= 0 &&
                    !visited[cur.x + 1][cur.y - 1] && grid[cur.x + 1][cur.y - 1] == 1) {
                visited[cur.x + 1][cur.y - 1] = true;
                queue.offerLast(new Coord(cur.x + 1, cur.y - 1, cur.depth + 1));
            }
            if (cur.x - 1 >= 0 && cur.y + 1 < grid[0].length &&
                    !visited[cur.x - 1][cur.y + 1] && grid[cur.x - 1][cur.y + 1] == 1) {
                visited[cur.x - 1][cur.y + 1] = true;
                queue.offerLast(new Coord(cur.x - 1, cur.y + 1, cur.depth + 1));
            }
            if (cur.x + 1 < grid.length && cur.y + 1 < grid[0].length &&
                    !visited[cur.x + 1][cur.y + 1] && grid[cur.x + 1][cur.y + 1] == 1) {
                visited[cur.x + 1][cur.y + 1] = true;
                queue.offerLast(new Coord(cur.x + 1, cur.y + 1, cur.depth + 1));
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    public static String startPoint(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 3) {
                    return i + "," + j;
                }
            }
        }
        return null;
    }

    public static Coord stringToCoord(String str) {
        if (str == null) return new Coord(0, 0);
        String[] split = str.split(",");
        return new Coord(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }


}
