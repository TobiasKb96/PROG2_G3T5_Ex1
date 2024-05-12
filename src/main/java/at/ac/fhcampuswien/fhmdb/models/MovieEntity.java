package at.ac.fhcampuswien.fhmdb.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

//Movie data required for the database
@DatabaseTable(tableName = "movie")
public class MovieEntity {
    //generateID: automatic display of the id for new entries
//    @DatabaseField()
//    private long id;
    @DatabaseField(id = true)
    private String apiId;
    @DatabaseField()
    private String title, description, genres, imgUrl;
    @DatabaseField()
    private int releaseYear, lengthInMinutes;
    @DatabaseField()
    private double rating;

    public MovieEntity(){
        //Dont delete, crashes otherwise
    }

    //Without id (generated by database)
    public MovieEntity(String apiId, String title, String description, String genres, String imgUrl, int releaseYear, int lengthInMinutes, double rating) {
        this.apiId = apiId;
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.imgUrl = imgUrl;
        this.releaseYear = releaseYear;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

//    public static String genresToString (String<Genres> genres) {
//
//    }

    public static List<MovieEntity> fromMovies (List<Movie> movies) {
        List<MovieEntity> entityList = new ArrayList<>();
        for(Movie movie : movies){
            entityList.add(MovieRepository.movieToEntity(movie));
        }
        return entityList;
    }

    public static List<Movie> toMovies (List<MovieEntity> movieEntities) {
        List<Movie> movieList = new ArrayList<>();
        for(MovieEntity entity : movieEntities){
            movieList.add(MovieRepository.entityToMovie(entity));
        }
        return movieList;
    }

//    public long getId() {
//        return id;
//    }

    public String getApiId() {
        return apiId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public double getRating() {
        return rating;
    }
}
