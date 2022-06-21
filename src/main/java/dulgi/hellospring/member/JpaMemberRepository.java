package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository 
{
	private final EntityManager em;

	public JpaMemberRepository(EntityManager em) 
	{
		this.em = em;
	}

	public Member save(Member member) 
	{
		em.persist(member);	//��ƼƼ ���� 
		return member;
	}

	public Optional<Member> findById(Long id) 
	{
		Member member = em.find(Member.class, id); //��ƼƼ ��ȸ
		return Optional.ofNullable(member);
	}

	public List<Member> findAll() 
	{
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

	public Optional<Member> findByName(String name) 
	{
		//List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)	.setParameter("name", name).getResultList();
		//return result.stream().findAny();
		Member member = em.find(Member.class, name); //��ƼƼ ��ȸ
		return Optional.ofNullable(member);
		
	}
}
