package com.as3.reddit.dao;

import com.as3.reddit.dao.mappers.PostsMapper;
import com.as3.reddit.representations.Posts;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface PostsDAO {



    // @Mapper(PostsMapper.class)
    // @SqlQuery("select * from posts order by id desc")
    // Posts getPostsById(@Bind("id") int id);

    @Mapper(PostsMapper.class)
    @SqlQuery("select * from posts where id = :id")
    Posts getPostsById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into posts (id, url, title, vote) values (NULL, :url, :title, NULL)")
    int createPosts(@Bind("url") String url, @Bind("title") String title);

    @SqlUpdate("update posts set vote = vote + 1 where id = :id")
    void likePost(@Bind("id") int id);

    @SqlUpdate("update posts set vote = vote - 1 where id = :id")
    void dislikePost(@Bind("id") int id);

    // @SqlUpdate("delete from posts where id = :id")
    // void deletePosts(@Bind("id") int id);
}
