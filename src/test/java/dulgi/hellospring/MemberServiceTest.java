package dulgi.hellospring;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemoryMemberRepository;
import dulgi.hellospring.member.MemberService;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	@Test
	public void joinMember() throws Exception {
		//Given
		Member member = new Member();
		member.setName("hello");
		//When
		Long saveId = memberService.join(member);
		//Then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}
	@Test
	public void duplicateMember() throws Exception {
		//Given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");
		//When
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("Already used member name.");
	}

}
