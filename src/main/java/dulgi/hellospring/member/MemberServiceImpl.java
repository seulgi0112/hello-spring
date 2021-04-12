package dulgi.hellospring.member;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{
	private MemberRepository memberRepository;

	//*ȸ�� �������丮�� �ڵ尡 ȸ�� ���� �ڵ带 DI �����ϰ� �����Ѵ�
	public  void MemberService(MemberRepository memberRepository) {
		 this.memberRepository =  memberRepository;
	}
	/**
	 * ȸ������
	 */
	@Override
	public Long join(Member member) {
		validateDuplicateMember(member); //�ߺ� ȸ�� ����
		 memberRepository.save(member);
		 return member.getId();
	}

	/**
	 * �ߺ����� Ȯ��
	 */
	@Override
	public void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
		 .ifPresent(m -> {
		 throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
		 });		
	}

	/**
	 * ��üȸ����ȸ
	 */
	@Override
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/**
	 * ID�� ȸ�� ��ȸ
	 */
	@Override
	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
	

}
