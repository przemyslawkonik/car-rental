package pl.edu.wszib.command.customer.get;

import org.springframework.data.domain.Pageable;
import pl.edu.wszib.command.Command;

public class GetPageableCustomerListCommand implements Command {

    private Pageable pageable;

    public GetPageableCustomerListCommand(Pageable pageable) {
        this.pageable = pageable;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
