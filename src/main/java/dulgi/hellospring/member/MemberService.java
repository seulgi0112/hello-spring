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

	/*
	 * public Long join(Member member) 
	 * { 
	 * validateDuplicateMember(member);
	 * memberRepository.save(member); 
	 * return member.getId(); 
	 * }
	 */
	// 시간 측정 추가(AOP)
	public Long join(Member member) {
		long start = System.currentTimeMillis();
		try {
			validateDuplicateMember(member); // 중복 회원 검증
			memberRepository.save(member);
			return member.getId();
		}
		finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("join " + timeMs + "ms");
		}
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	
	/*
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	 */
	//시간 측정 추가(AOP)
	public List<Member> findMembers() {
		 long start = System.currentTimeMillis();
		 try {
			 return memberRepository.findAll();
		 } 
		 finally {
			 long finish = System.currentTimeMillis();
			 long timeMs = finish - start;
			 System.out.println("findMembers " + timeMs + "ms");
		}
	}
	
	
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
