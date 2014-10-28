package com.stairways.dao;

/**
 * Created by matvey on 28.10.14.
 */

import com.stairways.dao.DAOFactory.MySqlDAOFactory;
import com.stairways.model.Track;
import com.stairways.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by matvey on 28.10.14.
 */
public class TracksDAOImpl implements MySqlDAO<Track>{

   private Connection connection = MySqlDAOFactory.createConnection();

    @Override
    public List<Track> findAll() {
        List<Track> tracksList = null;
        ResultSet rs = null;
        try {

            PreparedStatement prst =
                    connection.prepareStatement("Select * from tracks");
            rs = prst.executeQuery();
            tracksList = (List<Track>) rs;

        } catch (Exception ex) {
            ex.printStackTrace();
            return tracksList;
        }

        return tracksList;

    }

    @Override
    public Track findById(int id) {
        Track track = null;

        try {
            PreparedStatement prst =
                    connection.prepareStatement("Select * from tracks WHERE id_track = ?");
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();
            track = resultSetToTrack(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return track;
    }

    @Override
    public void insert(Track value) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into tracks " +
                            "(id_track, name, file_path, " +
                            "price , duration, description," +
                            " author_id, album_id) values (?,?,?,?,?,?,?,?)");

            int resultExecute = executePrepareStatement(preparedStatement, value);

//            if (resultExecute == 1)
//                System.out.println("Success Insertion!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Track value) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update tracks set id_track=?," +
                            " name = ?, file_path = ?, duration = ?, price= ?," +
                            " description =?, author_id=?, album_id=?");
            int executeResult = executePrepareStatement(preparedStatement, value);

            if (executeResult == 1)
                System.out.println("Update Succeed!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

private Track resultSetToTrack(ResultSet resultSet) {

        Track track = new Track();

        try {

            while (resultSet.next()) {

                track.setIdTrack(resultSet.getInt("id_track"));
                track.setName(resultSet.getString("name"));
                track.setFilePath(resultSet.getString("file_path"));
                track.setDuration(resultSet.getString("duration"));
                track.setPrice(resultSet.getInt("price"));
                track.setDescription(resultSet.getString("description"));
                track.setAuthor_id(resultSet.getInt("author_id"));
                track.setAlbum_id(resultSet.getInt("album_id"));

            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return track;
        }

        return track;
    }

private int executePrepareStatement(PreparedStatement stmt,
                                        Track value) {
        int result;

        try {
            stmt.setInt(1, value.getIdTrack());
            stmt.setString(2, value.getName());
            stmt.setString(3, value.getFilePath());
            stmt.setString(4, value.getDuration());
            stmt.setInt(5, value.getPrice());
            stmt.setString(6, value.getDescription());
            stmt.setInt(7, value.getAuthor_id());
            stmt.setInt(8, value.getAlbum_id());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return result;
    }
}
