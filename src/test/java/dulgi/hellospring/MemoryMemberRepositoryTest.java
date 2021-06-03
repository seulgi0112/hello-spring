package dulgi.hellospring;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import dulgi.hellospring.member.Member;
import dulgi.hellospring.member.MemoryMemberRepository;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	 public void afterEach() {
		repository.clearStore();
	 }
	
	@Test
	void save() {
		//given
		Member member = new Member();
		member.setName("hello");
		//when
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		//then
		Assertions.assertThat(result).isEqualTo(member);
	}
	
	@Test
	void findByName() {
		//given
		Member member1 = new Member();
		member1.setName("hello1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("hello2");
		repository.save(member2);
		
		//when
		Member result = repository.findByName("hello2").get();
		
		//then
		Assertions.assertThat(result).isEqualTo(member2);
		
	}
	
	@Test
	void findAll() {
		//given
		Member member1 = new Member();
		member1.setName("hello1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("hello2");
		repository.save(member2);
		
		//when
		List<Member> result = repository.findAll();
		
		//then
		Assertions.assertThat(result.size()).isEqualTo(2);
	}

}
