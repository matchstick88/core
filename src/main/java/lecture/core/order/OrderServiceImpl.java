package lecture.core.order;

import lecture.core.discount.DiscountPolicy;
import lecture.core.discount.FixDiscountPolicy;
import lecture.core.discount.RateDiscountPolicy;
import lecture.core.member.Member;
import lecture.core.member.MemberRepository;
import lecture.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //DIP 위반
    private final DiscountPolicy discountPolicy; //DIP 지킴

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
