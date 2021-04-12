package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{
	private MemberRepository memberRepository;

	//*회원 리포지토리의 코드가 회원 서비스 코드를 DI 가능하게 변경한다
	public  void MemberService(MemberRepository memberRepository) {
		 this.memberRepository =  memberRepository;
	}
	/**
	 * 회원가입
	 */
	@Override
	public Long join(Member member) {
		validateDuplicateMember(member); //중복 회원 검증
		 memberRepository.save(member);
		 return member.getId();
	}

	/**
	 * 중복가입 확인
	 */
	@Override
	public void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		 .ifPresent(m -> {
		 throw new IllegalStateException("이미 존재하는 회원입니다.");
		 });		
	}

	/**
	 * 전체회원조회
	 */
	@Override
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/**
	 * ID로 회원 조회
	 */
	@Override
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
	

}
