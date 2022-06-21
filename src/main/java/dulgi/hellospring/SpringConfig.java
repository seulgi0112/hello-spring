package dulgi.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import dulgi.hellospring.aop.TimeTraceAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dulgi.hellospring.member.JdbcMemberRepository;
import dulgi.hellospring.member.JdbcTemplateMemberRepository;
import dulgi.hellospring.member.JpaMemberRepository;
import dulgi.hellospring.member.MemberRepository;
import dulgi.hellospring.member.MemberService;
import dulgi.hellospring.member.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	//private final DataSource dataSource;
	//private final EntityManager em;
	private final MemberRepository memberRepository;
	
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	 }
	
	/*//Use JPA
	 public SpringConfig(DataSource dataSource, EntityManager em) {
		 this.dataSource = dataSource;
		 this.em = em;
	 }
	 */
	
	/*//USE JDBC
	 * public SpringConfig(DataSource dataSource) {
		 this.dataSource = dataSource;
	 }
	 */
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	/*
	@Bean
	public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}
	*/


	/*
	@Bean
	public TimeTraceAop timeTraceAop(){
		return new TimeTraceAop();
	}

	 */
	
}
