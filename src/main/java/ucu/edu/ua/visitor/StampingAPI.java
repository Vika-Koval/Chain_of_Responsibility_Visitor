package ucu.edu.ua.visitor;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StampingAPI implements Visitor {
    private String groupUUID;
    @Override
    public void visit(Task<?> task) {
        task.setHeader("groupUUID", groupUUID);
    }
}