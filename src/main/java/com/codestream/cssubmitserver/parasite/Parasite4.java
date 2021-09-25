package com.codestream.cssubmitserver.parasite;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parasite4 {

    int[][] grid;

    static class Coord {
        int x;
        int y;

        Coord(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public Parasite4(int[][] _grid) {
        grid = _grid;
    }

    public int timeC() {
        Deque<Coord> queue = new ArrayDeque<>();
        Coord start = stringToCoord(startPoint(grid));
        int[][][] visited = new int[grid.length][grid[0].length][2];
        visited[start.x][start.y][0] = 1;
        queue.offerLast(start);
        while (!queue.isEmpty()) {
            Coord cur = queue.pollFirst();
            if (cur.x - 1 >= 0) {
                int energy = grid[cur.x - 1][cur.y] == 1 ?
                        visited[cur.x][cur.y][1] : visited[cur.x][cur.y][1] + 1;
                if (visited[cur.x - 1][cur.y][0] != 1) {
                    visited[cur.x - 1][cur.y][0] = 1;
                    visited[cur.x - 1][cur.y][1] = energy;
                    queue.offerLast(new Coord(cur.x - 1, cur.y));

                } else {
                    if (visited[cur.x - 1][cur.y][1] > energy) {
                        visited[cur.x - 1][cur.y][1] = energy;
                    }
                }
            }
            if (cur.y - 1 >= 0) {
                int energy = grid[cur.x][cur.y - 1] == 1 ?
                        visited[cur.x][cur.y][1] : visited[cur.x][cur.y][1] + 1;
                if (visited[cur.x][cur.y - 1][0] != 1) {
                    visited[cur.x][cur.y - 1][0] = 1;
                    visited[cur.x][cur.y - 1][1] = energy;
                    queue.offerLast(new Coord(cur.x, cur.y - 1));

                } else {
                    if (visited[cur.x][cur.y - 1][1] > energy) {
                        visited[cur.x][cur.y - 1][1] = energy;
                    }
                }
            }
            if (cur.x + 1 < grid.length) {
                int energy = grid[cur.x + 1][cur.y] == 1 ?
                        visited[cur.x][cur.y][1] : visited[cur.x][cur.y][1] + 1;
                if (visited[cur.x + 1][cur.y][0] != 1) {
                    visited[cur.x + 1][cur.y][0] = 1;
                    visited[cur.x + 1][cur.y][1] = energy;
                    queue.offerLast(new Coord(cur.x + 1, cur.y));

                } else {
                    if (visited[cur.x + 1][cur.y][1] > energy) {
                        visited[cur.x + 1][cur.y][1] = energy;
                    }
                }
            }
            if (cur.y + 1 < grid[0].length) {
                int energy = grid[cur.x][cur.y + 1] == 1 ?
                        visited[cur.x][cur.y][1] : visited[cur.x][cur.y][1] + 1;
                if (visited[cur.x][cur.y + 1][0] != 1) {
                    visited[cur.x][cur.y + 1][0] = 1;
                    visited[cur.x][cur.y + 1][1] = energy;
                    queue.offerLast(new Coord(cur.x, cur.y + 1));

                } else {
                    if (visited[cur.x][cur.y + 1][1] > energy) {
                        visited[cur.x][cur.y + 1][1] = energy;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j][1] > max) {
                    max = visited[i][j][1];
                }
            }
        }
        return max;
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
