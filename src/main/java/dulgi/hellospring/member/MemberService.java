package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;


import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemberRepository;

public class MemberService {

	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Long join(Member member) {
		validateDuplicateMember(member); 
		memberRepository.save(member);
		return member.getId();
	}
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
				});
	}
	
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
