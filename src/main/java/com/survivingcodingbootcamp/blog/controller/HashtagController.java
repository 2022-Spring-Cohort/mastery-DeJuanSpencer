package com.survivingcodingbootcamp.blog.controller;

/*TODO
* provide three path mappings, one for individual hashtags, one for all hashtags, and one for adding a hashtag to the system.
Add a link to the all hashtags endpoint to the header's nav list on all pages.
*
* */

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@Controller
public class HashtagController {
    private PostRepository postRepo;
    private TopicRepository topicRepo;
    private HashtagRepository hashtagRepo;

    public HashtagController(PostRepository postRepo, TopicRepository topicRepo, HashtagRepository hashtagRepo) {
        this.postRepo = postRepo;
        this.topicRepo = topicRepo;
        this.hashtagRepo = hashtagRepo;
    }



    @GetMapping("/hashtags")
    public String displayAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        return "all-hashtags-template";
    }

    @GetMapping("/hashtags/{id}")
    public String displaySingleHashtag(Model model, @PathVariable long id) {


        Optional<Hashtag> tempHashtag = hashtagRepo.findById(id);
        if (tempHashtag.isPresent())
        {
            model.addAttribute("hashtag", tempHashtag.get());
        }

        return "single-hashtag-template";
    }





}
