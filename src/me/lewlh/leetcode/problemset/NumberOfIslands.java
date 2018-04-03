package me.lewlh.leetcode.problemset;

/**
 * 给定 '1'（陆地）和
 * '0'（水）的二维网格图，计算岛屿的数量。一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。你可以假设网格的四个边均被水包围。
 * 
 * @author lewlh
 * @url https://leetcode-cn.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int length = grid.length;
		if (length == 0)
			return 0;
		int width = grid[0].length;
		int nums = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				System.out.println("遍历 i=[" + i + "],j=[" + j + "]:" + grid[i][j]);
				if (grid[i][j] == '1') {
					dfs(i, j, grid);
					nums++;
				}
			}
		}
		return nums;
	}

	public void dfs(int l, int w, char[][] grid) {
		System.out.println("l=[" + l + "],w=[" + w + "]:" + grid[l][w]);
		int length = grid.length;
		int width = grid[0].length;
		grid[l][w] = '0';
		if (l + 1 < length && grid[l + 1][w] == '1') {
			dfs(l + 1, w, grid);
		}
		if (w + 1 < width && grid[l][w + 1] == '1') {
			dfs(l, w + 1, grid);
		}
		if (l - 1 >= 0 && grid[l - 1][w] == '1') {
			dfs(l - 1, w, grid);
		}
		if (w - 1 >= 0 && grid[l][w - 1] == '1') {
			dfs(l, w - 1, grid);
		}
	}

	public static void main(String[] args) {
		// char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0',
		// '0' }, { '0', '0', '1', '0', '0' },
		// { '0', '0', '0', '1', '1' }, { '0', '0', '0', '1', '1' } };
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		NumberOfIslands n = new NumberOfIslands();
		System.out.println(n.numIslands(grid));
	}
}
