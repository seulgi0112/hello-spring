package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemberRepository;

/*
 * �ش�Ŭ������ �����Ҷ� Transaction����
 * �޼��尡 ����Ǹ� Transaction ����
 */
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	// �ð� ���� �߰�(AOP)
	public Long join(Member member) {
			validateDuplicateMember(member); // 중복 회원 검증
			memberRepository.save(member);
			return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(
				member.getName()).ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
	}
	

	//�ð� ���� �߰�(AOP)
	public List<Member> findMembers() {
			 return memberRepository.findAll();
	}
	
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
