package com.pan;

import com.pan.po.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringboottestApplication.class) // 指定spring boot的启动类
public class SpringboottestApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc(){
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void listPageTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/read/readingList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
	}
    @Test
    public void addBook() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/read/readingList")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("title", "标题")
                    .param("author", "作者")
                    .param("isbn", "123")
                    .param("description", "描述")
                ).andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.header().string("Location", "./readingList"));
    }
}
