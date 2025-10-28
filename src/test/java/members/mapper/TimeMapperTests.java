package members.mapper;

import com.ssg.membertest.members.mapper.TimeMapper2;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/members/root-context.xml")
public class TimeMapperTests {

    // 실제 객체 주입 X
    @Autowired(required = false)
    private TimeMapper2 timeMapper;

    @Test
    public void testTimeMapper2() {
        log.info(timeMapper.getNow());
    }
}
