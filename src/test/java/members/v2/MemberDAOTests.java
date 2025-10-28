package members.v2;

import com.ssg.membertest.members.v2.repository.MemberDAO;
import com.ssg.membertest.members.v2.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
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
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void testFindAll() throws Exception {
        List<MemberVO> list = memberDAO.findAll();
        list.forEach(log::info);
    }

    @Test
    public void testInsert() throws Exception {
        MemberVO vo = MemberVO.builder()
                .userId("tester4")
                .userPwd("333333")
                .userName("테스터4")
                .userEmail("tester4@test.com")
                .joinDate(LocalDate.now())
                .build();
        memberDAO.insert(vo);
    }

    @Test
    public void testUpdate() throws Exception {
        MemberVO updated = MemberVO.builder()
                .userId("tester4")
                .userPwd("1234")
                .userName("테스터4")
                .userEmail("tester04@test.com")
                .build();
        Assertions.assertTrue(memberDAO.update(updated));
    }

    @Test
    public void testDelete() throws Exception {
        String userId = "tester4";
        Assertions.assertTrue(memberDAO.delete(userId));
    }
}
