package members.v2;

import com.ssg.membertest.members.v2.dto.MemberDTO;
import com.ssg.membertest.members.v2.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void testJoinMember() throws Exception {
        MemberDTO dto = MemberDTO.builder()
                .userId("tester5")
                .userPwd("4444")
                .userName("테스터5")
                .joinDate(LocalDate.now())
                .build();
        memberService.joinMember(dto);
    }

    @Test
    public void testListAll() throws Exception {
        List<MemberDTO> list = memberService.memberList();
        list.forEach(log::info);
    }

    @Test
    public void testGet()  throws Exception {
        MemberDTO MemberDTO = memberService.get("tester1");
        log.info(MemberDTO);
    }

    @Test
    public void testEdit() throws Exception {
        MemberDTO MemberDTO = com.ssg.membertest.members.v2.dto.MemberDTO.builder()
                .userId("tester5")
                .userPwd("123456")
                .userName("updatedTester")
                .userEmail("member04@test.com")
                .build();
        memberService.edit(MemberDTO);
    }

    @Test
    public void testRemove() throws Exception {
        String userId = "tester5";
        memberService.remove(userId);
    }
}
