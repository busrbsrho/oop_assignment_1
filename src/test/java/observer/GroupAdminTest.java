package observer;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {


    @Test
    void register() {
        GroupAdmin g = new GroupAdmin();
        UndoableStringBuilder usb=new UndoableStringBuilder();
        ConcreteMember m = new ConcreteMember();
        ConcreteMember m_1 = new ConcreteMember();
        g.register(m);
        g.register(m_1);
        assertEquals(true ,g.contains(m)&&g.contains(m_1) );
    }

    @Test
    void unregister() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        ConcreteMember falseobject=new ConcreteMember();
        g.register(m);
        g.unregister(m);
        assertEquals(false,g.contains(m));
        assertEquals(false,g.contains(falseobject));
    }

    @Test
    void notifyMembers() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        g.register(m);
        assertEquals(false,g.getNotified());
        g.notifyMembers();
        assertEquals(true,g.getNotified());


    }

    @Test
    void insert() {

        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        g.register(m);
        g.insert(0,"inserted");
        assertEquals("inserted",g.state());

    }

    @Test
    void append() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        g.register(m);
        g.append("append");
        assertEquals("append",g.state());
    }

    @Test
    void delete() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        g.register(m);
        g.append("append");
        assertEquals("append",g.state());
        g.delete(0,3);
        assertEquals("end",g.state());
    }

    @Test
    void undo() {
        GroupAdmin g = new GroupAdmin();
        ConcreteMember m = new ConcreteMember();
        g.register(m);
        g.append("append");
        g.delete(0,3);
        g.undo();
        assertEquals("append",g.state());
        g.append("2345");
        assertEquals("append2345",g.state());

    }


}