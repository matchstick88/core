package lecture.core;

import lecture.core.member.Grade;
import lecture.core.member.Member;
import lecture.core.member.MemberService;
import lecture.core.member.MemberServiceImpl;
import lecture.core.order.Order;
import lecture.core.order.OrderService;
import lecture.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new  Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
