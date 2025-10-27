package members;

import com.ssg.membertest.members.dto.MemberDTO;
import com.ssg.membertest.members.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void testListAll() throws Exception {
        List<MemberDTO> list = memberService.listAll();
        list.forEach(log::info);
    }

    @Test
    public void testRegister() throws Exception {
        MemberDTO dto = MemberDTO.builder()
                .mid("member05")
                .mpw("4444")
                .mname("tester")
                .build();
        memberService.register(dto);
    }
}
