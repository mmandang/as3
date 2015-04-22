package com.as3.reddit.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.as3.reddit.representations.Posts;

public class PostsMapper implements ResultSetMapper<Posts> {
   public Posts map(int index, ResultSet r, StatementContext ctx)
   throws SQLException {
      return new Posts(
      r.getInt("id"), r.getString("url"),
      r.getString("title"), r.getInt("vote"));
   }
}