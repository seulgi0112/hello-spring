package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

	Member save(Member member);
	//Optional -> null�� ��ȯ�Ҷ�
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
