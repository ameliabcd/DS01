public class Main {
    public static void main(String[] args) {
        MyLL<Integer> myList=new MyLL<>();

        myList.add(0,-1);
        myList.add(1,1);
        myList.add(2,2);
        myList.add(3,2);
        myList.add(4,1);
        myList.add(5,9);
        myList.addFirst(1);
        //myList.removeLast();
        myList.replaceAll(2,2);
        System.out.println(myList.removeFirstOccurrence(9));
        myList.display();

    }
}