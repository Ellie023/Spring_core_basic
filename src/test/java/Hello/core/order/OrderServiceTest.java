package Hello.core.order;

import Hello.core.AppConfig;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Hello.core.member.Grade.VIP;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long memberId=1L;
        Member member = new Member(memberId,"memberA",VIP);
        memberService.join(member);

        Order order =orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
