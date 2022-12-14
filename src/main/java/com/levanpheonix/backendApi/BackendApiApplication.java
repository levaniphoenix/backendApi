package com.levanpheonix.backendApi;

import com.levanpheonix.backendApi.model.Comment;
import com.levanpheonix.backendApi.model.Post;
import com.levanpheonix.backendApi.model.SubReddit;
import com.levanpheonix.backendApi.model.User;
import com.levanpheonix.backendApi.repository.CommentRepository;
import com.levanpheonix.backendApi.repository.PostRepository;
import com.levanpheonix.backendApi.repository.SubRedditRepository;
import com.levanpheonix.backendApi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(CommentRepository commentRepository, UserRepository users, SubRedditRepository subRedditRepository, PostRepository postRepository, PasswordEncoder passwordEncoder){
		return args -> {
			User user = users.findByUsername("user").orElseThrow();
			Post post = postRepository.findById(2L).orElseThrow();

//			for(Post p: user.getPosts())
//				System.out.println(p);
			System.out.println(post.getComments());

		};
	}

}
