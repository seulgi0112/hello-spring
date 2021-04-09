package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
	public Long join(Member member);
	public void validateDuplicateMember(Member member);
	public List<Member> findMembers();
	public Optional<Member> findOne(Long memberId);
	
}
