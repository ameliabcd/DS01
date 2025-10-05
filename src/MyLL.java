import java.lang.reflect.Array;

public class MyLL <Y>{
    Node<Y> head;
    Node<Y> tail;

    int size=0;

    public void addFirst(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Think about pointer manipulation order!
        Node<Y> newNode=new Node<>(data);
        //LL is empty
        //LL has data in it
        size++;
        if(head==null)
        {
            //create a new node object;
            head=newNode;
            tail=newNode;
        }
        else
        {
            //create a new node object;
            newNode.setNext(head);
            head=newNode;
            tail=this.getNode(this.size()-1);
        }
    }

    public void addLast(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Don't forget the empty list edge case!
        Node<Y> newNode=new Node<>(data);
        tail=this.getNode(this.size()-1);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;

    }

    public boolean add(int index, Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Be careful with index bounds and pointer order!
        Node<Y> newNode=new Node<>(data);
        if(index>this.size())
        {
            return false;
        }
        if(index==0)
        {
            this.addFirst(data);
//            tail=this.getNode(size()-1);
            return true;
        }
        if(index==this.size())
        {
            this.addLast(data);
            return true;
        }

        Node<Y> beforeNode=this.getNode(index-1);
        Node<Y> afterNode=this.getNode(index);;

        beforeNode.setNext(newNode);
        newNode.setNext(afterNode);
        size++;
        tail=this.getNode(size()-1);
        return true;
    }

    public Y removeFirst() {
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
        if(head==null)
        {
            return null;
        }
        Node<Y> oldhead=head;
        if(this.size()>1)
        {
            head=head.getNext();
            size--;
            return oldhead.getData();
        }
        else
        {
            size--;
            this.clear();
            return oldhead.getData();
        }

    }

    public Y removeLast() {
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
        if(head==null)
        {
            return null;
        }
        Node<Y> newtail=this.getNode(this.size()-2);
        Node<Y> oldtail=tail;
        tail=newtail;
        if(this.size()>1)
        {
            newtail.setNext(null);
            size--;
            return oldtail.getData();
        }
        else
        {
            size--;
            this.clear();
            return oldtail.getData();
        }
    }

    public boolean remove(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: You need the node BEFORE the one you're removing!
        if(!this.contains(data))
            return false;
        for(int i=0;i<this.size();i++)
        {
            if(this.get(i).equals(data))
            {
                if(i==0)
                {
                    removeFirst();
                }
                else if(i==this.size()-1)
                {
                    removeLast();
                }
                else
                {
                    this.getNode(i-1).setNext(getNode(i+1));
                    size--;
                }
                i--;
            }
        }
        return true;
    }

    public boolean removeFirstOccurrence(Y data) {
        // TODO: Implement this method - replace object with generic
        for(int i=0;i<this.size();i++)
        {
            if(this.get(i).equals(data))
            {
                if(i==0)
                {
                    removeFirst();
                    return true;
                }
                if(i==this.size()-1)
                {
                    removeLast();
                    return true;
                }
                this.getNode(i-1).setNext(this.getNode(i+1));
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeLastOccurrence(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the previous node of the last occurrence found

        for(int i=this.size()-1;i>=0;i--)
        {
            if(this.get(i).equals(data))
            {
                if(i==this.size()-1)
                {
                    removeLast();
                    return true;
                }
                if(i==0)
                {
                    removeFirst();
                    return true;
                }

                this.getNode(i-1).setNext(this.getNode(i+1));
                size--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        // TODO: Implement this method
        head=null;
        tail=null;
        size=0;
    }


    public Y get(int index) {
        // TODO: Implement this method - replace object with generic
        // Hint: Use a loop counter to traverse the right number of steps
        if(head==null)
        {
            return null;
        }
        return this.getNode(index).getData();
    }

    public Node<Y> getNode(int index) { //possible problems
        // TODO: Implement this method - replace object with generic
        // Hint: Use a loop counter to traverse the right number of steps
        Node<Y> find = head;
        if(head==null)
            return null;
        if(index>this.size()-1 || index<0)
        {
            return null;
        }
        for(int i=0;i<index;i++)
        {
            find=find.getNext();
        }

        return find;
    }

    public Y getFirst() {
        // TODO: Implement this method - replace object with generic
        // Hint: Check if list is empty first!
        if(head==null)
            return null;
        return head.getData();
    }


    public Y getLast() {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse to the end or use tail pointer if available
        if(head==null)
            return null;
        return tail.getData();
    }


    public boolean contains(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse the entire list checking each node's data
        if(head==null)
        {
            return false;
        }
        Node<Y> current=head;
        if(head.getData().equals(data))
            return true;
        for(int i=0;i<this.size();i++)
        {
            if(current.getData().equals(data))
                return true;
            current=current.getNext();
        }
        return false;
    }

    public int indexOf(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Keep track of current index while traversing
        // Return -1 if not found
        Node<Y> current=head;
        if(head==null)
            return -1;
        if(head.getData().equals(data))
            return 0;
        for(int i=0;i<this.size();i++)
        {
            if(current.getData().equals(data))
                return i;
            current=current.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the last found index during traversal
        for(int i=this.size()-1;i>=0;i--)
        {
            if(this.get(i).equals(data))
                return i;
        }
        return -1;
    }

    public Y set(int index, Y data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Similar to get(), but replace the data
        // Returns old value
        if(index>this.size()-1)
            return null;
        Y old=this.get(index);
        this.getNode(index).setData(data);
        return old;

    }

    public void replaceAll(Y oldValue, Y newValue) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse and replace all instances of old value with new
        Node<Y> current=head;
        if(head==null)
            return;
        if(head.getData().equals(oldValue))
            head.setData(newValue);
        for(int i=0;i<this.size();i++)
        {
            if(current.getData().equals(oldValue))
                current.setData(newValue);
            current=current.getNext();
        }
    }

    public int size() {
        // TODO: Implement this method
        // Hint: Just return the size field!
        return size;
    }

    public boolean isEmpty() {
        // TODO: Implement this method
        // Hint: Check if size is 0 or head is null
        if(head==null)
            return true;
        return false;
    }

    public void display() {
        // TODO: Implement this method
        // Goal: Print something like "[HEAD] -> 10 -> 20 -> 30 -> [NULL]"
        String print="[HEAD] -> ";
        for(int i=0;i<this.size();i++)
        {
            print+=this.get(i)+" -> ";
        }
        print+="[NULL]";
        System.out.println(print);
    }

    public Y[] toArray() {
        // TODO: Implement this method - replace object with generic
        // Hint: Create array of size() and populate while traversing
        Object[] bl=new Object[this.size()];
        for(int i=0;i<this.size();i++)
        {
            bl[i]=this.get(i);
        }

        return (Y[]) bl;
    }


}
