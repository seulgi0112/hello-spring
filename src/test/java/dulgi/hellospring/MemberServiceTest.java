package dulgi.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemberServiceImpl;
import dulgi.hellospring.member.MemoryMemberRepository;

class MemberServiceTest {

	MemberServiceImpl memberService;
	MemoryMemberRepository memberRepository;
	
	//Test �޼ҵ� ���� ��
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberServiceImpl(memberRepository);
	}
	//Test �޼ҵ� ���� ��
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	//ȸ������
	@Test
	public void join() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberRepository.findById(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}
	//�ߺ�ȸ������
	@Test
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
		
		assertEquals(e.getMessage(), "�̹� �����ϴ� ȸ���̾�");
	}

}
