package ch.zli.m223.punchclock;

/* @Author Stefan Diefenbacher
Wir testen die CRUD Operationen über die REST Schnittstelle über POST, GET, PUT, und DELETE
Leider läuft das ganze noch nicht. Wohl wegen der Security. Entweder deaktivieren für den Test oder
besser auch Mocken weil für update und insert ein sowieso Principal Objekt benötigt wird.
 */

import ch.zli.m223.punchclock.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class CategoryControllerTest extends AbstractTest {

@Override
@Before
public void setUp(){
    super.setUp();
}
    @Test
    public void createCategory() throws Exception {
        String uri = "/category";

        Category category = new Category();
        category.setName("support");

        String inputJson = super.mapToJson(category);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Category is created successfully");
    }

    @Test
    public void getCategoryList() throws Exception {
        String uri = "/category";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

    }

@Test
    public void updateCategory() throws Exception {
        String uri ="/category";
        Category category = new Category();
        category.setId((long) 1);
        category.setName("mockmeup");

    String inputJson = super.mapToJson(category);
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content = mvcResult.getResponse().getContentAsString();
    assertEquals(content, "Category is updated successfully");
    }

    @Test
    public void deleteCategory() throws Exception{
        String uri ="/category/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Category is deleted successfully");

    }

}
