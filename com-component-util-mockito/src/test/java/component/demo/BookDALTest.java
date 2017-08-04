package component.demo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class BookDALTest {

    private static BookDAL mockedBookDAL;
    private static Book book_1;
    private static Book book_2;

    @Before
    public void setUp() throws Exception{
        mockedBookDAL = mock(BookDAL.class);
        book_1 = new Book("12345678","PC", Arrays.asList("zhangsan","lisi"),100);
        book_2 = new Book("1234567800","JAVA", Arrays.asList("kk","JJ"),200);
        when(mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(book_1,book_2));
        when(mockedBookDAL.getBook("12345678")).thenReturn(book_1);
        when(mockedBookDAL.addBook(book_1)).thenReturn(book_1.getIsbn());
        when(mockedBookDAL.updBook(book_1)).thenReturn(book_1.getIsbn());
    }

    @Test
    public void testGetAllBooks()throws Exception{
        List<Book> allBooks = mockedBookDAL.getAllBooks();
        assertEquals(2,allBooks.size());
        Book myBook = allBooks.get(0);
        assertEquals("12345678", myBook.getIsbn());
    }

    @Test
    public void testGetBook() throws Exception{
        Book book = mockedBookDAL.getBook("12345678");
        assertNotNull(book);
        assertEquals("12345678",book.getIsbn());
    }

    @Test
    public void testAddBook()throws Exception{
        String isbn = mockedBookDAL.addBook(book_1);
        assertNotNull(isbn);
        assertEquals(book_1.getIsbn(), isbn);
    }

    @Test
    public void testUptBook()throws Exception{
        String isbn = mockedBookDAL.updBook(book_1);
        assertNotNull(isbn);
        assertEquals(book_1.getIsbn(), isbn);
    }
}
