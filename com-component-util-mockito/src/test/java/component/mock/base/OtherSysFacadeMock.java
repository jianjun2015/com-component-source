package component.mock.base;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by wangjianjun on 2017/8/4.
 */
public class OtherSysFacadeMock extends BaseMock<OtherSysFacade> {
    @Override
    public void initMock(OtherSysFacade mock) {
        when(mock.getMsg(anyString())).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                return "mock msg success";
            }
        });
        when(mock.oper(anyString())).thenAnswer(new Answer<Object>() {

//            ChargeRequest request = (ChargeRequest) invocationOnMock.getArguments()[0];
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String arg = (String) invocationOnMock.getArguments()[0];
                if (arg.equals("succ")) {
                    return "oper success";
                }else {
                    return "oper failure";
                }
            }
        });
        when(mock.getResult(anyInt())).thenAnswer(new Answer<OtherResult>() {
            @Override
            public OtherResult answer(InvocationOnMock invocationOnMock) throws Throwable {
                return getResult();
            }
        });
        when(mock.exceptionFun()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                throw new Exception();
            }
        });
    }

    private OtherResult getResult(){
        return new OtherResult("zhangsan","passwd");
    }
}
