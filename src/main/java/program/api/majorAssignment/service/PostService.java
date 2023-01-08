package program.api.majorAssignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.api.majorAssignment.domain.Post;
import program.api.majorAssignment.exception.BusinessException;
import program.api.majorAssignment.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final Logger log = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Boolean checkIfPostHasExited(long id) {
        if (postRepository.existsById(id)) {
            log.info("id {} has exited", id);
            return true;
        } else {
            log.info("id {} dose not exit", id);
            return false;
        }

    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post, long id) {
        Optional<Post> oldPost = postRepository.findById(id);
        if (oldPost.isPresent()) {
            oldPost.get().setTitle(post.getTitle());
            oldPost.get().setDescription(post.getDescription());
            oldPost.get().setPostDate(post.getPostDate());
            oldPost.get().setContent(post.getContent());
            oldPost.get().setAuthor(post.getAuthor());
            return postRepository.save(oldPost.get());
        }
        throw new BusinessException("400 Bad request", "Update post failed");
    }

    public List<Post> getPostsOfAuthorSearchByEmail(String email) {
        return postRepository.findPostsOfAuthorSearchByEmail(email);
    }

    public List<Post> getTop10PostsNewest() {
        return postRepository.findTop10Lastest();
    }

    public void deletePost(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            log.info("Delete post has id = {} successfully", id);
        }
        throw new BusinessException("Delete post failed");
    }
}
