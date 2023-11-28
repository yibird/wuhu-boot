package fly.sys;

import com.fly.ServerApplication;
import com.fly.common.utils.TreeUtils;
import com.fly.convert.SysMenuConvert;
import com.fly.mapper.SysMenuMapper;
import com.fly.mapper.SysPostMapper;
import com.fly.model.domain.SysMenuDO;
import com.fly.model.vo.SysMenuVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest(classes = ServerApplication.class)
@AutoConfigureMockMvc
public class SysPostTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SysPostMapper postMapper;

    @Autowired
    SysMenuMapper menuMapper;

    @Test
    public void getListTest() throws Exception {
        List<SysMenuDO> list = menuMapper.getListByUserId(1L);
        List<SysMenuVO> menus = SysMenuConvert.INSTANCE.toMenuVOList(list);
        List<SysMenuVO> tree = TreeUtils.toTree(menus, node -> node.getPId() == 0L);
        System.out.println("list:" + tree);

//        SysPostQuery query = new SysPostQuery();
//        query.setCurrent(1);
//        query.setPageSize(10);
//        System.out.println("result:" + postMapper.getList(query));
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/v1/sys/post/getList?current=1&pageSize=10")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//        System.out.println("result:" + mvcResult.getResponse().getContentAsString());

    }
}
