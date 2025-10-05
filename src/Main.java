public class Main {
    public static void main(String[] args) {
        MyLL<Integer> myList=new MyLL<>();

//        myList.add(0,0);
//        myList.add(1,1);
//        myList.add(2,2);
//        myList.add(3,3);
//        myList.add(4,4);
//        myList.add(5,5);
        myList.addFirst(100);
        myList.addFirst(90);
        myList.addFirst(80);//90,80,100
        myList.display();

        // myList.removeLast();
        //myList.addFirst(1);
        //myList.removeLast();
//        myList.replaceAll(2,2);
//        System.out.println(myList.removeFirstOccurrence(1));
        //myList.display();

    }
}