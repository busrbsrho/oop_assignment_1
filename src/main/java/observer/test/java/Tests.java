package observer.test.java;

import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.JvmUtilities;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){

        ConcreteMember member_1=new ConcreteMember();
        ConcreteMember member_2=new ConcreteMember();
        ConcreteMember member_3=new ConcreteMember();
        System.out.println("checking the ConcreteMembers Footprints\n");
        logger.info(()-> JvmUtilities.objectFootprint(member_1,member_2,member_3));
        System.out.println("checking the ConcreteMembers total size");
        logger.info(()->JvmUtilities.objectTotalSize(member_1,member_2,member_3));


        GroupAdmin g=new GroupAdmin();
        g.register(member_1);
        g.register(member_2);
        g.register(member_3);
        System.out.println("\nchecking the Group admin's Footprint and total size \n tptal size:");
        logger.info(()->JvmUtilities.objectTotalSize(g));
        System.out.println("foot prints:");
        logger.info(()-> JvmUtilities.objectFootprint(g));

        g.append("siu");
        System.out.println("\nchecking foot prints of the members after the update of the append");
        logger.info(()-> JvmUtilities.objectFootprint(member_1,member_2,member_3));
        System.out.println("\nchecking the ConcreteMembers total size after the update of the append");
        logger.info(()->JvmUtilities.objectTotalSize(member_1,member_2,member_3));
        System.out.println("\nchecking the Group admin's Footprint and total size after the update of the append \n total size:");
        logger.info(()->JvmUtilities.objectTotalSize(g));
        logger.info(()-> JvmUtilities.objectFootprint(g));

        g.unregister(member_1);
        g.unregister(member_2);
        g.unregister(member_3);

        System.out.println("\nchecking the Group admin's Footprint and total size after the unregistered members \n total size:");
        logger.info(()->JvmUtilities.objectTotalSize(g));
        logger.info(()-> JvmUtilities.objectFootprint(g));


//        logger.info(()->JvmUtilities.objectFootprint(s1,s2));
//
//        logger.info(()->JvmUtilities.objectTotalSize(s1));




        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
