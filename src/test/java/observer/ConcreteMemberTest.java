package observer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        ConcreteMember member= new ConcreteMember();
        GroupAdmin g= new GroupAdmin();
        UndoableStringBuilder usb=new UndoableStringBuilder();
        usb.append("bro");
        member.update(usb);
        assertEquals(usb,member.currentState());
        usb.append("bro2");
        assertEquals(usb,member.currentState());
    }
}