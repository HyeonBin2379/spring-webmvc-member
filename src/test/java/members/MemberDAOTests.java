package members;

import com.ssg.membertest.members.dao.MemberDAO;
import com.ssg.membertest.members.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class MemberDAOTests {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void testSelectAll() throws Exception {
        List<MemberVO> list = memberDAO.selectAll();
        list.forEach(log::info);
    }

    @Test
    public void testInsert() throws Exception {
        MemberVO vo = MemberVO.builder()
                .mid("member04")
                .mpw("3333")
                .mname("tester")
                .build();
        memberDAO.insert(vo);
    }

    @Test
    public void testUpdate() throws Exception {
        String mid = "member00";
        MemberVO memberVO = MemberVO.builder()
                .mid(mid)
                .mpw("1234")
                .mname("tester")
                .build();
        Assertions.assertTrue(memberDAO.updateOne(memberVO));
    }

    @Test
    public void testDelete() throws Exception {
        String mid = "member04";
        Assertions.assertTrue(memberDAO.deleteOne(mid));
    }
}
