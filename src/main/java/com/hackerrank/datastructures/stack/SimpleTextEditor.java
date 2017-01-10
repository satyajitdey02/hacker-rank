package com.hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by satyajit on 1/10/17.
 */
public class SimpleTextEditor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int Q = in.nextInt();
    if (Q == 0) {
      return;
    }

    Stack<Command> commandStack = new Stack<Command>();
    StringBuilder S = new StringBuilder();
    while (Q-- > 0) {
      int op = in.nextInt();
      if (op == 1) {
        String data = in.next();
        S.append(data);
        commandStack.push(new Command(op, data));
        continue;
      }

      if (op == 2) {
        int k = in.nextInt();
        if (k > S.length()) {
          return;
        }

        String data = S.substring(S.length() - k, S.length());
        S.delete(S.length() - k, S.length());
        commandStack.push(new Command(op, data));
        continue;
      }

      if (op == 3) {
        int k = in.nextInt();
        if (k > S.length()) {
          return;
        }
        System.out.println(S.charAt(k - 1));
        continue;
      }

      if (op == 4) {
        Command lastCommand = commandStack.pop();
        int lastOp = lastCommand.op;
        String lastOpData = lastCommand.data;
        if (lastOp == 1) {
          S.setLength(S.length() - lastOpData.length());
          continue;
        }

        if (lastOp == 2) {
          S.append(lastOpData);
        }
      }

    }
    in.close();
  }

  static class Command {
    int op;
    String data;

    public Command(int op, String data) {
      this.op = op;
      this.data = data;
    }
  }
}
