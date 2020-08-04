package com.yclooper.springrestdoc;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chen on 2019/7/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JUnit4ExampleTests {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("custom");
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Before
    public void setup() {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.applicationContext)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void login() throws Exception{
        this.mockMvc.perform(get("/login").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("index", links(
                        linkWithRel("username").description("用户姓名"),
                        linkWithRel("password").description("用户密码")
                )));
    }

}

