package com.hackerrank.worldcodesprint9;

import java.util.*;

/**
 * Created by satyajit on 1/29/17.
 */
public class QueensAttackII {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n == 0) {
      return;
    }
    int board[][] = new int[n][n];

    int k = in.nextInt();
    int rq = in.nextInt() - 1;
    int cq = in.nextInt() - 1;

    for (int i = 0; i < k; i++) {
      int r = in.nextInt() - 1;
      int c = in.nextInt() - 1;
      board[r][c] = 1;
    }

    // 0 - ULC
    // 1 - URC
    // 2 - LLC
    // 3 - LRC
    // 4 - SD
    // 5 - SU
    // 6 - SL
    // 7 - SR
    int availableAttacks[] = {0, 1, 2, 3, 4, 5, 6, 7};
    if (rq == 0 && cq == 0) {
      availableAttacks = new int[]{1, 5, 7};
    }

    if (rq == n - 1 && cq == 0) {
      availableAttacks = new int[]{3, 4, 7};
    }

    if (rq == n - 1 && cq == n - 1) {
      availableAttacks = new int[]{2, 4, 6};
    }

    if (rq == 0 && cq == n - 1) {
      availableAttacks = new int[]{0, 5, 6};
    }

    if (rq > 0 && rq < n - 1 && cq == n - 1) {
      availableAttacks = new int[]{0, 2, 4, 5, 6};
    }

    if (rq == n - 1 && cq > 0 && cq < n - 1) {
      availableAttacks = new int[]{2, 3, 4, 6, 7};
    }

    if (rq > 0 && rq < n - 1 && cq == 0) {
      availableAttacks = new int[]{1, 3, 4, 5, 7};
    }

    if (rq == 0 && cq > 0 && cq < n - 1) {
      availableAttacks = new int[]{0, 1, 5, 6, 7};
    }

    int count = 0;
    for (int attack : availableAttacks) {
      // Upper Left Corner
      if (attack == 0) {
        for (int j = rq + 1, l = cq - 1; j <= n && l >= 0; j++, l--) {
          if (j == n || l < 0) {
            break;
          }
          if (board[j][l] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Upper Right Corner
      if (attack == 1) {
        for (int j = rq + 1, l = cq + 1; j <= n && l <= n; j++, l++) {
          if (j == n || l == n) {
            break;
          }
          if (board[j][l] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Lower Left Corner
      if (attack == 2) {
        for (int j = rq - 1, l = cq - 1; j >= 0 && l >= 0; j--, l--) {
          if (j < 0 || l < 0) {
            break;
          }
          if (board[j][l] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Lower Right Corner
      if (attack == 3) {
        for (int j = rq - 1, l = cq + 1; j >= 0 && l <= n; j--, l++) {
          if (j < 0 || l == n) {
            break;
          }
          if (board[j][l] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Straight Down
      if (attack == 4) {
        for (int j = rq - 1; j >= 0; j--) {
          if (j < 0) {
            break;
          }
          if (board[j][cq] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Straight Up
      if (attack == 5) {
        for (int j = rq + 1; j <= n; j++) {
          if (j == n) {
            break;
          }
          if (board[j][cq] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Straight Left
      if (attack == 6) {
        for (int j = cq - 1; j >= 0; j--) {
          if (j < 0) {
            break;
          }
          if (board[rq][j] == 1) {
            break;
          }
          count++;
        }
        continue;
      }

      // Straight Right
      if (attack == 7) {
        for (int j = cq + 1; j <= n; j++) {
          if (j == n) {
            break;
          }
          if (board[rq][j] == 1) {
            break;
          }
          count++;
        }
      }
    }

    System.out.println(count);

    in.close();
  }
}
