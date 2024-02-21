package singlylinkedlist;

import java.util.Scanner;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    int size = 0;
    Node head;
    Node tail;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void InsertAtBeg(int data) {
        // khởi tạo 1 nút mới
        Node newNode = new Node(data);
        //nếu danh sách trống thì cập nhập head trỏ về nút
        if (head == null) {
            head = newNode;
        } else {
            // liên kết phần pointer của nút mới tới giá trị head
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void InsertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void insertAtEnd2(int data) {
        Node newNode = new Node(data);
        // Kiểm tra xem danh sách liên kết có rỗng không
        if (head == null) {
            //cập nhập head và tail cùng trỏ đến nút đầu tiên
            head = tail = newNode;
        } else {
            //liên kết tail với nút mới 
            tail.next = newNode;
            //chuyển vị trí trỏ tail trỏ tới nút mới
            tail = newNode;
        }
        size++;
    }

    public void DeleteAtBeg() {
        //kiểm tra xem trong danh sách có rỗng không
        if (head == null) {
            System.out.print("Mảng rỗng");
            return;
        }
        //tạo 1 trỏ mới trỏ với cùng địa chỉ với trỏ head
        Node current = head;
        //di chuyển head trỏ tới nút tiếp theo
        head = head.next;
        //ngắt đi liên kết giữa nút current đang trỏ tới và nút head đang trỏ tới 
        current.next = null;
    }

    public void DeleteAtEnd() {
        if (head == null) {
            System.out.print("Mảng rỗng");
            return;
        }
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        //kiểm tra chỉ có 1 node trong danh sách
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
    }

    public void DeleteAtEnd2() {
        if (head == null) {
            System.out.print("Mảng rỗng ");
            return;
        }
        Node current = head;
        if (current.next == null) {
            head = null;
            return;
        }
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void display() {
        Node currentNode;
        if (head == null) {
            System.out.println("Null");
        }
        currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");

            currentNode = currentNode.next;
        }
    }

    public void Count() {
        Node current;
        int count = 0;
        if (head == null) {
            System.out.println("Null");
        }
        current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("\nSố phần tử của danh sách: " + count);
    }

    public void insertPosition(int pos, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        // kiểm tra vị trí hợp lệ, size tăng lên mỗi khi add thêm 1 nút vào danh sách
        if (pos < 1 || pos > size + 1) {
            System.out.println("\nInvalid");
        } // nếu vị trí cần thêm vào là 1, giống add to head
        else if (pos == 1) {
            new_node.next = head;
            head = new_node;
            size++; // cập nhập số lượng nút trong danh sách
        } else {
            Node temp = head;
            // duyệt danh sách đến bằng cách giảm dần giá trị vị trí đến khi = 1
            while (--pos > 1) {
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
            size++;
        }
    }

    public void AddAfter(Node p, int x) {
        //tạo trỏ tới giá trị nút mới
        Node q = new Node(x);
        //tạo liên kết giữa nút mới với nút sau
        q.next = p.next;
        //tạo liên kết giữa nút mới và nút trước 
        p.next = q;
    }

    public void Dele(int i) {
        //kiểm tra vị trí hợp lệ, 
        if (i < 1 || i > size) {
            System.out.println("Invalid");
            return;
        }
        if (i == 1) {
            head = head.next;
        } else {
            Node current = head;
            Node previous = null;
            //di chuyển đến trước nút cần xoá
            for (int j = 0; j < i - 1; j++) {
                previous = current;
                current = current.next;
            }
            //tạo liên kết từ nút trước nút cần xoá đến nút sau nút cần xoá
            previous.next = current.next;
        }

        size--; // giảm số lượng nút trong danh sách đi sau khi xoá
    }

    public int max() {
        // Kiểm tra xem danh sách có rỗng không
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE; //  biểu diễn danh sách rỗng
        }
        // Khởi tạo giá trị lớn nhất với giá trị của nút đầu tiên
        int max = head.data;
        // Bắt đầu từ nút thứ hai trong danh sách
        Node current = head.next;
        // Duyệt qua danh sách để tìm giá trị lớn nhất
        while (current != null) {
            // Cập nhật giá trị lớn nhất nếu tìm thấy giá trị mới lớn hơn
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("\nMax: " + max);
        return max;
    }

    public int min() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MAX_VALUE; // Giả sử giá trị nguyên tối đa biểu diễn danh sách rỗng
        }

        int min = head.data;
        Node current = head.next;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("Min: "+min);
        return min;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        // Node p = Integer.parseInt(x);
        //thêm 1 nút vào đầu danh sách
        // SinglyLinkedList second = new SinglyLinkedList(1);
        // SinglyLinkedList third = new SinglyLinkedList(8);
        // SinglyLinkedList fourth = new SinglyLinkedList(11);
// 
        sll.InsertAtBeg(4);
        sll.InsertAtBeg(3);
        sll.InsertAtBeg(8);
        sll.InsertAtBeg(0);
        sll.InsertAtEnd(7);
        //sll.DeleteAtEnd();
        /* sll.DeleteAtBeg();
        sll.DeleteAtBeg();
        sll.DeleteAtBeg();
        sll.DeleteAtBeg();
       // sll.DeleteAtEnd2();*/
        sll.insertPosition(6, 9);
        Node p = sll.head;
        /*for (int i = 0; i < 2 && p != null; i++) {
            p = p.next; 
        }*/
        sll.AddAfter(p, 22);
        sll.display();
        sll.max();
        sll.min();
        sll.Count();
    }

}
