package chapter1.highlycoupled;

/**
 * 판매원은 매표소에서 초대장을 티켓으로 교환하거나
 * 티켓을 판매한다.
 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
