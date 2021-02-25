package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.repository.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements IPostService {
    final IPostRepository iPostRepository;

    public PostService(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @Override
    public boolean createPost(Post post) {
        if(post != null){
            iPostRepository.save(post);
            return true;
        }
        else return false;
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
    public boolean deletePost(Long id) {
        if(id<=0){
            return false;
        }
        else {iPostRepository.deleteById(id); return true;}
    }

    @Override
    public boolean deletePost(String title) {
        if (title != null) {
            iPostRepository.deletePostByTitle(title);
            return true;
        } else
            return false;
    }
}
