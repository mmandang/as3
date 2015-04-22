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

        //     List<Blog> blogs = new ArrayList<>();
        // while (dbCursor.hasNext()) {
        //     Blog blog = dbCursor.next();
        //     blogs.add(blog);
        // }
        // return blogs;

    @PUT
    @Path("/{id}")
    public Response likePost(@PathParam("id") int id) {       
        postsDao.likePost(id);
        return Response.noContent().build();
    }

}
