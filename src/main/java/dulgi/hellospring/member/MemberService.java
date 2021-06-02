package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemberRepository;

/*
 * 해당클래스가 시작할때 Transaction시작
 * 메서드가 종료되면 Transaction 종료
 */
@Transactional
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
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}
	
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
