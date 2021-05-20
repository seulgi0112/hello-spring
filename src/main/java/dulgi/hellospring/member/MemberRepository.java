package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

	Member save(Member member);
	//Optional -> nullpoint exception을 막아준다
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
