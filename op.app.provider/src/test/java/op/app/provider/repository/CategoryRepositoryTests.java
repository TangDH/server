package op.app.provider.repository;

import op.app.ApplicationProvider;
import op.app.protocol.model.entity.TmCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationProvider.class)
@DataJpaTest //是否使用内存型数据库代替当前数据库配置
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //当前数据库配置
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findAllByName() throws Exception {
        TmCategory model = new TmCategory();
        model.name = "神偷奶爸";
        repository.save(model);
        TmCategory protocolBanner = repository.findAllByName("神偷奶爸").get(0);
        assertThat(model).isEqualTo(protocolBanner);
    }

    @Test
    public void findAllByParentId() throws Exception {
        TmCategory model = new TmCategory();
        model.name = "神偷奶爸";
        model.level = 1;
        repository.save(model);
        long id = repository.findAllByName("神偷奶爸").get(0).getId();

        TmCategory model2 = new TmCategory();
        model2.name = "小黄人";
        model2.level = 2;
        model2.parentId = id;
        repository.save(model2);

        TmCategory model3 = new TmCategory();
        model3.name = "女儿们";
        model3.level = 2;
        model3.parentId = id;
        repository.save(model3);

        List<TmCategory> listFrom = repository.findAllByParentId(id);

        assertThat(model2).isEqualTo(listFrom.get(0));
        assertThat(model3).isEqualTo(listFrom.get(1));
    }

    @Test
    public void findAllByGradeAndIdNotIn() throws Exception {
        TmCategory model = new TmCategory();
        model.name = "神偷奶爸";
        model.level = 1;
        repository.save(model);
        long id = repository.findAllByName("神偷奶爸").get(0).getId();

        TmCategory model2 = new TmCategory();
        model2.name = "小黄人";
        model2.level = 2;
        model2.parentId = id;
        repository.save(model2);

        TmCategory model3 = new TmCategory();
        model3.name = "女儿们";
        model3.level = 2;
        model3.parentId = id;
        repository.save(model3);

        Collection<Long> ids = new ArrayList<>();
        ids.add(model3.getId());
        List<TmCategory> listFrom = repository.findAllByLevelAndIdNotIn(2, ids);

        assertThat(listFrom.size()).isEqualTo(1);
        assertThat(model2).isEqualTo(listFrom.get(0));}



}
