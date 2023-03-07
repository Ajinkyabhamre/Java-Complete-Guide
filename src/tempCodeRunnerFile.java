    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= 10; i++) {
        q.add(i);
    }

    reverseQueue(q);

    while (!q.isEmpty()) {
        System.out.print(q.remove() + " ");
    }
    System.out.println();