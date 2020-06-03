package chapter1.autonomous;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // 외부의 제 3자가 자신의 가방 을 열어보도록 허용하지 않는다.
//    public Bag getBag() {
//        return bag;
//    }

    /**
     * 티켓을 구매한다.
     */
//    public Long buy(Ticket ticket) {
//        if (bag.hasInvitation()) { // Bag은 수동적인 존재이다.
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
//    }

    /**
     * Audience는 Bag의 인터페이스에만 의존한다.
     */
     public Long buy(Ticket ticket) {
         return bag.hold(ticket);
     }
}
