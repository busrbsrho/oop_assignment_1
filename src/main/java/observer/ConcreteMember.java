package observer;



import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Stack;




public class ConcreteMember implements Member {
    private UndoableStringBuilder usb_2;
    public ConcreteMember()
    {
        this.usb_2=new UndoableStringBuilder();
    }



    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb_2=usb;
    }


    public UndoableStringBuilder currentState(){
        return this.usb_2;
    }


}



