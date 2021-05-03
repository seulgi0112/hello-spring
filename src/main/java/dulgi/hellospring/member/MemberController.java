package dulgi.hellospring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
	private final MemberService memberService;
	/*
	 *  �����ڿ� @Autowired �� ������ �������� ������ ��ü�� ������ �����̳ʿ��� ã�Ƽ� �־��ش�.
	 *  �̷��԰�ü �������踦 �ܺο��� �־��ִ� ���� DI (Dependency Injection), ������ �����̶� �Ѵ�.
	 */
	@Autowired
	 public MemberController(MemberService memberService) {
	 this.memberService = memberService;
	 }
}
