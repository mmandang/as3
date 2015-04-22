package com.as3.reddit.resources;

import com.as3.reddit.representations.Posts;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.skife.jdbi.v2.DBI;
import com.as3.reddit.dao.PostsDAO;
import java.net.URI;
import java.net.URISyntaxException;


@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostsResource {

    private final PostsDAO postsDao;
    //private final Validator validator;

    public PostsResource(DBI jdbi) {
        postsDao = jdbi.onDemand(PostsDAO.class);
        //this.validator = validator;
    }

    @POST
    public Response createpOSTS(Posts posts) throws URISyntaxException {
        // store the new posts
        int newPostsId = postsDao.createPosts(posts.getUrl(), posts.getTitle());
        return Response.created(new URI(String.valueOf(newPostsId))).build();
    }

    // @POST("/{id}")
    // public Response getPosts(@PathParam("id") int id) {
    //     // retrieve information about the posts with the provided id
    //     Posts posts = postsDao.getPostsById(id);
    //     return Response
    //             .ok(posts)
    //             .build();
    // }

    @POST
    @Path("/{id}")
    public Response likePost(@PathParam("id") int id) {       
        postsDao.likePost(id);
        return Response.noContent().build();
    }

}
