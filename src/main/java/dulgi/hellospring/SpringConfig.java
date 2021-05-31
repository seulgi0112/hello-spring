package dulgi.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dulgi.hellospring.member.MemberRepository;
import dulgi.hellospring.member.MemberService;
import dulgi.hellospring.member.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
}
