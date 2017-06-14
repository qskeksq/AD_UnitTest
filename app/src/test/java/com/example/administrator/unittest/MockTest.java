package com.example.administrator.unittest;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    Context context;

    List<Integer> ints = mock(List.class);

    @Before
    public void stubbing(){
        ints.add(10);
        when(context.getString(R.string.sample_string)).thenReturn("sample string");
        when(ints.get(anyInt())).thenReturn(10);
    }



    @Test
    public void testStringConverter(){
        StringConverter converter = new StringConverter(context);
        assertThat(converter.getString(R.string.sample_string), is("sample string"));
        assertThat(ints.get(100),is(10));
        verify(context, times(2)).getSystemService(Context.NETWORK_STATS_SERVICE);
    }






}
