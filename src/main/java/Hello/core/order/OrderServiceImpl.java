package Hello.core.order;

import Hello.core.annotation.MainDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.order.Order;

import Hello.core.discount.DiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemoryMemberRepository;
import Hello.core.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
    public  MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
