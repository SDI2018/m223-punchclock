package ch.zli.m223.punchclock;

/* @Author Stefan Diefenbacher
Wir testen die CRUD Operationen über die REST Schnittstelle über POST, GET, PUT, und DELETE
Leider läuft das ganze noch nicht. Wohl wegen der Security. Entweder deaktivieren für den Test oder
besser auch Mocken weil für update und insert ein sowieso Principal Objekt benötigt wird.
 */

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Entry;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class EntryControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void createEntry() throws Exception {
        String uri = "/entries";

        Entry entry = new Entry();

        String in = "2020-10-02 08:00:00";
        String out = "2020-10-02 17:25:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime checkIn = LocalDateTime.parse(in, formatter);
        LocalDateTime checkOut = LocalDateTime.parse(out, formatter);
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);

        String inputJson = super.mapToJson(entry);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Category is created successfully");
    }

    @Test
    public void getEntryList() throws Exception {
        String uri = "/entries";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();

    }

    @Test
    public void updateEntry() throws Exception {
        String uri ="/entries";
        Entry entry = new Entry();
        entry.setId((long) 1);

        String in = "2020-11-02 09:00:00";
        String out = "2020-11-02 16:05:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime checkIn;
        checkIn = LocalDateTime.parse(in, formatter);
        LocalDateTime checkOut;
        checkOut = LocalDateTime.parse(out, formatter);
        entry.setCheckIn(checkIn);
        entry.setCheckOut(checkOut);

        Category category = new Category();
        category.setId((long) 1);

        String inputJson = super.mapToJson(entry);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Category is updated successfully");
    }

    @Test
    public void deleteEntry() throws Exception{
        String uri ="/Entry/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Category is deleted successfully");

    }
}
