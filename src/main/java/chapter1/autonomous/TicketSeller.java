package chapter1.autonomous;


/**
 * 티켓 판매원
 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /**
     * 관객에게 티켓을 판매한다.
     */
    public void sellTo(Audience audience) {
        // 관객이 Bag을 가졌는지 묻지 않는다.
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));

//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }

    }
}
