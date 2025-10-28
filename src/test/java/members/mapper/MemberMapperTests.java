package members.mapper;

import com.ssg.membertest.members.domain.MemberVO;
import com.ssg.membertest.members.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class MemberMapperTests {

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Test
    public void testSelectAll() {
        List<MemberVO> list = memberMapper.findAll();
        list.forEach(log::info);
    }

    @Test
    public void testFindById() {
        String mid = "member00";
        Optional<MemberVO> optionalMemberVO = memberMapper.findById(mid);
        Assertions.assertTrue(optionalMemberVO.isPresent());
    }

    @Test
    public void testFindById2() {
        String mid = "member99";
        Optional<MemberVO> optionalMemberVO = memberMapper.findById(mid);
        Assertions.assertFalse(optionalMemberVO.isPresent());
    }

    @Test
    public void testInsert() {
        MemberVO vo = MemberVO.builder()
                .mid("member04")
                .mpw("3333")
                .mname("tester")
                .build();
        memberMapper.insert(vo);
    }

    @Test
    public void testUpdate() {
        String mid = "member00";
        MemberVO memberVO = MemberVO.builder()
                .mid(mid)
                .mpw("1234")
                .mname("tester")
                .build();
        Assertions.assertTrue(memberMapper.update(memberVO));
    }

    @Test
    public void testDelete() {
        String mid = "member04";
        Assertions.assertTrue(memberMapper.delete(mid));
    }
}
