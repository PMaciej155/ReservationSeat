package com.mpek.ReservationSeat.repository;

import com.mpek.ReservationSeat.model.Screening;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {

    @Query("select s from Screening s")
    List<Screening> findAll();

    @Query("select s from Screening s where s.dayOfScreening = :dayOfScreening AND s.timeOfScreening >= :startInterval AND s.timeOfScreening <= :endInterval")
    List<Screening> findByDayOfScreening(@Param("dayOfScreening") Date dayOfScreening, @Param("startInterval") Date startInterval, @Param("endInterval") Date endInterval);

    // By defualt it would be that function but i lost my patient to JPQL.
//    @Query(value ="SELECT s FROM Seat s WHERE s.id IN (\n" +
//            "SELECT  r.seats FROM Room r WHERE r.id IN (\n" +
//            "SELECT screening.room FROM Screening screening WHERE screening.id = :idOfScreeing))" +
//            "  AND s.id NOT IN (SELECT DISTINCT reservation.seats FROM Reservation reservation WHERE reservation.screening = :idOfScreeing)")
//    List<Seat> findAllAvailableSeats(@Param("idOfScreeing") Long idOfScreeing);

    Screening findById(long id);
}
