package dulgi.hellospring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberJoinController {
	private MemberServiceImpl memberService;
	
	@Autowired
	public MemberJoinController(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/member/new")
	public String createForm() {
		return "members/createMemberForm";
	}
}
