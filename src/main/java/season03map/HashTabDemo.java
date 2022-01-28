package season03map;

import java.util.Scanner;

/**
 * 尚硅谷java数据结构 [88 代码
 */
public class HashTabDemo {


    public static void main(String[] args) {
        //创建一个哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单菜单
        String key = "";
        Scanner scanner= new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch(key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名称");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }

}

//创建HashTable 管理多条链表
class HashTab {

    private EmpLinkedList[] empLinkedListArray;

    private int size;

    // 构造器
    public HashTab(int size){
        // 初始化empLinkedListArray
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }


    // 添加雇员
    public void add(Emp emp){
        int no = hashFun(emp.id);

        // 将emp添加到对应的链表中

        empLinkedListArray[no].add(emp);
    }


    // 遍历所有的hash表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }

    }

    // 根据输入id查找雇员
    public void findEmpById(int id){
        int no = hashFun(id);
        Emp emp = empLinkedListArray[no].findEmpById(id);
        if(emp != null){//找到
            System.out.printf("在第%d条链表中找到 雇员id = %d \r", no,id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    public int hashFun(int id){
        return id % size;
    }

}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}

// 创建一个链表
class EmpLinkedList{
    // 头指针
    private Emp head;

    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }

        Emp curEmp = head;
        // 说明到链表最后了
        while (curEmp.next != null) {
            curEmp = curEmp.next; // 后移
        }

        // 退出时直接将emp加入链表
        curEmp.next = emp;
    }

    public void list(){
        if(head == null){ // 说明链表为空
            System.out.println("当前链表为空");
            return;
        }
        System.out.print("当前链表信息为:");
        Emp curEmp = head; // 辅助指针
        while(curEmp != null){
            System.out.printf("id=%d name=%s \r", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }

            if(curEmp.next == null){
                curEmp = null;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}
































