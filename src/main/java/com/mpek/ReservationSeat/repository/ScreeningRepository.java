package com.mpek.ReservationSeat.repository;

import com.mpek.ReservationSeat.model.Screening;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {


    List<Screening> findByDayOfScreening(Date dayOfScreening);

//    @Query("select s from Screenings s where s.screeningDate = :screeningDate and s.movie.tile = :movieTitle")
//    Screening findByMovieAndDate(@Param("screeningDate")Date dateofScreening, @Param("movieTitle")String movieTitle);

    Screening findById(long id);
}
