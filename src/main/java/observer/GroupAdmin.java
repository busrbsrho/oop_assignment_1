package observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class GroupAdmin implements Sender {
    private ArrayList <Member> myMembers=new ArrayList<>();
    private boolean isNotified=false;
    private UndoableStringBuilder u= new UndoableStringBuilder();


    @Override
    public void register(Member obj) {
        this.myMembers.add(obj);

    }

    @Override
    public void unregister(Member obj) {
        this.myMembers.remove(obj);

    }

    public void notifyMembers(){
        isNotified=true;
        for (Member m : this.myMembers)
        {
            m.update(u);

        }
    }

    @Override
    public void insert(int offset, String obj) {
        this.u.insert(offset,obj);
        notifyMembers();



    }

    @Override
    public void append(String obj) {
        this.u.append(obj);
        notifyMembers();

    }

    @Override
    public void delete(int start, int end) {
        this.u.delete(start,end);
        notifyMembers();
    }

    @Override
    public void undo() {
        this.u.undo();
        notifyMembers();

    }

    public List<Member> getMyMembers()
    {
        return myMembers;

    }
    public String  state()
    {
       return u.toString();
    }
    public String toString()
    {
        return myMembers.toString();
    }
    public boolean contains(ConcreteMember obj)
    {
        if (myMembers.contains(obj))
        {
            return true;
        }
        return false;
    }
    public boolean getNotified()
    {
        return isNotified;
    }

    public static void main(String[] args) {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m=new ConcreteMember();
        g.register(m);
        System.out.println(g.toString());
        System.out.println(" now state is : \n");
        g.state();
    }
}
