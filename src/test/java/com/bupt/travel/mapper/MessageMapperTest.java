package com.bupt.travel.mapper;

import com.bupt.travel.model.Message;
import com.bupt.travel.model.reponseBean.PhotoInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;
    @Test
    public void selectPhoto() {

        List<Message> list = messageMapper.selectPhoto(112, 1);
        System.out.println(list.toString());
    }
}