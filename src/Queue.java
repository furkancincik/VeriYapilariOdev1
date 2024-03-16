import java.util.NoSuchElementException;

public class Queue {
    // Node sınıfını Queue sınıfının içinde tanımlıyoruz cünkü sadece burada kullanılacak

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int peek() {
        if (front == null) {
            throw new NoSuchElementException("Kuyruk boş, peek işlemi yapılamaz.");
        }
        return front.data;
    }


    // Kuyruğa yeni bir eleman ekleme metotu
    public void addQueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Kuyruktan eleman silme
    public void deleteQueue(int data) {
        if (front == null) {
            System.out.println("Sıra boş !");
            return;
        } else {
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
    }



    // Kuyruktaki elemanları yazdırmak için metot
    public void printQueue(){
        Node current=front;
        if (front==null){
            System.out.println("Sıra boş !");
            return;
        }else {
            System.out.println("Sıradaki Eleman :");
            while (current != null){
                System.out.println(current.data+" ");
                current=current.next;
            }
            System.out.println();
        }
    }



}
