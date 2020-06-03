package chapter1.autonomous;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    // private 으로 캡슐화
    private  Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // private 으로 캡슐화
    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    // TicketOffice와 Audience 사이에 의존성이 추가됨
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }
}
