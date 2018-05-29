package pl.edu.wszib.command.customer.get;

import pl.edu.wszib.command.Command;

public class GetCustomerCommand implements Command {

    private int id;

    public GetCustomerCommand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
