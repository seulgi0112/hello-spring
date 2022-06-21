package dulgi.hellospring.member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//SpringData JPA
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	Optional<Member> findByName(String name);
	Member save(Member member);
}
