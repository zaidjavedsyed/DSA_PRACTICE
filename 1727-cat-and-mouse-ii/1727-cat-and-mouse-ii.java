import java.util.*;

public class Solution {
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN   = 2;
    private static final int UNKNOWN   = 0;
    private static final int[] DR = { -1, 1, 0, 0 };
    private static final int[] DC = { 0, 0, -1, 1 };

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int rows = grid.length, cols = grid[0].length();
        // Map each cell to an index, and find start & food positions
        int mouseStart = 0, catStart = 0, foodPos = 0, N = 0;
        int[][] cellIndex = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cellIndex[r][c] = N;
                char ch = grid[r].charAt(c);
                if (ch == 'M') mouseStart = N;
                if (ch == 'C') catStart   = N;
                if (ch == 'F') foodPos    = N;
                N++;
            }
        }
        int maxStates = N * N * 2;

        // Precompute moves for mouse and cat from each cell
        @SuppressWarnings("unchecked")
        List<Integer>[] mouseMoves = new ArrayList[N];
        @SuppressWarnings("unchecked")
        List<Integer>[] catMoves   = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            mouseMoves[i] = computeMoves(i, grid, rows, cols, mouseJump, cellIndex);
            catMoves[i]   = computeMoves(i, grid, rows, cols, catJump,   cellIndex);
        }

        // Build reverse graph (parents) and out-degree
        @SuppressWarnings("unchecked")
        List<Integer>[] parents = new ArrayList[maxStates];
        int[] degree = new int[maxStates];
        for (int i = 0; i < maxStates; i++) {
            parents[i] = new ArrayList<>();
        }
        for (int m = 0; m < N; m++) {
            for (int c = 0; c < N; c++) {
                for (int turn = 0; turn < 2; turn++) {
                    int s = (m * N + c) * 2 + turn;
                    List<Integer> moves = (turn == 0 ? mouseMoves[m] : catMoves[c]);
                    degree[s] = moves.size();
                    for (int nxt : moves) {
                        int m2 = (turn == 0 ? nxt : m);
                        int c2 = (turn == 1 ? nxt : c);
                        int nextState = (m2 * N + c2) * 2 + (1 - turn);
                        parents[nextState].add(s);
                    }
                }
            }
        }

        // status[s]: UNKNOWN / MOUSE_WIN / CAT_WIN
        int[] status = new int[maxStates];
        Queue<Integer> queue = new ArrayDeque<>();

        // Initialize terminal states
        for (int m = 0; m < N; m++) {
            for (int c = 0; c < N; c++) {
                for (int turn = 0; turn < 2; turn++) {
                    int s = (m * N + c) * 2 + turn;
                    if (m == c) {
                        status[s] = CAT_WIN;    // Cat catches Mouse
                        queue.offer(s);
                    } else if (m == foodPos) {
                        status[s] = MOUSE_WIN;  // Mouse reaches food
                        queue.offer(s);
                    } else if (c == foodPos) {
                        status[s] = CAT_WIN;    // Cat reaches food
                        queue.offer(s);
                    }
                }
            }
        }

        // BFS retrograde analysis
        while (!queue.isEmpty()) {
            int v = queue.poll();
            int winPlayer = status[v];
            for (int u : parents[v]) {
                if (status[u] != UNKNOWN) continue;
                int turnU = u & 1;  // 0 = Mouse's turn, 1 = Cat's turn
                if ((winPlayer == MOUSE_WIN && turnU == 0) ||
                    (winPlayer == CAT_WIN   && turnU == 1)) {
                    status[u] = winPlayer;
                    queue.offer(u);
                } else {
                    if (--degree[u] == 0) {
                        // All moves lead to opponent win
                        status[u] = (turnU == 0 ? CAT_WIN : MOUSE_WIN);
                        queue.offer(u);
                    }
                }
            }
        }

        // Check the start state (mouseStart, catStart, Mouse's turn)
        int startState = (mouseStart * N + catStart) * 2 + 0;
        return status[startState] == MOUSE_WIN;
    }

    // Compute all reachable positions (including staying) from 'idx'
    private List<Integer> computeMoves(int idx, String[] grid, int R, int C,
                                       int jump, int[][] cellIndex) {
        List<Integer> moves = new ArrayList<>();
        int r = idx / C, c = idx % C;
        moves.add(idx);  // staying
        for (int d = 0; d < 4; d++) {
            for (int step = 1; step <= jump; step++) {
                int nr = r + DR[d] * step, nc = c + DC[d] * step;
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) break;
                if (grid[nr].charAt(nc) == '#') break;
                moves.add(cellIndex[nr][nc]);
            }
        }
        return moves;
    }
}
