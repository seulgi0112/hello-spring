package dulgi.hellospring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dulgi.hellospring.member.JdbcMemberRepository;
import dulgi.hellospring.member.MemberRepository;
import dulgi.hellospring.member.MemberService;
import dulgi.hellospring.member.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	 public SpringConfig(DataSource dataSource) {
		 this.dataSource = dataSource;
	 }
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
	
}
