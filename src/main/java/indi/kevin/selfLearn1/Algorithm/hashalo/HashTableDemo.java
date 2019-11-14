package indi.kevin.selfLearn1.Algorithm.hashalo;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1:add");
            System.out.println("2:list");
            System.out.println("3:exit");
            System.out.println("4:find");
            System.out.println("5:delete");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println("input id");
                    int id = scanner.nextInt();
                    System.out.println("input name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "2":
                    hashTab.listAll();
                    break;
                case "3":
                    scanner.close();
                    System.exit(0);
                case "4":
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case "5":
                    int delId = scanner.nextInt();
                    hashTab.delete(delId);
                    break;
                default:
                    break;
            }
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class HashTab {
    private int size;
    private EmpLinkedList[] empLinkedListArray;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinListNo = hashMemo(emp.id);
        empLinkedListArray[empLinListNo].add(emp);
    }

    public void delete(int id) {
        int empLinListNo = hashMemo(id);
        empLinkedListArray[empLinListNo].deleteById(id);
    }

    public void listAll() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].listEmp(i);
        }
    }

    public void findEmpById(int id) {
        int empLinListNo = hashMemo(id);
        Emp emp = empLinkedListArray[empLinListNo].findEmpById(id);
        if (emp != null) {
            System.out.println("find employee at: " + empLinListNo);
        } else {
            System.out.println("not find this employee");
        }

    }

    public int hashMemo(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        } else {
            //add to the last position of the linked list
            Emp currentEmp = head;
            while (true) {
                if (currentEmp.next == null) {
                    break;
                }
                currentEmp = currentEmp.next;
            }
            currentEmp.next = emp;
        }
    }

    public void listEmp(int no) {
        if (head == null) {
            System.out.println(no + ": current linkedlist is empty");
            return;
        }
        System.out.print(no + ": current linkedlist is");
        Emp currentEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", currentEmp.id, currentEmp.name);
            if (currentEmp.next == null) {
                break;
            }
            currentEmp = currentEmp.next;
        }
        System.out.println();
    }

    public void deleteById(int id) {
        if (head == null) {
            System.out.println("empty linkedlist");
            return;
        }
        if (head.id == id) {
            head = head.next;
            return;
        }
        Emp currentEmp = head.next;
        Emp preEmp = head;
        while (true) {
            if (currentEmp.id == id) {
                if (currentEmp.next != null) {
                    preEmp.next = currentEmp.next;
                } else {
                    preEmp.next = null;
                }
                break;
            } else {
                if (currentEmp.next != null) {
                    preEmp = currentEmp;
                    currentEmp = currentEmp.next;
                } else {
                    break;
                }
            }
        }

    }

    public Emp findEmpById(int id) {

        if (head == null) {
            System.out.println("empty linkedlist");
            return null;
        }
        Emp currentEmp = head;
        while (true) {
            if (currentEmp.id == id) {
                break;
            }
            if (currentEmp.next == null) {
                currentEmp = null;
                break;
            }
            currentEmp = currentEmp.next;
        }
        return currentEmp;
    }
}