package dulgi.hellospring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	private final MemberService memberService;

	/*
	 * �����ڿ� @Autowired �� ������ �������� ������ ��ü�� ������ �����̳ʿ��� ã�Ƽ� �־��ش�. �̷��԰�ü �������踦 �ܺο��� �־��ִ�
	 * ���� DI (Dependency Injection), ������ �����̶� �Ѵ�.
	 */
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(value = "/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}

	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		memberService.join(member);
		return "redirect:/";
	}
}
