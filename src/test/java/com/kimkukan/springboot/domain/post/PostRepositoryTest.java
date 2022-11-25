package com.kimkukan.springboot.domain.post;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //h2 가상DB를 자동실행도 해줌
public class PostRepositoryTest {
    
    @Autowired
    PostRepository postRepository;
    
    @After
    public void cleanup(){
        postRepository.deleteAll();
    }
    //단위테스트가 끝나고 메모리를 비워주는 역할
    
    @Test
    public void table_call_test() {
        String title = "테스트게시글";
        String content = "테스트 게시글 본문입니다. 어쩌구 저쩌구";
        
        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .author("kimkukan@gmail.com")
                .build());
        
        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_register(){
        LocalDateTime now = LocalDateTime.of(2022,11,25,9,0,0);
        postRepository.save(Post.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build());

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);

        System.out.println(">>>>>>>>>>>>>>>> createDate="+post.getCreatedDate()+", modifiedDate="+post.getModifiedDate());

        assertThat(post.getCreatedDate().isAfter(now));
        assertThat(post.getModifiedDate().isAfter(now));
    }
}
