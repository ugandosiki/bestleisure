package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.repository.IPostRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    private final IPostRepository iPostRepository;

    public PostService(final IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public void createPost(Post post) {
        try {
            iPostRepository.save(post);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public Post getOnePost(Long id) {
        return iPostRepository.getOne(id);
    }

    @Override
    public Post getPostByTitle(String title) {
        return iPostRepository.findPostByTitle(title);
    }

    @Override
    public List<Post> getAllPost() {
        return iPostRepository.findAll();
    }

    @Override
    public void deletePost(Long id) {
        try {
            iPostRepository.deleteById(id);
        } catch (NumberFormatException exception) {
            throw new RuntimeException(exception.getCause());
        }
    }

    @Override
    public void deletePost(String title) {
        try {
            iPostRepository.deletePostByTitle(title);
        } catch (NumberFormatException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
