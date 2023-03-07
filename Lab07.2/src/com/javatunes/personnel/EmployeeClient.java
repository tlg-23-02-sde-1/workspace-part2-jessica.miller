package com.javatunes.personnel;

class EmployeeClient {

    public static void main(String[] args) {
        Employee emp = new Employee();
        long begin = System.nanoTime();
        emp.work();
        long end = System.nanoTime();
        long begin1 = System.nanoTime();
        emp.pay();
        long end1 = System.nanoTime();

        double elapsedMillis = (end - begin) / 1_000_000.0;
        double elapsedMillis1 = (end1 - begin1) / 1_000_000.0;
        System.out.println(elapsedMillis);
        System.out.println(elapsedMillis1);
    }

}