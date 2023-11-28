package com.fly.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
public class IdempotentTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    public void interfaceIdempotenceTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        // 调用获取 Token 接口
        String token = mockMvc.perform(MockMvcRequestBuilders.get("/token")
                        .accept(MediaType.TEXT_HTML))
                .andReturn()
                .getResponse().getContentAsString();
        for (int i = 1; i <= 5; i++) {
            String result = mockMvc.perform(MockMvcRequestBuilders.post("/test")
                            .header("x-token", token)
                            .accept(MediaType.TEXT_HTML))
                    .andReturn().getResponse().getContentAsString();

            // 结果断言
            if (i == 0) {
                Assertions.assertEquals(result, "正常调用");
            } else {
                Assertions.assertEquals(result, "重复调用");
            }
        }
    }
}
