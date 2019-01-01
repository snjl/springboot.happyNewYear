package com.mapper;

import com.model.MessageWithBLOBs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageMapperTest {

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void selectByExampleWithBLOBs() {
        List<MessageWithBLOBs> messages = messageMapper.selectByExampleWithBLOBs(null);
        messages.forEach(
                messageWithBLOBs -> {
                    System.out.println(messageWithBLOBs);
                }
        );

    }
}