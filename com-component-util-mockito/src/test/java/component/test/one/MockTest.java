package component.test.one;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;//静态导入

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangjianjun on 2017/8/3.
 */
public class MockTest {

    @Test
    public void verify_behaviour(){

        //模拟创建一个List对象
        List mock = mock(List.class);
        //使用mock的对象
        mock.add(1);

        System.out.println(mock.size());
        mock.clear();

        System.out.println(mock.size());

        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }

    @Test
    public void when_thenReturn(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        String result = iterator.next()+" "+iterator.next()+" "+iterator.next();

        Assert.assertEquals("hello world world",result);
    }

    @Test
    public void test_when_thenThrow(){
        try {
            when_thenThrow();
        } catch (IOException e) {
            System.out.println("捕获:"+e);
        }
    }

    public void when_thenThrow() throws IOException{
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }

    @Test
    public void returnsSmartNullsTest() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));

        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }

    @Test
    public void deepstubsTest(){
        Account account=mock(Account.class,RETURNS_DEEP_STUBS);
        when(account.getRailwayTicket().getDestination()).thenReturn("Beijing");
        account.getRailwayTicket().getDestination();
        verify(account.getRailwayTicket()).getDestination();
        Assert.assertEquals("Beijing",account.getRailwayTicket().getDestination());
    }
    @Test
    public void deepstubsTest2(){
        Account account=mock(Account.class);
        RailwayTicket railwayTicket=mock(RailwayTicket.class);
        when(account.getRailwayTicket()).thenReturn(railwayTicket);
        when(railwayTicket.getDestination()).thenReturn("Beijing");

        account.getRailwayTicket().getDestination();
        verify(account.getRailwayTicket()).getDestination();
        Assert.assertEquals("Beijing",account.getRailwayTicket().getDestination());
    }

    public class RailwayTicket{
        private String destination;

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }
    }

    public class Account{
        private RailwayTicket railwayTicket;

        public RailwayTicket getRailwayTicket() {
            return railwayTicket;
        }

        public void setRailwayTicket(RailwayTicket railwayTicket) {
            this.railwayTicket = railwayTicket;
        }
    }

    @Test(expected = RuntimeException.class)
    public void doThrow_when(){
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list.add(1));
        list.add(1);
    }
}
