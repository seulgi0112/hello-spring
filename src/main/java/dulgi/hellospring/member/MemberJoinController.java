package dulgi.hellospring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class MemberJoinController {
	private final MemberServiceImpl memberService;
	
	@Autowired
	public MemberJoinController(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/member/new")
	public String createForm() {
		return "members/createMemberForm";
	}
}
