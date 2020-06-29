package com.metis.base.jdk8.stream;

public class Main {

    /**
     * 这篇文章有比较清楚的stream详解
     *
     * @link https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
     */
    public static void main(String[] args) {
//        List<Transaction> groceryTransactions = new Arraylist<>();
//        for (Transaction t : transactions) {
//            if (t.getType() == Transaction.GROCERY) {
//                groceryTransactions.add(t);
//            }
//        }
//        Collections.sort(groceryTransactions, new Comparator() {
//            public int compare(Transaction t1, Transaction t2) {
//                return t2.getValue().compareTo(t1.getValue());
//            }
//        });
//        List<Integer> transactionIds = new ArrayList<>();
//        for (Transaction t : groceryTransactions) {
//            transactionsIds.add(t.getId());
//        }


//        List<Integer> transactionsIds = transactions.parallelStream()
//                .filter(t -> t.getType() == Transaction.GROCERY)
//                .sorted(comparing(Transaction::getValue).reversed())
//                .map(Transaction::getId)
//                .collect(toList());
    }
}
