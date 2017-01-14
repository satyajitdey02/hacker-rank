package com.hackerrank.datastructures.queues;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by satyajit on 1/14/17.
 */
public class QueueUsingTwoStacks<I> {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    Queue<Integer> queue = new Queue<Integer>();
    while (N-- > 0) {
      int q = in.nextInt();
      if (q == 1) {
        int x = in.nextInt();
        queue.enqueue(x);
        continue;
      }

      if (q == 2) {
        queue.dequeue();
        continue;
      }

      if (q == 3) {
        System.out.println(queue.front());
      }
    }
    in.close();
  }


  static class Queue<Integer> {
    private Stack<Integer> inbox = new Stack<Integer>();
    private Stack<Integer> outbox = new Stack<Integer>();

    public Queue() {

    }

    public void enqueue(Integer item) {
      inbox.push(item);
    }

    public Integer dequeue() {
      pourInboxToOutbox();
      return outbox.pop();
    }

    public Integer front() {
      pourInboxToOutbox();
      return outbox.peek();
    }

    public int size() {
      return inbox.size() + outbox.size();
    }

    public boolean isEmpty() {
      return inbox.isEmpty() && outbox.isEmpty();
    }

    private void pourInboxToOutbox() {
      if (outbox.isEmpty()) {
        while (!inbox.isEmpty()) {
          outbox.push(inbox.pop());
        }
      }
    }
  }
}

