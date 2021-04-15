package dulgi.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemberServiceImpl;
import dulgi.hellospring.member.MemoryMemberRepository;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

class MemberServiceTest {

	MemberServiceImpl memberService;
	MemoryMemberRepository memberRepository;
	
	//Test 메소드 실행 전
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberServiceImpl(memberRepository);
	}
	//Test 메소드 실행 후
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	//회원가입
	@Test
	public void join() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberRepository.findById(member.getId()).get();
		assertEquals(member.getName(), findMember.getName());
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());	//assertEquals와 동일
	}
	//중복회원예외
	@IgnoreForBinding
	public void dupCheck() {
		//given
		String name = "user";
		
		Member member1 = new Member();
		member1.setName(name);
		
		Member member2 = new Member();
		member2.setName(name);
		
		//when
		memberService.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");
	}

}
