import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import ucu.edu.ua.visitor.Group;
import ucu.edu.ua.visitor.Signature;
import ucu.edu.ua.visitor.StampingAPI;
import ucu.edu.ua.visitor.Task;


public class VisitorTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testGroupApply() {
        Group<String> group = new Group<>();
        @SuppressWarnings({ "rawtypes" })
        Signature task1 = new Signature(s -> {});
        @SuppressWarnings({ "rawtypes" })
        Signature task2 = new Signature(s -> {});
        group.addTask(task1).addTask(task2);

        group.apply("TestArg");

        assertNotNull(group.getId());
        assertNotNull(task1.getId());
        assertNotNull(task2.getId());
        assertEquals(group.getHeader("groupUUID"), task1.getHeader("groupUUID"));
        assertEquals(group.getHeader("groupUUID"), task2.getHeader("groupUUID"));
    }
    @Test
    public void testSignatureApply() {
        Signature<String> signature = new Signature<>(s -> {});
        signature.apply("TestArg");

        assertNotNull(signature.getId());
    }
    @Test
    public void testVisit() {
        String groupUUID = "test-group-uuid";
        StampingAPI stampingAPI = new StampingAPI(groupUUID);
        Task<String> task = new Signature<>(s -> {});

        stampingAPI.visit(task);

        assertEquals(groupUUID, task.getHeader("groupUUID"));
    }
}