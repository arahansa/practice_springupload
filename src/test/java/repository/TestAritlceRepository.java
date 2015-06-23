package repository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.example.PracticeSpringImgload;
import com.example.model.BoardArticle;
import com.example.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by arahansa on 2015-06-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PracticeSpringImgload.class)
@WebAppConfiguration
public class TestAritlceRepository {

    public static final String ARAHANSA = "arahansa";
    public static final String HELLO_WORLD = "hello world";
    public static final String PARK = "park";
    public static final String THE_UNIVERSE_WILL_HELP_YOU = "the universe will help you";
    @Autowired
    ArticleRepository repository;

    @Before
    public void setup(){
        repository.save(new BoardArticle(ARAHANSA, HELLO_WORLD));
        repository.save(new BoardArticle(PARK, THE_UNIVERSE_WILL_HELP_YOU));
    }

    @Test
    public void save() {
        List<BoardArticle> list = repository.findAll();
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getNick(), ARAHANSA);
        assertEquals(list.get(0).getContent(), HELLO_WORLD);
        assertEquals(list.get(1).getNick(), PARK);
        assertEquals(list.get(1).getContent(), THE_UNIVERSE_WILL_HELP_YOU);
        list.forEach(n-> System.out.println(n));
    }

}
